package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class InfoValidator extends ObjectValidatorBase<Info> {

    @Inject
    private Validator<Contact> contactValidator;

    @Override
    public void validateModel(Info info, ValidationResults results) {
        validateString(info.getTitle(), results, false, null, "title");
        validateField(info.getContact(), results, true, "contact", contactValidator);
    }
}
