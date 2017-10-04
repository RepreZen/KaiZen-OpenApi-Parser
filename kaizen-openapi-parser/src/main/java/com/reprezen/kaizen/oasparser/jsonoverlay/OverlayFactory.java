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

public abstract class OverlayFactory<V, OV extends JsonOverlay<V>> {

	private final Class<? super OV> overlayClass = getOverlayClass();

	public OV create(V value, ReferenceRegistry refReg) {
		return _create(value, refReg);
	}

	public OV create(JsonNode json, ReferenceRegistry refReg) {
		return _create(json, refReg);
	}

	public boolean isCompatible(JsonOverlay<?> overlay) {
		return overlayClass.isAssignableFrom(overlay.getClass());
	}

	protected abstract Class<? super OV> getOverlayClass();

	public abstract OV _create(V value, ReferenceRegistry refReg);

	public abstract OV _create(JsonNode json, ReferenceRegistry refReg);
}
