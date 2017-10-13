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

public class BooleanOverlay extends ScalarOverlay<Boolean> {

	private BooleanOverlay(Boolean value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(value, parent, refReg);
	}

	private BooleanOverlay(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Override
	public Boolean fromJson(JsonNode json) {
		return json.isBoolean() ? json.booleanValue() : null;
	}

	@Override
	public JsonNode toJson(JsonOptions options) {
		return value != null ? jsonBoolean(value) : jsonMissing();
	}

	public static OverlayFactory<Boolean, BooleanOverlay> factory = new OverlayFactory<Boolean, BooleanOverlay>() {
		@Override
		protected Class<BooleanOverlay> getOverlayClass() {
			return BooleanOverlay.class;
		}

		@Override
		public BooleanOverlay _create(Boolean value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new BooleanOverlay(value, parent, refReg);
		}

		@Override
		public BooleanOverlay _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new BooleanOverlay(json, parent, refReg);
		}
	};
}