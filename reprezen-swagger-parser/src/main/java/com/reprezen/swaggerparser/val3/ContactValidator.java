package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class ContactValidator extends ObjectValidatorBase<Contact> {

    @Override
    public void validateModel(Contact contact, ValidationResults results) {
        validateString(contact.getName(), results, false, null, "name");
        validateUrl(contact.getUrl(), results, false, "url");
        validateEmail(contact.getEmail(), results, false, "email");
        validateExtensions(contact.getExtensions(), results);
    }

}
