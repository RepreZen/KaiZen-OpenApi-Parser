package com.reprezen.swaggerparser.jsonoverlay;

public class ResolutionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResolutionException() {
        super();
    }

    public ResolutionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ResolutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResolutionException(String message) {
        super(message);
    }

    public ResolutionException(Throwable cause) {
        super(cause);
    }

}
