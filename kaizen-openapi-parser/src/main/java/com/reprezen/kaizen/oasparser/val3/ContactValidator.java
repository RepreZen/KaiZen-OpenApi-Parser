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

import static com.reprezen.kaizen.oasparser.ovl3.ContactImpl.F_email;
import static com.reprezen.kaizen.oasparser.ovl3.ContactImpl.F_name;
import static com.reprezen.kaizen.oasparser.ovl3.ContactImpl.F_url;

import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class ContactValidator extends ObjectValidatorBase<Contact> {

	@Override
	public void runObjectValidations() {
		Contact contact = (Contact) value.getOverlay();
		validateStringField(F_name, false);
		validateUrlField(F_url, false, true, false);
		validateEmailField(F_email, false);
		validateExtensions(contact.getExtensions());
	}
}
