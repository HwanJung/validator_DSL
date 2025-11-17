package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.exception.ErrorMessage;
import me.hwanjung.validation.rule.ValidationRule;
import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.exception.ValidationException;

public class StringValidator extends BaseValidator<String> {

    public StringValidator(String field) {
        super(field);
    }

    @Override
    public StringValidator notNull() {
        if (this.field == null) {
            throw new ValidationException(ErrorMessage.MUST_NOT_BE_NULL);
        }
        return this;
    }

    @Override
    public StringValidator satisfies(ValidationRule<String> rule) {
        if (this.field == null) {
            return this;
        }
        if (!rule.isValid(this.field)) {
            throw new ValidationException(ErrorMessage.DOES_NOT_SATISFY_CONDITION);
        }
        return this;
    }

    public StringValidator notBlank() {
        if (field == null || field.trim().isEmpty()) {
            throw new ValidationException(ErrorMessage.STRING_MUST_NOT_BE_BLANK);
        }
        return this;
    }

    public StringValidator notEmpty() {
        if (field == null || field.isEmpty()) {
            throw new ValidationException(ErrorMessage.STRING_MUST_NOT_BE_EMPTY);
        }
        return this;
    }

    public StringValidator maxLength(int maxLength) {
        if (field == null) {
            return this;
        }
        if (field.length() > maxLength) {
            throw new ValidationException(ErrorMessage.STRING_MAX_LENGTH, String.valueOf(maxLength));
        }
        return this;
    }

    public StringValidator minLength(int minLength) {
        if (field == null) {
            return this;
        }
        if (field.length() < minLength) {
            throw new ValidationException(ErrorMessage.STRING_MIN_LENGTH, String.valueOf(minLength));
        }
        return this;
    }
}
