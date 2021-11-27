package com.cs.validation;

import com.cs.model.Point;
import com.cs.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleValidationTest {
    private final RectangleValidation rectangleValidation = new RectangleValidation();

    @Test
    void testLineValidation() {
        Assertions.assertTrue(rectangleValidation.valid(new Rectangle(0, 0, "R", new Point(2, 4), new Point(4, 9))));
    }

    @Test
    void negativeTestCases() {
        //x1 !< x2
        Assertions.assertFalse(rectangleValidation.valid(new Rectangle(0, 0, "R", new Point(2, 2), new Point(2, 9))));

        //y1 !< y2
        Assertions.assertFalse(rectangleValidation.valid(new Rectangle(0, 0, "R", new Point(2, 2), new Point(4, 2))));

        //type incorrect
        Assertions.assertFalse(rectangleValidation.valid(new Rectangle(0, 0, "L", new Point(2, 4), new Point(2, 9))));
    }
}
