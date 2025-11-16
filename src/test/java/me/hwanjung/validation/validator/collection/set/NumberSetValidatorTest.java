package me.hwanjung.validation.validator.collection.set;

import me.hwanjung.validation.exception.ValidationException;
import me.hwanjung.validation.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberSetValidatorTest {

    @DisplayName("notEmpty: Set이 null이거나 비어있다면 예외가 발생한다.")
    @Test
    void notEmpty_whenListIsEmpty() {
        // given
        Set<Integer> set1 = null;
        Set<Integer> set2 = new HashSet<>();

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(set1).notEmpty()
        );
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(set2).notEmpty()
        );
    }

    @DisplayName("notEmpty: Set이 비어있지 않다면 아무 일도 일어나지 않는다.")
    @Test
    void notEmpty_whenListIsNotEmpty() {
        // given
        Set<Integer> set = Set.of(1, 2, 3);

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set).notEmpty()
        );
    }

    @DisplayName("sizeAtLeast: Set이 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenListIsNull() {
        // given
        Set<Integer> set = null;
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: Set의 크기가 인자보다 작다면 예외가 발생한다.")
    @Test
    void sizeAtLeast_whenListSizeLessThanMin() {
        // given
        Set<Integer> set = Set.of(1, 2, 3);
        int min = 5;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(set).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtLeast: Set의 크기가 min보다 크거나 같다면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtLeast_whenSatisfy() {
        // given
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(1, 2, 3, 4);
        int min = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set1).sizeAtLeast(min)
        );
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set2).sizeAtLeast(min)
        );
    }

    @DisplayName("sizeAtMost: Set이 null이라면 아무 일도 발생하지 않는다.")
    @Test
    void sizeAtMost_whenListIsNull() {
        // given
        Set<Integer> set = null;
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: Set이 max보다 크다면 예외가 발생한다.")
    @Test
    void sizeAtMost_whenListSizeGreaterThanMax() {
        // given
        Set<Integer> set = Set.of(1, 2, 3, 4);
        int max = 3;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(set).sizeAtMost(max)
        );
    }

    @DisplayName("sizeAtMost: Set이 max보다 작거나 같다면 아무 일도 일어나지 않는다.")
    @Test
    void sizeAtMost_whenListSizeLessThanMax() {
        // given
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(1, 2);
        int max = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set1).sizeAtMost(max)
        );
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set2).sizeAtMost(max)
        );
    }

    @DisplayName("size: Set이 null이면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListIsNull() {
        // given
        Set<Integer> set = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set).size(1)
        );
    }

    @DisplayName("size: Set의 크기가 size와 같지 않으면 예외가 발생한다.")
    @Test
    void size_whenListSizeNotEqualsSize() {
        // given
        Set<Integer> set = Set.of(1, 2, 3);
        int size = 4;

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(set).size(size)
        );
    }

    @DisplayName("size: Set의 크기가 size와 같으면 아무 일도 발생하지 않는다.")
    @Test
    void size_whenListSizeEqualsSize() {
        // given
        Set<Integer> set = Set.of(1, 2, 3);
        int size = 3;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set).size(size)
        );
    }

    @DisplayName("forEach: Set이 null이면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenListIsNull() {
        // given
        Set<Integer> set = null;

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set).forEach(null)
        );
    }

    @DisplayName("forEach: Set의 요소가 지정 조건을 만족하지 않는다면 예외가 발생한다.")
    @Test
    void forEach_whenNotSatisfy() {
        // given
        Set<Integer> set = Set.of(1, 2, 3);

        // when & then
        assertThrows(ValidationException.class,
            () -> Validator.validateNumbers(set)
                .forEach(e -> e.greaterThan(2))
        );
    }

    @DisplayName("forEach: Set의 모든 요소가 조건을 만족한다면 아무 일도 일어나지 않는다.")
    @Test
    void forEach_whenSatisfy() {
        // given
        Set<Integer> set = Set.of(1, 2, 3);

        // when & then
        assertDoesNotThrow(
            () -> Validator.validateNumbers(set)
                .forEach(e -> e
                    .notNull()
                    .lessThan(10)
                )
        );
    }
}
