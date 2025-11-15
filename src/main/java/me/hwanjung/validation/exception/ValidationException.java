package me.hwanjung.validation.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super("Validation failed: " + message);
    }
}
