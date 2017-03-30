package com.reprezen.swaggerparser.val;

import com.fasterxml.jackson.databind.node.TextNode;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;

public class StringValidator extends OverlayValidator<StringOverlay> {

    @Override
    public void validate(StringOverlay overlay, ValidationResults results) {
        super.validate(overlay, results, TextNode.class);
    }

}
