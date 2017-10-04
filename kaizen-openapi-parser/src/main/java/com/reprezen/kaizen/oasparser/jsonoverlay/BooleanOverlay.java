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

	private BooleanOverlay(Boolean value, ReferenceRegistry refReg) {
		super(value, refReg);
	}

	private BooleanOverlay(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	@Override
	public Boolean fromJson(JsonNode json) {
		return json.isBoolean() ? json.booleanValue() : null;
	}

	@Override
	public JsonNode _toJson() {
		return jsonBoolean(value);
	}

	public static OverlayFactory<Boolean, BooleanOverlay> factory = new OverlayFactory<Boolean, BooleanOverlay>() {
		@Override
		protected Class<BooleanOverlay> getOverlayClass() {
			return BooleanOverlay.class;
		}

		@Override
		public BooleanOverlay _create(Boolean value, ReferenceRegistry refReg) {
			return new BooleanOverlay(value, refReg);
		}

		@Override
		public BooleanOverlay _create(JsonNode json, ReferenceRegistry refReg) {
			return new BooleanOverlay(json, refReg);
		}
	};
}