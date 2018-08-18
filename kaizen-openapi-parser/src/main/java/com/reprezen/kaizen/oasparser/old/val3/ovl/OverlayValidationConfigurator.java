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
package com.reprezen.kaizen.oasparser.old.val3.ovl;

import com.google.inject.TypeLiteral;
import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.old.val.ImplValidator;
import com.reprezen.kaizen.oasparser.old.val3.ValidationConfigurator;

public class OverlayValidationConfigurator extends ValidationConfigurator {

    @Override
    protected void configureImplValidators() {
	bind(new TypeLiteral<ImplValidator<OpenApi3>>() {
	}).to(Swagger3OverlayValidator.class);
	bind(new TypeLiteral<ImplValidator<Info>>() {
	}).to(InfoOverlayValidator.class);
	bind(new TypeLiteral<ImplValidator<Contact>>() {
	}).to(ContactOverlayValidator.class);
    }
}
