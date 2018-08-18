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

import static com.reprezen.kaizen.oasparser.old.val3.Regexes.NAME_REGEX;

import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.old.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.old.val.ValidationResults;
import com.reprezen.kaizen.oasparser.old.val.Validator;

public class ServerValidator extends ObjectValidatorBase<Server> {

    @Inject
    private Validator<ServerVariable> serverVariableValidator;

    @Override
    public void validateObject(Server server, ValidationResults results) {
	// no validation for: description
	validateUrl(server.getUrl(), results, false, "url", true);
	validateMap(server.getServerVariables(), results, false, "variables", NAME_REGEX, serverVariableValidator);
	validateExtensions(server.getExtensions(), results);
    }
}
