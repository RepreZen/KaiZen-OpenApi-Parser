package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.impl3.Swagger3Impl;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.ValidationResults.CrumbState;

public class Swagger3Validator extends ObjectValidator<Swagger3Impl> {

    public static Swagger3Validator validator = new Swagger3Validator();

    @Override
    public void validate(Swagger3Impl object, ValidationResults results) {
        try (CrumbState crumbs = results.withCrumb("model")) {
            super.validate(object, results);
            validateString("openApi", true);
        }
    }
}
