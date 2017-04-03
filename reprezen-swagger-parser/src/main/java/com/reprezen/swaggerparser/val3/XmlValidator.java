package com.reprezen.swaggerparser.val3;

import javax.print.attribute.standard.Severity;

import com.reprezen.swaggerparser.model3.Xml;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class XmlValidator extends ObjectValidatorBase<Xml> {

    @Override
    public void validateModel(Xml xml, ValidationResults results) {
        // no validation for: name, prefix, attribute, wrapped
        validateUrl(xml.getNamespace(), results, false, "namespace", false, Severity.WARNING);
        validateExtensions(xml.getExtensions(), results);
    }

}
