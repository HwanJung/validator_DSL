package me.hwanjung.validation.validator;

import me.hwanjung.validation.validator.list.ListValidator;
import me.hwanjung.validation.validator.value.NumberValidator;
import me.hwanjung.validation.validator.value.StringValidator;

import java.util.List;

public class Validator {

    private Validator() {}

    public static StringValidator validate(String value) {
        return new StringValidator(value);
    }

    public static <N extends Number & Comparable<N>> NumberValidator<N> validate(N value) {
        return new NumberValidator<>(value);
    }

    public static <E> ListValidator<E> validate(List<E> list) {
        return new ListValidator<>(list);
    }

    public static <T> BaseValidator<T> validate(T value) {
        return new BaseValidator<>(value);
    }
}
