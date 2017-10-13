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
	private boolean elaborated = false;
	private boolean deferElaboration = false;

	protected PropertiesOverlay(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
		deferElaboration = json.isMissingNode();
	}

	public PropertiesOverlay(V value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(value, parent, refReg);
		elaborated = true;
	}

	protected void maybeElaborateChildrenAtCreation() {
		if (!deferElaboration) {
			ensureElaborated();
		}
	}

	protected void ensureElaborated() {
		if (!elaborated) {
			elaborateChildren();
			elaborated = true;
		}
	}

	protected abstract void elaborateChildren();

	@Override
	public boolean isElaborated() {
		return elaborated;
	}

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
	public JsonNode toJson(JsonOptions options) {
		JsonNode obj = jsonMissing();
		for (ChildOverlay<?, ?> child : children) {
			JsonNode childJson = child.toJson(options.minus(JsonOption.KEEP_ONE_EMPTY));
			if (!childJson.isMissingNode()) {
				obj = child.getPath().setInPath(obj, childJson);
			}
		}
		JsonNode result = fixJson(obj);
		return result.size() > 0 || options.isKeepThisEmpty() ? result : jsonMissing();
	}

	protected JsonNode fixJson(JsonNode json) {
		return json;
	}

	@Override
	public V get(boolean elaborate) {
		if (elaborate) {
			ensureElaborated();
		}
		return value;
	}

	@Override
	public void set(V value) {
		super.set(value);
		elaborateChildren();
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildOverlay<VC, OVC> createChild(boolean create, String path,
			JsonOverlay<?> parent, OverlayFactory<VC, OVC> factory) {
		return create ? createChild(path, parent, factory) : null;
	}

	protected <VC, OVC extends JsonOverlay<VC>> ChildOverlay<VC, OVC> createChild(String path, JsonOverlay<?> parent,
			OverlayFactory<VC, OVC> factory) {
		ChildOverlay<VC, OVC> child = new ChildOverlay<>(path, json.at("/" + path), parent, factory, refReg);
		child.getOverlay().setPathInParent(path);
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
		child.getOverlay().setPathInParent(path);
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
		child.getOverlay().setPathInParent(path);
		children.add(child);
		return child;
	}

	private JsonPointer pathPointer(String path) {
		return (path == null || path.isEmpty()) ? JsonPointer.compile("") : JsonPointer.compile("/" + path);
	}
}
