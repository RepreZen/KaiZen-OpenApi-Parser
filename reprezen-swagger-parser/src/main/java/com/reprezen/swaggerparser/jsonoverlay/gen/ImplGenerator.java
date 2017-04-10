/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.jsonoverlay.gen;

import static com.reprezen.swaggerparser.jsonoverlay.gen.Template.t;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.gen.SimpleJavaGenerator.Member;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Type;

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
    public void addGeneratedMembers(Type type, SimpleJavaGenerator gen) {
        super.addGeneratedMembers(type, gen);
        gen.addMember(getFactoryMethod(type));
    }

    @Override
    public String getTypeDeclaration(Type type, String suffix) {
        requireTypes(SwaggerObjectImpl.class);
        requireTypes(type);
        return t("public class ${name}${0} extends ${1} implements ${name}", type, suffix, getSuperType(type));
    }

    private String getSuperType(Type type) {
        String superType = type.getExtensionOf();
        return superType != null ? getImplType(superType) : "SwaggerObjectImpl";
    }

    @Override
    protected Members getConstructors(Type type) {
        Members members = new Members();
        members.add(t("public ${name}Impl(String key, JsonNode json, JsonOverlay<?> parent)", type),
                code("super(key, json, parent);"));
        requireTypes(JsonNode.class, JsonOverlay.class);
        members.add(t("public ${name}Impl(String key, JsonOverlay<?> parent)", type), code("super(key, parent);"));
        return members;
    }

    @Override
    protected boolean skipField(Field field) {
        return field.isNoImpl();
    }

    @Override
    protected Members getFieldMembers(Field field) {
        requireTypes(field.getType(), getImplType(field));
        Members members = new Members();
        switch (field.getStructure()) {
        case scalar:
            String reg = t("registerField(${qpath}, \"${lcName}\", ${qkeyPat}", field);
            if (isScalarType(field)) {
                // T foo = register(..., new TImpl(path, this))
                members.add(t("private ${implType} ${lcName} = ${0}, new ${implType}(${qpath}, this))", field, reg));
            } else {
                // T foo = register(..., TImpl.factory.create(path, this)) - protects against infinite recursion
                members.add(t("private ${implType} ${lcName} = ${0}, ${implType}.factory.create(${qpath}, this))",
                        field, reg));
            }
            break;
        case collection:
            requireTypes(Collection.class);
            reg = t("registerField(${qpath}, \"${lcPlural}\", ${qkeyPat}", field);
            if (isScalarType(field)) {
                requireTypes(ValListOverlay.class);
                // ValListOverlay<T, TImpl> foos = new ValListOverlay<T, TImpl>(id, this, TImpl.factory)
                members.add(
                        t("private ValListOverlay<${type}, ${implType}> ${lcPlural} = ${0}, new ValListOverlay<${type}, ${implType}>(${qpath}, this, ${implType}.factory));",
                                field, reg));
            } else {
                requireTypes(ListOverlay.class);
                // ListOverlay<TImpl> foos = new ListOverlay<TImpl>(id, this, TImpl.factory)
                members.add(
                        t("private ListOverlay<${implType}> ${lcPlural} = ${0}, new ListOverlay<${implType}>(${qpath}, this, ${implType}.factory))",
                                field, reg));
            }
            break;
        case map:
            requireTypes(Map.class);
            reg = t("registerField(${qpath}, \"${lcPlural}\", ${qkeyPat}", field);
            if (isScalarType(field)) {
                requireTypes(ValMapOverlay.class);
                // ValMapOverlay<T, TImpl> foos = new ValMapOverlay<T, TImpl>(id, this, TImpl.factory)
                members.add(
                        t("private ValMapOverlay<${type},${implType}> ${lcPlural} = ${0}, new ValMapOverlay<${type}, ${implType}>(${qpath}, this, ${implType}.factory, ${qkeyPat}))",
                                field, reg));
            } else {
                requireTypes(MapOverlay.class);
                // MapOverlay<TImpl> foos = new MapOverlay<TImpl>(id, this, TImpl.factory)
                members.add(
                        t("private MapOverlay<${implType}> ${lcPlural} = ${0}, new MapOverlay<${implType}>(${qpath}, this, ${implType}.factory, ${qkeyPat}))",
                                field, reg));
            }
            break;
        }

        return members;
    }

    @Override
    protected Members getFieldMethods(Field field) {
        Members methods = new Members();
        boolean first = true;
        String typeComment = field.getName();
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
        String setDecl = t("public void set${name}(${type} ${lcName})", field);
        if (isScalarType(field)) {
            // T getFoo() => return foo.get()
            methods.add(getDecl, code(field, "return ${lcName}.get();"));
            if (field.isBoolean()) {
                // boolean isFoo() => foo.get() != null ? foo.get() : boolDefault
                methods.add(t("public boolean is${name}()", field),
                        code(field, "return ${lcName}.get() != null ? ${lcName}.get() : ${boolDefault};"));
            }
            // void setFoo(T foo) => foo = this.foo.set(foo)
            methods.add(setDecl, code(field, "this.${lcName}.set(${lcName});"));
        } else {
            // T getFoo() => return foo
            methods.add(getDecl, code(field, "return ${lcName};"));
            // void setFoo(T foo) => this.foo.set((TImpl) foo)
            methods.add(setDecl, code(field, "this.${lcName}.set((${implType}) ${lcName});"));
        }
        return methods;
    }

    private Members getCollectionMethods(Field field) {
        Members methods = new Members();
        String getDecl = t("public Collection<${collType}> get${plural}()", field);
        String iGetDecl = t("public ${type} get${name}(int index)", field);
        String setDecl = t("public void set${plural}(Collection<${collType}> ${lcPlural})", field);
        String iSetDecl = t("public void set${name}(int index, ${type} ${lcName})", field);
        String addDecl = t("public void add${name}(${type} ${lcName})", field);
        // String insDecl = t("public void insert${name}(int index, ${type} ${lcName})", field);
        String remDecl = t("public void remove${name}(int index)", field);

        // Collection<T> getFoos() => foos.get()
        methods.add(getDecl, code(field, "return ${lcPlural}.get();"));
        // T getFoo(int index) => foos.get(index)
        methods.add(iGetDecl, code(field, "return ${lcPlural}.get(index);"));
        if (isScalarType(field)) {
            // void setFoos(Collection<T> foos) => this.foos.set((TImpl) foos)
            methods.add(setDecl, code(field, "this.${lcPlural}.set((Collection<${collType}>) ${lcPlural});"));
            // void setFoo(int index, T foo) => foos.set(index, foo)
            methods.add(iSetDecl, code(field, "${lcPlural}.set(index, ${lcName});"));
            // void addFoo(Foo foo) => foos.add(foo)
            methods.add(addDecl, code(field, "${lcPlural}.add(${lcName});"));
        } else {
            // void setFoos(Collection<? extends T> foos) => this.foos.set(foos) (requires unchecked cast)
            methods.add(setDecl,
                    code(field, //
                            "@SuppressWarnings(\"unchecked\")", //
                            "Collection<${implType}> impl${plural} = (Collection<${implType}>) ${lcPlural};",
                            "this.${lcPlural}.set(impl${plural});"));
            // void setFoo(int index, Foo foo) => foos.set(index, (TImpl) foo)
            methods.add(iSetDecl, code(field, "${lcPlural}.set(index, (${implType}) ${lcName});"));
            // void addFoo(Foo foo) => foos.add((TImpl) foo)
            methods.add(addDecl, code(field, "${lcPlural}.add((${implType}) ${lcName});"));
        }
        // void insertFoo(int index, Foo foo) => foos.insertOveraly(index, foo)
        // methods.add(insDecl, code(field, "${lcPlural}.insert(index, ${lcName});"));
        // void removeFoo(int index) => foos.remove(index)
        methods.add(remDecl, code(field, "${lcPlural}.remove(index);"));
        // methods.addAll(getKeyedCollectionMethods(field));
        return methods;
    }

    private Member getFactoryMethod(Type type) {
        requireTypes(JsonOverlayFactory.class, JsonNode.class);
        Collection<String> decl = t(type,
                "public static JsonOverlayFactory<${implName}> factory = new JsonOverlayFactory<${implName}>() {", //
                "    @Override", //
                "    public ${implName} create(String key, JsonNode json, JsonOverlay<?> parent) {", //
                "        return isEmptyRecursive(parent, ${implName}.class) ? null : new ${implName}(key, json, parent);", //
                "    }", //
                "}");
        return new Member(StringUtils.join(decl, "\n"), null).generated(true);
    }

    private Members getMapMethods(Field field) {
        Members methods = new Members();
        // Map<String, ? extends T> getFoos() => foos.get()
        methods.add(t("public Map<String, ${collType}> get${plural}()", field),
                code(field, "return ${lcPlural}.get();"));
        // boolean hasFoo(String key) => foos.containsKey(key)
        methods.add(t("public boolean has${name}(String ${keyName})", field),
                code(field, "return ${lcPlural}.containsKey(${keyName});"));
        // T getFoo(String key) => foos.get(key)
        methods.add(t("public ${type} get${name}(String ${keyName})", field),
                code(field, "return ${lcPlural}.get(${keyName});"));
        if (isScalarType(field)) {
            // void setFoos(Map<String, T> foos) => this.foos.set(foos)
            methods.add(t("public void set${plural}(Map<String, ${type}> ${lcPlural})", field),
                    code(field, "this.${lcPlural}.set(${lcPlural});"));
            // void setFoo(String key, Foo foo) => foos.set(key, foo)
            methods.add(t("public void set${name}(String ${keyName}, ${type} ${lcName})", field),
                    code(field, "${lcPlural}.set(${keyName}, ${lcName});"));
        } else {
            // void setFoos(Map<String, ? extends Foo> foos) => this.foos.set(foo) (requires unchecked cast)
            methods.add(t("public void set${plural}(Map<String, ${collType}> ${lcPlural})", field),
                    code(field, //
                            "@SuppressWarnings(\"unchecked\")",
                            "Map<String,${implType}> impl${plural} = (Map<String, ${implType}>) ${lcPlural};",
                            "this.${lcPlural}.set(impl${plural});"));
            // void setFoo(String key, Foo foo) => foos.set(key, (TImpl) foo)
            methods.add(t("public void set${name}(String ${keyName}, ${type} ${lcName})", field),
                    code(field, "${lcPlural}.set(${keyName}, (${implType}) ${lcName});"));
        }
        // void removeFoo(String key) => foos.remove(key)
        methods.add(t("public void remove${name}(String ${keyName})", field),
                code(field, "${lcPlural}.remove(${keyName});"));
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
