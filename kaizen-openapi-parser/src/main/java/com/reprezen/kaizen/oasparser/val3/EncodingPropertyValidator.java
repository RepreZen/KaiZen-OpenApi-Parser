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

import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class EncodingPropertyValidator extends ObjectValidatorBase<EncodingProperty> {

	@Override
	public void validateObject(EncodingProperty encodingProperty, ValidationResults results) {
		// no validation for: contentType, explode
		// TODO Q: spec says "Headers" (capitalized) for peroperty name -assuming it's a
		// typo
		validateMap(encodingProperty.getHeaders(), results, false, "headers", Regexes.NOEXT_REGEX, null);
		validateString(encodingProperty.getStyle(), results, false, Regexes.STYLE_REGEX, "style");
		validateExtensions(encodingProperty.getExtensions(), results);
	}

}
