/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.kaizen.oasparser.val;

import static com.reprezen.kaizen.oasparser.val.Messages.m;
import static com.reprezen.kaizen.oasparser.val.NumericUtils.le;
import static com.reprezen.kaizen.oasparser.val.NumericUtils.lt;
import static com.reprezen.kaizen.oasparser.val.NumericUtils.zero;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.print.attribute.standard.Severity;

import com.google.common.collect.Sets;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.val.oasparser.fake.scheme.Handler;

public abstract class ValidatorBase<T> implements Validator<T> {

	@Override
	public void validate(T object, ValidationResults results) {
		// TODO Auto-generated method stub

	}

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
			final String crumb) {
		validateString(value, results, required, (Pattern) null, crumb, null);
	}

	public void validateString(final String value, final ValidationResults results, final boolean required,
			final String pattern, final String crumb) {
		validateString(value, results, required, Pattern.compile(pattern), crumb, null);
	}

	public <V> void validateString(final String value, final ValidationResults results, final boolean required,
			final String pattern, final String crumb, PropertiesOverlay<V> overlay) {
		validateString(value, results, required, Pattern.compile(pattern), crumb, overlay);
	}

	public void validateString(final String value, final ValidationResults results, final boolean required,
			final Pattern pattern, final String crumb) {
		validateString(value, results, required, pattern, crumb, null);
	}

	public <V> void validateString(final String value, final ValidationResults results, final boolean required,
			final Pattern pattern, final String crumb, PropertiesOverlay<V> overlay) {
		checkMissing(required, value, results, crumb);
		if (value != null && pattern != null && !pattern.matcher(value).matches()) {
			results.addError(m.msg("PatternMatchFail|String value does not match required pattern", value, pattern),
					crumb, Overlay.of(overlay, crumb, StringOverlay.class));
		}
	}

	public void validateUrl(String value, ValidationResults results, boolean required, String crumb) {
		validateUrl(value, results, required, crumb, false);
	}

	public void validateUrl(String value, ValidationResults results, boolean required, String crumb,
			boolean allowVars) {
		validateUrl(value, results, required, crumb, allowVars, Severity.ERROR);
	}

	public void validateUrl(final String value, final ValidationResults results, boolean required, String crumb,
			final boolean allowVars, final Severity severity) {
		validateString(value, results, required, crumb);
		if (value != null) {
			checkUrl(value, results, allowVars, severity, crumb);
		}
	}

	public void validateEmail(final String value, final ValidationResults results, boolean required, String crumb) {
		validateString(value, results, required, crumb);
		if (value != null) {
			checkEmail(value, results, crumb);
		}
	}

	public <N extends Number> void validatePositive(final N value, final ValidationResults results,
			final boolean required, final String crumb) {
		checkMissing(required, value, results, crumb);
		if (value != null && le(value, zero(value))) {
			results.addError(m.msg("ReqPositive|Value must be strictly positive", crumb, value), crumb);
		}
	}

	public <N extends Number> void validateNonNegative(final N value, final ValidationResults results,
			final boolean required, final String crumb) {
		checkMissing(required, value, results, crumb);
		if (value != null && lt(value, zero(value))) {
			results.addError(m.msg("ReqPositive|Value must be strictly positive", crumb, value), crumb);
		}
	}

	public void validateNonEmpty(Collection<?> values, boolean hasValues, ValidationResults results, String crumb) {
		if (hasValues && values.isEmpty()) {
			results.addError(m.msg("EmptyColl|Collection may not be empty"), crumb);
		}
	}

	public <V> void validateUnique(final Collection<V> values, final ValidationResults results, final String crumb) {
		results.withCrumb(crumb, new Runnable() {
			Set<V> seen = Sets.newHashSet();

			@Override
			public void run() {
				int i = 0;
				for (V value : values) {
					if (seen.contains(value)) {
						results.addError(m.msg("DuplicateValue|Value appeared already", value, crumb), "[" + i + "]");
					} else {
						seen.add(value);
					}
					i += 1;
				}
			}
		});
	}

	public void validatePattern(final String pattern, final ValidationResults results, final boolean required,
			final String crumb) {
		checkMissing(required, pattern, results, crumb);
		if (pattern != null) {
			try {
				Pattern.compile(pattern);
			} catch (PatternSyntaxException e) {
				results.addWarning(
						m.msg("BadPattern|Pattern is not a valid Java Regular Expression but may be valid ECMA 262",
								pattern),
						crumb);
			}
		}
	}

	public <F> void validateField(final F value, final ValidationResults results, final boolean required,
			final String crumb, final Validator<F> validator) {
		checkMissing(required, value, results, crumb);
		if (isPresent(value)) {
			validator.validate(value, results, crumb);
		}
	}

	public <V> void validateList(final Collection<? extends V> value, final boolean isPresent,
			final ValidationResults results, final boolean required, final String crumb, final Validator<V> validator) {
		if (required && !isPresent) {
			results.addError(m.msg("MissingField|Required field is missing", crumb), crumb);
		}
		if (isPresent && validator != null) {
			int i = 0;
			for (V element : value) {
				validator.validate(element, results, "[" + i++ + "]");
			}
		}
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
		validateExtensions(extensions, results, null);
	}

	public void validateExtensions(final Map<String, Object> extensions, final ValidationResults results,
			String crumb) {
		validateMap(extensions, results, false, crumb, null, null);
	}
	
    public void validateExample(final Object example, final ValidationResults results) {
        //
    }

    public void validateDescription(String description, ValidationResults results) {
       validateString(description, results, false, "description");
    }
    
    public void validateSummary(String summary, ValidationResults results) {
        if (summary != null && summary.length() > 120) {
            // Why 120? Why not 160? I didn't find it in the spec
            results.addWarning(m.msg("LongSummary|Sumamry exceeds recommended limit of 120 chars"), "summary");
        }
    }
    
	public void validateFormat(String format, String type, ValidationResults results, String crumb) {
		if (format != null && type != null) {
			String normalType = null;
			switch (format) {
			case "int32":
			case "int64":
				normalType = "integer";
				break;
			case "float":
			case "double":
				normalType = "number";
				break;
			case "byte":
			case "binary":
			case "date":
			case "date-time":
			case "password":
				normalType = "string";
				break;
			}
			if (normalType != null && !type.equals(normalType)) {
				results.addWarning(m.msg("WrongTypeFormat|OpenAPI-defined format used with nonstandard type", format,
						type, normalType), crumb);
			}
		}
	}

	public void validateDefault(Object defaultValue, String type, ValidationResults results, String crumb) {
		if (defaultValue != null && type != null) {
			boolean ok = false;
			switch (type) {
			case "string":
				ok = defaultValue instanceof String;
				break;
			case "number":
				ok = NumericUtils.isNumeric(defaultValue);
				break;
			case "integer":
				ok = NumericUtils.isIntegral(defaultValue);
				break;
			case "boolean":
				ok = defaultValue instanceof Boolean;
				break;
			case "object":
				ok = defaultValue instanceof Map<?, ?>;
				break;
			case "array":
				ok = defaultValue instanceof Collection<?>;
				break;
			}
			if (!ok) {
				results.addError(m.msg("WrongTypeValue|Value is incompatible with schema type", type, defaultValue),
						crumb);
			}
		}
	}

	private void checkMissing(boolean required, final Object value, final ValidationResults results,
			final String crumb) {
		if (required && !isPresent(value)) {
			results.addError(m.msg("MissingField|Required field is missing", crumb), crumb);
		}
	}

	private void checkKey(final String key, final Pattern pattern, final ValidationResults results) {
		if (pattern != null && !pattern.matcher(key).matches()) {
			results.addError(m.msg("BadKey|Invalid key in map", key, pattern), key);
		}
	}

	public static final String SPECIAL_SCHEME = Handler.class.getPackage().getName()
			.substring(ValidatorBase.class.getPackage().getName().length() + 1);
	private static boolean specialSchemeInited = false;

	private void checkUrl(String url, ValidationResults results, boolean allowVars, Severity severity, String crumb) {
		// TODO Q: Any help from spec in being able to validate URLs with vars? E.g is
		// our treatment here valid? We
		// assume vars can only appear where simple text can appear, so handling vars
		// means relacing {.*} with "1" and
		// testing for URL validity. We use a digit instead of a letter because it
		// covers vars in the port, and
		// elsewhere digits are always allowed where letters are.
		String origUrl = url;
		if (allowVars) {
			url = url.replaceAll("\\{[^}]+\\}", "1");
			if (url.startsWith("1:")) {
				// "1" is not a valid scheme name, so we need to replace it with special scheme,
				// for which we provide a
				// do-nothing protocol handler implementation
				url = SPECIAL_SCHEME + url.substring(1);
				if (!specialSchemeInited) {
					// register protocol handler for special scheme
					initSpecialScheme();
				}
			}
		}
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			results.addError(m.msg("BadUrl|Invalid URL", origUrl, e.toString()), crumb);
		}
	}

	private void initSpecialScheme() {
		String prop = "java.protocol.handler.pkgs";
		String former = System.getProperty(prop);
		try {
			System.setProperty(prop, ValidatorBase.class.getPackage().getName());
			new URL(SPECIAL_SCHEME + ":");
		} catch (MalformedURLException e) {
		} finally {
			if (former != null) {
				System.setProperty(prop, former);
			} else {
				System.getProperties().remove(prop);
			}
		}
		specialSchemeInited = true;
	}

	private void checkEmail(String email, ValidationResults results, String crumb) {
		try {
			InternetAddress addr = new InternetAddress();
			addr.setAddress(email);
			addr.validate();
		} catch (AddressException e) {
			results.addError(m.msg("BadEmail|Invalid email address", email, e.toString()), crumb);
		}
	}

	private boolean isPresent(Object value) {
		return value instanceof JsonOverlay ? Overlay.isPresent((JsonOverlay<?>) value) : value != null;
	}

}
