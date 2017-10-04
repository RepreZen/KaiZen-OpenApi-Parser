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

public class StringOverlay extends ScalarOverlay<String> {

	private StringOverlay(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	private StringOverlay(String value, ReferenceRegistry refReg) {
		super(value, refReg);
	}

	@Override
	public String fromJson(JsonNode json) {
		return json.isTextual() ? json.textValue() : null;
	}

	@Override
	public JsonNode _toJson() {
		return jsonScalar(value);
	}

	public static OverlayFactory<String, StringOverlay> factory = new OverlayFactory<String, StringOverlay>() {

		@Override
		protected Class<StringOverlay> getOverlayClass() {
			return StringOverlay.class;
		}

		@Override
		public StringOverlay _create(String value, ReferenceRegistry refReg) {
			return new StringOverlay(value, refReg);
		}

		@Override
		public StringOverlay _create(JsonNode json, ReferenceRegistry refReg) {
			return new StringOverlay(json, refReg);
		}

	};
}
