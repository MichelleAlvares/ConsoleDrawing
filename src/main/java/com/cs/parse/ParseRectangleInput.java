package com.cs.parse;

import com.cs.draw.DrawRectangle;
import com.cs.model.Rectangle;
import com.cs.model.Shape2D;
import com.cs.util.RectangleUtil;
import com.cs.validation.InputParameterValidation;

import static com.cs.constants.AppConstants.RECTANGLE;

public class ParseRectangleInput {

    private InputParameterValidation inputParameterValidation;
    private RectangleUtil rectangleUtil;
    private DrawRectangle drawRectangle;

    public ParseRectangleInput() {
        this.inputParameterValidation = new InputParameterValidation();
        this.rectangleUtil = new RectangleUtil();
        this.drawRectangle = new DrawRectangle();
    }

    public void parseRectangleInput(String[] userInputArray, char[][] drawing, Shape2D shape2D) {
        if (inputParameterValidation.isCanvasDrawn(drawing)
                && inputParameterValidation.areCorrectNoOfParametersEntered(RECTANGLE, userInputArray)
                && inputParameterValidation.areParameterTypesCorrect(RECTANGLE, userInputArray)) {
            Rectangle r = (Rectangle) rectangleUtil.getShape(userInputArray, shape2D);
            drawRectangle.draw(r, drawing);
        }
    }
}
