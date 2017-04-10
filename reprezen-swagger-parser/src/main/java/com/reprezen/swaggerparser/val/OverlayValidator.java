/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.Reference;

public class OverlayValidator extends Validator<JsonOverlay<?>> {

    public static OverlayValidator validator = new OverlayValidator();

    @Override
    public void validate(JsonOverlay<?> object, ValidationResults results) {
        checkReference(object, results);
    }

    private void checkReference(JsonOverlay<?> object, ValidationResults results) {
        if (object.isReference()) {
            Reference ref = object.getReference();
            if (ref.isInvalid()) {
                results.addError(
                        m.msg("BadRef|JSON reference node was not resolved", ref.getRefString(), ref.getErrorReason()));
            }
        }
    }

}
