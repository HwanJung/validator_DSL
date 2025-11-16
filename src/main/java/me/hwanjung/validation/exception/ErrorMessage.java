package me.hwanjung.validation.exception;

public enum ErrorMessage {

    // For BaseValidator
    MUST_NOT_BE_NULL("must not be null"),
    DOES_NOT_SATISFY_CONDITION("does not satisfy the required condition"),

    // For NumberValidator
    NUMBER_MUST_BE_GREATER_THAN("must be greater than %s"),
    NUMBER_MUST_BE_LESS_THAN("must be less than %s"),
    NUMBER_MUST_BE_GREATER_OR_EQUAL("must be greater than or equal to %s"),
    NUMBER_MUST_BE_LESS_OR_EQUAL("must be less than or equal to %s"),

    NUMBER_MUST_BE_BETWEEN_EXCLUSIVE("must be greater than %s and less than %s"),
    NUMBER_MUST_BE_BETWEEN_INCLUSIVE("must be between %s and %s (inclusive)"),

    NUMBER_MUST_BE_INTEGER("must be an integer"),
    NUMBER_MUST_BE_MULTIPLE_OF("must be a multiple of %s"),

    // For StringValidator
    STRING_MUST_NOT_BE_BLANK("must not be blank"),
    STRING_MUST_NOT_BE_EMPTY("must not be empty"),

    STRING_MAX_LENGTH("length must be at most %s"),
    STRING_MIN_LENGTH("length must be at least %s"),

    // For CollectionValidator
    COLLECTION_MUST_NOT_BE_EMPTY("must not be empty"),
    COLLECTION_SIZE_AT_LEAST("must have at least %s elements"),
    COLLECTION_SIZE_AT_MOST("must have at most %s elements"),
    COLLECTION_SIZE_EXACT("must have %s elements");

    private final String template;

    ErrorMessage(String template) {
        this.template = template;
    }

    public String format(String... args) {
        return String.format(template, args);
    }

}
