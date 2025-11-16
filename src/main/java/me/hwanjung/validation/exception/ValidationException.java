package me.hwanjung.validation.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(ErrorMessage errorMessage, String... messageParameters) {
        super("Validation failed: " + errorMessage.format(messageParameters));
    }
}
