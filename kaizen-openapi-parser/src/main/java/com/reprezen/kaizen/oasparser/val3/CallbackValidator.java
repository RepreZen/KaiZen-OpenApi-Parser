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

import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class CallbackValidator extends ObjectValidatorBase<Callback> {

	@Override
	public void runObjectValidations() {
		Callback callback = (Callback) value.getOverlay();
		validateMapField("callbackPaths", false, false, Path.class, new PathValidator());
		validateExtensions(callback.getExtensions());
	}

}
