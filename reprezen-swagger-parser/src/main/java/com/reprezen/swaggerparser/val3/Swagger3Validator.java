package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class Swagger3Validator extends ObjectValidatorBase<Swagger3> {

    @Inject
    private Validator<Info> infoValidator;

    @Override
    public void validateModel(final Swagger3 swagger, final ValidationResults results) {
        results.withCrumb("model", new Runnable() {
            @Override
            public void run() {
                validateString(swagger.getOpenApi(), results, true, "3\\.\\d+(\\.\\d+)?", "openapi");
                validateField(swagger.getInfo(), results, true, "info", infoValidator);
            }
        });
    }
}
