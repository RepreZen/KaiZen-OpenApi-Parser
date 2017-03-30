package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.reprezen.swaggerparser.jsonoverlay.std.NumberOverlay;

public class NumberValidator extends Validator<NumberOverlay> {

    public static NumberValidator validator = new NumberValidator();

    @Override
    public void validate(NumberOverlay overlay, ValidationResults results) {
        JsonNode json = overlay.getJson();
        if (!json.isMissingNode() && !json.isNumber()) {
            results.addError(m.msg("NotNumber|Value must be a number", json.getNodeType()));
        }
    }

    @Override
    public Map<? extends Validator<?>, String> getBeforeValidators() {
        return ImmutableMap.of(OverlayValidator.validator, NO_CRUMB);
    }
}
