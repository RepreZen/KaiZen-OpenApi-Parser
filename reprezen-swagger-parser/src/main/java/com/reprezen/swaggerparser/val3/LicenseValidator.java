package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.model3.License;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class LicenseValidator extends ObjectValidatorBase<License> {

    @Override
    public void validateModel(License license, ValidationResults results) {
        validateString(license.getName(), results, true, null, "name");
        validateUrl(license.getUrl(), results, false, "url");
        validateExtensions(license.getExtensions(), results);
    }

}
