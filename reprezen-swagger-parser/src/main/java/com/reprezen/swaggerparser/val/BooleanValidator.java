package com.reprezen.swaggerparser.val;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.reprezen.swaggerparser.jsonoverlay.std.BooleanOverlay;

public class BooleanValidator extends OverlayValidator<BooleanOverlay> {

    @Override
    public void validate(BooleanOverlay overlay, ValidationResults results) {
        super.validate(overlay, results, BooleanNode.class);
    }
}
