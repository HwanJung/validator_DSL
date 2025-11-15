package me.hwanjung.validation.validator;

import me.hwanjung.validation.exception.ValidationException;

import java.util.function.Predicate;

public class BaseValidator<T> {

    protected final String valueName;
    protected final T value;

    public BaseValidator(String valueName, T value) {
        this.valueName = valueName;
        this.value = value;
    }

    /**
     * Validate the value is not null
     *
     * @return BaseValidator
     * @throws ValidationException when the value is null
     */
    public BaseValidator<T> notNull() {
        if (this.value == null) {
            throw new ValidationException(valueName, "must not be NULL");
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
        if (!predicate.test(this.value)) {
            throw new ValidationException(valueName, "must satisfies the condition that user set");
        }
        return this;
    }
}
