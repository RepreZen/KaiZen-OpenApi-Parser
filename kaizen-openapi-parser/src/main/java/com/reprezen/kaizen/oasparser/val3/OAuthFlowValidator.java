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

import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

import javax.print.attribute.standard.Severity;

public class OAuthFlowValidator extends ObjectValidatorBase<OAuthFlow> {

	@Override
	public void validateObject(OAuthFlow oauthFlow, ValidationResults results) {
		validateUrl(oauthFlow.getAuthorizationUrl(), results, true, "authorizationUrl", false, Severity.ERROR, (OAuthFlowImpl) oauthFlow);
		validateUrl(oauthFlow.getTokenUrl(), results, true, "tokenUrl", false, Severity.ERROR, (OAuthFlowImpl) oauthFlow);
		validateUrl(oauthFlow.getRefreshUrl(), results, true, "refreshUrl", false, Severity.ERROR, (OAuthFlowImpl) oauthFlow);
		validateMap(oauthFlow.getScopes(), results, true, "scopes", Regexes.NOEXT_REGEX, null);
		validateExtensions(oauthFlow.getExtensions(), results);
	}

}
