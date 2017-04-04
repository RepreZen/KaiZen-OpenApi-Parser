package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class ExternalDocsValidator extends ObjectValidatorBase<ExternalDocs> {

    @Override
    public void validateObject(ExternalDocs externalDocs, ValidationResults results) {
        // no validation for: description
        validateUrl(externalDocs.getUrl(), results, true, "externalDocs");
        validateExtensions(externalDocs.getExtensions(), results);
    }

}
