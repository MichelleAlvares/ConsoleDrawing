package com.cs.validation;

import com.cs.model.Canvas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CanvasValidationTest {
    private final CanvasValidation canvasValidation = new CanvasValidation();

    @Test
    void testLineValidation() {
        Assertions.assertTrue(canvasValidation.valid(new Canvas(10, 4, "C")));
    }

    @Test
    void negativeTestCases() {
        //w and h = 0
        Assertions.assertFalse(canvasValidation.valid(new Canvas(0, 0, "C")));

        //w <0 and h = 0
        Assertions.assertFalse(canvasValidation.valid(new Canvas(-1, 0, "C")));

        //w = 0 and h < 0
        Assertions.assertFalse(canvasValidation.valid(new Canvas(0, -10, "C")));

        //type incorrect
        Assertions.assertFalse(canvasValidation.valid(new Canvas(10, 10, "R")));
    }
}
