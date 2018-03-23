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
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Tag;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class TagValidator extends ObjectValidatorBase<Tag> {

	@Inject
	private Validator<ExternalDocs> externalDocsValidator;

	@Override
	public void validateObject(Tag tag, ValidationResults results) {
		validateString(tag.getName(), results, true, "name");
		validateField(tag.getExternalDocs(false), results, false, "externalDocs", externalDocsValidator);
		validateExtensions(tag.getExtensions(), results);
	}

}
