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
package com.reprezen.kaizen.oasparser.val;

import static com.reprezen.kaizen.oasparser.val.Messages.m;

import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.IntegerOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.NumberOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PrimitiveOverlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.StringOverlay;

public class JsonTypeChecker {

	public static void checkJsonType(Overlay<?> value, ValidationResults results) {
		JsonNode json = value.getParsedJson();
		if (json != null && !json.isMissingNode()) {
			Collection<Class<? extends JsonNode>> allowedJsonTypes = getAllowedJsonTypes(value);
			for (Class<? extends JsonNode> type : allowedJsonTypes) {
				if (type.isAssignableFrom(json.getClass())) {
					return;
				}
			}
			results.addError(m.msg("WrongTypeJson|Property bound to incompatible JSON Node type", json.getNodeType(),
					allowedJsonTypes), value);
		}
	}

	private static Multimap<Class<?>, Class<? extends JsonNode>> allowedJsonTypes = null;

	private static Collection<Class<? extends JsonNode>> getAllowedJsonTypes(Overlay<?> value) {
		if (allowedJsonTypes == null) {
			createAllowedJsonTypes();
		}
		JsonOverlay<?> overlay = value.getOverlay();
		return allowedJsonTypes
				.get(overlay instanceof PropertiesOverlay ? PropertiesOverlay.class : overlay.getClass());
	}

	private static void createAllowedJsonTypes() {
		Multimap<Class<?>, Class<? extends JsonNode>> types = ArrayListMultimap
				.<Class<?>, Class<? extends JsonNode>>create();
		types.put(StringOverlay.class, TextNode.class);
		types.put(BooleanOverlay.class, BooleanNode.class);
		types.putAll(IntegerOverlay.class, Arrays.asList(IntNode.class, ShortNode.class, BigIntegerNode.class));
		types.put(NumberOverlay.class, NumericNode.class);
		types.putAll(PrimitiveOverlay.class, Arrays.asList(TextNode.class, NumericNode.class, BooleanNode.class));
		types.put(ObjectOverlay.class, JsonNode.class);
		types.put(MapOverlay.class, ObjectNode.class);
		types.put(ListOverlay.class, ArrayNode.class);
		types.put(PropertiesOverlay.class, ObjectNode.class);
		allowedJsonTypes = types;
	}
}
