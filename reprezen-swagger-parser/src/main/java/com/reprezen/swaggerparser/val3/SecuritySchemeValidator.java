package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.OAuthFlow;
import com.reprezen.swaggerparser.model3.SecurityScheme;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class SecuritySchemeValidator extends ObjectValidatorBase<SecurityScheme> {

    @Inject
    private Validator<OAuthFlow> oauthFlowValidator;

    @Override
    public void validateModel(SecurityScheme securityScheme, ValidationResults results) {
        // no validation for: description, bearerFormat
        validateString(securityScheme.getType(), results, true, "apiKey|http|oauth2|openIdConnect", "type");
        validateString(securityScheme.getName(), results, true, null, "name");
        validateString(securityScheme.getIn(), results, true, "query|header", "in");
        // TODO Q: Spec says 'flow' is required, but it's just a map of OAuthFlow objects, none of which is noted as
        // required. What's the real requirement here?
        validateField(securityScheme.getImplicitOAuthFlow(), results, false, "flow.implicit", oauthFlowValidator);
        validateExtensions(securityScheme.getOAuthFlowsExtensions(), results, "flow");
        validateUrl(securityScheme.getOpenIdConnectUrl(), results, true, "openIdConnectUrl");
        validateExtensions(securityScheme.getExtensions(), results);
    }

}
