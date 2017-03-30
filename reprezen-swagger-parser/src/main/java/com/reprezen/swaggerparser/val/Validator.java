package com.reprezen.swaggerparser.val;

public interface Validator<T> {

    ValidationResults validate(T object);

    void validate(T object, ValidationResults results);

    void validate(T object, ValidationResults results, String crumb);

}