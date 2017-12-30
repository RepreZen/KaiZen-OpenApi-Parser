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
import java.util.List;
import java.util.Map;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.google.common.collect.Lists;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.SimpleJavaGenerator.Member;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type;

public class InterfaceGenerator extends TypeGenerator {

	public InterfaceGenerator(File dir, String intfPackage, String implPackage, String suffix, boolean preserve) {
		super(dir, intfPackage, implPackage, suffix, preserve);
	}

	@Override
	protected String getPackage() {
		return intfPackage;
	}

	@Override
	protected ClassOrInterfaceDeclaration getTypeDeclaration(Type type, String suffix) {
		String superType = getSuperType(type);
		requireTypes(superType);
		requireTypes(type.getExtendInterfaces());
		ClassOrInterfaceDeclaration decl = new ClassOrInterfaceDeclaration();
		decl.setInterface(true);
		decl.setName(type.getName());
		decl.setPublic(true);
		List<String> allTypes = Lists.newArrayList(superType);
		allTypes.addAll(type.getExtendInterfaces());
		for (String extensionType : allTypes) {
			decl.addExtendedType(extensionType);
		}
		return decl;
	}

	@Override
	protected Collection<String> getImports(Type type) {
		return type.getRequiredImports("intf");
	}

	private String getSuperType(Type type) {
		String superType = type.getExtensionOf();
		return superType != null ? superType : t("OpenApiObject<${modelType}, ${name}>", type);
	}

	@Override
	protected Members getFieldMethods(Field field) {
		Members methods = new Members(field);
		requireTypes(field.getType());
		boolean first = true;
		String typeComment = field.getName();
		if (field.isRefable()) {
			requireTypes(Reference.class);
		}
		switch (field.getStructure()) {
		case scalar:
			for (Member method : getScalarMethods(field)) {
				methods.addMember(method).comment(first ? typeComment : null);
				first = false;
			}
			break;
		case collection:
			requireTypes(Collection.class);
			for (Member method : getCollectionMethods(field)) {
				methods.addMember(method).comment(first ? typeComment : null);
				first = false;
			}
			break;
		case map:
			requireTypes(Map.class);
			for (Member method : getMapMethods(field)) {
				methods.addMember(method).comment(first ? typeComment : null);
				first = false;
			}
			break;
		}
		for (Member method: methods) {
			method.packageAccess();
		}
		return methods;
	}

	private Members getScalarMethods(Field field) {
		Members methods = new Members(field);
		// T getFoo()
		methods.addMethod("${type}", "get${name}");
		// T getFoo(boolean elaborate)
		methods.addMethod("${type}", "get${name}", "boolean", "elaborate");
		if (field.getType().equals("Boolean")) {
			// boolean isFoo()
			methods.addMethod("boolean", "is${name}");
		}
		// void setFoo(T foo)
		methods.addMethod("void", "set${name}", "${type}", "${lcName}");
		if (field.isRefable()) {
			// boolean isFooReference()
			methods.addMethod("boolean", "is${name}Reference");
			// Reference getFooReference()
			methods.addMethod("Reference", "get${name}Reference");
		}
		return methods;
	}

	private Members getCollectionMethods(Field field) {
		Members methods = new Members(field);
		// Collection<? extends T> getFoos()
		methods.addMethod("Collection<${collType}>", "get${plural}");
		// Collection<? extends T> getFoos(boolean elaborate)
		methods.addMethod(t("Collection<${collType}>", field), t("get${plural}", field), "boolean", "elaborate");
		// boolean hasFoos()
		methods.addMethod("boolean", t("has${plural}", field));
		// T getFoo(int index)
		methods.addMethod(t("${type}", field), t("get${name}", field), "int", "index");
		// void setFoos(Collection<? extends T> foos)
		methods.addMethod("void", "set${plural}", "Collection<${collType}>", "${lcPlural}");
		// void setFoo(int index, Foo foo)
		methods.addMethod("void", "set${name}", "int", "index", "${type}", "${lcName}");
		// void addFoo(Foo foo)
		methods.addMethod("void", "add${name}", "${type}", "${lcName}");
		// void insertFoo(int index, Foo foo)
		methods.addMethod("void", "insert${name}", "int", "index", "${type}", "${lcName}");
		// void removeFoo(int index)
		methods.addMethod("void", "remove${name}", "int", "index");
		if (field.isRefable()) {
			// boolean isFooReference(int index)
			methods.addMethod("boolean", "is${name}Reference", "int", "index");
			// ReferencegetFooReference(int index)
			methods.addMethod("Reference", "get${name}Reference", "int", "index");
		}
		return methods;
	}

	private Members getMapMethods(Field field) {
		Members methods = new Members(field);
		// Map<String, ? extends T> getFoos()
		methods.addMethod("Map<String, ${collType}>", "get${plural}");
		// Map<String, ? extends T> getFoos(boolean elaborate)
		methods.addMethod("Map<String, ${collType}>", "get${plural}", "boolean", "elaborate");
		// boolean hasFoo(String name)
		methods.addMethod("boolean", "has${name}", "String", "${keyName}");
		// Foo getFoo(String name)
		methods.addMethod("${type}", "get${name}", "String", "${keyName}");
		// void setFoos(Map<String, ? extends T> foos)
		methods.addMethod("void", "set${plural}", "Map<String, ${collType}>", "${lcPlural}");
		// void setFoo(String name, Foo foo)
		methods.addMethod("void", "set${name}", "String", "${keyName}", "${type}", "${lcName}");
		// void removeFoo(String name)
		methods.addMethod("void", "remove${name}", "String", "${keyName}");
		if (field.isRefable()) {
			// boolean isFooReference(String key)
			methods.addMethod("boolean", "is${name}Reference", "String", "key");
			// ReferencegetFooReference(int index)
			methods.addMethod("Reference", "get${name}Reference", "String", "key");
		}
		return methods;
	}
}
