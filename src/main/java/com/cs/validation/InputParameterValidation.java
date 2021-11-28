package com.cs.validation;

import java.util.Map;
import java.util.function.Predicate;

import static com.cs.constants.AppConstants.*;
import static com.cs.constants.AppConstants.ErrorMessage.*;
import static com.cs.constants.AppConstants.InformationalMessage.*;

public class InputParameterValidation {

    public boolean inputParameterValidation(String type, char[][] drawing, String[] userInputArray) {
        if (!CANVAS.equals(type)) {
            return isCanvasDrawn.test(drawing) && areCorrectNoOfParametersEntered(type, userInputArray) && areParameterTypesCorrect(type, userInputArray);
        } else {
            return areCorrectNoOfParametersEntered(type, userInputArray) && areParameterTypesCorrect(type, userInputArray);
        }
    }

    Predicate<char[][]> isCanvasDrawn = (drawing) -> drawing != null && drawing.length != 0;

    boolean areCorrectNoOfParametersEntered(String type, String[] userInputArray) {
        if (userInputArray.length != NO_OF_PARAMETERS.get(type) + 1) {
            numberOfParametersDoNotMatch(type);
            return false;
        } else return true;
    }

    boolean areParameterTypesCorrect(String type, String[] userInputArray) {
        for (Map.Entry entry : EXPECTED_DATA_TYPES.get(type).entrySet()) {
            switch ((String) entry.getValue()) {
                case INT:
                    try {
                        int parsedInt = Integer.parseInt(userInputArray[(int) entry.getKey()]);
                        if (parsedInt <= 0) {
                            numberGreaterThanZeroExpected();
                            return false;
                        }
                    } catch (NumberFormatException e) {
                        parameterTypeIsIncorrect(type);
                        return false;
                    }
                    break;
                case CHAR:
                    if (userInputArray[(int) entry.getKey()].length() > 1) {
                        parameterTypeIsIncorrect(type);
                        return false;
                    }
            }
        }
        return true;
    }

    private void numberGreaterThanZeroExpected() {
        System.out.println(ERROR_MESSAGE + NUMBER_GREATER_THAN_ZERO_MESSAGE);
        System.out.println(USER_INSTRUCTIONS);
    }

    private void numberOfParametersDoNotMatch(String type) {
        System.out.println(ERROR_MESSAGE + type + NEEDS + NO_OF_PARAMETERS.get(type) + INPUT_PARAMETERS);
        System.out.println(USER_INSTRUCTIONS);
    }

    private void parameterTypeIsIncorrect(String type) {
        for (Map.Entry entry : EXPECTED_DATA_TYPES.get(type).entrySet()) {
            System.out.println(ERROR_MESSAGE + type + NEEDS_PARAMETERS + entry.getKey() + TYPE_OF_PARAMETER + entry.getValue());
        }
        System.out.println(USER_INSTRUCTIONS);
    }

    private void canvasIsNotDrawn() {
        System.out.println(ERROR_MESSAGE + DRAW_CANVAS_MESSAGE);
        System.out.println(USER_INSTRUCTIONS);
    }
}
