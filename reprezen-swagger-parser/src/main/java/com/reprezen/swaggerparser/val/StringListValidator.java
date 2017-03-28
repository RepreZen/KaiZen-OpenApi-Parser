package com.reprezen.swaggerparser.val;

import com.reprezen.swaggerparser.jsonoverlay.std.StringListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;

public class StringListValidator extends Validator<StringListOverlay> {

    public static StringListValidator validator = new StringListValidator();

    @Override
    public void validate(StringListOverlay object, ValidationResults results) {
        new ListValidator<StringOverlay>(StringValidator.validator).validate(object, results);
    }
}
