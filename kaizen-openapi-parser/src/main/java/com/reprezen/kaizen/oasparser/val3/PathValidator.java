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

import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class PathValidator extends ObjectValidatorBase<Path> {

	@Override
	public void runObjectValidations() {
		Path path = (Path) value.getOverlay();
		validateStringField("summary", false);
		validateStringField("description", false);
		validateMapField("operations", false, false, Operation.class, new OperationValidator());
		validateListField("servers", false, false, Server.class, new ServerValidator());
		validateListField("parameters", false, false, Parameter.class, new ParameterValidator());
		validateExtensions(path.getExtensions());
	}
}
