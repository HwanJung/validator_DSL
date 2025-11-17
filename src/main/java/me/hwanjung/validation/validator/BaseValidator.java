package me.hwanjung.validation.validator;

import me.hwanjung.validation.exception.ErrorMessage;
import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.rule.ValidationRule;

public class BaseValidator<T> {

    protected final T field;

    public BaseValidator(T field) {
        this.field = field;
    }

    public BaseValidator<T> notNull() {
        if (this.field == null) {
            throw new ValidationException(ErrorMessage.MUST_NOT_BE_NULL);
        }
        return this;
    }

    public BaseValidator<T> satisfies(ValidationRule<T> rule) {
        if (this.field == null) {
            return this;
        }
        if (!rule.isValid(this.field)) {
            throw new ValidationException(ErrorMessage.DOES_NOT_SATISFY_CONDITION);
        }
        return this;
    }
}
