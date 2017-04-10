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
package com.reprezen.swaggerparser.val3.ovl;

import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.ovl3.InfoImpl;
import com.reprezen.swaggerparser.val.ImplValidator;
import com.reprezen.swaggerparser.val.ObjectValidator;
import com.reprezen.swaggerparser.val.ValidationResults;

public class InfoOverlayValidator extends ObjectValidator<InfoImpl> implements ImplValidator<Info> {

    @Override
    public void validateImpl(Info info, ValidationResults results) {
        super.validate((InfoImpl) info, results);
    }

}
