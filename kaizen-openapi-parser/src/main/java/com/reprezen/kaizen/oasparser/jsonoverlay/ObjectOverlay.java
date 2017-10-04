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

public class ObjectOverlay extends ScalarOverlay<Object> {

	private ObjectOverlay(JsonNode json, ReferenceRegistry refReg) {
		super(json, refReg);
	}

	private ObjectOverlay(Object value, ReferenceRegistry refReg) {
		super(value, refReg);
	}

	@Override
	public Object fromJson(JsonNode json) {
		return json.isMissingNode() ? null : mapper.convertValue(json, Object.class);
	}

	@Override
	public JsonNode _toJson() {
		return mapper.convertValue(value, JsonNode.class);
	}

	public static OverlayFactory<Object, ObjectOverlay> factory = new OverlayFactory<Object, ObjectOverlay>() {
		@Override
		protected Class<ObjectOverlay> getOverlayClass() {
			return ObjectOverlay.class;
		}

		@Override
		public ObjectOverlay _create(Object value, ReferenceRegistry refReg) {
			return new ObjectOverlay(value, refReg);
		}

		@Override
		public ObjectOverlay _create(JsonNode json, ReferenceRegistry refReg) {
			return new ObjectOverlay(json, refReg);
		}
	};
}
