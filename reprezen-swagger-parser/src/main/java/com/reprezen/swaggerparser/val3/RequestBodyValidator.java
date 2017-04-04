package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.RequestBody;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class RequestBodyValidator extends ObjectValidatorBase<RequestBody> {

    @Inject
    private Validator<MediaType> mediaTypeValidator;

    @Override
    public void validateObject(RequestBody requestBody, ValidationResults results) {
        // no validation for: description, required
        validateMap(requestBody.getContentMediaTypes(), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateExtensions(requestBody.getExtensions(), results);
    }

}
