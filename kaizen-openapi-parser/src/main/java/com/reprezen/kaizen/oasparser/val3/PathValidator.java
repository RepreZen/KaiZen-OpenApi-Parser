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
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class PathValidator extends ObjectValidatorBase<Path> {

    @Inject
    private Validator<Operation> operationValidator;
    @Inject
    private Validator<Server> serverValidator;
    @Inject
    private Validator<Parameter> parameterValidator;

    @Override
    public void validateObject(Path path, ValidationResults results) {
        // no validation for: summary, description
        validateMap(path.getOperations(false), results, false, null, Regexes.METHOD_REGEX, operationValidator);
        validateList(path.getServers(false), path.hasServers(), results, false, "servers", serverValidator);
        validateList(path.getParameters(false), path.hasParameters(), results, false, "parameters", parameterValidator);
        validateExtensions(path.getExtensions(false), results);
    }
}
