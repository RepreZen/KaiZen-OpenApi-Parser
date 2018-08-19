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

import static com.reprezen.kaizen.oasparser.ovl3.EncodingPropertyImpl.F_contentType;
import static com.reprezen.kaizen.oasparser.ovl3.EncodingPropertyImpl.F_explode;
import static com.reprezen.kaizen.oasparser.ovl3.EncodingPropertyImpl.F_headers;
import static com.reprezen.kaizen.oasparser.ovl3.EncodingPropertyImpl.F_style;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_allowReserved;

import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class EncodingPropertyValidator extends ObjectValidatorBase<EncodingProperty> {

	@Override
	public void runObjectValidations() {
		EncodingProperty encodingProperty = (EncodingProperty) value.getOverlay();

		// TODO ought to have a pattern for acceptable values "a/b", "a/*", comma-lists
		// of those.
		validateStringField(F_contentType, false);

		// TODO Q: spec says "Headers" (capitalized) for property name -assuming it's a
		// typo
		validateMapField(F_headers, false, false, Header.class, null);
		validateStringField(F_style, false, Regexes.STYLE_REGEX);
		validateBooleanField(F_explode, false);
		validateBooleanField(F_allowReserved, false);
		validateExtensions(encodingProperty.getExtensions());
	}

}
