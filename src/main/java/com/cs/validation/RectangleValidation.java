package com.cs.validation;

import com.cs.model.Rectangle;
import com.cs.model.Shape2D;
import com.cs.print.DisplayMessage;

import static com.cs.constants.AppConstants.*;
import static com.cs.constants.AppConstants.ErrorMessage.*;

public class RectangleValidation implements Validation, DisplayMessage {

    @Override
    public boolean valid(Shape2D shape2D) {
        Rectangle rectangle = (Rectangle) shape2D;
        //x1,y1 should be the top left corner and x2,y2 the bottom right corner
        return RECTANGLE.equals(rectangle.getType()) && ((rectangle.getTopLeft().getX() < rectangle.getBottomRight().getX()) && (rectangle.getTopLeft().getY() < rectangle.getBottomRight().getY()));
    }

    @Override
    public void displayInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + RECTANGLE_VALIDATION_FAILED_MESSAGE);
        System.out.println(USER_INSTRUCTIONS);
    }
}
