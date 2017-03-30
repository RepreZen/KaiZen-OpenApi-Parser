package com.reprezen.swaggerparser.val;

import java.util.Arrays;

public class Messages {
    public static Messages m = new Messages();

    public String msg(String text, Object... args) {
        int pos = text.indexOf('|');
        if (pos >= 0) {
            String nls = nls(text.substring(0, pos));
            text = nls != null ? nls : text.substring(pos + 1);
        }
        return String.format("%s %s", text, Arrays.asList(args));
    }

    public String nls(String text) {
        return null;
    }
}
