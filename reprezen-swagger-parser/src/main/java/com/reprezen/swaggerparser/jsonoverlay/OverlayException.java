package com.reprezen.swaggerparser.jsonoverlay;

public class OverlayException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OverlayException() {
        super();
    }

    public OverlayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OverlayException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverlayException(String message) {
        super(message);
    }

    public OverlayException(Throwable cause) {
        super(cause);
    }
}
