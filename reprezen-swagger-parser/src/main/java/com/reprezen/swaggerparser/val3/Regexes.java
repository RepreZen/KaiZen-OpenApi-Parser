package com.reprezen.swaggerparser.val3;

import java.util.regex.Pattern;

public class Regexes {

    public static final Pattern PATH_REGEX = Pattern.compile("/.+");
    public static final Pattern EXT_REGEX = Pattern.compile("x-.+");
    public static final Pattern NOEXT_REGEX = Pattern.compile("(?!x-).*");
    public static final Pattern NAME_REGEX = Pattern.compile("[a-zA-Z0-9\\._-]+");
    public static final Pattern NOEXT_NAME_REGEX = Pattern.compile("(?!x-)[a-zA-Z0-9\\._-]+");
    public static final Pattern METHOD_REGEX = Pattern.compile("get|put|post|delete|options|head|patch|trace");
}
