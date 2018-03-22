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

import static com.reprezen.kaizen.oasparser.val.Messages.m;

import com.google.inject.Inject;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class HeaderValidator extends ObjectValidatorBase<Header> {

    @Inject
    private Validator<Schema> schemaValidator;
    @Inject
    private Validator<MediaType> mediaTypeValidator;

    @Override
    public void validateObject(Header header, ValidationResults results) {
        // no validations for: description, deprecated, allowEmptyValue, explode,
        // example, examples
        validateString(header.getName(false), results, false, "name");
        validateString(header.getIn(false), results, false, Regexes.PARAM_IN_REGEX, "in");
        checkPathParam(header, results);
        checkRequired(header, results);
        validateString(header.getStyle(false), results, false, Regexes.STYLE_REGEX, "style");
        checkAllowReserved(header, results);
        // TODO Q: Should schema be required in header object?
        validateField(header.getSchema(false), results, false, "schema", schemaValidator);
        validateMap(header.getContentMediaTypes(false), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateExtensions(header.getExtensions(false), results);
    }

    private void checkPathParam(Header header, ValidationResults results) {
        if (header.getIn(false) != null && header.getIn(false).equals("path") && header.getName(false) != null) {
            String path = getPathString(header);
            if (path != null) {
                if (!path.matches(".*/\\{" + header.getName(false) + "\\}(/.*)?")) {
                    results.addError(m.msg("MissingPathTplt|No template for path parameter in path string",
                            header.getName(false), path), "name");
                }
            } else {
                results.addWarning(m.msg("NoPath|Could not locate path for parameter", header.getName(false),
                        header.getIn(false)));
            }
        }
    }

    private void checkRequired(Header header, ValidationResults results) {
        if ("path".equals(header.getIn(false))) {
            if (header.getRequired(false) != Boolean.TRUE) {
                results.addError(
                        m.msg("PathParamReq|Path param must have 'required' property set true", header.getName(false)),
                        "required");
            }
        }
    }

    private void checkAllowReserved(Header header, ValidationResults results) {
        if (header.isAllowReserved() && !"query".equals(header.getIn(false))) {
            results.addWarning(m.msg("NonQryAllowRsvd|AllowReserved is ignored for non-query parameter",
                    header.getName(false), header.getIn(false)), "allowReserved");
        }
    }

    private String getPathString(Header header) {
        PropertiesOverlay<?> parent = Overlay.getParentPropertiesOverlay(header);
        while (parent != null && !(parent instanceof Path)) {
            parent = Overlay.of(parent).getParentPropertiesOverlay();
        }
        return parent != null && parent instanceof Path ? Overlay.getPathInParent(parent) : null;
    }
}
