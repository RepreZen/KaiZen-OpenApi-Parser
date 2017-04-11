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
package com.reprezen.swaggerparser.val;

import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;

public class ValListValidator<T extends ValListOverlay<?, T>> extends OverlayValidator<ValListOverlay<?, T>> {

    private Validator<T> elementValidator;

    public ValListValidator(Validator<T> elementValidator) {
        this.elementValidator = elementValidator;
    }

    @Override
    public void validate(ValListOverlay<?, T> overlay, ValidationResults results) {
        int i = 0;
        for (T value : overlay.getStore().getOverlays()) {
            elementValidator.validate(value, results, getElementCrumb(i++));
        }
    }

    protected String getElementCrumb(int index) {
        return "[" + index + "]";
    }
}
