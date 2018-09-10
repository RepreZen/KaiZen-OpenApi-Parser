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

import static com.reprezen.kaizen.oasparser.ovl3.ServerImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.ServerImpl.F_serverVariables;
import static com.reprezen.kaizen.oasparser.ovl3.ServerImpl.F_url;

import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class ServerValidator extends ObjectValidatorBase<Server> {

    @Override
    public void runObjectValidations() {
        Server server = (Server) value.getOverlay();
        validateStringField(F_description, false);
        validateUrlField(F_url, true, true, true);
        validateMapField(F_serverVariables, false, false, ServerVariable.class, new ServerVariableValidator());
        validateExtensions(server.getExtensions());
    }
}
