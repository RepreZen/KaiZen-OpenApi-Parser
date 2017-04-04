package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val3.Regexes.EXT_REGEX;
import static com.reprezen.swaggerparser.val3.Regexes.NAME_REGEX;
import static com.reprezen.swaggerparser.val3.Regexes.PATH_REGEX;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Callback;
import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.model3.Header;
import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.model3.Link;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.model3.Path;
import com.reprezen.swaggerparser.model3.RequestBody;
import com.reprezen.swaggerparser.model3.Response;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.SecurityRequirement;
import com.reprezen.swaggerparser.model3.SecurityScheme;
import com.reprezen.swaggerparser.model3.Server;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.model3.Tag;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class Swagger3Validator extends ObjectValidatorBase<Swagger3> {

    @Inject
    private Validator<Info> infoValidator;
    @Inject
    private Validator<Server> serverValidator;
    @Inject
    private Validator<Path> pathValidator;
    @Inject
    private Validator<Schema> schemaValidator;
    @Inject
    private Validator<Response> responseValidator;
    @Inject
    private Validator<Parameter> parameterValidator;
    @Inject
    private Validator<RequestBody> requestBodyValidator;
    @Inject
    private Validator<Header> headerValidator;
    @Inject
    private Validator<SecurityScheme> securitySchemeValidator;
    @Inject
    private Validator<Link> linkValidator;
    @Inject
    private Validator<Callback> callbackValidator;
    @Inject
    private Validator<SecurityRequirement> securityRequirementValidator;
    @Inject
    private Validator<Tag> tagValidator;
    @Inject
    private Validator<ExternalDocs> externalDocsValidator;

    @Override
    public void validateObject(final Swagger3 swagger, final ValidationResults results) {
        results.withCrumb("model", new Runnable() {
            @Override
            public void run() {
                validateString(swagger.getOpenApi(), results, true, "3\\.\\d+(\\.\\d+)?", "openapi");
                validateField(swagger.getInfo(), results, true, "info", infoValidator);
                validateList(swagger.getServers(), swagger.hasServers(), results, false, "servers", serverValidator);
                validateMap(swagger.getPaths(), results, true, "paths", EXT_REGEX, pathValidator);
                validateMap(swagger.getPathsExtensions(), results, false, "paths", PATH_REGEX, null);
                validateMap(swagger.getSchemas(), results, false, "collections/schemas", NAME_REGEX, schemaValidator);
                validateMap(swagger.getResponses(), results, false, "collections/responses", NAME_REGEX,
                        responseValidator);
                validateMap(swagger.getParameters(), results, false, "collections/parameters", NAME_REGEX,
                        parameterValidator);
                validateMap(swagger.getExamples(), results, false, "collections/examples", NAME_REGEX, null);
                validateMap(swagger.getRequestBodies(), results, false, "collection/requestBodies", NAME_REGEX,
                        requestBodyValidator);
                validateMap(swagger.getHeaders(), results, false, "collections/headers", NAME_REGEX, headerValidator);
                validateMap(swagger.getSecuritySchemes(), results, false, "collections/securitySchemes", NAME_REGEX,
                        securitySchemeValidator);
                validateMap(swagger.getLinks(), results, false, "collections/links", NAME_REGEX, linkValidator);
                validateMap(swagger.getCallbacks(), results, false, "collections/callbacks", NAME_REGEX,
                        callbackValidator);
                validateMap(swagger.getComponentsExtensions(), results, false, "collections", EXT_REGEX, null);
                validateList(swagger.getSecurityRequirements(), swagger.hasSecurityRequirements(), results, false,
                        "security", securityRequirementValidator);
                validateList(swagger.getTags(), swagger.hasTags(), results, false, "tags", tagValidator);
                validateField(swagger.getExternalDocs(), results, false, "externalDocs", externalDocsValidator);
                validateExtensions(swagger.getExtensions(), results);
            }
        });
    }
}
