package com.cs.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.cs.constants.AppConstants.*;

class InputParameterValidationTest {
    private final InputParameterValidation inputValidation = new InputParameterValidation();

    @Test
    void validCanvasCommandTest() {
        Assertions.assertTrue(inputValidation.valid(CANVAS, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"C", "2", "2"}));
    }

    @Test
    void validLineCommandTest() {
        Assertions.assertTrue(inputValidation.valid(LINE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"L", "2", "2", "2", "5"}));
    }

    @Test
    void validRectangleCommandTest() {
        Assertions.assertTrue(inputValidation.valid(RECTANGLE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"R", "2", "2", "5", "5"}));
    }

    @Test
    void validFillCommandTest() {
        Assertions.assertTrue(inputValidation.valid(BUCKET_FILL, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"B", "2", "2", "v"}));
        Assertions.assertTrue(inputValidation.valid(BUCKET_FILL, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"B", "2", "2", "2"}));
    }

    @Test
    void invalidCanvasCommandTest() {
        Assertions.assertFalse(inputValidation.valid(CANVAS, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"C", "2", "0"}));
        Assertions.assertFalse(inputValidation.valid(CANVAS, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"C", "-1", "0"}));
        Assertions.assertFalse(inputValidation.valid(CANVAS, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"C", "20"}));
        Assertions.assertFalse(inputValidation.valid(CANVAS, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"213 2"}));
    }

    @Test
    void invalidLineCommandTest() {
        Assertions.assertFalse(inputValidation.valid(LINE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"L", "2", "2", "5", "5", "9"}));
        Assertions.assertFalse(inputValidation.valid(LINE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"L", "2", "2", "5", "o"}));
        Assertions.assertFalse(inputValidation.valid(LINE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"L", "2", "2", "5"}));
        Assertions.assertFalse(inputValidation.valid(LINE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"L", "2", "2", "2ß", "0"}));
    }

    @Test
    void invalidRectangleCommandTest() {
        Assertions.assertFalse(inputValidation.valid(RECTANGLE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"R", "2", "i", "5", "5"}));
        Assertions.assertFalse(inputValidation.valid(RECTANGLE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"R", "2", "2", "0", "5"}));
        Assertions.assertFalse(inputValidation.valid(RECTANGLE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"R", "2", "2", "5", "5", "0"}));
        Assertions.assertFalse(inputValidation.valid(RECTANGLE, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"R", "2", "2", "5"}));
    }

    @Test
    void invalidFillCommandTest() {
        Assertions.assertFalse(inputValidation.valid(BUCKET_FILL, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"B", "2", "2", "vw"}));
        Assertions.assertFalse(inputValidation.valid(BUCKET_FILL, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"B", "2", "2", "24"}));
        Assertions.assertFalse(inputValidation.valid(BUCKET_FILL, new char[][]{{'-', '-', '-'}, {'|', ' ', '|'}, {'-', '-', '-'}}, new String[]{"B", "-9", "2", "e"}));
    }

    @Test
    void areCorrectNoOfParametersEnteredTest() {
        Assertions.assertTrue(inputValidation.areCorrectNoOfParametersEntered(CANVAS, new String[]{"C", "4", "4"}));
        Assertions.assertFalse(inputValidation.areCorrectNoOfParametersEntered(CANVAS, new String[]{"C", "4"}));
    }

    @Test
    void areParameterTypesCorrectTest() {
        Assertions.assertTrue(inputValidation.areParameterTypesCorrect(BUCKET_FILL, new String[]{"L", "4", "4", "o"}));
        Assertions.assertTrue(inputValidation.areParameterTypesCorrect(BUCKET_FILL, new String[]{"L", "4", "4", "1"}));
        Assertions.assertFalse(inputValidation.areParameterTypesCorrect(BUCKET_FILL, new String[]{"L", "4", "4", "yy"}));
        Assertions.assertFalse(inputValidation.areParameterTypesCorrect(LINE, new String[]{"L", "4", "U", "6", "4"}));
        Assertions.assertFalse(inputValidation.areParameterTypesCorrect(LINE, new String[]{"L", "4", "-1", "6", "4"}));
    }

    @Test
    void isCanvasDrawnTest() {
        Assertions.assertTrue(inputValidation.isCanvasDrawn(new char[][]{{'-', '-'}, {'|', ' ',}}));
        Assertions.assertFalse(inputValidation.isCanvasDrawn(new char[][]{}));
        Assertions.assertFalse(inputValidation.isCanvasDrawn(null));
    }
}
