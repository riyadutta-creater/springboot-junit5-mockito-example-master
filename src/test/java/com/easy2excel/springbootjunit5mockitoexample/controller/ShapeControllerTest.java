package com.easy2excel.springbootjunit5mockitoexample.controller;

import com.easy2excel.springbootjunit5mockitoexample.service.ShapeService;
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

public class ShapeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShapeService shapeService;

    @InjectMocks
    private ShapeController shapeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(shapeController).build();
    }

    @Test
    void testGetCircleArea() throws Exception {
        when(shapeService.calculateCircleArea(5)).thenReturn(Math.PI * 25);

        mockMvc.perform(get("/shapes/circle/area").param("radius", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Math.PI * 25)));

        verify(shapeService, times(1)).calculateCircleArea(5);
    }


    @Test
    void testGetRectangleArea() throws Exception {
        when(shapeService.calculateRectangleArea(5, 3)).thenReturn(15.0);

        mockMvc.perform(get("/shapes/rectangle/area").param("length", "5").param("width", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));

        verify(shapeService, times(1)).calculateRectangleArea(5, 3);
    }

    @Test
    void testGetTriangleArea() throws Exception {
        when(shapeService.calculateTriangleArea(10, 2)).thenReturn(10.0);

        mockMvc.perform(get("/shapes/triangle/area").param("base", "10").param("height", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));

        verify(shapeService, times(1)).calculateTriangleArea(10, 2);
    }

    @Test
    void testGetCirclePerimeter() throws Exception {
        when(shapeService.calculateCirclePerimeter(5)).thenReturn(2 * Math.PI * 5);

        mockMvc.perform(get("/shapes/circle/perimeter").param("radius", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(2 * Math.PI * 5)));

        verify(shapeService, times(1)).calculateCirclePerimeter(5);
    }

    @Test
    void testGetRectanglePerimeter() throws Exception {
        when(shapeService.calculateRectanglePerimeter(5, 3)).thenReturn(16.0);

        mockMvc.perform(get("/shapes/rectangle/perimeter").param("length", "5").param("width", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("16.0"));

        verify(shapeService, times(1)).calculateRectanglePerimeter(5, 3);
    }

    @Test
    void testGetTrianglePerimeter() throws Exception {
        when(shapeService.calculateTrianglePerimeter(3, 4, 5)).thenReturn(12.0);

        mockMvc.perform(get("/shapes/triangle/perimeter").param("side1", "3").param("side2", "4").param("side3", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("12.0"));

        verify(shapeService, times(1)).calculateTrianglePerimeter(3, 4, 5);
    }
}

