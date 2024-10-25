package com.easy2excel.springbootjunit5mockitoexample.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeServiceTest {

    @InjectMocks
    private ShapeService shapeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateCircleArea() {
        double result = shapeService.calculateCircleArea(5);
        assertEquals(Math.PI * 25, result);
    }

    @Test
    void testCalculateCircleAreaNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shapeService.calculateCircleArea(-5);
        });
        assertEquals("Radius cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateRectangleArea() {
        double result = shapeService.calculateRectangleArea(5, 3);
        assertEquals(15, result);
    }

    @Test
    void testCalculateRectangleAreaNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shapeService.calculateRectangleArea(-5, 3);
        });
        assertEquals("Length and width cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateTriangleArea() {
        double result = shapeService.calculateTriangleArea(10, 2);
        assertEquals(10, result);
    }

    @Test
    void testCalculateTriangleAreaNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shapeService.calculateTriangleArea(10, -2);
        });
        assertEquals("Base and height cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateCirclePerimeter() {
        double result = shapeService.calculateCirclePerimeter(5);
        assertEquals(2 * Math.PI * 5, result);
    }

    @Test
    void testCalculateCirclePerimeterNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shapeService.calculateCirclePerimeter(-5);
        });
        assertEquals("Radius cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateRectanglePerimeter() {
        double result = shapeService.calculateRectanglePerimeter(5, 3);
        assertEquals(16, result);
    }

    @Test
    void testCalculateRectanglePerimeterNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shapeService.calculateRectanglePerimeter(-5, 3);
        });
        assertEquals("Length and width cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateTrianglePerimeter() {
        double result = shapeService.calculateTrianglePerimeter(3, 4, 5);
        assertEquals(12, result);
    }

    @Test
    void testCalculateTrianglePerimeterNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            shapeService.calculateTrianglePerimeter(3, 4, -5);
        });
        assertEquals("Sides cannot be negative", exception.getMessage());
    }
}

