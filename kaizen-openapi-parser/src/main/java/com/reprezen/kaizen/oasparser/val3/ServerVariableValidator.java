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

import javax.lang.model.type.NullType;

import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.val.Messages;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.StringValidator;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class ServerVariableValidator extends ObjectValidatorBase<ServerVariable> {

    @Override
    public void validateObject(final ServerVariable variable, final ValidationResults results) {
        validateList(variable.getEnumValues(), variable.hasEnumValues(), results, false, "enum", null);
        validateString(variable.getDefault(), results, true, "default");
        validateDescription(variable.getDescription(), results);
        validateExtensions(variable.getExtensions(), results);
    }

}
