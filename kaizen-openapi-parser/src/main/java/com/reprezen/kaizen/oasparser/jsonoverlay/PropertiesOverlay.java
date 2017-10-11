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

import java.util.List;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;

public abstract class PropertiesOverlay<V extends IPropertiesOverlay<V>> extends JsonOverlay<V> {

	protected List<ChildOverlay<?, ?>> children = Lists.newArrayList();
	private boolean filledChildren = false;
	private boolean deferFill = false;

	protected PropertiesOverlay(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
		deferFill = json.isMissingNode();
	}

	public PropertiesOverlay(V value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(value, parent, refReg);
		filledChildren = true;
	}

	protected void maybeFillChildrenAtCreation() {
		if (!deferFill) {
			ensureFilledChildren();
		}
	}

	protected void ensureFilledChildren() {
		if (!filledChildren) {
			fillChildren();
			filledChildren = true;
		}
	}

	protected abstract void fillChildren();

	@Override
	public IJsonOverlay<?> _find(JsonPointer path) {
		for (ChildOverlay<?, ?> child : children) {
			if (child.matchesPath(path)) {
				IJsonOverlay<?> found = child.find(child.tailPath(path));
				if (found != null) {
					return found;
				}
			}
		}
		return null;
	}

	@Override
	public V fromJson(JsonNode json) {
		// parsing of the json node is expected to be done in the constructor of the
		// subclass, so nothing is done here. But we do establish this object as its own
		// value.
		@SuppressWarnings("unchecked")
		V result = (V) this;
		return result;
	}

	@Override
	public JsonNode toJson(boolean keepEmpty) {
		JsonNode obj = jsonMissing();
		for (ChildOverlay<?, ?> child : children) {
			JsonNode childJson = child.getOverlay().toJson();
			if (!childJson.isMissingNode()) {
				obj = child.getPath().setInPath(obj, childJson);
			}
		}
		JsonNode result = fixJson(obj);
		return result.size() > 0 || keepEmpty ? result : jsonMissing();
	}

	protected JsonNode fixJson(JsonNode json) {
		return json;
	}

	@Override
	protected V get(boolean complete) {
		if (complete) {
			ensureFilledChildren();
		}
		return value;
	}

	@Override
	public void set(V value) {
		super.set(value);
		fillChildren();
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildOverlay<VC, OVC> createChild(boolean create, String path,
			JsonOverlay<?> parent, OverlayFactory<VC, OVC> factory) {
		return create ? createChild(path, parent, factory) : null;
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildOverlay<VC, OVC> createChild(String path, JsonOverlay<?> parent,
			OverlayFactory<VC, OVC> factory) {
		ChildOverlay<VC, OVC> child = new ChildOverlay<>(path, json.at("/" + path), parent, factory, refReg);
		children.add(child);
		return child;
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildMapOverlay<VC, OVC> createChildMap(boolean create, String path,
			JsonOverlay<?> parent, OverlayFactory<VC, OVC> factory, String keyPattern) {
		return create ? createChildMap(path, parent, factory, keyPattern) : null;
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildMapOverlay<VC, OVC> createChildMap(String path,
			JsonOverlay<?> parent, OverlayFactory<VC, OVC> factory, String keyPattern) {
		ChildMapOverlay<VC, OVC> child = new ChildMapOverlay<VC, OVC>(path, json.at(pathPointer(path)), parent,
				MapOverlay.getFactory(factory, keyPattern), refReg);
		children.add(child);
		return child;
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildListOverlay<VC, OVC> createChildList(boolean create, String path,
			JsonOverlay<?> parent, OverlayFactory<VC, OVC> factory) {
		return create ? createChildList(path, parent, factory) : null;
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildListOverlay<VC, OVC> createChildList(String path,
			JsonOverlay<?> parent, OverlayFactory<VC, OVC> factory) {
		ChildListOverlay<VC, OVC> child = new ChildListOverlay<VC, OVC>(path, json.at(pathPointer(path)), parent,
				ListOverlay.getFactory(factory), refReg);
		children.add(child);
		return child;
	}

	private JsonPointer pathPointer(String path) {
		return (path == null || path.isEmpty()) ? JsonPointer.compile("") : JsonPointer.compile("/" + path);
	}
}
