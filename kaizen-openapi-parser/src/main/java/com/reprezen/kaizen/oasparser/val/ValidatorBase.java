package com.reprezen.kaizen.oasparser.val;

import static com.reprezen.kaizen.oasparser.val.Messages.m;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.val.oasparser.fake.scheme.Handler;

public abstract class ValidatorBase<V> implements Validator<V> {
	protected Overlay<V> value;
	protected ValidationResults results;

	@Override
	public final void validate(Overlay<V> value) {
		this.value = value;
		this.results = ValidationResults.get();
		JsonTypeChecker.checkJsonType(value, results);
		runValidations();
	}

	public abstract void runValidations();

	public Overlay<Boolean> validateBooleanField(String name, boolean required) {
		return validateField(name, required, Boolean.class, null);
	}

	public Overlay<String> validateStringField(String name, boolean required) {
		return validateStringField(name, required, (Pattern) null);
	}

	public Overlay<String> validateStringField(String name, boolean required, String pattern) {
		return validateStringField(name, required, Pattern.compile(pattern));
	}

	@SafeVarargs
	public final Overlay<String> validateStringField(String name, boolean required, Pattern pattern,
			Consumer<Overlay<String>>... otherChecks) {
		Overlay<String> field = validateField(name, required, String.class, null);
		checkMissing(field, required);
		if (field != null && field.isPresent()) {
			if (pattern != null) {
				checkPattern(field, pattern);
			}
			for (Consumer<Overlay<String>> otherCheck : otherChecks) {
				otherCheck.accept(field);
			}
		}
		return field;
	}

	void checkPattern(Overlay<String> field, Pattern pattern) {
		if (!pattern.matcher(field.get()).matches()) {
			results.addError(
					m.msg("PatternMatchFail|String value does not match required pattern", field.get(), pattern),
					field);
		}
	}

	public Overlay<String> validatePatternField(String name, boolean required) {
		return validateStringField(name, required, null, this::checkRegex);
	}

	private void checkRegex(Overlay<String> field) {
		String regex = field.get();
		try {
			Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			results.addWarning(
					m.msg("BadPattern|Pattern is not a valid Java Regular Expression but may be valid ECMA 262", regex),
					field);
		}
	}

	public Overlay<String> validateUrlField(String name, boolean required, boolean allowVars) {
		return validateUrlField(name, required, allowVars, (Pattern) null);
	}

	public Overlay<String> validateUrlField(String name, boolean required, boolean allowVars, String pattern) {
		return validateUrlField(name, required, allowVars, Pattern.compile(pattern));
	}

	public Overlay<String> validateUrlField(String name, boolean required, boolean allowVars, Pattern pattern) {
		return validateStringField(name, required, pattern, field -> checkUrl(field, allowVars));
	}

	public static final String SPECIAL_SCHEME = Handler.class.getPackage().getName()
			.substring(ValidatorBase.class.getPackage().getName().length() + 1);
	private static boolean specialSchemeInited = false;

	private void checkUrl(Overlay<String> overlay, boolean allowVars) {
		// TODO Q: Any help from spec in being able to validate URLs with vars? E.g is
		// our treatment here valid? We assume vars can only appear where simple text
		// can appear, so handling vars means relacing {.*} with "1" and testing for URL
		// validity. We use a digit instead of a letter because it covers vars in the
		// port, and elsewhere digits are always allowed where letters are.
		String origUrl = overlay.get();
		String url = origUrl;
		if (allowVars) {
			url = url.replaceAll("\\{[^}]+\\}", "1");
			if (url.startsWith("1:")) {
				// "1" is not a valid scheme name, so we need to replace it with special scheme,
				// for which we provide a do-nothing protocol handler implementation
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
			results.addError(m.msg("BadUrl|Invalid URL", origUrl, e.toString()), overlay);
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

	public Overlay<String> validateEmailField(String name, boolean required) {
		return validateEmailField(name, required, (Pattern) null);
	}

	public Overlay<String> validateUrlField(String name, boolean required, String pattern) {
		return validateEmailField(name, required, Pattern.compile(pattern));
	}

	public Overlay<String> validateEmailField(String name, boolean required, Pattern pattern) {
		return validateStringField(name, required, pattern, this::checkEmail);
	}

	private void checkEmail(Overlay<String> overlay) {
		String email = overlay.get();
		try {
			InternetAddress addr = new InternetAddress();
			addr.setAddress(email);
			addr.validate();
		} catch (AddressException e) {
			results.addError(m.msg("BadEmail|Invalid email address", email, e.toString()), overlay);
		}
	}

	public Overlay<Number> validatePositiveField(String name, boolean required) {
		return validateNumericField(name, required, NumericUtils::isPositive, "be positive");
	}

	public Overlay<Number> validateNonNegativeField(String name, boolean required) {
		return validateNumericField(name, required, NumericUtils::isNonNegative, "not be positive");
	}

	public Overlay<Number> validateNumericField(String name, boolean required, Function<Number, Boolean> test,
			String desc) {
		Overlay<Number> field = validateField(name, required, Number.class, null);
		checkMissing(field, required);
		if (field != null && field.isPresent() && test != null) {
			Number n = field.get();
			if (!test.apply(n)) {
				results.addError(m.msg("ReqPositive|Value must be " + desc, n), field);
			}
		}
		return field;
	}

	@SafeVarargs
	public final <F> Overlay<F> validateField(String name, boolean required, Class<F> fieldClass,
			Validator<F> validator, Consumer<Overlay<F>>... otherChecks) {
		@SuppressWarnings("unchecked")
		PropertiesOverlay<V> propValue = (PropertiesOverlay<V>) value.get();
		Overlay<F> field = Overlay.of(propValue, name, fieldClass);
		JsonTypeChecker.checkJsonType(field, results);
		checkMissing(field, required);
		if (value != null && value.isPresent() && validator != null) {
			validator.validate(field);
			for (Consumer<Overlay<F>> otherCheck : otherChecks) {
				otherCheck.accept(field);
			}
		}
		return field;
	}

	public <X> Overlay<List<X>> validateListField(String name, boolean nonEmpty, boolean unique, Class<X> itemClass,
			Validator<X> itemValidator) {
		@SuppressWarnings("unchecked")
		Overlay<List<X>> list = (Overlay<List<X>>) (Object) Overlay.of((PropertiesOverlay<V>) value.get(), name,
				List.class);
		validateList(list, nonEmpty, unique, itemValidator);
		return list;
	}

	private <X> void validateList(Overlay<List<X>> list, boolean nonEmpty, boolean unique, Validator<X> itemValidator) {
		new ListValidator<X>(itemValidator).validate(list);
		checkListNotEmpty(list, nonEmpty);
		checkListUnique(list, unique);
	}

	private <X> void checkListNotEmpty(Overlay<List<X>> list, boolean nonEmpty) {
		if (nonEmpty) {
			ListOverlay<X> listOverlay = Overlay.getListOverlay(list);
			if (list != null && !list.isPresent()) {
				if (nonEmpty && listOverlay.size() == 0) {
					results.addError(m.msg("EmptyList|List may not be empty"), list);
				}
			}
		}
	}

	private <X> void checkListUnique(Overlay<List<X>> list, boolean unique) {
		if (unique) {
			ListOverlay<X> listOverlay = Overlay.getListOverlay(list);
			Set<X> seen = new HashSet<>();
			for (int i = 0; i < listOverlay.size(); i++) {
				X item = listOverlay.get(i);
				if (seen.contains(item)) {
					results.addError(m.msg("DuplicateValue|Value appeared already", item, i),
							Overlay.of(listOverlay, i));
				} else {
					seen.add(item);
				}
			}
		}
	}

	public <X> Overlay<Map<String, X>> validateMapField(String name, boolean nonEmpty, boolean unique,
			Class<X> valueClass, Validator<X> valueValidator) {
		@SuppressWarnings("unchecked")
		Overlay<Map<String, X>> map = (Overlay<Map<String, X>>) (Object) Overlay.of((PropertiesOverlay<V>) value.get(),
				name, Map.class);
		validateMap(map, nonEmpty, unique, valueValidator);
		return map;
	}

	private <X> void validateMap(Overlay<Map<String, X>> map, boolean nonEmpty, boolean unique,
			Validator<X> valueValidator) {
		new MapValidator<X>(valueValidator).validate(map);
		checkMapNotEmpty(map, nonEmpty);
		checkMapUnique(map, unique);
	}

	private <X> void checkMapNotEmpty(Overlay<Map<String, X>> list, boolean nonEmpty) {
		if (nonEmpty) {
			MapOverlay<X> mapOverlay = Overlay.getMapOverlay(list);
			if (list != null && !list.isPresent()) {
				if (nonEmpty && mapOverlay.size() == 0) {
					results.addError(m.msg("EmptyList|List may not be empty"), list);
				}
			}
		}
	}

	private <X> void checkMapUnique(Overlay<Map<String, X>> map, boolean unique) {
		if (unique) {
			MapOverlay<X> mapOverlay = Overlay.getMapOverlay(map);
			Set<X> seen = new HashSet<>();
			for (String key : mapOverlay.keySet()) {
				X value = mapOverlay.get(key);
				if (seen.contains(value)) {
					results.addError(m.msg("DuplicateValue|Value appeared already", value, key),
							Overlay.of(mapOverlay, key));
				} else {
					seen.add(value);
				}
			}
		}
	}

	void checkMissing(Overlay<?> field, boolean required) {
		if (required && (field == null || !field.isPresent())) {
			results.addError(m.msg("MissingField|required field is missing", field.getPathInParent()), value);
		}
	}

	public Overlay<Map<String, Object>> validateExtensions(Map<String, Object> extensions) {
		return validateExtensions(extensions, null);
	}

	public Overlay<Map<String, Object>> validateExtensions(Map<String, Object> extensions, String crumb) {
		Overlay<Map<String, Object>> mapOverlay = Overlay.of(extensions);
		validateMap(mapOverlay, false, false, null);
		return mapOverlay;
	}

	public Overlay<String> validateFormatField(String name, boolean required, String type) {
		Overlay<String> field = validateStringField(name, required);
		if (field != null && field.isPresent()) {
			String normalType = null;
			switch (field.get()) {
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
			}
			if (normalType != null) {
				if (type == null || !type.equals(normalType)) {
					results.addWarning(
							m.msg("WrongTypeFormat|OpenAPI-defined format used with nonstandard or missing type", field,
									type, normalType),
							field);
				}
			}
		}
		return field;
	}

	public void checkDefault(Overlay<?> overlay, String type) {
		if (overlay != null && overlay.isPresent() && type != null) {
			Object defaultValue = overlay.get();
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
				ok = defaultValue instanceof List<?>;
				break;
			}
			if (!ok) {
				results.addError(m.msg("WrongTypeValue|Value is incompatible with schema type", type, defaultValue),
						overlay);
			}
		}
	}
}
