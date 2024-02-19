package io.github.seujorgenochurras.image.ascii.exception;

public class NoSymbolException extends RuntimeException {
    public NoSymbolException() {
    }

    public NoSymbolException(String message) {
        super(message);
    }

    public NoSymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSymbolException(Throwable cause) {
        super(cause);
    }

    public NoSymbolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
