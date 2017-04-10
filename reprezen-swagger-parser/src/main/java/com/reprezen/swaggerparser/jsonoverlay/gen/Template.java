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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.swaggerparser.jsonoverlay.gen.TypeData.Type;

public class Template {

    private static Pattern varPat = Pattern.compile("\\$\\{([a-zA-Z]+|\\d+)\\}");

    public static <T> String t(String template, T item, String... args) {
        Matcher matcher = varPat.matcher(template);
        StringBuffer result = new StringBuffer();
        int start = 0;
        while (matcher.find()) {
            // would use matcher.appendReplace and matcher.appendTail, but it's way too hard to deal with all the
            // escaping and quoting. Literal replacement is what I need here. Too bad they don't support that!
            result.append(template.substring(start, matcher.start()));
            result.append(replacement(matcher.group(1), item, args));
            start = matcher.end();
        }
        result.append(template.substring(start));
        return result.toString();
    }

    public static <T> List<String> t(final T item, String... templates) {
        return Lists.transform(Lists.newArrayList(templates), new Function<String, String>() {
            @Override
            public String apply(String template) {
                return t(template, item);
            }
        });
    }

    private static String replacement(String var, Field field, String[] args) {
        switch (var) {
        case "name":
            return field.getName();
        case "lcName":
            return field.getLcName();
        case "plural":
            return field.getPlural();
        case "lcPlural":
            return field.getLcPlural();
        case "type":
            return field.getType();
        case "implType":
            return TypeGenerator.getImplType(field);
        case "collType":
            return TypeGenerator.getTypeInCollection(field);
        case "keyName":
            return field.getKeyName();
        case "id":
            return field.getId();
        case "qid":
            return quote(field.getId());
        case "qpath":
            return quote(field.getParentPath());
        case "qkeyPat":
            return quote(field.getKeyPattern());
        case "boolDefault":
            return String.valueOf(field.getBoolDefault());
        default:
            return args[Integer.valueOf(var)];
        }
    }

    private static String replacement(String var, Type type, String[] args) {
        switch (var) {
        case "name":
            return type.getName();
        case "implName":
            return TypeGenerator.getImplType(type);
        default:
            return args[Integer.valueOf(var)];
        }
    }

    private static String replacement(String var, Object item, String[] args) {
        if (item instanceof Field) {
            return replacement(var, (Field) item, args);
        } else if (item instanceof Type) {
            return replacement(var, (Type) item, args);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private static String quote(String s) {
        return s != null ? "\"" + StringEscapeUtils.escapeJava(s) + "\"" : "null";
    }
}
