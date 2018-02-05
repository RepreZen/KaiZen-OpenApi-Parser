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
package com.reprezen.kaizen.oasparser.jsonoverlay.gen

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Field
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type
import java.io.File
import java.util.Collection
import java.util.Map

class InterfaceGenerator extends TypeGenerator {

	new(File dir, String intfPackage, String implPackage, String suffix, boolean preserve) {
		super(dir, intfPackage, implPackage, suffix, preserve)
	}

	override getPackage() {
		return intfPackage
	}

	override ClassOrInterfaceDeclaration getTypeDeclaration(Type type, String suffix) {
		val decl = new ClassOrInterfaceDeclaration
		decl.interface = true
		decl.name = type.name
		decl.public = true
		decl.addExtendedType(type.superType)
		requireTypes(type.superType)
		if (type.typeData.modelType !== null) {
			requireTypes("IModelPart")
			decl.addExtendedType('''IModelPart<«type.typeData.modelType», «type.name»>''')
		}
		type.extendInterfaces.forEach[requireTypes(it); decl.addExtendedType(it)]
		return decl
	}

	def private getSuperType(Type type) {
		type.extensionOf ?: '''IPropertiesOverlay<«type.name»>'''
	}

	override getImports(Type type) {
		type.getRequiredImports("intf")
	}

	override getFieldMethods(Field field) {
		val methods = new Members(field)
		requireTypes(field.type)
		var first = true
		if (field.isRefable) {
			requireTypes(Reference)
		}
		switch (field.structure) {
			case scalar: {
				for (method : field.scalarMethods) {
					methods.addMember(method).comment(if(first) field.name)
					first = false
				}
			}
			case collection: {
				for (method : field.collectionMethods) {
					methods.addMember(method).comment(if(first) field.name)
					first = false

				}
			}
			case map: {
				for (method : field.mapMethods) {
					methods.addMember(method).comment(if(first) field.name)
					first = false
				}
			}
		}
		methods.forEach[it.packageAccess]
		return methods
	}

	def private getScalarMethods(Field f) {
		val methods = new Members(f)
		// T getFoo()
		methods.addMethod(f.type, '''get«f.name»''')
		// T getFoo(boolean elaborate)
		methods.addMethod(f.type, '''get«f.name»''', "boolean", "elaborate")
		if (f.type == "Boolean") {
			// boolean isFoo()
			methods.addMethod("boolean", '''is«f.name»''')
		}
		// void setFoo(T foo)
		methods.addMethod("void", '''set«f.name»''', f.type, f.lcName)
		if (f.refable) {
			// boolean isFooReference()
			methods.addMethod("boolean", '''is«f.name»Reference''')
			// boolean Reference getFooReference()
			methods.addMethod("Reference", '''get«f.name»Reference''')
		}
		return methods
	}

	def private getCollectionMethods(Field f) {
		val methods = new Members(f)
		requireTypes(Collection)
		// Collection<T> getFoos()
		methods.addMethod('''Collection<«f.type»>''', '''get«f.plural»''')
		// Collection<T> getFoos(boolean elaborate)
		methods.addMethod('''Collection<«f.type»>''', '''get«f.plural»''', "boolean", "elaborate")
		// boolean hasFoos()
		methods.addMethod("boolean", '''has«f.plural»''')
		// T getFoo(int index)
		methods.addMethod(f.type, '''get«f.name»''', "int", "index")
		// void setFoos(Collection<T> foos)
		methods.addMethod("void", '''set«f.plural»''', '''Collection<«f.type»>''', f.lcPlural)
		// void setFoo(int index, T foo)
		methods.addMethod("void", '''set«f.name»''', "int", "index", f.type, f.lcName)
		// void addFoo(T foo)
		methods.addMethod("void", '''add«f.name»''', f.type, f.lcName)
		// void insertFoo(int index, T foo)
		methods.addMethod("void", '''insert«f.name»''', "int", "index", f.type, f.lcName)
		// void removeFoo(int index)
		methods.addMethod("void", '''remove«f.name»''', "int", "index");
		if (f.refable) {
			// boolean isFooReference(int index)
			methods.addMethod("boolean", '''is«f.name»Reference''', "int", "index");
			// Reference getFooReference(int index)
			methods.addMethod("Reference", '''get«f.name»Reference''', "int", "index")
		}
		return methods
	}

	def private getMapMethods(Field f) {
		requireTypes(Map)
		val methods = new Members(f)
		// Map<String, T> getFoos()
		methods.addMethod('''Map<String, «f.type»>''', '''get«f.plural»''')
		// Map<String, T> getFoos(boolean elaborate)
		methods.addMethod('''Map<String, «f.type»>''', '''get«f.plural»''', "boolean", "elaborate")
		// boolean hasFoo(String name)
		methods.addMethod("boolean", '''has«f.name»''', "String", f.keyName)
		// T getFoo(String name)
		methods.addMethod(f.type, '''get«f.name»''', "String", f.keyName)
		// void setFoos(Map<String, T> foos)
		methods.addMethod("void", '''set«f.plural»''', '''Map<String, «f.type»>''', f.lcPlural)
		methods.addMethod("void", "set${name}", "String", "${keyName}", "${type}", "${lcName}");
		// void removeFoo(String name)
		methods.addMethod("void", '''remove«f.name»''', "String", f.keyName);
		if (f.refable) {
			// boolean isFooReference(String name)
			methods.addMethod("boolean", '''is«f.name»Reference''', "String", f.keyName)
			// ReferencegetFooReference(String name)
			methods.addMethod("Reference", '''get«f.name»Reference''', "String", f.keyName)
		}
		return methods
	}
}
