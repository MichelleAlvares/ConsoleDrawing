package com.cs.validation;

import com.cs.model.Line;
import com.cs.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineValidationTest {
    private final LineValidation lineValidation = new LineValidation();

    @Test
    void testLineValidation() {
        Assertions.assertTrue(lineValidation.valid(new Line(0, 0, "L", new Point(2, 4), new Point(2, 9))));
    }

    @Test
    void negativeTestCases() {
        //x1!=x2 and y1!=y2
        Assertions.assertFalse(lineValidation.valid(new Line(0, 0, "L", new Point(2, 4), new Point(6, 9))));

        //type incorrect
        Assertions.assertFalse(lineValidation.valid(new Line(0, 0, " ", new Point(2, 4), new Point(2, 9))));
    }
}
