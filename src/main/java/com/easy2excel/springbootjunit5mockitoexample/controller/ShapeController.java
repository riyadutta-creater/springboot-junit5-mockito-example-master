package com.easy2excel.springbootjunit5mockitoexample.controller;

import com.easy2excel.springbootjunit5mockitoexample.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shapes")
public class ShapeController {

    @Autowired
    private ShapeService shapeService;

    @GetMapping("/circle/area")
    public double getCircleArea(@RequestParam double radius) {
        return shapeService.calculateCircleArea(radius);
    }

    @GetMapping("/rectangle/area")
    public double getRectangleArea(@RequestParam double length, @RequestParam double width) {
        return shapeService.calculateRectangleArea(length, width);
    }

    @GetMapping("/triangle/area")
    public double getTriangleArea(@RequestParam double base, @RequestParam double height) {
        return shapeService.calculateTriangleArea(base, height);
    }

    @GetMapping("/circle/perimeter")
    public double getCirclePerimeter(@RequestParam double radius) {
        return shapeService.calculateCirclePerimeter(radius);
    }

    @GetMapping("/rectangle/perimeter")
    public double getRectanglePerimeter(@RequestParam double length, @RequestParam double width) {
        return shapeService.calculateRectanglePerimeter(length, width);
    }

    @GetMapping("/triangle/perimeter")
    public double getTrianglePerimeter(@RequestParam double side1, @RequestParam double side2, @RequestParam double side3) {
        return shapeService.calculateTrianglePerimeter(side1, side2, side3);
    }
}

