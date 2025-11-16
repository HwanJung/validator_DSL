package me.hwanjung.validation.validator.collection;

import me.hwanjung.validation.exception.ErrorMessage;
import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.BaseValidator;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionValidator<E, C extends Collection<E>, V extends BaseValidator<E>>
    extends BaseValidator<C> {

    protected final Function<E, V> elementValidatorFactory;

    public CollectionValidator(C field, Function<E, V> elementValidatorFactory) {
        super(field);
        this.elementValidatorFactory = elementValidatorFactory;
    }

    @Override
    public CollectionValidator<E, C, V> notNull() {
        if (this.field == null) {
            throw new ValidationException(ErrorMessage.MUST_NOT_BE_NULL);
        }
        return this;
    }

    @Override
    public CollectionValidator<E, C, V> satisfies(Predicate<C> predicate) {
        if (this.field == null) {
            return this;
        }
        if (!predicate.test(this.field)) {
            throw new ValidationException(ErrorMessage.DOES_NOT_SATISFY_CONDITION);
        }
        return this;
    }

    public CollectionValidator<E, C, V> notEmpty() {
        if (field == null || field.isEmpty()) {
            throw new ValidationException(ErrorMessage.COLLECTION_MUST_NOT_BE_EMPTY);
        }
        return this;
    }

    public CollectionValidator<E, C, V> sizeAtLeast(int min) {
        if (field == null) {
            return this;
        }
        if (field.size() < min) {
            throw new ValidationException(ErrorMessage.COLLECTION_SIZE_AT_LEAST, String.valueOf(min));
        }
        return this;
    }

    public CollectionValidator<E, C, V> sizeAtMost(int max) {
        if (field == null) {
            return this;
        }
        if (field.size() > max) {
            throw new ValidationException(ErrorMessage.COLLECTION_SIZE_AT_MOST, String.valueOf(max));
        }
        return this;
    }

    public CollectionValidator<E, C, V> size(int size) {
        if (field == null) {
            return this;
        }
        if (field.size() != size) {
            throw new ValidationException(ErrorMessage.COLLECTION_SIZE_EXACT, String.valueOf(size));
        }
        return this;
    }

    public CollectionValidator<E, C, V> forEach(Consumer<V> validator) {
        if (field == null) {
            return this;
        }
        for (E element : field) {
            validator.accept(elementValidatorFactory.apply(element));
        }
        return this;
    }
}
