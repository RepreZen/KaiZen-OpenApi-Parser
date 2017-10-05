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
package com.reprezen.kaizen.oasparser.jsonoverlay;

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;

public class ReferenceRegistry {

	private Map<String, Reference> references = Maps.newHashMap();
	private Map<JsonNode, JsonOverlay<?>> overlays = Maps.newIdentityHashMap();

	public Collection<Reference> getAllReferences() {
		return references.values();
	}

	public String registerRef(JsonNode refStringNode, ResolutionBase base, boolean resolve) {
		return getRef(refStringNode, base, resolve).getKey();
	}

	public String registerRef(String refString, ResolutionBase base, boolean resolve) {
		return getRef(refString, base, resolve).getKey();
	}

	public Reference getRef(String key) {
		return references.get(key);
	}

	public Reference getRef(JsonNode refNode) {
		if (refNode.isObject() && refNode.has("$ref") && refNode.has("key")) {
			return getRef(refNode.get("key").textValue());
		} else {
			return null;
		}
	}

	public Reference getRef(JsonNode refStringNode, ResolutionBase base, boolean resolve) {
		if (refStringNode.isTextual()) {
			return getRef(refStringNode.textValue(), base, resolve);
		} else {
			String badRefString = refStringNode.toString();
			Reference ref = new Reference(badRefString, base,
					new ResolutionException("Non-text $ref property value in JSON reference node"));
			String key = ref.getKey();
			if (!references.containsKey(key)) {
				references.put(key, ref);
			}
			return references.get(key);
		}
	}

	public Reference getRef(String refString, ResolutionBase base, boolean resolve) {
		try {
			if (base.isInvalid()) {
				throw new ResolutionException("Invalid base for reference resolution", base.getError());
			}
			String comprehendedRef = base.comprehend(refString);
			if (!references.containsKey(comprehendedRef)) {
				references.put(comprehendedRef, new Reference(refString, comprehendedRef, base));
			}
			Reference ref = references.get(comprehendedRef);
			if (resolve) {
				ref.resolve();
			}
			return ref;
		} catch (ResolutionException e) {
			Reference ref = new Reference(refString, base, e);
			references.put(refString, ref);
			return ref;
		}
	}

	public JsonOverlay<?> getOverlay(JsonNode node) {
		return overlays.get(node);
	}

	public boolean hasOverlay(JsonNode node) {
		return overlays.containsKey(node);
	}

	public void setOverlay(JsonNode node, JsonOverlay<?> overlay) {
		overlays.put(node, overlay);
	}
}
