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

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class ChildMapOverlay<V, OV extends JsonOverlay<V>> extends ChildOverlay<Map<String, V>, MapOverlay<V, OV>> {

	public ChildMapOverlay(String path, JsonNode json, OverlayFactory<Map<String, V>, MapOverlay<V, OV>> factory,
			ReferenceRegistry refReg) {
		super(path, json, factory, refReg);
	}

	public ChildMapOverlay(String path, Map<String, V> value, OverlayFactory<Map<String, V>, MapOverlay<V, OV>> factory,
			ReferenceRegistry refReg) {
		super(path, value, factory, refReg);
	}

	public boolean containsKey(String name) {
		return false;
	}

	public V get(String name) {
		return null;
	}

	public void set(String name, V value) {

	}

	public void remove(String name) {

	}
}
