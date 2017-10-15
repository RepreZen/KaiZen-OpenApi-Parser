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
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class SecuritySchemeValidator extends ObjectValidatorBase<SecurityScheme> {

    @Inject
    private Validator<OAuthFlow> oauthFlowValidator;

    @Override
    public void validateObject(SecurityScheme securityScheme, ValidationResults results) {
        // no validation for: description, bearerFormat
        validateString(securityScheme.getType(false), results, true, "apiKey|http|oauth2|openIdConnect", "type");
        switch (securityScheme.getType(false)) {
            case "http":
            	validateString(securityScheme.getScheme(false), results, true, "scheme");
                // If bearer validate bearerFormat
                break;
            case "apiKey":
                validateString(securityScheme.getName(false), results, true, "name");
                validateString(securityScheme.getIn(false), results, true, "query|header|cookie", "in");
                break;
            case "oauth2":
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "flow.implicit", oauthFlowValidator);
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "flow.password", oauthFlowValidator);
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "flow.clientCredentials", oauthFlowValidator);
                validateField(securityScheme.getImplicitOAuthFlow(false), results, false, "authorizationCode", oauthFlowValidator);
                validateExtensions(securityScheme.getOAuthFlowsExtensions(false), results, "flow");
                break;
            case "openIdConnect":
                validateUrl(securityScheme.getOpenIdConnectUrl(false), results, true, "openIdConnectUrl");
                break;
        }
        validateExtensions(securityScheme.getExtensions(false), results);
    }

}
