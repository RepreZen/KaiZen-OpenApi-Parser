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

import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.ovl3.ContactImpl;
import com.reprezen.kaizen.oasparser.val.ImplValidator;
import com.reprezen.kaizen.oasparser.val.ObjectValidator;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class ContactOverlayValidator extends ObjectValidator<ContactImpl> implements ImplValidator<Contact> {

	@Override
	public void validateImpl(Contact contact, ValidationResults results) {
		super.validate((ContactImpl) contact, results);
	}

}
