package com.reprezen.swaggerparser.val;

import java.util.Collections;
import java.util.Map;

import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.val.ValidationResults.CrumbState;

public abstract class Validator<T extends JsonOverlay<?>> {

    protected static String NO_CRUMB = "";

    public void runValidations(Object object, ValidationResults results) {
        Map<? extends Validator<?>, String> beforeValidators = getBeforeValidators();
        for (Validator<?> validator : beforeValidators.keySet()) {
            String crumb = beforeValidators.get(validator);
            try (CrumbState state = results.withCrumb(crumb)) {
                validator.runValidations(object, results);
            }
        }
        @SuppressWarnings("unchecked")
        T t = (T) object;
        validate(t, results);
    }

    public abstract void validate(T object, ValidationResults results);

    public Map<? extends Validator<?>, String> getBeforeValidators() {
        return Collections.emptyMap();
    }
}
