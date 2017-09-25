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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class TypeData {

	private Collection<Type> types;
	private Map<String, String> imports = Maps.newHashMap();
	private List<String> defaultExtendInterfaces = null;
	private Map<String, Type> typeMap = null;

	// Container for "decls" section that is solely used to define reusable anchors
	@JsonProperty
	private Object decls;

	public void init() {
		typeMap = Maps.uniqueIndex(types, new Function<Type, String>() {
			@Override
			public String apply(Type type) {
				return type.getName();
			}
		});
		for (Type type : types) {
			type.init(this);
		}
	}

	public Collection<Type> getTypes() {
		return types;
	}

	public Map<String, Type> getTypeMap() {
		return typeMap;
	}

	public Type getType(String typeName) {
		return typeMap.get(typeName);
	}

	public Map<String, String> getImports() {
		return imports;
	}

	public List<String> getDefaultExtendInterfaces() {
		return defaultExtendInterfaces;
	}

	public static class Type {

		private String name;
		private Map<String, Field> fields = Maps.newLinkedHashMap();
		private List<String> extendInterfaces = Lists.newArrayList();
		private List<Method> extraMethods = Lists.newArrayList();
		private Map<String, Collection<String>> imports = Maps.newHashMap();
		private boolean noGen = false;
		private String extensionOf;

		private TypeData typeData;

		public void init(TypeData typeData) {
			this.typeData = typeData;
			for (Entry<String, Field> field : fields.entrySet()) {
				field.getValue().init(field.getKey(), this);
			}
		}

		public TypeData getTypeData() {
			return typeData;
		}

		public Collection<String> getRequiredImports(String moduleType) {
			Set<String> results = Sets.newLinkedHashSet();
			Collection<String> interfaces = extendInterfaces != null ? extendInterfaces
					: typeData.defaultExtendInterfaces;
			if (interfaces != null) {
				for (String intf : interfaces) {
					if (typeData.imports.containsKey(intf)) {
						results.add(typeData.imports.get(intf));
					}
				}
			}
			if (imports.get(moduleType) != null) {
				for (String imp : imports.get(moduleType)) {
					results.add(imp);
				}
			}
			return results;
		}

		public String getIntfExtendsDecl() {
			List<String> interfaces = extendInterfaces != null ? extendInterfaces : typeData.defaultExtendInterfaces;
			return interfaces != null ? " extends " + StringUtils.join(interfaces, ", ") : "";
		}

		public String getName() {
			return name;
		}

		public Map<String, Field> getFields() {
			return fields;
		}

		public List<String> getExtendInterfaces() {
			return extendInterfaces;
		}

		public List<Method> getExtraMethods() {
			return extraMethods;
		}

		public Map<String, Collection<String>> getImports() {
			return imports;
		}

		public boolean isNoGen() {
			return noGen;
		}

		public String getExtensionOf() {
			return extensionOf;
		}

		public String getImplType() {
			return isNoGen() ? name : getImplType(name);
		}

		public static String getImplType(String typeName) {
			switch (typeName) {
			case "String":
			case "Integer":
			case "Number":
			case "Boolean":
			case "Primitive":
				return typeName + "Overlay";
			case "Object":
				return "AnyObjectOverlay";
			default:
				return typeName + "Impl";
			}
		}
	}

	public static class Field {
		private String name;
		private String plural;
		private Structure structure = Structure.scalar;
		private String type;
		private String keyName = "name";
		private List<String> keyDecls;
		private boolean selfKeyed = false;
		private String keyPattern;
		private boolean noImpl;
		private String id;
		private boolean boolDefault = false;
		private String parentPath;

		private Type container;

		public void init(String id, Type container) {
			this.id = id;
			this.container = container;
		}

		public String getId() {
			return id;
		}

		public Type getContainer() {
			return container;
		}

		public TypeData getTypeData() {
			return container.getTypeData();
		}

		public String getName() {
			return name;
		}

		public String getLcName() {
			String lcName = lcFirst(name);
			switch (lcName) {
			case "default":
			case "enum":
				lcName = lcName + "Value";
			}
			return lcName;
		}

		public String getPlural() {
			return plural != null ? plural : name + "s";
		}

		public String getLcPlural() {
			return lcFirst(getPlural());
		}

		public Structure getStructure() {
			return structure;
		}

		public String getType() {
			return type != null ? type : name;
		}

		String lcFirst(String s) {
			return s.substring(0, 1).toLowerCase() + s.substring(1);
		}

		public String getKeyName() {
			return keyName;
		}

		public Collection<String> getKeyDecls() {
			return keyDecls;
		}

		public boolean isSelfKeyed() {
			return selfKeyed;
		}

		public String getKeyPattern() {
			return keyPattern;
		}

		public boolean isNoImpl() {
			return noImpl;
		}

		public boolean isBoolean() {
			return type.equals("Boolean");
		}

		public boolean getBoolDefault() {
			return boolDefault;
		}

		public String getParentPath() {
			return parentPath != null ? parentPath : id;
		}

		public String getImplType() {
			Type objectType = getContainer().getTypeData().getTypeMap().get(getType());
			return Type.getImplType(objectType != null ? objectType.getName() : getType());
		}

		public boolean isScalarType() {
			switch (getType()) {
			case "String":
			case "Integer":
			case "Number":
			case "Boolean":
			case "Primitive":
			case "Object":
				return true;
			default:
				return false;
			}
		}

		public String getPropertyName() {
			return structure == Structure.scalar ? getLcName() : getLcPlural();
		}

		public String getPropertyType() {
			switch (structure) {
			case scalar:
				return getImplType();
			case collection:
				if (isScalarType()) {
					return t("ValListOverlay<${type}, ${implType}>", this);
				} else {
					return t("ListOverlay<${implType}>", this);
				}
			case map:
				if (isScalarType()) {
					return t("ValMapOverlay<${type}, ${implType}>", this);
				} else {
					return t("MapOverlay<${implType}>", this);
				}
			}
			return null;
		}

		public String getPropertyNew() {
			switch (structure) {
			case scalar:
				return t(isScalarType() ? "new ${implType}(${qpath}, this)"
						: "${implType}.factory.create(${qpath}, this)", this);
			case collection:
				return t(isScalarType() ? "new ValListOverlay<${type}, ${implType}>(${qpath}, this, ${implType}.factory)"
						: "new ListOverlay<${implType}>(${qpath}, this, ${implType}.factory)", this);
			case map:
				return t(isScalarType()
						? "new ValMapOverlay<${type}, ${implType}>(${qpath}, this, ${implType}.factory, ${qkeyPat})"
						: "new MapOverlay<${implType}>(${qpath}, this, ${implType}.factory, ${qkeyPat})", this);
			}
			return null;
		}

		public String getTypeInCollection() {
			return isScalarType() ? type : t("? extends ${type}", this);
		}
	}

	public static class Method {
		private String name;
		private String type;
		private List<String> argDecls;
		private List<String> code;

		public String getName() {
			return name;
		}

		public String getType() {
			return type;
		}

		public List<String> getArgDecls() {
			return argDecls;
		}

		public List<String> getCode() {
			return code;
		}
	}

	public enum Structure {
		scalar, collection, map
	}
}
