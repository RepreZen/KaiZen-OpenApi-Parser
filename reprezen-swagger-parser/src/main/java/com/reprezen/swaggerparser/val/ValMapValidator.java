package com.reprezen.swaggerparser.val;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;

public class ValMapValidator<T extends JsonOverlay<?>> extends OverlayValidator<ValMapOverlay<?, T>> {

    private Validator<T> elementValidator;

    public ValMapValidator(Validator<T> elementValidator) {
        this.elementValidator = elementValidator;
    }

    @Override
    public void validate(ValMapOverlay<?, T> overlay, ValidationResults results) {
        super.validate(overlay, results, ObjectNode.class);
        for (T value : overlay.getStore().getOverlays()) {
            elementValidator.validate(value, results, value.getKey());
        }
    }
}
