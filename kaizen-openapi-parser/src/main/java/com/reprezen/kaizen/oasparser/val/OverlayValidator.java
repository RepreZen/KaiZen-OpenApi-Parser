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
package com.reprezen.kaizen.oasparser.val;

import static com.reprezen.kaizen.oasparser.val.Messages.m;

import java.util.Collections;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;

public class OverlayValidator<T> extends ValidatorBase<T> {

	@Override
	public void validate(T overlay, ValidationResults results) {
		checkReferences((JsonOverlay<?>) overlay, results);
	}

	public void validate(T overlay, ValidationResults results, Class<? extends JsonNode> allowedNodeType) {
		validate(overlay, results, Collections.<Class<? extends JsonNode>>singleton(allowedNodeType));
	}

	public void validate(T object, ValidationResults results, Set<Class<? extends JsonNode>> allowedNodeTypes) {
		JsonOverlay<?> overlay = (JsonOverlay<?>) object;
		JsonNode json = overlay.toJson();
		boolean isValidJsonType = false;
		for (Class<? extends JsonNode> type : allowedNodeTypes) {
			if (type.isAssignableFrom(json.getClass())) {
				isValidJsonType = true;
				break;
			}
		}
		isValidJsonType = isValidJsonType || json.isMissingNode();
		if (!isValidJsonType) {
			results.addError(m.msg("WrongTypeJson|Property bound to incompatible JSON Node type", json.getNodeType(),
					allowedNodeTypes));
		}
	}

	private void checkReferences(JsonOverlay<?> overlay, ValidationResults results) {
		if (overlay instanceof ListOverlay<?>) {
			checkReferences((ListOverlay<?>) overlay, results);
		} else if (overlay instanceof MapOverlay<?>) {
			checkReferences((MapOverlay<?>) overlay, results);
		} else if (overlay instanceof PropertiesOverlay<?>) {
			checkReferences((PropertiesOverlay<?>) overlay, results);
		}
	}

	private void checkReferences(ListOverlay<?> list, ValidationResults results) {
		for (int i = 0; i < list.size(); i++) {
			if (list.isReference(i)) {
				checkReference(list.getReference(i), results, Integer.toString(i));
			}
		}
	}

    private void checkReferences(MapOverlay<?> map, ValidationResults results) {
		for (String key : map.get().keySet()) {
			if (map.isReference(key)) {
				checkReference(map.getReference(key), results, key);
			}
		}
	}

	private void checkReferences(PropertiesOverlay<?> props, ValidationResults results) {
		if (props.isElaborated()) {
			for (String path : props.getRefablePaths()) {
				if (props.isReference(path)) {
					checkReference(props.getReference(path), results, path);
				}
			}
		}
	}

	private void checkReference(Reference ref, ValidationResults results, String crumb) {
		if (ref.isInvalid()) {
			results.addError(
					m.msg("BadRef|JSON reference node was not resolved", ref.getRefString(), ref.getErrorReason()),
					crumb);
		}

	}
}
