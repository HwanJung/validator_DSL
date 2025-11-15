package me.hwanjung.validation.validator.list;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.BaseValidator;
import me.hwanjung.validation.validator.Validator;

import java.util.List;
import java.util.function.Consumer;

public class ListValidator<E> extends BaseValidator<List<E>> {

    public ListValidator(List<E> field) {
        super(field);
    }

    public ListValidator<E> notEmpty() {
        if (field == null || field.isEmpty()) {
            throw new ValidationException("must not be empty");
        }
        return this;
    }

    public ListValidator<E> sizeAtLeast(int min) {
        if (field == null) {
            return this;
        }
        if (field.size() < min) {
            throw new ValidationException("must have at least " + min + " elements");
        }
        return this;
    }

    public ListValidator<E> sizeAtMost(int max) {
        if (field == null) {
            return this;
        }
        if (field.size() > max) {
            throw new ValidationException("must have at most " + max + " elements");
        }
        return this;
    }

    public ListValidator<E> size(int size) {
        if (field == null) {
            return this;
        }
        if (field.size() != size) {
            throw new ValidationException("must have " + size + " elements");
        }
        return this;
    }

    public <V extends BaseValidator<E>> ListValidator<E> forEach(Consumer<V> validator) {
        if (field == null) {
            return this;
        }
        for (int i = 0; i < field.size(); i++) {
            E element = field.get(i);
            String elementName = "element[" + i + "]";
            V val = (V) Validator.validate(element);
            validator.accept(val);
        }
        return this;
    }

}
