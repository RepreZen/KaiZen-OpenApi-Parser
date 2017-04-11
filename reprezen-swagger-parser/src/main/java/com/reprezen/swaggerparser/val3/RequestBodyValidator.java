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
package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.RequestBody;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class RequestBodyValidator extends ObjectValidatorBase<RequestBody> {

    @Inject
    private Validator<MediaType> mediaTypeValidator;

    @Override
    public void validateObject(RequestBody requestBody, ValidationResults results) {
        // no validation for: description, required
        validateMap(requestBody.getContentMediaTypes(), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateExtensions(requestBody.getExtensions(), results);
    }

}
