/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.impl3.SwaggerObjectImpl;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.CollectionOverlay;
import com.reprezen.swaggerparser.val.ValidationResults.CrumbState;

public abstract class ObjectValidator<OV extends SwaggerObjectImpl> extends Validator<OV> {

    protected OV object;
    protected ValidationResults results;

    @Override
    public void validate(OV object, ValidationResults results) {
        this.object = object;
        this.results = results;
        OverlayValidator.validator.validate(object, results);
        JsonNode json = object.getJson();
        if (!json.isMissingNode() && !json.isObject()) {
            results.addError(m.msg("NotObject|JSON nodes must be an object node", json.getNodeType()));
        }
    }

    public final void validateString(String name, boolean required) {
        validateField(name, required, StringValidator.validator);
    }

    public final void validateStringList(String name, boolean required) {
        validateField(name, required, StringListValidator.validator);
    }

    public final void validateBoolean(String name, boolean required) {
        validateField(name, required, BooleanValidator.validator);
    }

    public final void validateInteger(String name, boolean required) {
        validateField(name, required, IntegerValidator.validator);
    }

    public final void validateNumber(String name, boolean required) {
        validateField(name, required, NumberValidator.validator);
    }

    public final void validateAnyObject(String name, boolean required) {
        validateField(name, required, AnyObjectValidator.validator);
    }

    public final void validateUnimp(String name, boolean required) {
        // results.addWarning(m.msg("ValidationNotImp|Validation not implemented", name));
    }

    public final <T extends SwaggerObjectImpl, V extends ObjectValidator<T>> void validateField(String name,
            boolean required, Class<T> objectClass, Class<V> validatorClass) {
        try {
            @SuppressWarnings("unchecked")
            T value = (T) getFieldValue(name);
            V validator = getValidator(objectClass, validatorClass, value);
            validateField(name, required, value, validator);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
            results.addError(m.msg("NoValidator|Could not create validator for field", name, e.getLocalizedMessage()));
        }
    }

    public final <T extends JsonOverlay<?>, V extends Validator<T>> void validateListField(String name,
            boolean required, V validatorClass) {
        try {
            @SuppressWarnings("unchecked")
            CollectionOverlay<T> value = (CollectionOverlay<T>) getFieldValue(name);
            ListValidator<T> listValidator = new ListValidator<T>(validatorClass);
            validateField(name, required, value, listValidator);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            results.addError(m.msg("NoValidator|Could not create validator for field", name, e.getLocalizedMessage()));
        }
    }

    public final <T extends SwaggerObjectImpl, V extends ObjectValidator<T>> void validateObjListField(String name,
            boolean required, Class<T> objectClass, Class<V> validatorClass) {
        try {
            @SuppressWarnings("unchecked")
            CollectionOverlay<T> value = (CollectionOverlay<T>) getFieldValue(name);
            ListValidator<T> listValidator = new ListValidator<T>(objectClass, validatorClass);
            validateField(name, required, value, listValidator);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            results.addError(
                    m.msg("NoValidator|Could not create validator for object field", name, e.getLocalizedMessage()));
        }
    }

    public final <T extends SwaggerObjectImpl, V extends ObjectValidator<T>> void validateObjMapField(String name,
            boolean required, Class<T> objectClass, Class<V> validatorClass) {
        try {
            @SuppressWarnings("unchecked")
            CollectionOverlay<T> value = (CollectionOverlay<T>) getFieldValue(name);
            MapValidator<T> mapValidator = new MapValidator<T>(objectClass, validatorClass);
            validateField(name, required, value, mapValidator);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            results.addError(
                    m.msg("NoValidator|Could not create validator for object field", name, e.getLocalizedMessage()));
        }
    }

    private <T extends SwaggerObjectImpl> void validateField(String name, boolean required, T value,
            ObjectValidator<T> validator) {
        try (CrumbState crumbs = results.withCrumb(name)) {
            if ((value == null || value.isMissing()) && required) {
                results.addError(m.msg("MissingField|Field is required"));
            }
            validator.validate(value, results);
        }
    }

    private <T extends JsonOverlay<?>> void validateField(String name, boolean required, CollectionOverlay<T> value,
            ListValidator<T> validator) {
        try (CrumbState crumbs = results.withCrumb(name)) {
            if ((value == null || ((JsonOverlay<?>) value).isMissing()) && required) {
                results.addError(m.msg("MissingField|Field is required"));
            }
            validator.validate(value, results);
        }
    }

    protected final <T extends JsonOverlay<?>> void validateField(String name, boolean required,
            Validator<T> validator) {
        try {
            T value = getFieldValue(name);
            try (CrumbState state = results.withCrumb(name)) {
                validator.validate(value, results);
                if (required && (value == null || value.isMissing())) {
                    results.addError(m.msg("MissingField|Field is required"));
                }
            }
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            results.addError(m.msg("FieldAccess|Failed to retrieve value of field", name, e.getLocalizedMessage()));
        }
    }

    private <T extends JsonOverlay<?>> T getFieldValue(String name)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(name);
        field.setAccessible(true);
        @SuppressWarnings("unchecked")
        T value = (T) field.get(object);
        return value;
    }

    private <V extends ObjectValidator<T>, T extends SwaggerObjectImpl> V getValidator(Class<T> objectClass,
            Class<V> validatorClass, T value)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<V> cons;
        cons = validatorClass.getConstructor(objectClass, ValidationResults.class);
        V validator = cons.newInstance(value, results);
        return validator;
    }
}
