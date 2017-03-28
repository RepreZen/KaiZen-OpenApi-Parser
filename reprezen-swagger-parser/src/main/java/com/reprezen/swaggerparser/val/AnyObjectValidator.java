package com.reprezen.swaggerparser.val;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;

public class AnyObjectValidator extends Validator<AnyObjectOverlay> {

    public static AnyObjectValidator validator = new AnyObjectValidator();

    @Override
    public void validate(AnyObjectOverlay object, ValidationResults results) {

    }

    @Override
    public Map<? extends Validator<?>, String> getBeforeValidators() {
        return ImmutableMap.of(OverlayValidator.validator, NO_CRUMB);

    }

}
