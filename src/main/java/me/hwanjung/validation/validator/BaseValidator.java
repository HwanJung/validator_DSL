package me.hwanjung.validation.validator;

import me.hwanjung.validation.exception.ErrorMessage;
import me.hwanjung.validation.exception.ValidationException;

import java.util.function.Predicate;

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

    public BaseValidator<T> satisfies(Predicate<T> predicate) {
        if (this.field == null) {
            return this;
        }
        if (!predicate.test(this.field)) {
            throw new ValidationException(ErrorMessage.DOES_NOT_SATISFY_CONDITION);
        }
        return this;
    }
}
