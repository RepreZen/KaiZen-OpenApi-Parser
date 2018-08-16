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
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.ovl3.ServerImpl;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

import javax.print.attribute.standard.Severity;

import static com.reprezen.kaizen.oasparser.val3.Regexes.NAME_REGEX;

public class ServerValidator extends ObjectValidatorBase<Server> {

	@Inject
	private Validator<ServerVariable> serverVariableValidator;

	@Override
	public void validateObject(Server server, ValidationResults results) {
		// no validation for: description
		validateUrl(server.getUrl(), results, false, "url", true, Severity.ERROR, (ServerImpl) server);
		validateMap(server.getServerVariables(), results, false, "variables", NAME_REGEX, serverVariableValidator);
		validateExtensions(server.getExtensions(), results);
	}
}
