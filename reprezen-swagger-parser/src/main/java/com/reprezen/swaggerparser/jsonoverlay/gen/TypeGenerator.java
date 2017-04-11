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
package com.reprezen.swaggerparser.jsonoverlay.gen;

import static com.reprezen.swaggerparser.jsonoverlay.gen.Template.t;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.reprezen.swaggerparser.Swagger;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.gen.SimpleJavaGenerator.Member;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Type;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.BooleanOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.IntegerOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.NumberOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.Primitive;
import com.reprezen.swaggerparser.jsonoverlay.std.PrimitiveOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.ValidationResults.Severity;
import com.reprezen.swaggerparser.val.Validator;
import com.reprezen.swaggerparser.val3.Swagger3Validator;

public abstract class TypeGenerator {

    private File dir;
    protected String intfPackage;
    protected String implPackage;
    private String suffix;
    private boolean preserve;
    private Set<String> requiredTypes = Sets.newHashSet();

    public TypeGenerator(File dir, String intfPackage, String implPackage, String suffix, boolean preserve) {
        this.dir = dir;
        this.intfPackage = intfPackage;
        this.implPackage = implPackage;
        this.suffix = suffix;
        this.preserve = preserve;
    }

    protected abstract String getTypeDeclaration(Type type, String suffix);

    public void generate(Type type) throws IOException {
        File javaFile = new File(dir, t("${name}${0}.java", type, suffix));
        System.out.println("Generating " + javaFile.getCanonicalFile());
        CompilationUnit existing = preserve && javaFile.exists() ? tryParse(javaFile) : null;
        String declaration = getTypeDeclaration(type, suffix);
        SimpleJavaGenerator gen = new SimpleJavaGenerator(getPackage(), declaration);
        if (existing != null) {
            copyFileComment(gen, existing);
            addManualMethods(gen, existing);
        }
        requireTypes(getImports(type));
        addGeneratedMembers(type, gen);
        requireTypes(Generated.class);
        resolveImports(type, gen);
        FileUtils.write(javaFile, gen.format(), Charsets.UTF_8);
    }

    protected abstract String getPackage();

    protected abstract Collection<String> getImports(Type type);

    protected void requireTypes(Class<?>... types) {
        requireTypes(Collections2.transform(Arrays.asList(types), new Function<Class<?>, String>() {
            @Override
            public String apply(Class<?> type) {
                return type.getSimpleName();
            }
        }).toArray(new String[types.length]));
    }

    protected void requireTypes(Type... types) {
        requireTypes(Collections2.transform(Arrays.asList(types), new Function<Type, String>() {
            @Override
            public String apply(Type type) {
                return type.getName();
            }
        }).toArray(new String[types.length]));
    }

    protected void requireTypes(String... types) {
        requiredTypes.addAll(Arrays.asList(types));
    }

    protected void requireTypes(Collection<String> types) {
        requiredTypes.addAll(types);
    }

    private void resolveImports(Type type, SimpleJavaGenerator gen) {
        Map<String, String> importMap = type.getTypeData().getImports();
        Map<String, Type> typeMap = type.getTypeData().getTypeMap();
        for (String requiredType : requiredTypes) {
            gen.addImport(resolveImport(requiredType, typeMap, importMap));
        }
    }

    private static Set<String> autoTypes = getAutoTypes();

    private static Set<String> getAutoTypes() {
        Set<String> results = Sets.newHashSet();
        ArrayList<Class<?>> autos = Lists.<Class<?>> newArrayList(//
                String.class, //
                Integer.class, //
                Number.class, //
                Boolean.class, //
                Primitive.class, //
                Object.class);
        for (Class<?> cls : autos) {
            results.add(cls.getSimpleName());
        }
        return results;
    }

    private static Map<String, String> knownTypes = getKnownTypes();

    private static Map<String, String> getKnownTypes() {
        Map<String, String> results = Maps.newHashMap();
        ArrayList<Class<?>> overlays = Lists.<Class<?>> newArrayList( //
                Generated.class, //
                Collection.class, //
                Map.class, //
                Optional.class, //
                JsonNode.class, //
                JsonOverlay.class, //
                JsonOverlayFactory.class, //
                Inject.class, //
                StringOverlay.class, //
                IntegerOverlay.class, //
                NumberOverlay.class, //
                BooleanOverlay.class, //
                PrimitiveOverlay.class, //
                AnyObjectOverlay.class, //
                ListOverlay.class, //
                ValListOverlay.class, //
                MapOverlay.class, //
                ValMapOverlay.class, //
                Validator.class, //
                ValidationResults.class, //
                Swagger3Validator.class, //
                Swagger.class, //
                Severity.class);
        for (Class<?> cls : overlays) {
            results.put(cls.getSimpleName(), cls.getName().replaceAll("\\$", "."));
        }
        return results;
    }

    private String resolveImport(String type, Map<String, Type> typeMap, Map<String, String> importMap) {
        if (importMap.containsKey(type)) {
            String imp = importMap.get(type);
            if (imp.equals("_intf")) {
                return intfPackage + "." + type;
            } else if (imp.equals("_impl")) {
                return implPackage + "." + type;
            } else {
                return imp;
            }
        } else if (typeMap.containsKey(type)) {
            // interface type
            return intfPackage + "." + type;
        } else if (!suffix.isEmpty() && type.endsWith(suffix)
                && typeMap.containsKey(type.substring(0, type.length() - suffix.length()))) {
            // impl type
            return implPackage + "." + type;
        } else if (autoTypes.contains(type)) {
            return null;
        } else if (knownTypes.containsKey(type)) {
            return knownTypes.get(type);
        } else {
            throw new RuntimeException("Unable to resolve import for type: " + type);
        }
    }

    protected void addGeneratedMembers(Type type, SimpleJavaGenerator gen) {
        gen.addGeneratedMembers(getConstructors(type));
        for (Field field : type.getFields().values()) {
            if (!skipField(field)) {
                gen.addGeneratedMembers(getFieldMembers(field));
            }
        }
        for (Field field : type.getFields().values()) {
            if (!skipField(field)) {
                gen.addGeneratedMembers(getFieldMethods(field));
            }
        }
    }

    protected boolean skipField(Field field) {
        return false;
    }

    private CompilationUnit tryParse(File file) {
        try {
            return JavaParser.parse(file);
        } catch (ParseException | IOException e) {
            System.err.println("ABORTING AFTER PARTIAL GENERATION!");
            System.err.printf(
                    "Parsing of file %s failed; so generation cannot continue without destroying manual code.\n", file);
            System.err.println("Please restore generated code artifacts to a known good state before regenerating");
            System.err.println("Parse Error:");
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    private void copyFileComment(SimpleJavaGenerator gen, CompilationUnit existing) {
        Comment fileComment = existing.getComment();
        if (fileComment != null) {
            gen.setFileComment(fileComment.toString());
        }
    }

    private void addManualMethods(SimpleJavaGenerator gen, CompilationUnit existing) {
        for (TypeDeclaration type : existing.getTypes()) {
            for (BodyDeclaration member : type.getMembers()) {
                if (member instanceof MethodDeclaration || member instanceof FieldDeclaration) {
                    if (!isGenerated(member)) {
                        gen.addMember(new Member(member.toString(), null).complete(true));
                    }
                }
            }
        }

    }

    private boolean isGenerated(BodyDeclaration node) {
        for (AnnotationExpr annotation : node.getAnnotations()) {
            if (annotation.getName().toString().equals("Generated")) {
                return true;
            }
        }
        return false;
    }

    protected Members getConstructors(Type type) {
        return new Members();
    }

    protected Members getFieldMembers(Field field) {
        return new Members();
    }

    protected Members getFieldMethods(Field field) {
        return new Members();
    }

    protected Member addMember(String declaration, Collection<String> code) {
        Member member = new Member(declaration, code);
        return member;
    }

    protected final Member addMember(String declaration) {
        return addMember(declaration, null);
    }

    protected static String getImplType(Field field) {
        Type fieldType = field.getContainer().getTypeData().getTypeMap().get(field.getType());
        return fieldType == null ? getImplType(field.getType()) : getImplType(fieldType);
    }

    protected static String getImplType(Type type) {
        return type.isNoGen() ? type.getName() : getImplType(type.getName());
    }

    protected static String getTypeInCollection(Field field) {
        String type = field.getType();
        return isScalarType(field) ? type : "? extends " + type;
    }

    protected static String getImplType(String type) {
        switch (type) {
        case "String":
        case "Integer":
        case "Number":
        case "Boolean":
        case "Primitive":
            return type + "Overlay";
        case "Object":
            return "AnyObjectOverlay";
        default:
            return type + "Impl";
        }
    }

    protected static boolean isScalarType(Field field) {
        switch (field.getType()) {
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

    protected static class Members extends ArrayList<Member> {

        private static final long serialVersionUID = 1L;

        public Member add(String declaration, Collection<String> code) {
            Member member = new Member(declaration, code);
            super.add(member);
            return member;
        }

        public Member add(String declaration) {
            return add(declaration, null);
        }

        public Member addMember(Member member) {
            add(member);
            return member;
        }
    }
}
