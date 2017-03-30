package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.Reference;

public class OverlayValidator extends Validator<JsonOverlay<?>> {

    public static OverlayValidator validator = new OverlayValidator();

    @Override
    public void validate(JsonOverlay<?> object, ValidationResults results) {
        checkReference(object, results);
    }

    private void checkReference(JsonOverlay<?> object, ValidationResults results) {
        if (object.isReference()) {
            Reference ref = object.getReference();
            if (ref.isInvalid()) {
                results.addError(
                        m.msg("BadRef|JSON reference node was not resolved", ref.getRefString(), ref.getErrorReason()));
            }
        }
    }

}
