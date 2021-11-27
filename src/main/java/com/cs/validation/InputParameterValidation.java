package com.cs.validation;

import java.util.Map;

import static com.cs.constants.AppConstants.*;

public class InputParameterValidation {

    public boolean areCorrectNoOfParametersEntered(String type, String[] userInputArray) {
        if (userInputArray.length != NO_OF_PARAMETERS.get(type) + 1) {
            numberShouldBeGreaterThanZero(type);
            return false;
        } else return true;
    }

    public boolean areParameterTypesCorrect(String type, String[] userInputArray) {
        for (Map.Entry entry : EXPECTED_DATA_TYPES.get(type).entrySet()) {
            switch ((String) entry.getValue()) {
                case INT:
                    try {
                        int parsedInt = Integer.parseInt(userInputArray[(int) entry.getKey()]);
                        if (parsedInt <= 0) {
                            numberShouldBeGreaterThanZero();
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

    public boolean isCanvasDrawn(char[][] drawing) {
        if (drawing == null || drawing.length == 0) {
            canvasIsNotDrawn();
            return false;
        } else return true;
    }

    private void numberShouldBeGreaterThanZero() {
        System.out.println(ERROR_MESSAGE + "Number greater than 0 is expected");
        System.out.println(USER_INSTRUCTIONS);
    }

    private void numberShouldBeGreaterThanZero(String type) {
        System.out.println(ERROR_MESSAGE + type + " needs " + NO_OF_PARAMETERS.get(type) + " input parameters.");
        System.out.println(USER_INSTRUCTIONS);
    }

    private void parameterTypeIsIncorrect(String type) {
        for (Map.Entry entry : EXPECTED_DATA_TYPES.get(type).entrySet()) {
            System.out.println(ERROR_MESSAGE + type + " needs parameter " + entry.getKey() + " to be of type " + entry.getValue());
        }
        System.out.println(USER_INSTRUCTIONS);
    }

    private void canvasIsNotDrawn() {
        System.out.println(ERROR_MESSAGE + "Please draw Canvas first");
        System.out.println(USER_INSTRUCTIONS);
    }
}
