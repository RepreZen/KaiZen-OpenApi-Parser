package com.reprezen.swaggerparser.val;

import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;

public class ListValidator<T extends ListOverlay<T>> extends OverlayValidator<ListOverlay<T>> {

    Validator<T> elementValidator;

    public ListValidator(Validator<T> elementeValidator) {
        this.elementValidator = elementeValidator;
    }

    @Override
    public void validate(ListOverlay<T> overlay, ValidationResults results) {
        int i = 0;
        for (T value : overlay.getStore().getOverlays()) {
            elementValidator.validate(value, results, getElementCrumb(i++));
        }
    }

    protected String getElementCrumb(int index) {
        return "[" + index + "]";
    }
}
