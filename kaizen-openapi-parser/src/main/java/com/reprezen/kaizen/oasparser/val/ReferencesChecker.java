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

import static com.reprezen.kaizen.oasparser.val.BaseValidationMessages.BadRef;
import static com.reprezen.kaizen.oasparser.val.msg.Messages.msg;

import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.Reference;

public class ReferencesChecker {

    public static void checkReferences(ListOverlay<?> list, ValidationResults results) {
        Overlay<?> listAdapter = Overlay.of(list);
        for (int i = 0; i < list.size(); i++) {
            if (listAdapter.isReference(i)) {
                checkReference(listAdapter.getReference(i), results, Overlay.of(list, i));
            }
        }
    }

    public static void checkReferences(MapOverlay<?> map, ValidationResults results) {
        Overlay<?> mapAdapter = Overlay.of(map);
        for (String key : map.keySet()) {
            if (mapAdapter.isReference(key)) {
                checkReference(mapAdapter.getReference(key), results, Overlay.of(map, key));
            }
        }
    }

    public static void checkReferences(PropertiesOverlay<?> props, ValidationResults results) {
        if (props._isElaborated()) {
            Overlay<?> propsAdapter = Overlay.of(props);
            for (String name : propsAdapter.getPropertyNames()) {
                if (propsAdapter.isReference(name)) {
                    checkReference(propsAdapter.getReference(name), results, Overlay.of(props, name, Object.class));
                }
            }
        }
    }

    public static void checkReference(Reference ref, ValidationResults results, Overlay<?> context) {
        if (ref.isInvalid()) {
            results.addError(msg(BadRef, ref.getRefString(), ref.getInvalidReason()), context);
        }
    }
}
