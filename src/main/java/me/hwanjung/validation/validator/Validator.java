package me.hwanjung.validation.validator;

import me.hwanjung.validation.validator.value.NumberValidator;
import me.hwanjung.validation.validator.value.StringValidator;

public class Validator {

    private Validator() {}

    public static StringValidator value(String valueName, String value) {
        return new StringValidator(valueName, value);
    }

    public static <N extends Number & Comparable<N>> NumberValidator<N> value(String valueName, N value) {
        return new NumberValidator<>(valueName, value);
    }

    public static <T> BaseValidator<T> value(String valueName, T value) {
        return new BaseValidator<>(valueName, value);
    }
}
