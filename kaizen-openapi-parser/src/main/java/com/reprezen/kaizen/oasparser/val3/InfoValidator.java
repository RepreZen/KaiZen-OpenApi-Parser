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

import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.License;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class InfoValidator extends ObjectValidatorBase<Info> {

    @Inject
    private Validator<Contact> contactValidator;
    @Inject
    private Validator<License> licenseValidator;

    @Override
    public void validateObject(Info info, ValidationResults results) {
        validateString(info.getTitle(), results, true, "title");
        validateField(info.getContact(), results, false, "contact", contactValidator);
        validateField(info.getLicense(), results, false, "license", licenseValidator);
        validateString(info.getVersion(), results, true, "version");
        validateExtensions(info.getExtensions(), results);
    }
}
