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
package com.reprezen.kaizen.oasparser.old.val;

import java.util.IdentityHashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.reprezen.jsonoverlay.PropertiesOverlay;

public abstract class ObjectValidatorBase<T> extends ValidatorBase<T> {
	@Inject(optional = true)
	private ImplValidator<T> implValidator;

	public abstract void validateObject(T object, ValidationResults results);

	protected static ThreadLocal<ValidationVisits> validationVisits = new ThreadLocal<ValidationVisits>();

	protected static boolean visit(Object obj) {
		if (validationVisits.get() == null) {
			validationVisits.set(new ValidationVisits());
		}
		return validationVisits.get().visit(obj);
	}

	@Override
	public void validate(T value, ValidationResults results) {
		if (visit(value)) {
			@SuppressWarnings("unchecked")
			PropertiesOverlay<T> propValue = (PropertiesOverlay<T>) value;
			if (propValue._isElaborated()) {
				validateObject(value, results);
				if (implValidator != null) {
					implValidator.validateImpl(value, results);
				}
			}
		}
	}

	protected static class ValidationVisits {
		private Map<Object, Object> visits = new IdentityHashMap<Object, Object>();

		public boolean visit(Object obj) {
			if (visits.containsKey(obj)) {
				return false;
			} else {
				visits.put(obj, obj);
				return true;
			}
		}
	}
}
