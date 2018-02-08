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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.expr.Expression;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class SimpleJavaGenerator {

    private String pkg;
    private Set<String> imports = Sets.newHashSet();
    private TypeDeclaration<?> type;
    private List<Member> members = Lists.newArrayList();
    private String fileComment;
    private static int indentation = 4;

    public SimpleJavaGenerator(String pkg, TypeDeclaration<?> type) {
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
            this.members.add(member.generated());
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

        public Member(BodyDeclaration<?> declaration) {
            this.declaration = declaration;
        }

        public Member(String code) {
            try {
                this.declaration = JavaParser.parseBodyDeclaration(code);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(code);
            }
            // this(JavaParser.parseBodyDeclaration(code));
        }

        public Member generated() {
            declaration.addSingleMemberAnnotation(Generated.class, "\"" + CodeGenerator.class.getName() + "\"");
            return this;
        }

        public Member comment(String comment) {
            if (comment != null) {
                declaration.setLineComment(comment);
            } else {
                declaration.removeComment();
            }
            return this;
        }

        public Member override() {
            declaration.addMarkerAnnotation(Override.class);
            return this;
        }

        public Member rename(String from, String to) {
            if (declaration instanceof MethodDeclaration) {
                ((MethodDeclaration) declaration).setName(to);
            } else if (declaration instanceof FieldDeclaration) {
                for (VariableDeclarator var : ((FieldDeclaration) declaration).getVariables()) {
                    if (var.getName().equals(from)) {
                        var.setName(to);
                        break;
                    }
                }
            }
            return this;
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

        public String format() {
            return declaration.toString();
        }

        public String getName() {
            if (declaration instanceof MethodDeclaration) {
                return ((MethodDeclaration) declaration).getNameAsString();
            } else if (declaration instanceof FieldDeclaration) {
                NodeList<VariableDeclarator> vars = ((FieldDeclaration) declaration).getVariables();
                if (vars.size() == 1) {
                    return vars.get(0).getNameAsString();
                }
            }
            return null;
        }
    }
}
