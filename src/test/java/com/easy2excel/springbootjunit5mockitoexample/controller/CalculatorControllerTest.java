package com.easy2excel.springbootjunit5mockitoexample.controller;

import com.easy2excel.springbootjunit5mockitoexample.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CalculatorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    void testAdd() throws Exception {
        when(calculatorService.add(3, 2)).thenReturn(5);

        mockMvc.perform(get("/calculator/add").param("a", "3").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));

        verify(calculatorService, times(1)).add(3, 2);
    }

    @Test
    void testSubtract() throws Exception {
        when(calculatorService.subtract(5, 3)).thenReturn(2);

        mockMvc.perform(get("/calculator/subtract").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));

        verify(calculatorService, times(1)).subtract(5, 3);
    }

    @Test
    void testMultiply() throws Exception {
        when(calculatorService.multiply(4, 3)).thenReturn(12);

        mockMvc.perform(get("/calculator/multiply").param("a", "4").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));

        verify(calculatorService, times(1)).multiply(4, 3);
    }

    @Test
    void testDivide() throws Exception {
        when(calculatorService.divide(10, 2)).thenReturn(5.0);

        mockMvc.perform(get("/calculator/divide").param("a", "10").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));

        verify(calculatorService, times(1)).divide(10, 2);
    }

    @Test
    void testDivideByZero() throws Exception {
        when(calculatorService.divide(10, 0)).thenThrow(new IllegalArgumentException("Cannot divide by zero"));

        mockMvc.perform(get("/calculator/divide").param("a", "10").param("b", "0"))
                .andExpect(status().isBadRequest());

        verify(calculatorService, times(1)).divide(10, 0);
    }
}

