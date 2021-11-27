package com.cs.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.cs.constants.AppConstants.*;

class InputParameterValidationTest {
    private final InputParameterValidation inputValidation = new InputParameterValidation();

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
        Assertions.assertTrue(inputValidation.isCanvasDrawn(new char[][]{{'-','-'},{'|',' ',}}));
        Assertions.assertFalse(inputValidation.isCanvasDrawn(new char[][]{}));
        Assertions.assertFalse(inputValidation.isCanvasDrawn(null));
    }
}
