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
        validateString(securityScheme.getType(), results, true, "apiKey|http|oauth2|openIdConnect", "type");
        validateString(securityScheme.getName(), results, true, "name");
        validateString(securityScheme.getIn(), results, true, "query|header", "in");
        // TODO Q: Spec says 'flow' is required, but it's just a map of OAuthFlow objects, none of which is noted as
        // required. What's the real requirement here? Is anything required if type != oauth2
        validateField(securityScheme.getImplicitOAuthFlow(), results, false, "flow.implicit", oauthFlowValidator);
        validateExtensions(securityScheme.getOAuthFlowsExtensions(), results, "flow");
        // TODO Q: is this really required if type != openIdConnect?
        validateUrl(securityScheme.getOpenIdConnectUrl(), results, true, "openIdConnectUrl");
        validateExtensions(securityScheme.getExtensions(), results);
    }

}
