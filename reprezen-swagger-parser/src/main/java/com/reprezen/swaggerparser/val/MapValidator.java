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

import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionOverlay;

public class MapValidator<OV extends JsonOverlay<?>> extends ListValidator<OV> {

    public <T extends SwaggerObjectImpl, V extends ObjectValidator<T>> MapValidator(Class<T> objectClass,
            Class<V> objectValidatorClass) {
        super(objectClass, objectValidatorClass);
    }

    public MapValidator(Validator<OV> validator) {
        super(validator);
    }

    @Override
    public void validate(CollectionOverlay<OV> object, ValidationResults results) {
        super.validate(object, results);
    }

    @Override
    protected String getElementCrumb(int index, OV overlay) {
        return "[" + overlay.getKey() + "]";
    }

}
