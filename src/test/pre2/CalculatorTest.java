package com.example.tdddemo;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;
    private static List<String> records = new ArrayList<>();

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("양수 덧셈")
    void testAddTwoPositiveNumbers() {
        int a = 3, b = 4;
        int result = calculator.add(a, b);
        assertEquals(7, result, "3+4 should equal 7");
        records.add(a + " + " + b + " = " + result);
    }

    @Test
    @DisplayName("음수를 포함한 덧셈")
    void testTwoNegativeNumbers() {
        int a = 3, b = -4;
        int result = calculator.add(a, b);
        assertEquals(-1, result, "-1 필요");
        records.add(a + " + " + b + " = " + result);
    }

    @Test
    @DisplayName("음수를 포함한 덧셈2")
    void testAddPositiveAndNegativeNumber() {
        int a = 3, b = -4;
        int result = calculator.add(a, b);
        assertEquals(-1, result, "3 + (-4) should equal -1");
        records.add(a + " + " + b + " = " + result);
    }

    @Test
    @DisplayName("0 덧셈")
    void testAddZero() {
        int a = 3, b = 0;
        int result = calculator.add(a, b);
        assertEquals(3, result, "3 + 0 should equal 3");
        records.add(a + " + " + b + " = " + result);
    }

    @Test
    @DisplayName("덧셈시 오버플로우 확인")
    void testAddWithOverflow() {
        assertEquals(
                Integer.MIN_VALUE,
                calculator.add(Integer.MAX_VALUE, 1),
                "Adding 1 to MAX_VALUE should result in MIN_VALUE"
        );
        records.add(Integer.MAX_VALUE + " + " + 1 + " = " + Integer.MIN_VALUE);
    }

    @Test
    @DisplayName("양수 뺄셈")
    void subTwoPositiveNumbers() {
        int a = 5, b = 3;
        int result = calculator.sub(a, b);
        assertEquals(2, result, "5 - 3은 2여야 합니다");
        records.add(a + " - " + b + " = " + result);
    }

    @Test
    @DisplayName("결과가 음수가 나오는 뺄셈")
    void subResultIsNegative() {
        int a = 2, b = 3;
        int result = calculator.sub(a, b);
        assertEquals(-1, result, "2 - 3은 -1이어야 합니다");
        records.add(a + " - " + b + " = " + result);
    }

    @Test
    @DisplayName("큰 수 뺄셈")
    void subBigInteger() {
        int a = Integer.MAX_VALUE, b = 1;
        int result = calculator.sub(a, b);
        assertEquals(a, calculator.sub(a, b),
                "MAX_VALUE - 1은 MAX_VALUE-1이어야 합니다");
        records.add(a + " - " + b + " = " + result);
    }

    @Test
    @DisplayName("정수의 곱셈")
    void mulTwoNumbers() {
        int a = -3, b = 4;
        int result = calculator.mul(a, b);
        assertEquals(-12, result, "-3*4는 -12이어야 합니다.");
        records.add(a + " * " + b + " = " + result);
    }

    @Test
    @DisplayName("정수의 나눗셈")
    void divTwoNumbers() {
        int a = 5, b = 2;
        int result = calculator.div(a, b);
        assertEquals(2, result, "5/2는 2이어야 합니다.");
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(5, 0));
        records.add(a + " / " + b + " = " + result);
    }

    @AfterAll
    static void printResults() {
        for (String record : records) {
            System.out.println(record);
        }
    }
}

