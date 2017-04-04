package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.model3.EncodingProperty;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class EncodingPropertyValidator extends ObjectValidatorBase<EncodingProperty> {

    @Override
    public void validateObject(EncodingProperty encodingProperty, ValidationResults results) {
        // no validation for: contentType, explode
        // TODO Q: spec says "Headers" (capitalized) for peroperty name -assuming it's a typo
        validateMap(encodingProperty.getHeaders(), results, false, "headers", Regexes.NOEXT_REGEX, null);
        validateString(encodingProperty.getStyle(), results, false, Regexes.STYLE_REGEX, "style");
        validateExtensions(encodingProperty.getExtensions(), results);
    }

}
