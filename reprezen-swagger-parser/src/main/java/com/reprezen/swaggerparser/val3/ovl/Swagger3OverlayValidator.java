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
package com.reprezen.swaggerparser.val3.ovl;

import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.ovl3.Swagger3Impl;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;

public class Swagger3OverlayValidator extends ObjectValidator<Swagger3Impl> implements ImplValidator<Swagger3> {

    @Override
    public void validate(Swagger3Impl overlay, ValidationResults results) {
        super.validate(overlay, results);
    }

    @Override
    public void validateImpl(Swagger3 swagger3, ValidationResults results) {
        validate((Swagger3Impl) swagger3, results);
    }

}
