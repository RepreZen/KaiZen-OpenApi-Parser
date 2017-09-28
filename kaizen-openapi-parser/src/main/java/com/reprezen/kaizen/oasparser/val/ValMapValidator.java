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

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;

public class ValMapValidator<T extends JsonOverlay<?>> extends OverlayValidator<ValMapOverlay<?, T>> {

    private Validator<T> elementValidator;

    public ValMapValidator(Validator<T> elementValidator) {
        this.elementValidator = elementValidator;
    }

    @Override
    public void validate(ValMapOverlay<?, T> overlay, ValidationResults results) {
        super.validate(overlay, results, ObjectNode.class);
        for (T value : overlay.getStore().getOverlays()) {
            elementValidator.validate(value, results, value.getKey());
        }
    }
}
