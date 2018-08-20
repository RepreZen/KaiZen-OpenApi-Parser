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

import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_authorizationCodeOAuthFlow;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_bearerFormat;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_clientCredentialsOAuthFlow;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_implicitOAuthFlow;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_in;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_name;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_openIdConnectUrl;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_passwordOAuthFlow;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_scheme;
import static com.reprezen.kaizen.oasparser.ovl3.SecuritySchemeImpl.F_type;

import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SecuritySchemeValidator extends ObjectValidatorBase<SecurityScheme> {

	@Override
	public void runObjectValidations() {
		SecurityScheme securityScheme = (SecurityScheme) value.getOverlay();
		validateStringField(F_description, false);
		validateStringField(F_type, true, "apiKey|http|oauth2|openIdConnect");
		String type = securityScheme.getType();
		if (type != null) {
			switch (type) {
			case "http":
				validateStringField(F_scheme, true);
				validateStringField(F_bearerFormat, false);
				break;
			case "apiKey":
				validateStringField(F_name, true);
				validateStringField(F_in, true, "query|header|cookie");
				break;
			case "oauth2": {
				OAuthFlowValidator oauthFlowValidator = new OAuthFlowValidator();
				validateField(F_implicitOAuthFlow, false, OAuthFlow.class, oauthFlowValidator);
				validateField(F_passwordOAuthFlow, false, OAuthFlow.class, oauthFlowValidator);
				validateField(F_clientCredentialsOAuthFlow, false, OAuthFlow.class, oauthFlowValidator);
				validateField(F_authorizationCodeOAuthFlow, false, OAuthFlow.class, oauthFlowValidator);
				break;
			}
			case "openIdConnect":
				validateUrlField(F_openIdConnectUrl, true, false);
				break;
			}
		}
		validateExtensions(securityScheme.getExtensions());
	}
}
