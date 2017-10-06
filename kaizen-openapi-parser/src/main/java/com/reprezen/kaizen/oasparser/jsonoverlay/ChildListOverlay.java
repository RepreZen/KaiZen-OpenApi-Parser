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

import com.fasterxml.jackson.databind.JsonNode;

public class ChildListOverlay<V, OV extends JsonOverlay<V>> extends ChildOverlay<Collection<V>, ListOverlay<V, OV>> {

	public ChildListOverlay(String path, JsonNode json, JsonOverlay<?> parent,
			OverlayFactory<Collection<V>, ListOverlay<V, OV>> factory, ReferenceRegistry refReg) {
		super(path, json, parent, factory, refReg);
	}

	public ChildListOverlay(String path, Collection<V> value, JsonOverlay<?> parent,
			OverlayFactory<Collection<V>, ListOverlay<V, OV>> factory, ReferenceRegistry refReg) {
		super(path, value, parent, factory, refReg);
	}

	public V get(int index) {
		return null;
	}

	public void set(int index, V value) {

	}

	public void add(V value) {

	}

	public void insert(int index, V value) {

	}

	public void remove(int index) {

	}

}
