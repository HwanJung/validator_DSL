package main.java.valueValidator;

import main.java.exception.ValidationException;

public class ValueValidator<T> {

    private final String valueName;
    private final T value;

    public ValueValidator(String valueName, T value) {
        this.valueName = valueName;
        this.value = value;
    }

    /**
     * 검증하려는 value가 null이라면 예외를 던진다
     *
     * @return ValueValidator 본인을 반환한다
     * @throws ValidationException value가 null이면 예외를 던진다
     */
    public ValueValidator<T> notNull() {
        if (this.value == null) {
            throw new ValidationException(valueName, "must not be NULL");
        }
        return this;
    }
}
