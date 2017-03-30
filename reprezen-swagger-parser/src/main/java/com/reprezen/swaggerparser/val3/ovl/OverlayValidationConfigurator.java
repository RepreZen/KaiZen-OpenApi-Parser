package com.reprezen.swaggerparser.val3.ovl;

import com.google.inject.TypeLiteral;
import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val3.ValidationConfigurator;

public class OverlayValidationConfigurator extends ValidationConfigurator {

    @Override
    protected void configureImplValidators() {
        bind(new TypeLiteral<ImplValidator<Swagger3>>() {
        }).to(Swagger3OverlayValidator.class);
        bind(new TypeLiteral<ImplValidator<Info>>() {
        }).to(InfoOverlayValidator.class);
        bind(new TypeLiteral<ImplValidator<Contact>>() {
        }).to(ContactOverlayValidator.class);
    }
}
