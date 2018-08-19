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

import static com.reprezen.kaizen.oasparser.val.Messages.m;

import java.util.regex.Pattern;

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class OperationValidator extends ObjectValidatorBase<Operation> {

	@Override
	public void runObjectValidations() {
		validateListField("tags", false, false, String.class, null);
		validateStringField("summary", false, (Pattern) null, this::checkSummaryLength);
		validateField("externalDocs", false, ExternalDocs.class, new ExternalDocsValidator());
		// TODO Q: Not marked as required in spec, but spec says they all must be unique
		// within the API. Seems like it
		// should be required.
		validateStringField("operationId", false);
		validateListField("parameters", false, false, Parameter.class, new ParameterValidator());
		validateField("requestBody", false, RequestBody.class, new RequestBodyValidator());
		validateMapField("responses", true, false, Response.class, new ResponseValidator());
		validateMapField("callbacks", false, false, Callback.class, new CallbackValidator());
		validateListField("securityRequirements", false, false, SecurityRequirement.class,
				new SecurityRequirementValidator());
		validateListField("servers", false, false, Server.class, new ServerValidator());
	}

	private void checkSummaryLength(Overlay<String> summary) {
		if (summary != null && summary.isPresent() && summary.get().length() > 120) {
			results.addWarning(m.msg("LongSummary|Sumamry exceeds recommended limit of 120 chars"), summary);
		}
	}
}
