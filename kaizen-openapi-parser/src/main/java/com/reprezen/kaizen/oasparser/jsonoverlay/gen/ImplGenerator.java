/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.kaizen.oasparser.jsonoverlay.gen;

import static com.reprezen.kaizen.oasparser.jsonoverlay.gen.Template.t;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.SimpleJavaGenerator.FieldMember;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.SimpleJavaGenerator.Member;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.SimpleJavaGenerator.MethodMember;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;

public class ImplGenerator extends TypeGenerator {

	public ImplGenerator(File dir, String intfPackage, String implPackage, String suffix, boolean preserve) {
		super(dir, intfPackage, implPackage, suffix, preserve);
	}

	@Override
	protected String getPackage() {
		return implPackage;
	}

	@Override
	protected Collection<String> getImports(Type type) {
		return type.getRequiredImports("impl");
	}

	@Override
	public Members getOtherMembers(Type type) {
		Members members = new Members(type);
		members.add(getElaborateChildrenMethod(type));
		members.add(getFactoryMethod(type));
		return members;
	}

	@Override
	public ClassOrInterfaceDeclaration getTypeDeclaration(Type type, String suffix) {
		requireTypes(OpenApiObjectImpl.class, OpenApi3.class);
		requireTypes(type);
		ClassOrInterfaceDeclaration decl = new ClassOrInterfaceDeclaration();
		decl.setInterface(false);
		decl.setPublic(true);
		decl.setName(type.getName() + suffix);
		decl.addExtendedType(getSuperType(type));
		decl.addImplementedType(type.getName());
		return decl;
	}

	private String getSuperType(Type type) {
		String superType = type.getExtensionOf();
		return superType != null ? Type.getImplType(superType) : t("OpenApiObjectImpl<${modelType}, ${name}>", type);
	}

	@Override
	protected Members getConstructors(Type type) {
		Members members = new Members(type);
		members.addConstructor("${implName}", //
				"JsonNode", "json", "JsonOverlay<?>", "parent", "ReferenceRegistry", "refReg") //
				.code( //
						"super(json, parent, refReg);", //
						"super.maybeElaborateChildrenAtCreation();");
		requireTypes(JsonNode.class, JsonOverlay.class);
		members.addConstructor("${implName}", //
				"${name}", "${lcName}", "JsonOverlay<?>", "parent", "ReferenceRegistry", "refReg") //
				.code( //
						"super(${lcName}, parent, refReg);", //
						"super.maybeElaborateChildrenAtCreation();");
		return members;
	}

	@Override
	protected boolean skipField(Field field) {
		return field.isNoImpl();
	}

	@Override
	protected Members getFieldMembers(Field field) {
		requireTypes(field.getType(), field.getImplType());
		Members members = new Members(field);
		members.addField("${propType}", "${propName}", "null");
		switch (field.getStructure()) {
		case scalar:
			requireTypes(ChildOverlay.class);
		case collection:
			requireTypes(Collection.class, ListOverlay.class, ChildListOverlay.class);
			break;
		case map:
			requireTypes(Map.class, MapOverlay.class, ChildMapOverlay.class);
			break;
		default:
			break;
		}
		return members;
	}

	@Override
	protected Members getFieldMethods(Field field) {
		Members methods = new Members(field);
		boolean first = true;
		String typeComment = field.getName();
		if (field.isRefable()) {
			requireTypes(Reference.class);
		}
		switch (field.getStructure()) {
		case scalar:
			for (Member method : getScalarMethods(field)) {
				methods.addMember(method).override().comment(first ? typeComment : null);
				first = false;
			}
			break;
		case collection:
			for (Member method : getCollectionMethods(field)) {
				methods.addMember(method).override().comment(first ? typeComment : null);
				first = false;
			}
			break;
		case map:
			for (Member method : getMapMethods(field)) {
				methods.addMember(method).override().comment(first ? typeComment : null);
				first = false;
			}
			break;
		}
		return methods;
	}

	private Members getScalarMethods(Field field) {
		Members methods = new Members(field);
		// T getFoo() => return foo.get()
		methods.addMethod("${type}", "get${name}").code("return ${lcName}.get();");
		// T getFoo(boolean elaborate) => return foo.get(elaborate)
		methods.addMethod("${type}", "get${name}", "boolean", "elaborate").code("return ${lcName}.get(elaborate);");
		if (field.isBoolean()) {
			// boolean isFoo() => foo.get() != null ? foo.get() : boolDefault
			methods.addMethod("boolean", "is${name}")
					.code("return ${lcName}.get() != null ? ${lcName}.get() : ${boolDefault};");
		}
		// void setFoo(T foo) => foo = this.foo.set(foo)
		methods.addMethod("void", "set${name}", "${type}", "${lcName}").code("this.${lcName}.set(${lcName});");
		if (field.isRefable()) {
			// boolean isFooReference() => foo.isReference()
			methods.addMethod("boolean", "is${name}Reference")
					.code("return ${lcName} != null ? ${lcName}.isReference() : false;");
			// Reference getFooReference() => foo.getReference()
			methods.addMethod("Reference", "get${name}Reference")
					.code("return ${lcName} != null ? ${lcName}.getReference() : null;");
		}
		return methods;
	}

	private Members getCollectionMethods(Field field) {
		Members methods = new Members(field);

		// Collection<T> getFoos(boolean) => foos.get()
		methods.addMethod("Collection<${collType}>", "get${plural}").code("return ${lcPlural}.get();");
		// Collection<T> getFoos(boolean elaborate) => foos.get(elaborate)
		methods.addMethod("Collection<${collType}>", "get${plural}", "boolean", "elaborate")
				.code("return ${lcPlural}.get(elaborate);");
		// boolean hasFoos() => foos.isPresent()
		methods.addMethod("boolean", "has${plural}").code("return ${lcPlural}.isPresent();");
		// T getFoo(int index) => foos.get(index)
		methods.addMethod("${type}", "get${name}", "int", "index").code("return ${lcPlural}.get(index);");
		// void setFoos(Collection<T> foos) => this.foos.set((TImpl) foos)
		methods.addMethod("void", "set${plural}", "Collection<${collType}>", "${lcPlural}")
				.code("this.${lcPlural}.set((Collection<${collType}>) ${lcPlural});");
		// void setFoo(int index, T foo) => foos.set(index, foo)
		methods.addMethod("void", "set${name}", "int", "index", "${type}", "${lcName}")
				.code("${lcPlural}.set(index, ${lcName});");
		// void addFoo(Foo foo) => foos.add(foo)
		methods.addMethod("void", "add${name}", "${type}", "${lcName}").code("${lcPlural}.add(${lcName});");
		// void insertFoo(int index, Foo foo) => foos.insertOveraly(index, foo)
		methods.addMethod("void", "insert${name}", "int", "index", "${type}", "${lcName}")
				.code("${lcPlural}.insert(index, ${lcName});");
		// void removeFoo(int index) => foos.remove(index)
		methods.addMethod("void", "remove${name}", "int", "index").code("${lcPlural}.remove(index);");
		// methods.addAll(getKeyedCollectionMethods(field));
		if (field.isRefable()) {
			// boolean isFooReference(int index) => foos.getChild(index).isReference()
			methods.addMethod("boolean", "is${name}Reference", "int", "index")
					.code("return ${lcPlural}.getChild(index).isReference();");
			// Reference getFooReference(int index) => foos.getChild(index).getReference()
			methods.addMethod("Reference", "get${name}Reference", "int", "index")
					.code("return ${lcPlural}.getChild(index).getReference();");
		}
		return methods;
	}

	private Member getElaborateChildrenMethod(Type type) {
		Collection<String> code = Lists.newArrayList();
		for (Field field : type.getFields().values()) {
			if (!field.isNoImpl()) {
				code.addAll(code(field, "${propName} = ${propCons};"));
				if (field.isRefable()) {
					code.addAll(code(field, "refables.put(${qpath}, ${propName});"));
				}
			}
		}
		return new MethodMember(null, "void", "elaborateChildren").override().protectedAccess().code(code);
	}

	private Member getFactoryMethod(Type type) {
		requireTypes(OverlayFactory.class, JsonNode.class, ReferenceRegistry.class);
		String initializer = String.join("\n", t(type, "new OverlayFactory<${name}, ${implName}>() {", //
				"    @Override", //
				"    protected Class<? super ${implName}> getOverlayClass() {", //
				"         return ${implName}.class;", //
				"    }", //
				"", //
				"    @Override", //
				"    public ${implName} _create(${name} ${lcName}, JsonOverlay<?> parent, ReferenceRegistry refReg) {", //
				"        return new ${implName}(${lcName}, parent, refReg);", //
				"    }", //
				"", //
				"    @Override", //
				"    public ${implName} _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {", //
				"        return new ${implName}(json, parent, refReg);", //
				"    }", //
				"}"));
		return new FieldMember(null, t("OverlayFactory<${name}, ${implName}>", type), "factory", initializer)
				._static(true).publicAccess();
	}

	private Members getMapMethods(Field field) {
		Members methods = new Members(field);
		// Map<String, ? extends T> getFoos() => foos.get()
		methods.addMethod("Map<String, ${collType}>", "get${plural}").code("return ${lcPlural}.get();");
		// Map<String, ? extends T> getFoos(boolean elaborate) => foos.get(elaborate)
		methods.addMethod("Map<String, ${collType}>", "get${plural}", "boolean", "elaborate")
				.code("return ${lcPlural}.get(elaborate);");
		// boolean hasFoo(String key) => foos.containsKey(key)
		methods.addMethod("boolean", "has${name}", "String", "${keyName}")
				.code("return ${lcPlural}.containsKey(${keyName});");
		// T getFoo(String key) => foos.get(key)
		methods.addMethod("${type}", "get${name}", "String", "${keyName}").code("return ${lcPlural}.get(${keyName});");
		// void setFoos(Map<String, T> foos) => this.foos.set(foos)
		methods.addMethod("void", "set${plural}", "Map<String, ${type}>", "${lcPlural}")
				.code("this.${lcPlural}.set(${lcPlural});");
		// void setFoo(String key, Foo foo) => foos.set(key, foo)
		methods.addMethod("void", "set${name}", "String", "${keyName}", "${type}", "${lcName}")
				.code("${lcPlural}.set(${keyName}, ${lcName});");
		// void removeFoo(String key) => foos.remove(key)
		methods.addMethod("void", "remove${name}", "String", "${keyName}").code("${lcPlural}.remove(${keyName});");
		if (field.isRefable()) {
			// boolean isFooReference(String key) => foos.getChild(key).isReference()
			methods.addMethod("boolean", "is${name}Reference", "String", "key").code(
					"ChildOverlay<${type}, ${implType}> child = ${lcPlural}.getChild(key);",
					"return child != null ? child.isReference() : false;");
			// Reference getFooReference(String key) => foos.getChild(key).getReference()
			methods.addMethod("Reference", "get${name}Reference", "String", "key").code(
					"ChildOverlay<${type}, ${implType}> child = ${lcPlural}.getChild(key);",
					"return child != null ? child.getReference() : null;");
		}
		return methods;
	}

	private Collection<String> code(final Field field, String... lines) {
		return Lists.transform(Lists.newArrayList(lines), new Function<String, String>() {
			@Override
			public String apply(String template) {
				return t(template, field);
			}
		});
	}
}
