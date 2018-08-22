package com.reprezen.kaizen.oasparser.val.msg;

import java.util.Locale;
import java.util.Properties;

public interface Messages {
	public String getFormatString();

	public String name();

	public default String getFormatString(Locale locale) {
		Properties localeStrings = locale != null ? getFormatStrings(locale) : null;
		String formatString = localeStrings != null ? localeStrings.getProperty(name()) : null;
		return formatString != null ? formatString : getFormatString();
	}

	public default Properties getFormatStrings(Locale locale) {
		return MessagesHelper.loadLocalizations(this.getClass(), locale);
	}

	public default String msg(Object... args) {
		return msg(Locale.getDefault(), args);
	}

	public default String msgNoLocale(Object... args) {
		return msg((Locale) null, args);
	}

	public default String msg(Locale locale, Object... args) {
		return MessagesHelper.format(locale, this, args);
	}

	public static String msg(Messages instance, Object... args) {
		return instance.msg(args);
	}
}
