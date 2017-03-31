package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val3.Regexes.NAME_REGEX;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Server;
import com.reprezen.swaggerparser.model3.ServerVariable;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class ServerValidator extends ObjectValidatorBase<Server> {

    @Inject
    private Validator<ServerVariable> serverVariableValidator;

    @Override
    public void validateModel(Server server, ValidationResults results) {
        // can't use validateUrl to validate URL syntax because of potential variable templates in the value
        validateString(server.getUrl(), results, false, null, "url");
        validateString(server.getDescription(), results, false, null, "description");
        validateMap(server.getServerVariables(), results, false, "variables", NAME_REGEX, serverVariableValidator);
        validateExtensions(server.getExtensions(), results);
    }
}
