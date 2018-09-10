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

import java.util.List;

import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.Overlay;

public class ListValidator<T> extends ValidatorBase<List<T>> {

    Validator<T> itemValidator;

    public ListValidator(Validator<T> elementeValidator) {
        this.itemValidator = elementeValidator;
    }

    @Override
    public void runValidations() {
        if (itemValidator != null) {
            ListOverlay<T> list = Overlay.getListOverlay(value);
            for (int i = 0; i < list.size(); i++) {
                itemValidator.validate(Overlay.of(list, i));
            }
        }
    }
}
