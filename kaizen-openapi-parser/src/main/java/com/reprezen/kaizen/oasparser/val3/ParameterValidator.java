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

import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_allowEmptyValue;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_contentMediaTypes;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_deprecated;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_example;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_examples;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_explode;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_in;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_name;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_schema;
import static com.reprezen.kaizen.oasparser.ovl3.ParameterImpl.F_style;
import static com.reprezen.kaizen.oasparser.val.Messages.m;

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class ParameterValidator extends ObjectValidatorBase<Parameter> {

	@Override
	public void runObjectValidations() {
		Parameter parameter = (Parameter) value.getOverlay();
		validateStringField(F_description, false);
		validateBooleanField(F_deprecated, false);
		validateBooleanField(F_allowEmptyValue, false);
		validateBooleanField(F_explode, false);
		validateField(F_example, false, Example.class, new ExampleValidator());
		validateMapField(F_examples, false, false, Example.class, new ExampleValidator());
		validateStringField(F_name, true);
		validateStringField(F_in, true, Regexes.PARAM_IN_REGEX);
		checkPathParam(parameter);
		checkRequired(parameter);
		validateStringField(F_style, false, Regexes.STYLE_REGEX);
		checkAllowReserved(parameter);
		// TODO Q: Should schema be required in parameter object?
		validateField(F_schema, false, Schema.class, new SchemaValidator());
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateExtensions(parameter.getExtensions());
	}

	private void checkPathParam(Parameter parameter) {
		if (parameter.getIn() != null && parameter.getIn().equals("path") && parameter.getName() != null) {
			String path = getPathString(parameter);
			if (path != null) {
				if (!path.matches(".*/\\{" + parameter.getName() + "\\}(/.*)?")) {
					results.addError(m.msg("MissingPathTplt|No template for path parameter in path string",
							parameter.getName(), path), value);
				}
			} else {
				results.addWarning(
						m.msg("NoPath|Could not locate path for parameter", parameter.getName(), parameter.getIn()),
						value);
			}
		}
	}

	private void checkRequired(Parameter parameter) {
		if ("path".equals(parameter.getIn())) {
			if (parameter.getRequired() != Boolean.TRUE) {
				results.addError(
						m.msg("PathParamReq|Path param must have 'required' property set true", parameter.getName()),
						value);
			}
		}
	}

	private void checkAllowReserved(Parameter parameter) {
		if (parameter.isAllowReserved() && !"query".equals(parameter.getIn())) {
			results.addWarning(m.msg("NonQryAllowRsvd|AllowReserved is ignored for non-query parameter",
					parameter.getName(), parameter.getIn()), value);
		}
	}

	private String getPathString(Parameter parameter) {
		PropertiesOverlay<?> parent = Overlay.of(parameter).getParentPropertiesOverlay();
		while (parent != null && !(parent instanceof Path)) {
			parent = Overlay.of(parent).getParentPropertiesOverlay();
		}
		return parent != null && parent instanceof Path ? Overlay.getPathInParent(parent) : null;
	}
}
