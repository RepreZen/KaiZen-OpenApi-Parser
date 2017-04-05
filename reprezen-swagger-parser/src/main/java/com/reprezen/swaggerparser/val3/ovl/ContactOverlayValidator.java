package com.reprezen.swaggerparser.val3.ovl;

import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.ovl3.ContactImpl;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;

public class ContactOverlayValidator extends ObjectValidator<ContactImpl> implements ImplValidator<Contact> {

    @Override
    public void validateImpl(Contact contact, ValidationResults results) {
        super.validate((ContactImpl) contact, results);
    }

}
