package com.easy2excel.springbootjunit5mockitoexample.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CalculatorServiceTest {

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        int result = calculatorService.add(3, 2);
        assertEquals(5, result);
    }

    @Test
    void testSubtract() {
        int result = calculatorService.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    void testMultiply() {
        int result = calculatorService.multiply(4, 3);
        assertEquals(12, result);
    }

    @Test
    void testDivide() {
        double result = calculatorService.divide(10, 2);
        assertEquals(5.0, result);
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(10, 0);
        });

        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

