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

import static com.reprezen.kaizen.oasparser.ovl3.ResponseImpl.F_contentMediaTypes;
import static com.reprezen.kaizen.oasparser.ovl3.ResponseImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.ResponseImpl.F_headers;
import static com.reprezen.kaizen.oasparser.ovl3.ResponseImpl.F_links;

import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class ResponseValidator extends ObjectValidatorBase<Response> {

	@Override
	public void runObjectValidations() {
		Response response = (Response) value.getOverlay();
		validateStringField(F_description, false);
		validateMapField(F_headers, false, false, Header.class, new HeaderValidator());
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateMapField(F_links, false, false, Link.class, new LinkValidator());
		validateExtensions(response.getExtensions());
	}
}
