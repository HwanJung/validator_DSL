package me.hwanjung.validation.validator.list;

import me.hwanjung.validation.validator.BaseValidator;

import java.util.List;

public class ListValidator<E> extends BaseValidator<List<E>> {

    public ListValidator(String valueName, List<E> list) {
        super(valueName, list);
    }

}
