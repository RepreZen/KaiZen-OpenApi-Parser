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
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SecuritySchemeValidator extends ObjectValidatorBase<SecurityScheme> {

	@Override
	public void runObjectValidations() {
		SecurityScheme securityScheme = (SecurityScheme) value.getOverlay();
		validateStringField("description", false);
		validateStringField("type", true, "apiKey|http|oauth2|openIdConnect");
		String type = securityScheme.getType();
		if (type != null) {
			switch (type) {
			case "http":
				validateStringField("scheme", true);
				validateStringField("bearerFormat", false);
				break;
			case "apiKey":
				validateStringField("name", true);
				validateStringField("in", true, "query|header|cookie");
				break;
			case "oauth2": {
				OAuthFlowValidator oauthFlowValidator = new OAuthFlowValidator();
				validateField("implicitOAuthFlow", false, OAuthFlow.class, oauthFlowValidator);
				validateField("passwordOAuthFlow", false, OAuthFlow.class, oauthFlowValidator);
				validateField("clientCredentialsOAuthFlow", false, OAuthFlow.class, oauthFlowValidator);
				validateField("AuthorizationCodeOAuthFlow", false, OAuthFlow.class, oauthFlowValidator);
				break;
			}
			case "openIdConnect":
				validateUrlField("openIdConnectUrl", true, false);
				break;
			}
		}
		validateExtensions(securityScheme.getExtensions());
	}
}
