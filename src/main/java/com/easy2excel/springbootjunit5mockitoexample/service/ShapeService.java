package com.easy2excel.springbootjunit5mockitoexample.service;

import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }

    public double calculateRectangleArea(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width cannot be negative");
        }
        return length * width;
    }

    public double calculateTriangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height cannot be negative");
        }
        return 0.5 * base * height;
    }

    public double calculateCirclePerimeter(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return 2 * Math.PI * radius;
    }

    public double calculateRectanglePerimeter(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width cannot be negative");
        }
        return 2 * (length + width);
    }

    public double calculateTrianglePerimeter(double side1, double side2, double side3) {
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalArgumentException("Sides cannot be negative");
        }
        return side1 + side2 + side3;
    }
}

