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

import javax.lang.model.type.NullType;

import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.old.val.Messages;
import com.reprezen.kaizen.oasparser.old.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.old.val.ValidationResults;

public class ServerVariableValidator extends ObjectValidatorBase<ServerVariable> {

    @Override
    public void validateObject(final ServerVariable variable, final ValidationResults results) {
	results.withCrumb("enum", new Runnable() {
	    @Override
	    public void run() {
		int i = 0;
		for (Object primitive : variable.getEnumValues()) {
		    checkPrimitive(primitive, results, i++);
		}
	    }
	});
	results.withCrumb("default", new Runnable() {
	    @Override
	    public void run() {
		checkPrimitive(variable.getDefault(), results, "default");
	    }
	});
	validateString(variable.getDescription(), results, false, "description");
    }

    private void checkPrimitive(Object primitive, ValidationResults results, int index) {
	checkPrimitive(primitive, results, "[" + index + "]");
    }

    private void checkPrimitive(final Object primitive, ValidationResults results, String crumb) {
	if (!(primitive instanceof String || primitive instanceof Number || primitive instanceof Boolean)) {
	    results.withCrumb(crumb, new Runnable() {
		@Override
		public void run() {
		    Messages.m.msg("BadPrimitive|Invalid primitive value", String.valueOf(primitive),
			    (primitive != null ? primitive.getClass() : NullType.class).getName());
		}
	    });
	}
    }
}
