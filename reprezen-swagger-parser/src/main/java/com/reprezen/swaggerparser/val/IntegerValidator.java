package com.reprezen.swaggerparser.val;

import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.google.common.collect.Sets;
import com.reprezen.swaggerparser.jsonoverlay.std.IntegerOverlay;

public class IntegerValidator extends OverlayValidator<IntegerOverlay> {

    @SuppressWarnings("unchecked")
    private static Set<Class<? extends JsonNode>> intTypes = Sets.<Class<? extends JsonNode>> newHashSet( //
            IntNode.class, ShortNode.class, BigIntegerNode.class);

    @Override
    public void validate(IntegerOverlay overlay, ValidationResults results) {
        super.validate(overlay, results, intTypes);
    }
}
