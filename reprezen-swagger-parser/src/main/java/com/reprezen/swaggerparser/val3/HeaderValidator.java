package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Header;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class HeaderValidator extends ObjectValidatorBase<Header> {

    @Inject
    Validator<Parameter> parameterValidator;

    @Override
    public void validateObject(Header header, ValidationResults results) {
        // TODO: additional constraints peculiar to header
        parameterValidator.validate(header, results);
    }

}
