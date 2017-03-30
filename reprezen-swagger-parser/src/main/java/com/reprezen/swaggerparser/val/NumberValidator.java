package com.reprezen.swaggerparser.val;

import com.fasterxml.jackson.databind.node.NumericNode;
import com.reprezen.swaggerparser.jsonoverlay.std.NumberOverlay;

public class NumberValidator extends OverlayValidator<NumberOverlay> {

    @Override
    public void validate(NumberOverlay overlay, ValidationResults results) {
        super.validate(overlay, results, NumericNode.class);
    }

}
