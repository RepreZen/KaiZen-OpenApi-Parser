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

import com.reprezen.swaggerparser.impl3.Swagger3Impl;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.ValidationResults.CrumbState;

public class Swagger3Validator extends ObjectValidator<Swagger3Impl> {

    public static Swagger3Validator validator = new Swagger3Validator();

    @Override
    public void validate(Swagger3Impl object, ValidationResults results) {
        try (CrumbState crumbs = results.withCrumb("model")) {
            super.validate(object, results);
            validateString("openApi", true);
        }
    }
}
