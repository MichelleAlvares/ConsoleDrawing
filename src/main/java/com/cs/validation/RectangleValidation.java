package com.cs.validation;

import com.cs.model.Rectangle;
import com.cs.model.Shape2D;
import com.cs.print.PrintMessage;

import static com.cs.constants.AppConstants.*;

public class RectangleValidation implements Validation, PrintMessage {

    @Override
    public boolean valid(Shape2D shape2D) {
        Rectangle rectangle = (Rectangle) shape2D;
        //x1,y1 should be the top left corner and x2,y2 the bottom right corner
        return RECTANGLE.equals(rectangle.getType()) && ((rectangle.getTopLeft().getX() < rectangle.getBottomRight().getX()) && (rectangle.getTopLeft().getY() < rectangle.getBottomRight().getY()));
    }

    @Override
    public void printInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + "Invalid Input. Rectangle cannot be drawn. First point should be the top left corner and the second point should be the bottom right corner");
        System.out.println(USER_INSTRUCTIONS);
    }
}
