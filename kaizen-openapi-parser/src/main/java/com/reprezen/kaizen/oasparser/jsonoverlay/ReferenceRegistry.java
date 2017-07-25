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

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;

public class ReferenceRegistry {

    private Map<String, Reference> references = Maps.newHashMap();

    public Collection<Reference> getAllReferences() {
        return references.values();
    }

    public String register(JsonNode refStringNode, ResolutionBase base, boolean resolve) {
        return get(refStringNode, base, resolve).getKey();
    }

    public String register(String refString, ResolutionBase base, boolean resolve) {
        return get(refString, base, resolve).getKey();
    }

    public Reference get(String key) {
        return references.get(key);
    }

    public Reference get(JsonNode refNode) {
        if (refNode.isObject() && refNode.has("$ref") && refNode.has("key")) {
            return get(refNode.get("key").textValue());
        } else {
            return null;
        }
    }

    public Reference get(JsonNode refStringNode, ResolutionBase base, boolean resolve) {
        if (refStringNode.isTextual()) {
            return get(refStringNode.textValue(), base, resolve);
        } else {
            String badRefString = refStringNode.toString();
            Reference ref = new Reference(badRefString, base,
                    new ResolutionException("Non-text $ref property value in JSON reference node"));
            String key = ref.getKey();
            if (!references.containsKey(key)) {
                references.put(key, ref);
            }
            return references.get(key);
        }
    }

    public Reference get(String refString, ResolutionBase base, boolean resolve) {
        try {
            if (base.isInvalid()) {
                throw new ResolutionException("Invalid base for reference resolution", base.getError());
            }
            String comprehendedRef = base.comprehend(refString);
            if (!references.containsKey(comprehendedRef)) {
                references.put(comprehendedRef, new Reference(comprehendedRef, base));
            }
            Reference ref = references.get(comprehendedRef);
            if (resolve) {
                ref.resolve();
            }
            return ref;
        } catch (ResolutionException e) {
            Reference ref = new Reference(refString, base, e);
            references.put(refString, ref);
            return ref;
        }
    }

}
