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

import static com.reprezen.kaizen.oasparser.ovl3.TagImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.TagImpl.F_externalDocs;
import static com.reprezen.kaizen.oasparser.ovl3.TagImpl.F_name;

import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Tag;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class TagValidator extends ObjectValidatorBase<Tag> {

    @Override
    public void runObjectValidations() {
        Tag tag = (Tag) value.getOverlay();
        validateStringField(F_name, true);
        validateStringField(F_description, false);
        validateField(F_externalDocs, false, ExternalDocs.class, new ExternalDocsValidator());
        validateExtensions(tag.getExtensions());
    }
}
