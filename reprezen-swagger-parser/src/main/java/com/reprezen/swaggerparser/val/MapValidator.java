package com.reprezen.swaggerparser.val;

import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionOverlay;

public class MapValidator<OV extends JsonOverlay<?>> extends ListValidator<OV> {

    public <T extends SwaggerObjectImpl, V extends ObjectValidator<T>> MapValidator(Class<T> objectClass,
            Class<V> objectValidatorClass) {
        super(objectClass, objectValidatorClass);
    }

    public MapValidator(Validator<OV> validator) {
        super(validator);
    }

    @Override
    public void validate(CollectionOverlay<OV> object, ValidationResults results) {
        super.validate(object, results);
    }

    @Override
    protected String getElementCrumb(int index, OV overlay) {
        return "[" + overlay.getKey() + "]";
    }

}
