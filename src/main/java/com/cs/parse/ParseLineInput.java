package com.cs.parse;

import com.cs.draw.DrawLine;
import com.cs.model.Line;
import com.cs.model.Shape2D;
import com.cs.util.LineUtil;
import com.cs.validation.InputParameterValidation;

import static com.cs.constants.AppConstants.BUCKET_FILL;
import static com.cs.constants.AppConstants.LINE;

public class ParseLineInput {

    private InputParameterValidation inputParameterValidation;
    private LineUtil lineUtil;
    private DrawLine drawLine;

    public ParseLineInput() {
        this.inputParameterValidation = new InputParameterValidation();
        this.lineUtil = new LineUtil();
        this.drawLine = new DrawLine();
    }

    public void parseLineInput(String[] userInputArray, char[][] drawing, Shape2D shape2D) {
        if (inputParameterValidation.inputParameterValidation(LINE, drawing, userInputArray)) {
            Line l = (Line) lineUtil.getShape(userInputArray, shape2D);
            drawLine.draw(l, drawing);
        }
    }
}
