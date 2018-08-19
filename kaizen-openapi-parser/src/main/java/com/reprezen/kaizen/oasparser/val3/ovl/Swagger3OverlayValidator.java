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
package com.reprezen.kaizen.oasparser.val3.ovl;

import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.old.val.ImplValidator;
import com.reprezen.kaizen.oasparser.old.val.ObjectValidator;
import com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class Swagger3OverlayValidator extends ObjectValidator<OpenApi3Impl> implements ImplValidator<OpenApi3> {

	@Override
	public void validate(OpenApi3Impl overlay, ValidationResults results) {
		super.validate(overlay, results);
	}

	@Override
	public void validateImpl(OpenApi3 swagger3, ValidationResults results) {
		validate((OpenApi3Impl) swagger3, results);
	}

}
