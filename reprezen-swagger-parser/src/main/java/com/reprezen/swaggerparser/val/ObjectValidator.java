package com.reprezen.swaggerparser.val;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class ObjectValidator<T> extends OverlayValidator<T> {

    @Override
    public void validate(T overlay, ValidationResults results) {
        super.validate(overlay, results, ObjectNode.class);
    }
}