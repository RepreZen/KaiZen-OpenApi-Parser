package com.reprezen.swaggerparser.val;

import com.google.inject.Inject;

public abstract class ObjectValidatorBase<T> extends ValidatorBase<T> {
    @Inject(optional = true)
    private ImplValidator<T> implValidator;

    public abstract void validateObject(T object, ValidationResults results);

    @Override
    public void validate(T value, ValidationResults results) {
        validateObject(value, results);
        if (implValidator != null) {
            implValidator.validateImpl(value, results);
        }
    }

}
