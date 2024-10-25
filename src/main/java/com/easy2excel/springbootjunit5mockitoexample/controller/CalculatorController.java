package com.easy2excel.springbootjunit5mockitoexample.controller;

import com.easy2excel.springbootjunit5mockitoexample.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b) {
        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> divide(@RequestParam int a, @RequestParam int b) {
        try {
            return ResponseEntity.ok(calculatorService.divide(a, b));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    /*@GetMapping("/divide")
    public double divide(@RequestParam int a, @RequestParam int b) {
        return calculatorService.divide(a, b);
    }*/
}
