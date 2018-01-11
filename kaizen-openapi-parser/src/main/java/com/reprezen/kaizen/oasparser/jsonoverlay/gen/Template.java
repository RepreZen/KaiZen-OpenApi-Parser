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

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringEscapeUtils;

import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Field;
import com.reprezen.kaizen.oasparser.jsonoverlay.gen.TypeData.Type;

public class Template {

	private static Pattern varPat = Pattern.compile("\\$\\{([a-zA-Z]+|\\d+)\\}");

	public static <T> String t(String template, T item, String... args) {
		Matcher matcher = varPat.matcher(template);
		StringBuffer result = new StringBuffer();
		int start = 0;
		while (matcher.find()) {
			// would use matcher.appendReplace and matcher.appendTail, but it's way too hard
			// to deal with all the
			// escaping and quoting. Literal replacement is what I need here. Too bad they
			// don't support that!
			result.append(template.substring(start, matcher.start()));
			result.append(replacement(matcher.group(1), item, args));
			start = matcher.end();
		}
		result.append(template.substring(start));
		return result.toString();
	}

	public static <T> List<String> t(final T item, String... templates) {
		return t(item, Arrays.asList(templates));
	}

	public static <T> List<String> t(final T item, List<String> templates) {
		return templates.stream().map(s -> t(s, item)).collect(Collectors.toList());
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
		case "type": {
			String type = field.getType();
			return "Primitive".equals(type) ? "Object" : type;
		}
		case "implType":
			return field.getImplType();
		case "collType": {
			String type = field.getType();
			return "Primitive".equals(type) ? "Object" : type;
		}
		case "keyName":
			return field.getKeyName();
		case "id":
			return field.getId();
		case "qid":
			return quote(field.getId());
		case "qpath":
			return quote(field.getParentPath());
		case "qpointer": {
			String path = field.getParentPath();
			path = path == null || path.isEmpty() ? "" : "/" + path;
			return quote(path);
		}
		case "qkeyPat":
			return quote(field.getKeyPattern());
		case "boolDefault":
			return String.valueOf(field.getBoolDefault());
		case "propName":
			return field.getPropertyName();
		case "propType":
			return field.getPropertyType();
		case "propCons":
			return field.getPropertyNew();
		case "overlayType":
			return field.getOverlayType();
		default:
			if (var.matches("\\d+")) {
				return args[Integer.valueOf(var)];
			} else {
				return replacement(var, field.getContainer(), args);
			}
		}
	}

	private static String replacement(String var, Type type, String[] args) {
		switch (var) {
		case "name":
			return type.getName();
		case "lcName":
			return type.getLcName();
		case "implName":
			return type.getImplType();
		case "modelType":
			return type.getTypeData().getModelType();
		case "discriminator":
			return type.getDiscriminator();
		case "discValue":
			return type.getDiscriminatorValue();
		default:
			return args[Integer.valueOf(var)];
		}
	}

	private static String replacement(String var, Object item, String[] args) {
		if (item == null) {
			return "${" + var + "}";
		}
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
