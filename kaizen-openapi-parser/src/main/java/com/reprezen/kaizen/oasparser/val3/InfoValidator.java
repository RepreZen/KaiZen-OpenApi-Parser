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

import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.License;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class InfoValidator extends ObjectValidatorBase<Info> {

	@Override
	public void runObjectValidations() {
		Info info = value.get();
		validateStringField("title", true);
		validateField("contact", false, Contact.class, new ContactValidator());
		validateField("license", false, License.class, new LicenseValidator());
		validateStringField("version", true);
		validateExtensions(info.getExtensions());
	}
}
