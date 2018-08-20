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

import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_allowEmptyValue;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_contentMediaTypes;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_deprecated;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_example;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_examples;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_explode;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_schema;
import static com.reprezen.kaizen.oasparser.ovl3.HeaderImpl.F_style;
import static com.reprezen.kaizen.oasparser.val.Messages.m;

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class HeaderValidator extends ObjectValidatorBase<Header> {

	@Override
	public void runObjectValidations() {
		Header header = (Header) value.getOverlay();
		validateStringField(F_description, false);
		validateBooleanField(F_deprecated, false);
		validateBooleanField(F_allowEmptyValue, false);
		validateBooleanField(F_explode, false);
		validateField(F_example, false, Example.class, new ExampleValidator());
		validateMapField(F_examples, false, false, Example.class, new ExampleValidator());
		checkPathParam(header, results);
		checkRequired(header, results);
		validateStringField(F_style, false, Regexes.STYLE_REGEX);
		checkAllowReserved(header, results);
		// TODO Q: Should schema be required in header object?
		validateField(F_schema, false, Schema.class, new SchemaValidator());
		validateMapField(F_contentMediaTypes, false, false, MediaType.class, new MediaTypeValidator());
		validateExtensions(header.getExtensions());
	}

	private void checkPathParam(Header header, ValidationResults results) {
		if (header.getIn() != null && header.getIn().equals("path") && header.getName() != null) {
			String path = getPathString(header);
			if (path != null) {
				if (!path.matches(".*/\\{" + header.getName() + "\\}(/.*)?")) {
					results.addError(m.msg("MissingPathTplt|No template for path parameter in path string",
							header.getName(), path), value);
				}
			} else {
				results.addWarning(
						m.msg("NoPath|Could not locate path for parameter", header.getName(), header.getIn()), value);
			}
		}
	}

	private void checkRequired(Header header, ValidationResults results) {
		if ("path".equals(header.getIn())) {
			if (header.getRequired() != Boolean.TRUE) {
				results.addError(
						m.msg("PathParamReq|Path param must have 'required' property set true", header.getName()),
						value);
			}
		}
	}

	private void checkAllowReserved(Header header, ValidationResults results) {
		if (header.isAllowReserved() && !"query".equals(header.getIn())) {
			results.addWarning(m.msg("NonQryAllowRsvd|AllowReserved is ignored for non-query parameter",
					header.getName(), header.getIn()), value);
		}
	}

	private String getPathString(Header header) {
		PropertiesOverlay<?> parent = Overlay.of(header).getParentPropertiesOverlay();
		while (parent != null && !(parent instanceof Path)) {
			parent = Overlay.of(parent).getParentPropertiesOverlay();
		}
		return parent != null && parent instanceof Path ? Overlay.getPathInParent(parent) : null;
	}
}
