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

import com.reprezen.kaizen.oasparser.model3.License;
import com.reprezen.kaizen.oasparser.ovl3.LicenseImpl;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class LicenseValidator extends ObjectValidatorBase<License> {

	@Override
	public void validateObject(License license, ValidationResults results) {
		validateString(license.getName(), results, true, "name");
		validateUrl(license.getUrl(), results, false, "url", (LicenseImpl) license);
		validateExtensions(license.getExtensions(), results);
	}

}
