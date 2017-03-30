package com.reprezen.swaggerparser.val3.ovl;

import static com.reprezen.swaggerparser.val.Messages.m;

import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.ovl3.Swagger3Impl;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;

public class Swagger3OverlayValidator extends ObjectValidator<Swagger3Impl> implements ImplValidator<Swagger3> {

    @Override
    public void validate(Swagger3Impl overlay, ValidationResults results) {
        super.validate(overlay, results);
        results.addInfo(m.msg("Ha!"));
    }

    @Override
    public void validateImpl(Swagger3 swagger3, ValidationResults results) {
        validate((Swagger3Impl) swagger3, results);
    }

}
