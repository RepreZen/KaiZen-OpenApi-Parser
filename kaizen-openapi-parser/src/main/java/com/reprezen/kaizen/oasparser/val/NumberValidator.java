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

import com.fasterxml.jackson.databind.node.NumericNode;
import com.reprezen.jsonoverlay.NumberOverlay;

public class NumberValidator extends OverlayValidator<NumberOverlay> {

	@Override
	public void validate(NumberOverlay overlay, ValidationResults results) {
		super.validate(overlay, results, NumericNode.class);
	}

}
