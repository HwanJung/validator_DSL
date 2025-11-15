package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.exception.ValidationException;

public class StringValidator extends BaseValidator<String> {

    public StringValidator(String field) {
        super(field);
    }

    public StringValidator notBlank() {
        if (field == null || field.trim().isEmpty()) {
            throw new ValidationException("must not be blank");
        }
        return this;
    }

    public StringValidator notEmpty() {
        if (field == null || field.isEmpty()) {
            throw new ValidationException("must not be blank");
        }
        return this;
    }

    public StringValidator maxLength(int maxLength) {
        if (field == null) {
            return this;
        }
        if (field.length() > maxLength) {
            throw new ValidationException("must not be greater than " + maxLength);
        }
        return this;
    }

    public StringValidator minLength(int minLength) {
        if (field == null) {
            return this;
        }
        if (field.length() < minLength) {
            throw new ValidationException("must not be less than " + minLength);
        }
        return this;
    }
}
