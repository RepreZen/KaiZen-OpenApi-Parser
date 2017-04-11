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
package com.reprezen.kaizen.oasparser.jsonoverlay.std;

import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.coll.ValListOverlay;

public class StringListOverlay extends ValListOverlay<String, StringOverlay> {

    public StringListOverlay(String key, Collection<String> values, JsonOverlay<?> parent) {
        super(key, values, parent, StringOverlay.factory);
    }

    public StringListOverlay(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent, StringOverlay.factory);
    }

    public StringListOverlay(String key, JsonOverlay<?> parent) {
        super(key, parent, StringOverlay.factory);
    }

    public static JsonOverlayFactory<StringListOverlay> factory = new JsonOverlayFactory<StringListOverlay>() {
        @Override
        public StringListOverlay create(String key, JsonNode json, JsonOverlay<?> parent) {
            return new StringListOverlay(key, json, parent);
        }
    };
}
