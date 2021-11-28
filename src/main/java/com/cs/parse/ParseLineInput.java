package com.cs.parse;

import com.cs.draw.DrawLine;
import com.cs.model.Line;
import com.cs.model.Shape2D;
import com.cs.util.LineUtil;
import com.cs.validation.InputParameterValidation;

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

	public boolean parseLineInput(String[] userInputArray, char[][] drawing, Shape2D shape2D) {
		boolean result = true;
		if (inputParameterValidation.isCanvasDrawn(drawing)
				&& inputParameterValidation.areCorrectNoOfParametersEntered(LINE, userInputArray)
				&& (inputParameterValidation.areParameterTypesCorrect(LINE, userInputArray))) {
			Line l = (Line) lineUtil.getShape(userInputArray, shape2D);
			result = drawLine.draw(l, drawing);
		}
		return result;
	}
}
