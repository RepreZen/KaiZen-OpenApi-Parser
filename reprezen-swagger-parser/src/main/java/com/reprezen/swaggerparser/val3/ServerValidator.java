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
        // no validation for: description
        validateUrl(server.getUrl(), results, false, "url", true);
        validateMap(server.getServerVariables(), results, false, "variables", NAME_REGEX, serverVariableValidator);
        validateExtensions(server.getExtensions(), results);
    }
}
