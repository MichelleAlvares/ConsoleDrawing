package com.cs.validation;

import com.cs.model.Line;
import com.cs.model.Shape2D;
import com.cs.print.DisplayMessage;

import static com.cs.constants.AppConstants.*;
import static com.cs.constants.AppConstants.ErrorMessage.*;

public class LineValidation implements Validation, DisplayMessage {

    @Override
    public boolean valid(Shape2D shape2D) {
        Line line = (Line) shape2D;
        //in  a line either x vertices or y vertices have to be the same. Assuming its a straight line.
        return (line.getType().equals(LINE)) && (line.getLeftPoint().getX() == line.getRightPoint().getX() || line.getLeftPoint().getY() == line.getRightPoint().getY());
    }

    @Override
    public void displayInvalidInputMessage() {
        System.out.println(ERROR_MESSAGE + HORIZONTAL_VERTICAL_LINE_VALIDATION_FAILED_MESSAGE);
        System.out.println(USER_INSTRUCTIONS);
    }
}
