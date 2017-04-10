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

import com.reprezen.swaggerparser.SwaggerParser.SwaggerParserException;
import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionStore;
import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.val.ValidationResults.CrumbState;

public class ListValidator<OV extends JsonOverlay<?>> {

    Validator<OV> validator;
    Class<? extends ObjectValidator<? extends SwaggerObjectImpl>> objectValidatorClass;
    Class<? extends SwaggerObjectImpl> objectClass;

    public ListValidator(Validator<OV> validator) {
        this.validator = validator;
    }

    public <T extends SwaggerObjectImpl, V extends ObjectValidator<T>> ListValidator(Class<T> objectClass,
            Class<V> objectValidatorClass) {
        this.objectClass = objectClass;
        this.objectValidatorClass = objectValidatorClass;
    }

    public void validate(CollectionOverlay<OV> object, ValidationResults results) {
        CollectionStore<OV> store = getStore(object);
        int i = 0;
        for (OV value : store.getOverlays()) {
            String crumb = getElementCrumb(i++, value);
            try (CrumbState crumbs = results.withCrumb(crumb)) {
                validator.validate(value, results);
            }
        }
    }

    protected String getElementCrumb(int index, OV overlay) {
        return "[" + index + "]";
    }

    private CollectionStore<OV> getStore(CollectionOverlay<OV> object) {
        if (object instanceof ListOverlay) {
            ListOverlay<OV> list = (ListOverlay<OV>) object;
            return list.getStore();
        } else if (object instanceof ValListOverlay) {
            @SuppressWarnings("unchecked")
            ValListOverlay<?, OV> list = (ValListOverlay<?, OV>) object;
            return list.getStore();
        } else if (object instanceof MapOverlay) {
            MapOverlay<OV> map = (MapOverlay<OV>) object;
            return map.getStore();
        } else if (object instanceof ValMapOverlay) {
            @SuppressWarnings("unchecked")
            ValMapOverlay<?, OV> map = (ValMapOverlay<?, OV>) object;
            return map.getStore();
        } else {
            throw new SwaggerParserException(
                    "Could not obtain collection store for object of type " + object.getClass().getName());
        }
    }
}
