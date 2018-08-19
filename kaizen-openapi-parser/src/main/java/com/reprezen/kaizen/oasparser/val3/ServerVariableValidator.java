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

import static com.reprezen.kaizen.oasparser.ovl3.ServerVariableImpl.F_defaultValue;
import static com.reprezen.kaizen.oasparser.ovl3.ServerVariableImpl.F_enumValues;

import com.reprezen.jsonoverlay.Primitive;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class ServerVariableValidator extends ObjectValidatorBase<ServerVariable> {

	@Override
	public void runObjectValidations() {
		validateListField(F_enumValues, false, false, Primitive.class, null);
		validateField(F_defaultValue, false, Primitive.class, null);
	}
}
