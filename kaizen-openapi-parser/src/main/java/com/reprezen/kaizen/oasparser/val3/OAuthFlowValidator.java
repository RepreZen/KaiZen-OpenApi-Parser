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

import static com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl.F_authorizationUrl;
import static com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl.F_refreshUrl;
import static com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl.F_scopes;
import static com.reprezen.kaizen.oasparser.ovl3.OAuthFlowImpl.F_tokenUrl;

import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class OAuthFlowValidator extends ObjectValidatorBase<OAuthFlow> {

    @Override
    public void runObjectValidations() {
        OAuthFlow oauthFlow = (OAuthFlow) value.getOverlay();
        validateUrlField(F_authorizationUrl, true, true, false);
        validateUrlField(F_tokenUrl, true, true, false);
        validateUrlField(F_refreshUrl, false, true, false);
        validateMapField(F_scopes, true, false, String.class, null);
        validateExtensions(oauthFlow.getExtensions());
    }
}
