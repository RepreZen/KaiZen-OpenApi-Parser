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

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseStart;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StringProvider;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.validator.Java8Validator;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Field;

public class SimpleJavaGenerator {

    private String pkg;
    private Set<String> imports = Sets.newHashSet();
    private ClassOrInterfaceDeclaration type;
    private List<Member> members = Lists.newArrayList();
    private String fileComment;
    private static JavaParser parser = new JavaParser(new ParserConfiguration().setValidator(new Java8Validator()));
    private static int indentation = 4;

    public SimpleJavaGenerator(String pkg, ClassOrInterfaceDeclaration type) {
        this.pkg = pkg;
        this.type = type;
    }

    public String getPackage() {
        return pkg;
    }

    public void setPackage(String pkg) {
        this.pkg = pkg;
    }

    public int getIndentation() {
        return indentation;
    }

    public void setIndentation(int indentation) {
        SimpleJavaGenerator.indentation = indentation;
    }

    public Collection<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addMembers(Collection<Member> members) {
        this.members.addAll(members);
    }

    public void addGeneratedMembers(Collection<Member> members) {
        for (Member member : members) {
            this.members.add(member.generated(true));
        }
    }

    public void setFileComment(String fileComment) {
        this.fileComment = fileComment;
    }

    public void addImport(String imp) {
        if (imp != null) {
            imports.add(imp);
        }
    }

    public String format() {
        CompilationUnit cu = new CompilationUnit();
        if (fileComment != null) {
            cu.addOrphanComment(new JavadocComment(fileComment));
        }
        cu.setPackageDeclaration(pkg);
        for (String imp : imports) {
            cu.addImport(imp);
        }
        cu.addType(type);
        for (Member member : gatherFinalMembers(members, cu)) {
            type.addMember(member.getDeclaration());
        }
        return cu.toString();
    }

    private Collection<Member> gatherFinalMembers(List<Member> members, CompilationUnit cu) {
        Map<String, Member> memberMap = Maps.newLinkedHashMap();
        for (Member member : members) {
            String key = member.getKey();
            if (!memberMap.containsKey(key)) {
                memberMap.put(key, member);
            } else {
                BodyDeclaration<?> copy = member.getDeclaration().clone();
                if (copy instanceof ConstructorDeclaration) {
                    ((ConstructorDeclaration) copy).setBody(JavaParser.parseBlock("{}"));
                    ((ConstructorDeclaration) copy).setComment(null);
                } else if (copy instanceof MethodDeclaration) {
                    ((MethodDeclaration) copy).setBody(null);
                    ((MethodDeclaration) copy).setComment(null);
                } else if (copy instanceof FieldDeclaration) {
                    ((FieldDeclaration) copy).getVariable(0).setInitializer((Expression) null);
                    ((FieldDeclaration) copy).setComment(null);
                }
                copy.setAnnotations(new NodeList<>());
                Logger.getGlobal().warning(String.format("Suppressing already-present generated member in type %s: %s",
                        cu.getType(0).getNameAsString(), copy.toString()));
            }
        }
        return memberMap.values();
    }

    public static class Member {
        protected BodyDeclaration<?> declaration;
        protected Field field = null;
        protected com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type type = null;

        public Member(com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type type,
                BodyDeclaration<?> declaration) {
            this(declaration);
            this.type = type;
        }

        public Member(Field field, BodyDeclaration<?> declaration) {
            this(declaration);
            this.field = field;
        }

        public Member(BodyDeclaration<?> declaration) {
            this.declaration = declaration;
        }

        public BodyDeclaration<?> getDeclaration() {
            return declaration;
        }

        public String getKey() {
            if (declaration instanceof FieldDeclaration) {
                FieldDeclaration field = (FieldDeclaration) declaration;
                if (field.getVariables().size() != 1) {
                    throw new RuntimeException(
                            "Multiple fields in a single manual field declaration is not yet supported: "
                                    + field.toString());
                }
                return "F:" + field.getVariable(0).getNameAsString();
            } else if (declaration instanceof MethodDeclaration) {
                MethodDeclaration method = (MethodDeclaration) declaration;
                return "M:" + method.getNameAsString() + ":" + method.getParameters().stream()
                        .map(p -> p.getType().toString()).collect(Collectors.joining(","));
            } else if (declaration instanceof ConstructorDeclaration) {
                ConstructorDeclaration constructor = (ConstructorDeclaration) declaration;
                return "C:" + constructor.getParameters().stream().map(p -> p.getType().toString())
                        .collect(Collectors.joining(","));
            }
            throw new RuntimeException(
                    "Unsupported manual member type encountered: " + declaration.getClass().getName());
        }

        public Member override() {
            declaration.addMarkerAnnotation(Override.class);
            return this;
        }

        public Member comment(String comment) {
            return this;
        }

        public Member generated(boolean generated) {
            if (generated) {
                declaration.addSingleMemberAnnotation(Generated.class, "\"" + CodeGenerator.class.getName() + "\"");
            }
            return this;
        }

        public Member code(String... code) {
            return code(Arrays.asList(code));
        }

        public Member code(Collection<String> code) {
            throw new RuntimeException("Cannot add code to member of type " + this.declaration.getClass());
        }

        public Member _static(boolean _static) {
            throw new RuntimeException("Cannot set member of type " + this.declaration.getClass() + " static");
        }

        public Member publicAccess() {
            setAccess(Modifier.PUBLIC);
            return this;
        }

        public Member protectedAccess() {
            setAccess(Modifier.PROTECTED);
            return this;
        }

        public Member packageAccess() {
            setAccess(null);
            return this;
        }

        public Member privateAccess() {
            setAccess(Modifier.PRIVATE);
            return this;
        }

        protected void setAccess(Modifier mod) {
        }

        protected final EnumSet<Modifier> setAccessModifier(EnumSet<Modifier> mods, Modifier mod) {
            mods.remove(Modifier.PUBLIC);
            mods.remove(Modifier.PROTECTED);
            mods.remove(Modifier.PRIVATE);
            if (mod != null) { // package private
                mods.add(mod);
            }
            return mods;
        }

        public String format() {
            return declaration.toString();
        }

        public String getName() {
            return null;
        }

        public void setName(String name) {
        }
    }

    public static class ConstructorMember extends Member {
        private ConstructorDeclaration cons;

        public ConstructorMember(com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type type, String className,
                String... paramPairs) {
            this(type, className, Arrays.asList(paramPairs));
            this.cons = (ConstructorDeclaration) declaration;
        }

        public ConstructorMember(com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type type, String className,
                List<String> paramPairs) {
            super(type, constructorDecl(type, className, paramPairs));
        }

        @Override
        public Member code(Collection<String> code) {
            // JavaParser does not appear capable of parsing calls to super() and this() in
            // block statements. So we need to just add the statements one at a time...
            BlockStmt body = cons.getBody();
            for (String stmt : expandStrings(type, code)) {
                body.addStatement(stmt);
            }
            return this;
        }

        @Override
        protected void setAccess(Modifier mod) {
            cons.setModifiers(setAccessModifier(cons.getModifiers(), mod));
        }
    }

    private static ConstructorDeclaration constructorDecl(
            com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type type, String className,
            List<String> paramPairs) {
        ConstructorDeclaration decl = new ConstructorDeclaration();
        decl.setPublic(true);
        decl.setName(t(className, type));
        for (int i = 0; i < paramPairs.size(); i += 2) {
            decl.addParameter(t(paramPairs.get(i), type), t(paramPairs.get(i + 1), type));
        }
        return decl;
    }

    public static class MethodMember extends Member {
        private MethodDeclaration meth;

        public MethodMember(Field field, String type, String name, String... paramPairs) {
            this(field, type, name, Arrays.asList(paramPairs));
            this.meth = (MethodDeclaration) declaration;
        }

        public MethodMember(Field field, String type, String name, List<String> paramPairs) {
            super(field, methodDecl(field, type, name, paramPairs));
        }

        private static MethodDeclaration methodDecl(Field field, String type, String name, List<String> paramPairs) {
            MethodDeclaration decl = new MethodDeclaration();
            decl.setPublic(true);
            decl.setType(t(type, field));
            decl.setName(t(name, field));
            decl.setBody(null);
            for (int i = 0; i < paramPairs.size(); i += 2) {
                decl.addParameter(t(paramPairs.get(i), field), t(paramPairs.get(i + 1), field));
            }
            return decl;
        }

        @Override
        public Member code(Collection<String> code) {
            String blockCode = code != null ? "{" + String.join("", expandStrings(field, code)) + "}" : "{}";
            BlockStmt block = SimpleJavaGenerator.parser.parse(ParseStart.BLOCK, new StringProvider(blockCode))
                    .getResult().get();
            meth.setBody(block);
            return this;
        }

        @Override
        public Member _static(boolean _static) {
            meth.setStatic(_static);
            return this;
        }

        @Override
        public Member comment(String comment) {
            meth.setComment(comment != null ? new LineComment(comment) : null);
            return this;
        }

        @Override
        protected void setAccess(Modifier mod) {
            meth.setModifiers(setAccessModifier(meth.getModifiers(), mod));
        }

        @Override
        public String getName() {
            return meth.getNameAsString();
        }

        @Override
        public void setName(String name) {
            meth.setName(name);
        }
    }

    public static class FieldMember extends Member {
        private FieldDeclaration fld;

        public FieldMember(Field field, String type, String name) {
            this(field, type, name, null);
        }

        public FieldMember(Field field, String type, String name, String initializer) {
            super(field, fieldDecl(field, type, name, initializer));
            this.fld = (FieldDeclaration) declaration;
        }

        private static FieldDeclaration fieldDecl(Field field, String typeString, String name, String initializer) {
            FieldDeclaration decl = new FieldDeclaration();
            decl.setPrivate(true);
            Type type = parser.parse(ParseStart.TYPE, new StringProvider(t(typeString, field))).getResult().get();
            VariableDeclarator var = new VariableDeclarator(type, t(name, field));
            if (initializer != null) {
                var.setInitializer(parser.parse(ParseStart.EXPRESSION, new StringProvider(t(initializer, field)))
                        .getResult().get());
            }
            decl.addVariable(var);
            return decl;
        }

        @Override
        public Member _static(boolean _static) {
            fld.setStatic(_static);
            return this;
        }

        @Override
        protected void setAccess(Modifier mod) {
            fld.setModifiers(setAccessModifier(fld.getModifiers(), mod));
        }

        @Override
        public String getName() {
            return fld.getVariable(0).getNameAsString();
        }

        @Override
        public void setName(String name) {
            fld.getVariable(0).setName(name);
        }
    }

    private static List<String> expandStrings(Field field, Collection<String> strings) {
        return strings.stream().map(s -> t(s, field)).collect(Collectors.toList());
    }

    private static List<String> expandStrings(com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type type,
            Collection<String> strings) {
        return strings.stream().map(s -> t(s, type)).collect(Collectors.toList());
    }
}
