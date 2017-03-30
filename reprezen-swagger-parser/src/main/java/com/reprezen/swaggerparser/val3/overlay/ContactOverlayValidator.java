package com.reprezen.swaggerparser.val3.overlay;

import com.reprezen.swaggerparser.impl3.ContactImpl;
import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val.Messages;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;

public class ContactOverlayValidator extends ObjectValidator<ContactImpl> implements ImplValidator<Contact> {

    @Override
    public void validateImpl(Contact contact, ValidationResults results) {
        super.validate((ContactImpl) contact, results);
        results.addInfo(Messages.m.msg("Ha from Contact!"));
    }

}
