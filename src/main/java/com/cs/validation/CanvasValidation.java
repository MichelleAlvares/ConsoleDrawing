package com.cs.validation;

import com.cs.model.Canvas;
import com.cs.model.Shape2D;
import com.cs.print.PrintMessage;

import static com.cs.constants.AppConstants.*;
import static com.cs.constants.AppConstants.ErrorMessage.*;

public class CanvasValidation implements Validation, PrintMessage {

    @Override
    public boolean valid(Shape2D shape2D) {
        Canvas canvas = (Canvas) shape2D;
        return CANVAS.equals(canvas.getType()) && (shape2D.getWidth() > 0) && (shape2D.getHeight() > 0);
    }

    @Override
    public void printInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + CANVAS_VALIDATION_FAILED_MESSAGE);
        System.out.println(USER_INSTRUCTIONS);
    }
}
