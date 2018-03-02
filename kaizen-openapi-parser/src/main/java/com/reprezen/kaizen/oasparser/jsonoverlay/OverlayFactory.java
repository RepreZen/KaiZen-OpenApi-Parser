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

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class OverlayFactory<V> {

	private final Class<? extends IJsonOverlay<? super V>> overlayClass = getOverlayClass();

	public JsonOverlay<V> create(V value, JsonOverlay<?> parent, ReferenceRegistry refReg, Reference ref) {
		JsonOverlay<V> overlay = _create(value, parent, refReg);
		overlay.setReference(ref);
		return overlay;
	}

	public IJsonOverlay<V> create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg, Reference ref) {
		JsonOverlay<V> overlay = (JsonOverlay<V>) create(json, parent, false, refReg);
		overlay.setReference(ref);
		return overlay;
	}

	protected IJsonOverlay<V> create(JsonNode json, JsonOverlay<?> parent, boolean partial, ReferenceRegistry refReg) {
		if (!partial && refReg.hasOverlay(json) && isCompatible(refReg.getOverlay(json))) {
			@SuppressWarnings("unchecked")
			JsonOverlay<V> overlay = (JsonOverlay<V>) refReg.getOverlay(json);
			if (parent != null) {
				overlay.setParent(parent);
			}
			return overlay;
		} else {
			if (json.isMissingNode()) {
				return _create(json, parent, refReg);
			} else {
				return createAndRegister(json, parent, partial, refReg);
			}
		}
	}

	protected JsonOverlay<V> createAndRegister(JsonNode json, JsonOverlay<?> parent, boolean partial,
			ReferenceRegistry refReg) {
		// initially instantiate and register an, to avoid infinite recursion when
		// reference cycles are encountered
		if (needPlaceholder(json)) {
			JsonOverlay<V> placeholder = _create(getPlaceholderJsonNode(json), parent, refReg);
			if (!partial) {
				refReg.setOverlay(json, placeholder);
			}
			JsonOverlay<V> overlay = _create(json, parent, refReg);
			placeholder.copyOverlayData(overlay);
			if (placeholder instanceof PropertiesOverlay<?>) {
				((PropertiesOverlay<?>) placeholder).copyChildProperties(overlay);
			}
			return placeholder;
		} else {
			JsonOverlay<V> overlay = _create(json, parent, refReg);
			if (!partial) {
				refReg.setOverlay(json, overlay);
			}
			return overlay;
		}
	}

	private boolean needPlaceholder(JsonNode json) {
		return json.isObject() || json.isArray();
	}

	private JsonNode getPlaceholderJsonNode(JsonNode json) {
		if (json.isArray()) {
			return JsonNodeFactory.instance.arrayNode();
		} else {
			ObjectNode result = JsonNodeFactory.instance.objectNode();
			String disc = getDiscriminator();
			JsonNode discValue = disc != null ? json.at(JsonPointer.compile("/" + disc)) : null;
			if (discValue != null && !discValue.isMissingNode()) {
				setInObject(result, disc.split("[/]"), discValue);
			}
			return result;
		}
	}
	
	private void setInObject(ObjectNode obj, String[] segments, JsonNode value) {
		for (int i = 0; i < segments.length-1; i++) {
			obj = obj.putObject(segments[i]);
		}
		obj.set(segments[segments.length-1], value);
	}

	protected String getDiscriminator() {
		return null;
	}

	public boolean isCompatible(IJsonOverlay<?> overlay) {
		return overlayClass.isAssignableFrom(overlay.getClass());
	}

	protected abstract Class<? extends IJsonOverlay<? super V>> getOverlayClass();

	protected abstract JsonOverlay<V> _create(V value, JsonOverlay<?> parent, ReferenceRegistry refReg);

	protected abstract JsonOverlay<V> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg);
}
