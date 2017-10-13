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

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
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
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.SimpleJavaGenerator.Member;
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
		Members members = new Members();
		members.add(getElaborateChildrenMethod(type));
		members.add(getFactoryMethod(type));
		return members;
	}

	@Override
	public String getTypeDeclaration(Type type, String suffix) {
		requireTypes(OpenApiObjectImpl.class, OpenApi3.class);
		requireTypes(type);
		return t("public class ${name}${0} extends ${1} implements ${name}", type, suffix, getSuperType(type));
	}

	private String getSuperType(Type type) {
		String superType = type.getExtensionOf();
		return superType != null ? Type.getImplType(superType) : t("OpenApiObjectImpl<${modelType}, ${name}>", type);
	}

	@Override
	protected Members getConstructors(Type type) {
		Members members = new Members();
		members.add(t("public ${implName}(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg)", type), //
				code("super(json, parent, refReg);", "super.maybeElaborateChildrenAtCreation();"));
		requireTypes(JsonNode.class, JsonOverlay.class);
		members.add(t("public ${implName}(${name} ${lcName}, JsonOverlay<?> parent, ReferenceRegistry refReg)", type), //
				code(t("super(${lcName}, parent, refReg);", type), "super.maybeElaborateChildrenAtCreation();"));
		return members;
	}

	@Override
	protected boolean skipField(Field field) {
		return field.isNoImpl();
	}

	@Override
	protected Members getFieldMembers(Field field) {
		requireTypes(field.getType(), field.getImplType());
		Members members = new Members();
		members.add(t("private ${propType} ${propName} = null", field));
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
		Members methods = new Members();
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
		Members methods = new Members();
		String getDecl = t("public ${type} get${name}()", field);
		String getBoolDecl = t("public ${type} get${name}(boolean elaborate)", field);
		String setDecl = t("public void set${name}(${type} ${lcName})", field);
		// T getFoo() => return foo.get()
		methods.add(getDecl, code(field, "return ${lcName}.get();"));
		// T getFoo(boolean elaborate) => return foo.get(elaborate)
		methods.add(getBoolDecl, code(field, "return ${lcName}.get(elaborate);"));
		if (field.isBoolean()) {
			// boolean isFoo() => foo.get() != null ? foo.get() : boolDefault
			methods.add(t("public boolean is${name}()", field),
					code(field, "return ${lcName}.get() != null ? ${lcName}.get() : ${boolDefault};"));
		}
		// void setFoo(T foo) => foo = this.foo.set(foo)
		methods.add(setDecl, code(field, "this.${lcName}.set(${lcName});"));
		if (field.isRefable()) {
			// boolean isFooReference() => foo.isReference()
			methods.add(t("public boolean is${name}Reference()", field),
					code(field, "return ${lcName} != null ? ${lcName}.isReference() : false;"));
			// Reference getFooReference() => foo.getReference()
			methods.add(t("public Reference get${name}Reference()", field),
					code(field, "return ${lcName} != null ? ${lcName}.getReference() : null;"));
		}
		return methods;
	}

	private Members getCollectionMethods(Field field) {
		Members methods = new Members();
		String getDecl = t("public Collection<${collType}> get${plural}()", field);
		String getBoolDecl = t("public Collection<${collType}> get${plural}(boolean elaborate)", field);
		String hasDecl = t("public boolean has${plural}()", field);
		String iGetDecl = t("public ${type} get${name}(int index)", field);
		String setDecl = t("public void set${plural}(Collection<${collType}> ${lcPlural})", field);
		String iSetDecl = t("public void set${name}(int index, ${type} ${lcName})", field);
		String addDecl = t("public void add${name}(${type} ${lcName})", field);
		String insDecl = t("public void insert${name}(int index, ${type} ${lcName})", field);
		String remDecl = t("public void remove${name}(int index)", field);

		// Collection<T> getFoos(boolean) => foos.get()
		methods.add(getDecl, code(field, "return ${lcPlural}.get();"));
		// Collection<T> getFoos(boolean elaborate) => foos.get(elaborate)
		methods.add(getBoolDecl, code(field, "return ${lcPlural}.get(elaborate);"));
		// boolean hasFoos() => foos.isPresent()
		methods.add(hasDecl, code(field, "return ${lcPlural}.isPresent();"));
		// T getFoo(int index) => foos.get(index)
		methods.add(iGetDecl, code(field, "return ${lcPlural}.get(index);"));
		// void setFoos(Collection<T> foos) => this.foos.set((TImpl) foos)
		methods.add(setDecl, code(field, "this.${lcPlural}.set((Collection<${collType}>) ${lcPlural});"));
		// void setFoo(int index, T foo) => foos.set(index, foo)
		methods.add(iSetDecl, code(field, "${lcPlural}.set(index, ${lcName});"));
		// void addFoo(Foo foo) => foos.add(foo)
		methods.add(addDecl, code(field, "${lcPlural}.add(${lcName});"));
		// void insertFoo(int index, Foo foo) => foos.insertOveraly(index, foo)
		methods.add(insDecl, code(field, "${lcPlural}.insert(index, ${lcName});"));
		// void removeFoo(int index) => foos.remove(index)
		methods.add(remDecl, code(field, "${lcPlural}.remove(index);"));
		// methods.addAll(getKeyedCollectionMethods(field));
		if (field.isRefable()) {
			// boolean isFooReference(int index) => foos.getChild(index).isReference()
			methods.add(t("public boolean is${name}Reference(int index)", field),
					code(field, "return ${lcPlural}.getChild(index).isReference();"));
			// Reference getFooReference(int index) => foos.getChild(index).getReference()
			methods.add(t("public Reference get${name}Reference(int index)", field),
					code(field, "return ${lcPlural}.getChild(index).getReference();"));
		}
		return methods;
	}

	private Member getElaborateChildrenMethod(Type type) {
		String decl = "protected void elaborateChildren()";
		Collection<String> code = Lists.newArrayList();
		for (Field field : type.getFields().values()) {
			if (!field.isNoImpl()) {
				code.addAll(code(field, "${propName} = ${propCons};"));
				if (field.isRefable()) {
					code.addAll(code(field, "refables.put(${qpath}, ${propName});"));
				}
			}
		}
		return new Member(decl, code).override();
	}

	private Member getFactoryMethod(Type type) {
		requireTypes(OverlayFactory.class, JsonNode.class, ReferenceRegistry.class);
		Collection<String> decl = t(type,
				"public static OverlayFactory<${name}, ${implName}> factory = new OverlayFactory<${name}, ${implName}>() {", //
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
				"}");
		return new Member(StringUtils.join(decl, "\n"), null);
	}

	private Members getMapMethods(Field field) {
		Members methods = new Members();
		// Map<String, ? extends T> getFoos() => foos.get()
		methods.add(t("public Map<String, ${collType}> get${plural}()", field),
				code(field, "return ${lcPlural}.get();"));
		// Map<String, ? extends T> getFoos(boolean elaborate) => foos.get(elaborate)
		methods.add(t("public Map<String, ${collType}> get${plural}(boolean elaborate)", field),
				code(field, "return ${lcPlural}.get(elaborate);"));
		// boolean hasFoo(String key) => foos.containsKey(key)
		methods.add(t("public boolean has${name}(String ${keyName})", field),
				code(field, "return ${lcPlural}.containsKey(${keyName});"));
		// T getFoo(String key) => foos.get(key)
		methods.add(t("public ${type} get${name}(String ${keyName})", field),
				code(field, "return ${lcPlural}.get(${keyName});"));
		// void setFoos(Map<String, T> foos) => this.foos.set(foos)
		methods.add(t("public void set${plural}(Map<String, ${type}> ${lcPlural})", field),
				code(field, "this.${lcPlural}.set(${lcPlural});"));
		// void setFoo(String key, Foo foo) => foos.set(key, foo)
		methods.add(t("public void set${name}(String ${keyName}, ${type} ${lcName})", field),
				code(field, "${lcPlural}.set(${keyName}, ${lcName});"));
		// void removeFoo(String key) => foos.remove(key)
		methods.add(t("public void remove${name}(String ${keyName})", field),
				code(field, "${lcPlural}.remove(${keyName});"));
		if (field.isRefable()) {
			// boolean isFooReference(String key) => foos.getChild(key).isReference()
			methods.add(t("public boolean is${name}Reference(String key)", field),
					code(field, "ChildOverlay<${type}, ${implType}> child = ${lcPlural}.getChild(key);",
							"return child != null ? child.isReference() : false;"));
			// Reference getFooReference(String key) => foos.getChild(key).getReference()
			methods.add(t("public Reference get${name}Reference(String key)", field),
					code(field, "ChildOverlay<${type}, ${implType}> child = ${lcPlural}.getChild(key);",
							"return child != null ? child.getReference() : null;"));
		}
		return methods;
	}

	private Collection<String> code(String... lines) {
		return Lists.newArrayList(lines);
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
