package main.java.validator;

import main.java.valueValidator.ValueValidator;

public class Validator {

    private Validator() {}

    public static <T> ValueValidator<T> value(String valueName, T value) {
        return new ValueValidator<>(valueName, value);
    }
}
