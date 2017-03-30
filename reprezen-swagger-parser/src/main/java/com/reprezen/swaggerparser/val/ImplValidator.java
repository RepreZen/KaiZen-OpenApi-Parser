package com.reprezen.swaggerparser.val;

public interface ImplValidator<T> {

    void validateImpl(T object, ValidationResults results);
}
