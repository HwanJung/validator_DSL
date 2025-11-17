package me.hwanjung.validation.rule;

@FunctionalInterface
public interface ValidationRule<T> {
    boolean isValid(T value);
}
