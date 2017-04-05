package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val.Messages.m;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.model3.Path;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.SwaggerObject;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class ParameterValidator extends ObjectValidatorBase<Parameter> {

    @Inject
    private Validator<Schema> schemaValidator;
    @Inject
    private Validator<MediaType> mediaTypeValidator;

    @Override
    public void validateObject(Parameter parameter, ValidationResults results) {
        // no validations for: description, deprecated, allowEmptyValue, explode, example, examples
        validateString(parameter.getName(), results, true, "name");
        validateString(parameter.getIn(), results, true, Regexes.PARAM_IN_REGEX, "in");
        checkPathParam(parameter, results);
        checkRequired(parameter, results);
        validateString(parameter.getStyle(), results, false, Regexes.STYLE_REGEX, "style");
        checkAllowReserved(parameter, results);
        // TODO Q: Should schema be required in parameter object?
        validateField(parameter.getSchema(), results, false, "schema", schemaValidator);
        validateMap(parameter.getContentMediaTypes(), results, false, "content", Regexes.NOEXT_REGEX,
                mediaTypeValidator);
        validateExtensions(parameter.getExtensions(), results);
    }

    private void checkPathParam(Parameter parameter, ValidationResults results) {
        if (parameter.getIn() != null && parameter.getIn().equals("path") && parameter.getName() != null) {
            String path = getPathString(parameter);
            if (path != null) {
                if (!path.matches(".*/\\{" + parameter.getName() + "\\}(/.*)?")) {
                    results.addError(m.msg("MissingPathTplt|No template for path parameter in path string",
                            parameter.getName(), path), "name");
                }
            } else {
                results.addWarning(
                        m.msg("NoPath|Could not locate path for parameter", parameter.getName(), parameter.getIn()));
            }
        }
    }

    private void checkRequired(Parameter parameter, ValidationResults results) {
        if ("path".equals(parameter.getIn())) {
            if (parameter.getRequired() != Boolean.TRUE) {
                results.addError(
                        m.msg("PathParamReq|Path param must have 'required' property set true", parameter.getName()),
                        "required");
            }
        }
    }

    private void checkAllowReserved(Parameter parameter, ValidationResults results) {
        if (parameter.isAllowReserved() && !"query".equals(parameter.getIn())) {
            results.addWarning(m.msg("NonQryAllowRsvd|AllowReserved is ignored for non-query parameter",
                    parameter.getName(), parameter.getIn()), "allowReserved");
        }
    }

    private String getPathString(Parameter parameter) {
        SwaggerObject parent = parameter.getParent();
        while (parent != null && !(parent instanceof Path)) {
            parent = parent.getParent();
        }
        return parent instanceof Path ? parent.getKey() : null;
    }
}
