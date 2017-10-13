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

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;

public class ChildListOverlay<V, OV extends JsonOverlay<V>> extends ChildOverlay<Collection<V>, ListOverlay<V, OV>> {

	private ListOverlay<V, OV> listOverlay;

	public ChildListOverlay(String path, JsonNode json, JsonOverlay<?> parent,
			OverlayFactory<Collection<V>, ListOverlay<V, OV>> factory, ReferenceRegistry refReg) {
		super(path, json, parent, factory, refReg);
		setListOverlay();
	}

	public ChildListOverlay(String path, Collection<V> value, JsonOverlay<?> parent,
			OverlayFactory<Collection<V>, ListOverlay<V, OV>> factory, ReferenceRegistry refReg) {
		super(path, value, parent, factory, refReg);
		setListOverlay();
	}

	private void setListOverlay() {
		@SuppressWarnings("unchecked")
		ListOverlay<V, OV> castOverlay = (ListOverlay<V, OV>) overlay;
		this.listOverlay = castOverlay;
	}

	@Override
	protected boolean matchesPath(JsonPointer path) {
		if (super.matchesPath(path)) {
			int index = super.tailPath(path).getMatchingIndex();
			return index >= 0;
		} else {
			return false;
		}
	}

	public V get(int index) {
		return listOverlay.get(index);
	}

	public void set(int index, V value) {
		listOverlay.set(index, value);
	}

	public void add(V value) {
		listOverlay.add(value);
	}

	public void insert(int index, V value) {
		listOverlay.insert(index, value);
	}

	public void remove(int index) {
		listOverlay.remove(index);
	}

	public int size() {
		return listOverlay.size();
	}

	public ChildOverlay<V, OV> getChild(int index) {
		@SuppressWarnings("unchecked")
		ChildOverlay<V, OV> child = (ChildOverlay<V, OV>) listOverlay.get(index);
		return child;
	}
}
