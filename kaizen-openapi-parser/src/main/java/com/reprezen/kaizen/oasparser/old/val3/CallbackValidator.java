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
package com.reprezen.kaizen.oasparser.old.val3;

import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.old.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.old.val.ValidationResults;
import com.reprezen.kaizen.oasparser.old.val.Validator;

public class CallbackValidator extends ObjectValidatorBase<Callback> {

    @Inject
    private Validator<Path> pathValidator;

    @Override
    public void validateObject(Callback callback, ValidationResults results) {
	validateMap(callback.getCallbackPaths(), results, false, null, Regexes.NOEXT_REGEX, pathValidator);
	validateExtensions(callback.getExtensions(), results);
    }

}
