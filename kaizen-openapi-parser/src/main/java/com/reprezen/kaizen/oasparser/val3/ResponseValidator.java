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
package com.reprezen.kaizen.oasparser.val3;

import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class ResponseValidator extends ObjectValidatorBase<Response> {

    @Inject
    private Validator<Header> headerValidator;
    @Inject
    private Validator<MediaType> mediaTypeValidator;
    @Inject
    private Validator<Link> linkValidator;

    @Override
    public void validateObject(Response response, ValidationResults results) {
        validateMap(response.getHeaders(false), results, false, "headers", null, headerValidator);
        validateMap(response.getContentMediaTypes(false), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateMap(response.getLinks(false), results, false, "links", Regexes.NOEXT_NAME_REGEX, linkValidator);
        validateExtensions(response.getExtensions(false), results);
    }
}
