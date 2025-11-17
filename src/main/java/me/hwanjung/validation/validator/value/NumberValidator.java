package me.hwanjung.validation.validator.value;

import me.hwanjung.validation.exception.ErrorMessage;
import me.hwanjung.validation.rule.ValidationRule;
import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.exception.ValidationException;

public class NumberValidator<N extends Number & Comparable<N>> extends BaseValidator<N> {

    public NumberValidator(N field) {
        super(field);
    }

    @Override
    public NumberValidator<N> notNull() {
        if (this.field == null) {
            throw new ValidationException(ErrorMessage.MUST_NOT_BE_NULL);
        }
        return this;
    }

    @Override
    public NumberValidator<N> satisfies(ValidationRule<N> rule) {
        if (this.field == null) {
            return this;
        }
        if (!rule.isValid(this.field)) {
            throw new ValidationException(ErrorMessage.DOES_NOT_SATISFY_CONDITION);
        }
        return this;
    }

    public NumberValidator<N> greaterThan(N min) {
        if (min == null) {
            throw new IllegalArgumentException("min must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) <= 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_GREATER_THAN, min.toString());
        }
        return this;
    }

    public NumberValidator<N> lessThan(N max) {
        if (max == null) {
            throw new IllegalArgumentException("max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(max) >= 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_LESS_THAN, max.toString());
        }
        return this;
    }

    public NumberValidator<N> greaterThanOrEqualTo(N min) {
        if (min == null) {
            throw new IllegalArgumentException("min must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) < 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_GREATER_OR_EQUAL, min.toString());
        }
        return this;
    }

    public NumberValidator<N> lessThanOrEqualTo(N max) {
        if (max == null) {
            throw new IllegalArgumentException("max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(max) > 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_LESS_OR_EQUAL, max.toString());
        }
        return this;
    }

    public NumberValidator<N> betweenExclusive(N min, N max) {
        if (min == null || max == null) {
            throw new IllegalArgumentException("min and max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) <= 0 || field.compareTo(max) >= 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_BETWEEN_EXCLUSIVE, min.toString(), max.toString());
        }
        return this;
    }

    public NumberValidator<N> betweenInclusive(N min, N max) {
        if (min == null || max == null) {
            throw new IllegalArgumentException("min and max must not be null");
        }

        if (field == null) {
            return this;
        }
        if (field.compareTo(min) < 0 || field.compareTo(max) > 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_BETWEEN_INCLUSIVE, min.toString(), max.toString());
        }
        return this;
    }


    public NumberValidator<N> multipleOf(long number) {
        if (number == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }

        if (field == null) {
            return this;
        }
        if (!isIntegralNumber()) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_INTEGER);
        }

        long v = field.longValue();
        if (v % number != 0) {
            throw new ValidationException(ErrorMessage.NUMBER_MUST_BE_MULTIPLE_OF, String.valueOf(number));
        }
        return this;
    }

    private boolean isIntegralNumber() {
        return field instanceof Integer
            || field instanceof Long
            || field instanceof Byte
            || field instanceof Short;
    }
}
