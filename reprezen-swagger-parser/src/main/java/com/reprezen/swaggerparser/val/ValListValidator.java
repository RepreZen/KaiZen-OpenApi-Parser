package com.reprezen.swaggerparser.val;

import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;

public class ValListValidator<T extends ValListOverlay<?, T>> extends OverlayValidator<ValListOverlay<?, T>> {

    private Validator<T> elementValidator;

    public ValListValidator(Validator<T> elementValidator) {
        this.elementValidator = elementValidator;
    }

    @Override
    public void validate(ValListOverlay<?, T> overlay, ValidationResults results) {
        int i = 0;
        for (T value : overlay.getStore().getOverlays()) {
            elementValidator.validate(value, results, getElementCrumb(i++));
        }
    }

    protected String getElementCrumb(int index) {
        return "[" + index + "]";
    }
}
