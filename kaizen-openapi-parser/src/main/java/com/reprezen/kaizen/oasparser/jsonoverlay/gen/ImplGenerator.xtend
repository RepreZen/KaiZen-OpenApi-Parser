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

import com.fasterxml.jackson.core.JsonPointer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.TypeDeclaration
import com.google.common.collect.Queues
import com.google.common.collect.Sets
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.EnumOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.SimpleJavaGenerator.Member
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Field
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type
import java.io.File
import java.util.Collection
import java.util.Map
import java.util.stream.Collectors

class ImplGenerator extends TypeGenerator {

	new(File dir, String intfPackage, String implPackage, String suffix, boolean preserve) {
		super(dir, intfPackage, implPackage, suffix, preserve)
	}

	override String getPackage() {
		return implPackage
	}

	override Collection<String> getImports(Type type) {
		return type.getRequiredImports("impl", "both")
	}

	override boolean needIntfImports() {
		return true
	}

	override Members getOtherMembers(Type type) {
		val members = new Members
		if (type.isEnum) {
			members.add(new Member('''
				protected Class<«type.name»> getEnumClass() {
					return «type.name».class;
				}
			'''))
			members.add(type.enumFactoryMember)
		} else {
			members.add(getElaborateChildrenMethod(type))
			members.add(getCopyChildPropertiesMethod(type))
			members.addAll(getFactoryMembers(type))
		}
		return members
	}

	override TypeDeclaration<?> getTypeDeclaration(Type type, String suffix) {
		val decl = new ClassOrInterfaceDeclaration()
		decl.setInterface(false)
		decl.setPublic(true)
		decl.setName(type.getName() + suffix)
		if (type.isEnum) {
			requireTypes(EnumOverlay)
			decl.addExtendedType('''EnumOverlay<«type.name»>''')
		} else {
			decl.addExtendedType(getSuperType(type))
			decl.addImplementedType(type.getName())
		}
		return decl
	}

	def private isEnum(Type type) {
		return !type.enumValues.empty
	}

	def private String getSuperType(Type type) {
		var superType = type.getExtensionOf()
		if (superType === null) {
			requireTypes("PropertiesOverlay")
			return '''PropertiesOverlay<«type.name»>'''
		} else {
			return superType + suffix
		}
	}

	override Members getConstructors(Type type) {
		val members = new Members
		requireTypes(JsonNode, JsonOverlay)
		members.addMember('''
			public «type.implType»(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
				super(json, parent, refReg);
				«IF !type.isEnum»
					super.maybeElaborateChildrenAtCreation();
				«ENDIF»
			}
		''')
		members.addMember('''
			public «type.implType»(«type.name» «type.lcName», JsonOverlay<?> parent, ReferenceRegistry refReg) {
				super(«type.lcName», parent, refReg);
				«IF !type.isEnum»
					super.maybeElaborateChildrenAtCreation();
				«ENDIF»			
			}
		''')
		return members
	}

	override boolean skipField(Field field) {
		return field.noImpl
	}

	override Members getFieldMembers(Field field) {
		val members = new Members
		requireTypes(field.getType(), field.getImplType())
		members.addMember('''private «field.propertyType» «field.propertyName»;''')
		switch (field.getStructure()) {
			case scalar:
				requireTypes(ChildOverlay)
			case collection:
				requireTypes(Collection, ListOverlay, ChildListOverlay)
			case map:
				requireTypes(Map, MapOverlay, ChildMapOverlay)
		}
		return members
	}

	override Members getFieldMethods(Field field) {
		val methods = new Members
		var first = true
		if (field.refable) {
			requireTypes(Reference)
		}
		switch (field.getStructure()) {
			case scalar:
				for (Member method : getScalarMethods(field)) {
					methods.addMember(method).override().comment(if(first) field.name)
					first = false
				}
			case collection:
				for (Member method : getCollectionMethods(field)) {
					methods.addMember(method).override().comment(if(first) field.name)
					first = false
				}
			case map:
				for (Member method : getMapMethods(field)) {
					methods.addMember(method).override().comment(if(first) field.name)
					first = false
				}
		}
		return methods
	}

	def private Members getScalarMethods(Field f) {
		val methods = new Members
		methods.addMember('''
			public «f.type» get«f.name»() {
				return «f.propertyName».get();	
			}
		''')
		methods.addMember('''
			public «f.type» get«f.name»(boolean elaborate) {
				return «f.propertyName».get(elaborate);
			}
		''')
		if (f.isBoolean) {
			methods.addMember('''
				public boolean is«f.name»() {
					return «f.propertyName».get() != null ? «f.propertyName».get() : «f.boolDefault»;
				}
			''')
		}
		methods.addMember('''
			public void set«f.name»(«f.type» «f.lcName») {
				this.«f.lcName».set(«f.lcName»);
			}
		''')
		if (f.refable) {
			methods.addMember('''
				public boolean is«f.name»Reference() {
					return «f.propertyName» != null ? «f.propertyName».isReference() : false;
				}
			''')
			methods.addMember('''
				public Reference get«f.name»Reference() {
					return «f.propertyName» != null ? «f.propertyName».getReference() : null;
				}
			''')
		}
		return methods
	}

	def private Members getCollectionMethods(Field f) {
		val methods = new Members
		methods.addMember('''
			public Collection<«f.type»> get«f.plural»() {
					return «f.propertyName».get();
				}
		''')
		methods.addMember('''
			public Collection<«f.type»> get«f.plural»(boolean elaborate) {
				return «f.propertyName».get(elaborate);
			}
		''')
		methods.addMember('''
			public boolean has«f.plural»() {
				return «f.propertyName».isPresent();
			}
		''')
		methods.addMember('''
			public «f.type» get«f.name»(int index) {
				return «f.propertyName».get(index);
			}
		''')
		methods.addMember('''
			public void set«f.plural»(Collection<«f.type»> «f.lcPlural») {
				this.«f.propertyName».set(«f.lcPlural»);
			}
		''')
		methods.addMember('''
			public void set«f.name»(int index, «f.type» «f.lcName») {
				«f.propertyName».set(index, «f.lcName»);
			}
		''')
		methods.addMember('''
			public void add«f.name»(«f.type» «f.lcName») {
				«f.propertyName».add(«f.lcName»);
			}
		''')
		methods.addMember('''
			public void insert«f.name»(int index, «f.type» «f.lcName») {
				«f.propertyName».insert(index, «f.lcName»);
			}
		''')

		methods.addMember('''
			public void remove«f.name»(int index) {
				«f.propertyName».remove(index);
			}
		''')
		if (f.refable) {
			methods.addMember('''
				public boolean is«f.name»Reference(int index) {
					return «f.propertyName».getChild(index).isReference();
				}
			''')
			methods.addMember('''
				public Reference get«f.name»Reference(int index) {
					return «f.propertyName».getChild(index).getReference();
				}
			''')
		}
		return methods
	}

	def private Members getMapMethods(Field f) {
		val methods = new Members
		methods.addMember('''
			public Map<String, «f.type»> get«f.plural»() {
				return «f.propertyName».get();
			}
		''')
		methods.addMember('''
			public Map<String, «f.type»> get«f.plural»(boolean elaborate) {
				return «f.propertyName».get(elaborate);
			}
		''')
		methods.addMember('''
			public boolean has«f.name»(String «f.keyName») {
				return «f.propertyName».containsKey(«f.keyName»);
			}
		''')
		methods.addMember('''
			public «f.type» get«f.name»(String «f.keyName») {
				return «f.propertyName».get(«f.keyName»);
			}
		''')
		methods.addMember('''
			public void set«f.plural»(Map<String, «f.type»> «f.lcPlural») {
				this.«f.propertyName».set(«f.lcPlural»);
			}
		''')
		methods.addMember('''
			public void set«f.name»(String «f.keyName», «f.type» «f.lcName») {
				«f.propertyName».set(«f.keyName», «f.lcName»);
			}
		''')
		methods.addMember('''
			public void remove«f.name»(String «f.keyName») {
				«f.propertyName».remove(«f.keyName»);
			}
		''')
		if (f.refable) {
			methods.addMember('''
				public boolean is«f.name»Reference(String «f.keyName») {
					ChildOverlay<«f.type»> child = «f.propertyName».getChild(«f.keyName»);
					return child != null ? child.isReference() : false;
				}
			''')
			methods.addMember('''
				public Reference get«f.name»Reference(String «f.keyName») {
					ChildOverlay<«f.type»> child = «f.propertyName».getChild(«f.keyName»);
					return child != null ? child.getReference() : null;
				}
			''')
		}
		return methods
	}

	def private Member getElaborateChildrenMethod(Type type) {
		return new Member('''
			protected void elaborateChildren() {
				super.elaborateChildren();
				«FOR f : type.fields.values.filter[!it.noImpl]»
					«f.propertyName» = «f.propertyNew»;
					«IF f.refable»refables.put("«f.parentPath»", «f.propertyName»);«ENDIF»
				«ENDFOR»
			}
		''').override
	}

	def private Member getCopyChildPropertiesMethod(Type type) {
		requireTypes(ChildOverlay)
		return new Member('''
			protected void copyChildProperties(JsonOverlay<?> from) {
				super.copyChildProperties(from);
				«type.implType» impl = («type.implType») from;
				«FOR f : type.fields.values.filter[!it.noImpl]»
					this.«f.propertyName» = impl.«f.propertyName»;
					ChildOverlay.reparent(«f.propertyName», impl, this);
					«IF f.refable»refables.put("«f.parentPath»", «f.propertyName»);«ENDIF»
				«ENDFOR»
			}
		''').override
	}

	def private Member getEnumFactoryMember(Type type) {
		requireTypes(OverlayFactory, IJsonOverlay, JsonOverlay, JsonNode, ReferenceRegistry,
			JsonNodeFactory)
		return new Member('''
			public static OverlayFactory<«type.name»> factory = new OverlayFactory<«type.name»>() {
				@Override
				protected Class<? extends IJsonOverlay<? super «type.name»>> getOverlayClass() {
					return «type.implType».class;
				}
				
				@Override
				public JsonOverlay<«type.name»> _create(«type.name» «type.lcName», JsonOverlay<?> parent, ReferenceRegistry refReg) {
					return new «type.implType»(«type.lcName», parent, refReg);
				}
				
				@Override
				public JsonOverlay<«type.name»> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
					return new «type.implType»(json, parent, refReg);
				}
				
			};
		''')
	}

	def private Members getFactoryMembers(Type type) {
		val members = new Members
		members.add(getFactoryMember(type))
		members.addAll(getSubtypeSelectors(type))
		return members
	}

	def private Member getFactoryMember(Type type) {
		requireTypes(OverlayFactory, JsonNode, ReferenceRegistry, IJsonOverlay)
		return new Member('''
			public static OverlayFactory<«type.name»> factory = new OverlayFactory<«type.name»>(){
				@Override
				protected Class<? extends IJsonOverlay<? super «type.name»>> getOverlayClass() {
					return «type.implType».class;
				}
			
				@Override
				public JsonOverlay<«type.name»> _create(«type.name» «type.lcName», JsonOverlay<?> parent, ReferenceRegistry refReg) {
					IJsonOverlay<?> overlay;
					«IF type.subTypes.empty»
						overlay = new «type.implType»(«type.lcName», parent, refReg);
					«ELSE»
						Class<? extends «type.name»> subtype = getSubtypeOf(«type.lcName»);
						«getSubtypeCreate(type, type.lcName)»
					«ENDIF»
					@SuppressWarnings("unchecked")
					JsonOverlay<«type.name»> castOverlay = (JsonOverlay<«type.name»>) overlay;
					return castOverlay;
				}
			
				@Override
				public JsonOverlay<«type.name»> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
					IJsonOverlay<?> overlay;
					«IF type.subTypes.empty»
						overlay = new «type.implType»(json, parent, refReg);
					«ELSE»
						Class<? extends «type.name»> subtype = getSubtypeOf(json);
						«getSubtypeCreate(type, ".json")»
					«ENDIF»
					@SuppressWarnings("unchecked")
					JsonOverlay<«type.name»> castOverlay = (JsonOverlay<«type.name»>) overlay;
					return castOverlay;
				}
				
				«IF type.discriminator !== null»
					@Override
					protected getDiscriminator() {
						return "«type.discriminator»";
					}
				«ENDIF»
			};
		''')
	}

	def private Members getSubtypeSelectors(Type type) {
		val members = new Members
		val subTypes = type.subTypes
		if (!subTypes.isEmpty() && !type.isAbstract()) {
			subTypes.add(type)
		}
		members.add(getValueSubtypeSelector(type, subTypes))
		members.add(getJsonSubtypeSelector(type, subTypes))
		return members
	}

	def private Member getValueSubtypeSelector(Type t, Collection<Type> subTypes) {
		val switchExpr = '''«t.lcName».getClass().getSimpleName()'''
		return new Member('''
			private static Class<? extends «t.name»> getSubtypeOf(«t.name» «t.lcName») {
				«t.getSubtypeSwitch(subTypes, switchExpr,[it.name])»
			}
		''')
	}

	def private Member getJsonSubtypeSelector(Type t, Collection<Type> subTypes) {
		requireTypes(JsonPointer, Collectors)
		val switchExpr = '''json.at(JsonPointer.compile("/«t.discriminator»")).asText()'''
		return new Member('''
			private static Class<? extends «t.name»> getSubtypeOf(JsonNode json) {
				«t.getSubtypeSwitch(subTypes, switchExpr, [it.discriminatorValue])»
			}
		''')
	}

	def private String getSubtypeSwitch(Type t, Collection<Type> subTypes, String switchExpr, (Type)=>String discFn) {
		return '''
			«IF subTypes.empty»
				return «t.name».class;
			«ELSE»
				switch(«switchExpr») {
					«FOR sub: subTypes»
						case "«discFn.apply(sub)»":
							return «sub.name».class;
					«ENDFOR»
					default:
						return null;
				}
			«ENDIF»
		'''
	}

	def private String getSubtypeCreate(Type t, String arg0) {
		val subtypes = t.subTypes
		if (subtypes.empty) {
			return '''
				overlay = new «t.implType»(«t.castArg0(arg0)», parent, refReg);
			'''
		} else {
			return '''
				switch (subtype != null ? subtype.getSimpleName() : "") {
					«FOR sub : subtypes»
						case "«sub.name»":
							overlay = «sub.implType».factory.create(«sub.castArg0(arg0)», parent, refReg, null);
							break;
					«ENDFOR»
					default:
						overlay = new «t.implType»(«t.castArg0(arg0)», parent, refReg);
				}
			'''
		}
	}

	def private castArg0(Type type, String arg0) {
		return if(arg0 == ".json") "json" else '''(«type.name») «arg0»'''
	}

	def private Collection<Type> getSubTypes(Type type) {
		val subTypes = Sets.<Type>newHashSet()
		val todo = Queues.<Type>newArrayDeque()
		todo.add(type)
		while (!todo.isEmpty()) {
			val nextType = todo.remove()
			if (!subTypes.contains(nextType)) {
				subTypes.add(nextType)
				val directSubtypes = type.typeData.types.filter[it.extensionOf == nextType.name]
				todo.addAll(directSubtypes)
			}
		}
		subTypes.remove(type)
		return subTypes
	}
}
