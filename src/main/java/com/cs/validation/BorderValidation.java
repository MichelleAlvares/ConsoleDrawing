package com.cs.validation;

import com.cs.print.DisplayMessage;

import static com.cs.constants.AppConstants.ErrorMessage.*;
import static com.cs.constants.AppConstants.USER_INSTRUCTIONS;

public class BorderValidation implements DisplayMessage {

    public boolean withinBorder(int x, int y, int w, int h) {
        return (x <= w && x > 0) && (y <= h && y > 0);
    }

    @Override
    public void displayInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + BORDER_VALIDATION_FAILED_MESSAGE);
        System.out.println(USER_INSTRUCTIONS);
    }
}
