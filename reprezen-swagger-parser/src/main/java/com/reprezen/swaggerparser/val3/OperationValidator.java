package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val.Messages.m;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Callback;
import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.model3.Operation;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.model3.RequestBody;
import com.reprezen.swaggerparser.model3.Response;
import com.reprezen.swaggerparser.model3.SecurityRequirement;
import com.reprezen.swaggerparser.model3.Server;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class OperationValidator extends ObjectValidatorBase<Operation> {

    @Inject
    private Validator<ExternalDocs> externalDocsValidator;
    @Inject
    private Validator<Parameter> parameterValidator;
    @Inject
    private Validator<RequestBody> requestBodyValidator;
    @Inject
    private Validator<Response> responseValidator;
    @Inject
    private Validator<Callback> callbackValidator;
    @Inject
    private Validator<SecurityRequirement> securityRequirementValidator;
    @Inject
    private Validator<Server> serverValidator;

    @Override
    public void validateObject(Operation operation, ValidationResults results) {
        // no validation for: tags, description, deprecated
        checkSummaryLength(operation, results);
        validateField(operation.getExternalDocs(), results, false, "externalDocs", externalDocsValidator);
        // TODO Q: Not marked as required in spec, but spec says they all must be unique within the API. Seems like it should be required.
        validateString(operation.getOperationId(), results, false, "operationId");
        validateList(operation.getParameters(), operation.hasParameters(), results, false, "parameters",
                parameterValidator);
        validateField(operation.getRequestBody(), results, false, "requestBody", requestBodyValidator);
        validateMap(operation.getResponses(), results, true, "responses", Regexes.RESPONSE_REGEX, responseValidator);
        validateMap(operation.getCallbacks(), results, false, "callbacks", Regexes.NOEXT_REGEX, callbackValidator);
        validateList(operation.getSecurityRequirements(), operation.hasSecurityRequirements(), results, false,
                "security", securityRequirementValidator);
        validateList(operation.getServers(), operation.hasServers(), results, false, "servers", serverValidator);
    }

    private void checkSummaryLength(Operation operation, ValidationResults results) {
        String summary = operation.getSummary();
        if (summary != null && summary.length() > 120) {
            results.addWarning(m.msg("LongSummary|Sumamry exceeds recommended limit of 120 chars"), "summary");
        }
    }
}
