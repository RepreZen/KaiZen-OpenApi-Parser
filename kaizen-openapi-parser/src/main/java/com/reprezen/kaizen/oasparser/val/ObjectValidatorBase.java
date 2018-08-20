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

import java.util.IdentityHashMap;
import java.util.Map;

public abstract class ObjectValidatorBase<V> extends ValidatorBase<V> {

	@Override
	public void runValidations() {
		if (value.isElaborated() && visit(value)) {
			runObjectValidations();
		}
	}

	public abstract void runObjectValidations();

	protected static ThreadLocal<ValidationVisits> validationVisits = new ThreadLocal<ValidationVisits>();

	protected static boolean visit(Object obj) {
		if (validationVisits.get() == null) {
			validationVisits.set(new ValidationVisits());
		}
		return validationVisits.get().visit(obj);
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
