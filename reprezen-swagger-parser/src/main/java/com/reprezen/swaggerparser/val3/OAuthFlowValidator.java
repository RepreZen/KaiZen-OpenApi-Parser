package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.model3.OAuthFlow;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class OAuthFlowValidator extends ObjectValidatorBase<OAuthFlow> {

    @Override
    public void validateObject(OAuthFlow oauthFlow, ValidationResults results) {
        validateUrl(oauthFlow.getAuthorizationUrl(), results, true, "authorizationUrl");
        validateUrl(oauthFlow.getTokenUrl(), results, true, "tokenUrl");
        validateUrl(oauthFlow.getRefreshUrl(), results, true, "refreshUrl");
        validateMap(oauthFlow.getScopes(), results, true, "scopes", Regexes.NOEXT_REGEX, null);
        validateExtensions(oauthFlow.getExtensions(), results);
    }

}
