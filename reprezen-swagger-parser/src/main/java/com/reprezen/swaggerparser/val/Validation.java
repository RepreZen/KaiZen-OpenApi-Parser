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

import java.util.Collections;
import java.util.List;

import com.reprezen.swaggerparser.val.ValidationResults.CrumbState;

public class Validation {

    public static ValidationResults validate(Object obj, Validator<?> validators) {
        return validate(obj, Collections.<String> emptyList(), validators);
    }

    public static ValidationResults validate(Object obj, List<String> crumbs, Validator<?>... validators) {
        ValidationResults results = new ValidationResults();
        try (CrumbState state = results.withCrumbs(crumbs)) {
            for (Validator<?> validator : validators) {
                validator.runValidations(obj, results);
            }
        }
        return results;
    }
}
