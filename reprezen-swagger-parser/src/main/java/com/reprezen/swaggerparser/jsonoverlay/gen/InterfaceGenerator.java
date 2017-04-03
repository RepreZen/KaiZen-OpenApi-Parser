package com.reprezen.swaggerparser.jsonoverlay.gen;

import static com.reprezen.swaggerparser.jsonoverlay.gen.Template.t;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.reprezen.swaggerparser.jsonoverlay.gen.SimpleJavaGenerator.Member;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Type;

public class InterfaceGenerator extends TypeGenerator {

    public InterfaceGenerator(File dir, String intfPackage, String implPackage, String suffix, boolean preserve) {
        super(dir, intfPackage, implPackage, suffix, preserve);
    }

    @Override
    protected String getPackage() {
        return intfPackage;
    }

    @Override
    protected String getTypeDeclaration(Type type, String suffix) {
        String superType = getSuperType(type);
        requireTypes(superType);
        requireTypes(type.getExtendInterfaces());
        List<String> allTypes = Lists.newArrayList(superType);
        allTypes.addAll(type.getExtendInterfaces());
        return t("public interface ${name} extends ${0}", type, StringUtils.join(allTypes, ", "));
    }

    @Override
    protected Collection<String> getImports(Type type) {
        return type.getRequiredImports("intf");
    }

    private String getSuperType(Type type) {
        String superType = type.getExtensionOf();
        return superType != null ? superType : "SwaggerObject";
    }

    @Override
    protected Members getFieldMethods(Field field) {
        Members methods = new Members();
        requireTypes(field.getType());
        boolean first = true;
        String typeComment = field.getName();
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
        return methods;
    }

    private Members getScalarMethods(Field field) {
        Members methods = new Members();
        // T getFoo()
        methods.add(t("${type} get${name}()", field));
        if (field.getType().equals("Boolean")) {
            // boolean isFoo()
            methods.add(t("boolean is${name}()", field));
        }
        // void setFoo(T foo)
        methods.add(t("void set${name}(${type} ${lcName})", field));
        return methods;
    }

    private Members getCollectionMethods(Field field) {
        Members methods = new Members();
        // Collection<? extends T> getFoos()
        methods.add(t("Collection<${collType}> get${plural}()", field));
        // boolean hasFoos()
        methods.add(t("boolean has${plural}()", field));
        // T getFoo(int index)
        methods.add(t("${type} get${name}(int index)", field));
        // void setFoos(Collection<? extends T> foos)
        methods.add(t("void set${plural}(Collection<${collType}> ${lcPlural})", field));
        // void setFoo(int index, Foo foo)
        methods.add(t("void set${name}(int index, ${type} ${lcName})", field));
        // void addFoo(Foo foo)
        methods.add(t("void add${name}(${type} ${lcName})", field));
        // void insertFoo(int index, Foo foo)
        // methods.add(t("void insert${name}(int index, ${type} ${lcName})", field));
        // void removeFoo(int index)
        methods.add(t("void remove${name}(int index)", field));
        // methods.addAll(getKeyedCollectionMethods(field));
        return methods;
    }

    private Members getMapMethods(Field field) {
        Members methods = new Members();
        // Map<String, ? extends T> getFoos()
        methods.add(t("Map<String, ${collType}> get${plural}()", field));
        // boolean hasFoo(String name)
        methods.add(t("boolean has${name}(String ${keyName})", field));
        // Foo getFoo(String name)
        methods.add(t("${type} get${name}(String ${keyName})", field));
        // void setFoos(Map<String, ? extends T> foos)
        methods.add(t("void set${plural}(Map<String, ${collType}> ${lcPlural})", field));
        // void setFoo(String name, Foo foo)
        methods.add(t("void set${name}(String ${keyName}, ${type} ${lcName})", field));
        // void removeFoo(String name)
        methods.add(t("void remove${name}(String ${keyName})", field));
        return methods;
    }
}
