package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;

public abstract class ValidatorBase<T> implements Validator<T> {

    @Override
    public ValidationResults validate(T object) {
        ValidationResults results = new ValidationResults();
        validate(object, results);
        return results;
    }

    @Override
    public void validate(final T object, final ValidationResults results, String crumb) {
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                validate(object, results);
            }
        });
    }

    public void validateString(final String value, final ValidationResults results, final boolean required,
            final String pattern, final String crumb) {
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                checkMissing(required, value, results, crumb);
                if (value != null && !value.matches(pattern)) {
                    results.addError(
                            m.msg("PatternMatchFail|String value does not match required pattern", value, pattern));
                }
            }
        });
    }

    public void validateUrl(final String value, final ValidationResults results, boolean required, String crumb) {
        validateString(value, results, required, null, crumb);
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                checkUrl(value, results);
            }
        });
    }

    public void validateEmail(final String value, final ValidationResults results, boolean required, String crumb) {
        validateString(value, results, required, null, crumb);
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                checkEmail(value, results);
            }
        });
    }

    public <F> void validateField(final F value, final ValidationResults results, final boolean required,
            final String crumb, final Validator<F> validator) {
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                checkMissing(required, value, results, crumb);
                validator.validate(value, results);
            }
        });
    }

    public <V> void validateList(final Collection<? extends V> value, final ValidationResults results,
            final boolean required, final String crumb, final Validator<V> validator) {
        checkMissing(required, value, results, crumb);
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                for (V element : value) {
                    validator.validate(element, results);
                }
            }
        });
    }

    public <V> void validateMap(final Map<String, ? extends V> value, final ValidationResults results,
            final boolean required, final String crumb, final Pattern pattern, final Validator<V> validator) {
        checkMissing(required, value, results, crumb);
        results.withCrumb(crumb, new Runnable() {
            @Override
            public void run() {
                for (Entry<String, ? extends V> entry : value.entrySet()) {
                    checkKey(entry.getKey(), pattern, results);
                    if (validator != null) {
                        validator.validate(entry.getValue(), results, entry.getKey());
                    }
                }
            }
        });
    }

    public void validateExtensions(final Map<String, Object> extensions, final ValidationResults results) {
        validateMap(extensions, results, false, null, null, null);
    }

    private void checkMissing(boolean required, final Object value, final ValidationResults results,
            final String crumb) {
        if (required && isMissing(value)) {
            results.addError(m.msg("MissingField|Required field is missing", crumb));
        }
    }

    private void checkKey(final String key, final Pattern pattern, final ValidationResults results) {
        results.withCrumb(key, new Runnable() {
            @Override
            public void run() {
                if (!pattern.matcher(key).matches()) {
                    results.addError(m.msg("BadKey|Invalid key in map", key, pattern));
                }
            }
        });
    }

    private void checkUrl(String url, ValidationResults results) {
        // TODO implement this
    }

    private void checkEmail(String email, ValidationResults results) {
        // TODO implement this
    }

    private boolean isMissing(Object value) {
        return value instanceof JsonOverlay ? ((JsonOverlay<?>) value).isMissing() : value == null;
    }
}
