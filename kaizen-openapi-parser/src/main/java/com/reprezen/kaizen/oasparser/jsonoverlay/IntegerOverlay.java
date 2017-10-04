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
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class IntegerOverlay extends ScalarOverlay<Integer> {

	private IntegerOverlay(Integer value, ReferenceRegistry refReg) {
		super(value, refReg);
	}

	private IntegerOverlay(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	@Override
	public Integer fromJson(JsonNode json) {
		return json.isInt() ? json.intValue() : null;
	}

	@Override
	public JsonNode _toJson() {
		return JsonNodeFactory.instance.numberNode(value);
	}

	public static OverlayFactory<Integer, IntegerOverlay> factory = new OverlayFactory<Integer, IntegerOverlay>() {
		@Override
		protected Class<IntegerOverlay> getOverlayClass() {
			return IntegerOverlay.class;
		}

		@Override
		public IntegerOverlay _create(Integer value, ReferenceRegistry refReg) {
			return new IntegerOverlay(value, refReg);
		}

		@Override
		public IntegerOverlay _create(JsonNode json, ReferenceRegistry refReg) {
			return new IntegerOverlay(json, refReg);
		}
	};
}
