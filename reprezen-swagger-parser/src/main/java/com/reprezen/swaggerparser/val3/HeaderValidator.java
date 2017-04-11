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
import com.reprezen.swaggerparser.model3.Header;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class HeaderValidator extends ObjectValidatorBase<Header> {

    @Inject
    Validator<Parameter> parameterValidator;

    @Override
    public void validateObject(Header header, ValidationResults results) {
        // TODO: additional constraints peculiar to header
        parameterValidator.validate(header, results);
    }

}
