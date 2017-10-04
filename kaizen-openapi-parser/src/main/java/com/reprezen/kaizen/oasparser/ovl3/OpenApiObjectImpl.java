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
package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.IPropertiesOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.model3.OpenApiObject;
//import com.reprezen.swaggerparser.model3.OpenApi3;

public abstract class OpenApiObjectImpl<V extends IPropertiesOverlay<V>> extends PropertiesOverlay<V>
		implements OpenApiObject<V> {

	protected OpenApiObjectImpl(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	protected OpenApiObjectImpl(V value, ReferenceRegistry refReg) {
		super(value, refReg);
	}


	// TODO reimplement
	// @Override
	// public OpenApi3 getModel() {
	// IJsonOverlay<?> root = getRoot();
	// return root instanceof OpenApi3 ? (OpenApi3) root : null;
	// }
	//
	// public OpenApiObject<?> getParentObject() {
	// IJsonOverlay<?> parent = super.getParent();
	// while (parent != null && !(parent instanceof OpenApiObject)) {
	// parent = parent.getParent();
	// }
	// return (OpenApiObject<?>) parent;
	// }
}
