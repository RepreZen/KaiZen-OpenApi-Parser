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
import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class ParameterValidator extends ObjectValidatorBase<Parameter> {

    @Inject
    private Validator<Schema> schemaValidator;
    @Inject
    private Validator<MediaType> mediaTypeValidator;

    @Override
    public void validateObject(Parameter parameter, ValidationResults results) {
        // no validations for: description, deprecated, allowEmptyValue, explode,
        // example, examples
        validateString(parameter.getName(false), results, true, "name");
        validateString(parameter.getIn(false), results, true, Regexes.PARAM_IN_REGEX, "in");
        checkPathParam(parameter, results);
        checkRequired(parameter, results);
        validateString(parameter.getStyle(false), results, false, Regexes.STYLE_REGEX, "style");
        checkAllowReserved(parameter, results);
        // TODO Q: Should schema be required in parameter object?
        validateField(parameter.getSchema(false), results, false, "schema", schemaValidator);
        validateMap(parameter.getContentMediaTypes(false), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateExtensions(parameter.getExtensions(false), results);
    }

    private void checkPathParam(Parameter parameter, ValidationResults results) {
        if (parameter.getIn(false) != null && parameter.getIn(false).equals("path")
                && parameter.getName(false) != null) {
            String path = getPathString(parameter);
            if (path != null) {
                if (!path.matches(".*/\\{" + parameter.getName(false) + "\\}(/.*)?")) {
                    results.addError(m.msg("MissingPathTplt|No template for path parameter in path string",
                            parameter.getName(false), path), "name");
                }
            } else {
                results.addWarning(m.msg("NoPath|Could not locate path for parameter", parameter.getName(false),
                        parameter.getIn(false)));
            }
        }
    }

    private void checkRequired(Parameter parameter, ValidationResults results) {
        if ("path".equals(parameter.getIn(false))) {
            if (parameter.getRequired(false) != Boolean.TRUE) {
                results.addError(m.msg("PathParamReq|Path param must have 'required' property set true",
                        parameter.getName(false)), "required");
            }
        }
    }

    private void checkAllowReserved(Parameter parameter, ValidationResults results) {
        if (parameter.isAllowReserved() && !"query".equals(parameter.getIn(false))) {
            results.addWarning(m.msg("NonQryAllowRsvd|AllowReserved is ignored for non-query parameter",
                    parameter.getName(false), parameter.getIn(false)), "allowReserved");
        }
    }

    private String getPathString(Parameter parameter) {
        IPropertiesOverlay<?> parent = parameter.getParentPropertiesObject();
        while (parent != null && !(parent instanceof Path)) {
            parent = parent.getParentPropertiesObject();
        }
        return parent != null && parent instanceof Path ? parent.getPathInParent() : null;
    }
}
