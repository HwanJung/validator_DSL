package me.hwanjung.validation.validator;

import me.hwanjung.validation.exception.ValidationException;

import java.util.function.Predicate;

public class BaseValidator<T> {

    protected final String fieldName;
    protected final T field;

    public BaseValidator(String fieldName, T field) {
        this.fieldName = fieldName;
        this.field = field;
    }

    /**
     * Validate the value is not null
     *
     * @return BaseValidator
     * @throws ValidationException when the value is null
     */
    public BaseValidator<T> notNull() {
        if (this.field == null) {
            throw new ValidationException(fieldName, "must not be NULL");
        }
        return this;
    }

    /**
     * Validate the value satisfies the condition that user set
     *
     * @param predicate condition to satisfy
     * @return BaseValidator
     */
    public BaseValidator<T> satisfies(Predicate<T> predicate) {
        if (this.field == null) {
            return this;
        }
        if (!predicate.test(this.field)) {
            throw new ValidationException(fieldName, "must satisfies the condition that user set");
        }
        return this;
    }
}
