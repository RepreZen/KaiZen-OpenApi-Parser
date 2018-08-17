/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.kaizen.oasparser.val3;

import javax.print.attribute.standard.Severity;

import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class XmlValidator extends ObjectValidatorBase<Xml> {

    @Override
    public void validateObject(Xml xml, ValidationResults results) {
        // no validation for: name, prefix, attribute, wrapped
        validateUrl(xml.getNamespace(), results, false, "namespace", false, Severity.WARNING);
        validateExtensions(xml.getExtensions(), results);
    }

}
