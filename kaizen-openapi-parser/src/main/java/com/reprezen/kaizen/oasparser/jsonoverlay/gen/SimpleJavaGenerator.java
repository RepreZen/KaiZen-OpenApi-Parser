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
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class SimpleJavaGenerator {

    private String pkg;
    private Set<String> imports = Sets.newHashSet();
    private String declaration;
    private List<Member> members = Lists.newArrayList();
    private String fileComment;

    private static int indentation = 4;

    public SimpleJavaGenerator(String pkg, String declaration) {
        this.pkg = pkg;
        this.declaration = declaration;
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
        String result = String.format("%spackage %s;\n\n%s\n\n%s {\n\n", fileComment != null ? fileComment : "", pkg,
                getImports(), declaration);
        for (Member method : members) {
            result += method.format() + "\n";
        }
        return result + "}\n";

    }

    private static String indent(int n) {
        return StringUtils.repeat(" ", indentation * n);
    }

    private static String indent(int n, String text) {
        String[] lines = StringUtils.split(text, "\n");
        String result = "";
        for (String line : lines) {
            result += indent(n) + line + "\n";
        }
        return result;
    }

    public String getImports() {
        List<String> importsList = Lists.newArrayList(imports);
        Collections.sort(importsList);
        return StringUtils.join(Collections2.transform(importsList, new Function<String, String>() {
            @Override
            public String apply(String imp) {
                return "import " + imp + ";";
            }
        }), "\n");
    }

    public static class Member {
        private String declaration;
        private Collection<String> code;
        private String comment;
        private boolean override;
        private boolean generated;
        private boolean complete;

        public Member(String declaration, Collection<String> code) {
            this.declaration = declaration;
            this.code = code;
        }

        public String getDeclaration() {
            return declaration;
        }

        public Collection<String> getCode() {
            return code;
        }

        public Member override() {
            this.override = true;
            return this;
        }

        public Member comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Member generated(boolean generated) {
            this.generated = generated;
            return this;
        }

        public Member complete(boolean complete) {
            this.complete = complete;
            return this;
        }

        public String format() {
            if (this.complete) {
                return indent(1, declaration);
            } else {
                String override = this.override ? indent(1) + "@Override\n" : "";
                String gen = this.generated
                        ? indent(1) + String.format("@Generated(\"%s\")\n", CodeGenerator.class.getName()) : "";
                String comment = this.comment != null ? indent(1) + "// " + this.comment + "\n" : "";
                String header = comment + override + gen + indent(1) + declaration;
                return code == null || code.isEmpty() ? header + ";\n"
                        : header + " {\n" + formatCode() + "\n" + indent(1) + "}\n";
            }
        }

        private String formatCode() {
            return (indent(2) + StringUtils.join(code, "\n" + indent(3)));
        }
    }
}
