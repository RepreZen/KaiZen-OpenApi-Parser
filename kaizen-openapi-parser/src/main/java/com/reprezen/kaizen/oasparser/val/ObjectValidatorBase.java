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
package com.reprezen.kaizen.oasparser.val;

import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.jsonoverlay.IPropertiesOverlay;

public abstract class ObjectValidatorBase<T> extends ValidatorBase<T> {
	@Inject(optional = true)
	private ImplValidator<T> implValidator;

	public abstract void validateObject(T object, ValidationResults results);

	@Override
	public void validate(T value, ValidationResults results) {
		@SuppressWarnings("unchecked")
		IPropertiesOverlay<T> propValue = (IPropertiesOverlay<T>) value;
		if (propValue.isElaborated()) {
			validateObject(value, results);
			if (implValidator != null) {
				implValidator.validateImpl(value, results);
			}
		}
	}

}
