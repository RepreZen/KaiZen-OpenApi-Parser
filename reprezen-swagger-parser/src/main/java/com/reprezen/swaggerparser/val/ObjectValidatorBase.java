package com.reprezen.swaggerparser.val;

import com.google.inject.Inject;

public abstract class ObjectValidatorBase<T> extends ValidatorBase<T> {
    @Inject
    private ImplValidator<T> implValidator;

    public abstract void validateModel(T info, ValidationResults results);

    @Override
    public void validate(T value, ValidationResults results) {
        validateModel(value, results);
        implValidator.validateImpl(value, results);
    }

}
