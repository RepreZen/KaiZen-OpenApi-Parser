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
package com.reprezen.kaizen.oasparser.old.val3;

import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.old.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.old.val.ValidationResults;

public class ExternalDocsValidator extends ObjectValidatorBase<ExternalDocs> {

    @Override
    public void validateObject(ExternalDocs externalDocs, ValidationResults results) {
	// no validation for: description
	validateUrl(externalDocs.getUrl(), results, true, "externalDocs");
	validateExtensions(externalDocs.getExtensions(), results);
    }

}
