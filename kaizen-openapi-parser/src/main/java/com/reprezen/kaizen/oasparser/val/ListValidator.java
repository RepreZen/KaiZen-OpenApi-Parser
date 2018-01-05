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

import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;

public class ListValidator<T extends ListOverlay<T>> extends OverlayValidator<ListOverlay<T>> {

	Validator<T> elementValidator;

	public ListValidator(Validator<T> elementeValidator) {
		this.elementValidator = elementeValidator;
	}

	@Override
	public void validate(ListOverlay<T> overlay, ValidationResults results) {
		int i = 0;
		for (T value : overlay.get()) {
			elementValidator.validate(value, results, getElementCrumb(i++));
		}
	}

	protected String getElementCrumb(int index) {
		return "[" + index + "]";
	}
}
