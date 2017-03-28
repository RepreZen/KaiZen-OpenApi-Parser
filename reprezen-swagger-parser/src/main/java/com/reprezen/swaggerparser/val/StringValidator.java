package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;

public class StringValidator extends Validator<StringOverlay> {

    public static StringValidator validator = new StringValidator();

    @Override
    public void validate(StringOverlay overlay, ValidationResults results) {
        JsonNode json = overlay.getJson();
        if (!json.isMissingNode() && !json.isTextual()) {
            results.addError(m.msg("NotString|Value must be string", json.getNodeType()));
        }
    }

    @Override
    public Map<? extends Validator<?>, String> getBeforeValidators() {
        return ImmutableMap.of(OverlayValidator.validator, NO_CRUMB);
    }
}
