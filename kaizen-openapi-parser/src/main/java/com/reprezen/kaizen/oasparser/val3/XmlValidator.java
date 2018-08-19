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

import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class XmlValidator extends ObjectValidatorBase<Xml> {

	@Override
	public void runObjectValidations() {
		Xml xml = (Xml) value.getOverlay();
		validateStringField("name", false);
		validateStringField("prefix", false);
		validateBooleanField("attribute", false);
		validateUrlField("namespace", false, false);
		validateExtensions(xml.getExtensions());
	}
}
