package com.cs.validation;

import com.cs.print.PrintMessage;

import static com.cs.constants.AppConstants.ERROR_MESSAGE;
import static com.cs.constants.AppConstants.USER_INSTRUCTIONS;

public class BorderValidation implements PrintMessage {

    public boolean withinBorder(int x, int y, int w, int h) {
        return (x <= w && x > 0) && (y <= h && y > 0);
    }

    @Override
    public void printInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + "Invalid Input. Point is not within border");
        System.out.println(USER_INSTRUCTIONS);
    }
}
