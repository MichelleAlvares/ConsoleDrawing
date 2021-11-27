package com.cs.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BorderValidationTest {
    private final BorderValidation borderValidation = new BorderValidation();

    @Test
    void testBorderValidation() {
        Assertions.assertTrue(borderValidation.withinBorder(4, 4, 5, 6));
        Assertions.assertTrue(borderValidation.withinBorder(5, 4, 5, 6));
        Assertions.assertTrue(borderValidation.withinBorder(10, 8, 10, 8));
        Assertions.assertFalse(borderValidation.withinBorder(11, 8, 10, 8));
        Assertions.assertFalse(borderValidation.withinBorder(10, 9, 10, 8));
        Assertions.assertFalse(borderValidation.withinBorder(13, 19, 10, 8));
    }
}
