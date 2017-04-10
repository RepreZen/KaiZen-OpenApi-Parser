/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.val;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;

public class AnyObjectValidator extends Validator<AnyObjectOverlay> {

    public static AnyObjectValidator validator = new AnyObjectValidator();

    @Override
    public void validate(AnyObjectOverlay object, ValidationResults results) {

    }

    @Override
    public Map<? extends Validator<?>, String> getBeforeValidators() {
        return ImmutableMap.of(OverlayValidator.validator, NO_CRUMB);

    }

}
