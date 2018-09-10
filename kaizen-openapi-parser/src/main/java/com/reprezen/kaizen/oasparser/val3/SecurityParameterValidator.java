package com.reprezen.kaizen.oasparser.val3;

import static com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl.F_parameters;

import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SecurityParameterValidator extends ObjectValidatorBase<SecurityParameter> {

    @Override
    public void runObjectValidations() {
        validateListField(F_parameters, false, false, String.class, null);
    }

    @Override
    protected Collection<Class<? extends JsonNode>> getAllowedJsonTypes(Overlay<?> value) {
        // SecurityParameter is the odd case of a ParametersOverlay that is not formed
        // from an object. It's the value type of the security requirement map, and that
        // value comes in the form of a JSON array. The SecurityParameter type exposes
        // that type as a list valued property named "parameters". There's no object
        // containing that property.Hence we need to specify the expected JsonNode type
        return Arrays.asList(ArrayNode.class);
    }

}
