package com.reprezen.kaizen.oasparser.val.msg;

import java.util.Locale;
import java.util.Properties;

public interface Messages {

    // TODO: add a method to test a localization file for missing and invalid
    // property names (compare all the property keys to the enum value names). This
    // should be easily executed by a main method in the enum class. It would be
    // great to also flag localized messages whose list of placeholder positions
    // does not match that of the default message.
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
