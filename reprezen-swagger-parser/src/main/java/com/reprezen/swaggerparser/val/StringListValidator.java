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

import com.reprezen.swaggerparser.jsonoverlay.std.StringListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;

public class StringListValidator extends Validator<StringListOverlay> {

    public static StringListValidator validator = new StringListValidator();

    @Override
    public void validate(StringListOverlay object, ValidationResults results) {
        new ListValidator<StringOverlay>(StringValidator.validator).validate(object, results);
    }
}
