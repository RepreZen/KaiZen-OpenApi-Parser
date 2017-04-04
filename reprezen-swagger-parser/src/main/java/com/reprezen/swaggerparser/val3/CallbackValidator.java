package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Callback;
import com.reprezen.swaggerparser.model3.Path;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class CallbackValidator extends ObjectValidatorBase<Callback> {

    @Inject
    private Validator<Path> pathValidator;

    @Override
    public void validateObject(Callback callback, ValidationResults results) {
        validateMap(callback.getCallbackPaths(), results, false, null, Regexes.NOEXT_REGEX, pathValidator);
        validateExtensions(callback.getExtensions(), results);
    }

}
