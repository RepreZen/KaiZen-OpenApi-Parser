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
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class EncodingPropertyValidator extends ObjectValidatorBase<EncodingProperty> {

	@Override
	public void runObjectValidations() {
		EncodingProperty encodingProperty = (EncodingProperty) value.getOverlay();

		// TODO ought to have a pattern for acceptable values "a/b", "a/*", comma-lists
		// of those.
		validateStringField("contentType", false);

		// TODO Q: spec says "Headers" (capitalized) for property name -assuming it's a
		// typo
		validateMapField("headers", false, false, Header.class, null);
		validateStringField("style", false, Regexes.STYLE_REGEX);
		validateBooleanField("explode", false);
		validateBooleanField("allowReserved", false);
		validateExtensions(encodingProperty.getExtensions());
	}

}
