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

import static com.reprezen.kaizen.oasparser.ovl3.SecurityRequirementImpl.F_requirements;
import static com.reprezen.kaizen.oasparser.val.Messages.m;

import java.util.Map;
import java.util.Set;

import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SecurityRequirementValidator extends ObjectValidatorBase<SecurityRequirement> {

	@Override
	public void runObjectValidations() {
		Overlay<Map<String, SecurityParameter>> requirements = validateMapField(F_requirements, false, false,
				SecurityParameter.class, new SecurityParameterValidator());
		checkAllSchemesDefined(requirements);
	}

	public void checkAllSchemesDefined(Overlay<Map<String, SecurityParameter>> requirements) {
		OpenApi3 model = value.getModel();
		Set<String> definedSchemes = model.getSecuritySchemes().keySet();
		MapOverlay<SecurityParameter> mapOverlay = Overlay.getMapOverlay(requirements);
		for (String name : mapOverlay.keySet()) {
			if (!definedSchemes.contains(name)) {
				results.addError(m.msg("UnkSecScheme|Security scheme not defined in model", name),
						Overlay.of(mapOverlay, name));
			}
		}

	}
}
