package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Header;
import com.reprezen.swaggerparser.model3.Link;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.Response;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class ResponseValidator extends ObjectValidatorBase<Response> {

    @Inject
    private Validator<Header> headerValidator;
    @Inject
    private Validator<MediaType> mediaTypeValidator;
    @Inject
    private Validator<Link> linkValidator;

    @Override
    public void validateObject(Response response, ValidationResults results) {
        validateMap(response.getHeaders(), results, false, "headers", null, headerValidator);
        validateMap(response.getContentMediaTypes(), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateMap(response.getLinks(), results, false, "links", Regexes.NOEXT_NAME_REGEX, linkValidator);
        validateExtensions(response.getExtensions(), results);
    }
}
