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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;

public abstract class ScalarOverlay<V> extends JsonOverlay<V> {

	public ScalarOverlay(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	public ScalarOverlay(V value, ReferenceRegistry refReg) {
		super(value, refReg);
	}

	@Override
	public JsonNode toJson() {
		return value != null ? _toJson() : MissingNode.getInstance();
	}

	protected abstract JsonNode _toJson();
}
