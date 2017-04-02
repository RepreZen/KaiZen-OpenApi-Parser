package com.reprezen.swaggerparser.val3;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.model3.License;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class InfoValidator extends ObjectValidatorBase<Info> {

    @Inject
    private Validator<Contact> contactValidator;
    @Inject
    private Validator<License> licenseValidator;

    @Override
    public void validateModel(Info info, ValidationResults results) {
        validateString(info.getTitle(), results, true, null, "title");
        validateField(info.getContact(), results, true, "contact", contactValidator);
        validateField(info.getLicense(), results, false, "license", licenseValidator);
        validateString(info.getVersion(), results, true, null, "version");
        validateExtensions(info.getExtensions(), results);
    }
}
