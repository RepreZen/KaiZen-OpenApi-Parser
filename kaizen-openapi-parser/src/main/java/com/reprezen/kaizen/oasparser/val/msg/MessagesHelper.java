package com.reprezen.kaizen.oasparser.val.msg;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessagesHelper {
	private static final Pattern placeholderPattern = Pattern.compile("%(\\d+)|%\\{(\\d+)\\}");

	/**
	 * Interpolate arguments into the message format string for the given message.
	 * <p>
	 * If a non-null locale is provided, an attempt is made to load a properties
	 * file for the Message class of which this message is an instance, and the
	 * property named by this message's name is used as the format string. If that
	 * fails, or if the locale is null, the message object's default format string
	 * is used.
	 * <p>
	 * The format string contains embedded place holders indicating where arguments
	 * are to be substituted. Each place holder takes the form <code>%n</code> or
	 * <code>%{n}</code>, where <code>n</code> is an integer from 1 to the number of
	 * arguments. The second form allows interpolation at a site immediately
	 * followed by other digits.
	 * <p>
	 * To prevent a percent sign from triggering interpolation, double it:
	 * <code>%%</code>. For example, <code>"%%1 %%{2}"</code> will always produce
	 * <code>"%1 %{2}"</code>.
	 * <p>
	 * The result is obtained by replacing each placeholder with the corresponding
	 * argument's {@link #toString()} value (except that null arguments are rendered
	 * as empty strings).
	 *
	 * @param locale  locale to use
	 * @param message message to format
	 * @param args    values
	 * @return message with interpolated arguments
	 */
	public static String format(Locale locale, Messages message, Object... args) {
		String formatString = message.getFormatString(locale);
		Object[] sortArgs = sortArgs(formatString, args);
		String printfString = Stream.of(formatString.split("%%"))
				.map(part -> placeholderPattern.matcher(part).replaceAll("%s")) //
				.collect(Collectors.joining("%%"));
		return String.format(printfString, sortArgs);
	}

	private static Object[] sortArgs(String format, Object[] args) {
		List<Integer> sites = findInterpolationSites(format);
		sites.forEach(site -> {
			if (site < 1 || site > args.length) {
				String msg = String.format("Interpolation position must be from 1 to %d: %%%d", args.length, site);
				throw new IndexOutOfBoundsException(msg);
			}
		});
		return sites.stream().map(i -> args[i - 1] != null ? args[i - 1] : "").toArray();
	}

	private static List<Integer> findInterpolationSites(String format) {
		List<Integer> sites = new ArrayList<>();
		String[] parts = format.split("%%");
		for (String part : parts) {
			Matcher m = placeholderPattern.matcher(part);
			while (m.find()) {
				boolean braces = m.group(1) == null;
				String digits = m.group(braces ? 2 : 1);
				int index = digits.isEmpty() ? 0 : Integer.valueOf(digits);
				sites.add(index);
			}
		}
		return sites;
	}

	private static Map<Class<?>, Map<String, Properties>> localizationsByClass = new HashMap<>();

	public static Properties loadLocalizations(Class<? extends Messages> msgClass, Locale locale) {
		if (!localizationsByClass.containsKey(msgClass)) {
			localizationsByClass.put(msgClass, new HashMap<>());
		}
		Map<String, Properties> localizations = localizationsByClass.get(msgClass);
		// try locale-specified variant tag first, then fall back to just the language
		// code
		for (String tag : Arrays.asList(locale.toLanguageTag(), locale.getLanguage())) {
			if (!localizations.containsKey(tag)) {
				URL resource = msgClass.getResource(String.format("localizations/%s/messages.properties", tag));
				Properties props = null;
				if (resource != null) {
					props = new Properties();
					try (InputStream in = resource.openStream()) {
						props.load(in);
					} catch (IOException e) {
						props = null;
					}
				}
				// if no props loaded, set null value in localizations so we don't keep trying
				localizations.put(tag, props);
			}
			Properties result = localizations.get(tag);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
}
