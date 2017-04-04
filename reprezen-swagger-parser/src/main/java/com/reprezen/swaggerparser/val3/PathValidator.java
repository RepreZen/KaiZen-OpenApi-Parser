package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Operation;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.model3.Path;
import com.reprezen.swaggerparser.model3.Server;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class PathValidator extends ObjectValidatorBase<Path> {

    @Inject
    private Validator<Operation> operationValidator;
    @Inject
    private Validator<Server> serverValidator;
    @Inject
    private Validator<Parameter> parameterValidator;

    @Override
    public void validateObject(Path path, ValidationResults results) {
        // no validation for: summary, description
        validateMap(path.getOperations(), results, false, null, Regexes.METHOD_REGEX, operationValidator);
        validateList(path.getServers(), path.hasServers(), results, false, "servers", serverValidator);
        validateList(path.getParameters(), path.hasParameters(), results, false, "parameters", parameterValidator);
        validateExtensions(path.getExtensions(), results);
    }
}
