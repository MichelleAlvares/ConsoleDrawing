package com.cs.validation;

import com.cs.model.Canvas;
import com.cs.model.Shape2D;
import com.cs.print.PrintMessage;

import static com.cs.constants.AppConstants.*;

public class CanvasValidation implements Validation, PrintMessage {

    @Override
    public boolean valid(Shape2D shape2D) {
        Canvas canvas = (Canvas) shape2D;
        return CANVAS.equals(canvas.getType()) && (shape2D.getWidth() > 0) && (shape2D.getHeight() > 0);
    }

    @Override
    public void printInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + "Invalid Input. Canvas cannot be drawn. Dimensions should be greater than 0.");
        System.out.println(USER_INSTRUCTIONS);
    }
}
