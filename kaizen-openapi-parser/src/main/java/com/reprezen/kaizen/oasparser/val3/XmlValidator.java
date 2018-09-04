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

import static com.reprezen.kaizen.oasparser.ovl3.XmlImpl.F_attribute;
import static com.reprezen.kaizen.oasparser.ovl3.XmlImpl.F_name;
import static com.reprezen.kaizen.oasparser.ovl3.XmlImpl.F_namespace;
import static com.reprezen.kaizen.oasparser.ovl3.XmlImpl.F_prefix;

import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.ovl3.XmlImpl;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class XmlValidator extends ObjectValidatorBase<Xml> {

	@Override
	public void runObjectValidations() {
		Xml xml = (Xml) value.getOverlay();
		validateStringField(F_name, false);
		validateStringField(F_prefix, false);
		validateBooleanField(F_attribute, false);
		validateBooleanField(XmlImpl.F_wrapped, false);
		validateUrlField(F_namespace, false, true, false);
		validateExtensions(xml.getExtensions());
	}
}
