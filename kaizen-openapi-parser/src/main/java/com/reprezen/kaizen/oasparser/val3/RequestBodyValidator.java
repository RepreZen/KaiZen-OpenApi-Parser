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

import static com.reprezen.kaizen.oasparser.ovl3.RequestBodyImpl.F_contentMediaTypes;
import static com.reprezen.kaizen.oasparser.ovl3.RequestBodyImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.RequestBodyImpl.F_required;

import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class RequestBodyValidator extends ObjectValidatorBase<RequestBody> {

	@Override
	public void runObjectValidations() {
		RequestBody requestBody = (RequestBody) value.getOverlay();
		validateStringField(F_description, false);
		validateBooleanField(F_required, false);
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateExtensions(requestBody.getExtensions());
	}
}
