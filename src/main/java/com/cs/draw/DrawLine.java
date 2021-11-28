package com.cs.draw;

import com.cs.model.Line;
import com.cs.model.Shape2D;
import com.cs.validation.BorderValidation;
import com.cs.validation.LineValidation;

import static com.cs.constants.AppConstants.X;

public class DrawLine implements Draw {

	private LineValidation lineValidation;
	private BorderValidation borderValidation;

	public DrawLine() {
		this.lineValidation = new LineValidation();
		this.borderValidation = new BorderValidation();
	}

	@Override
	public boolean draw(Shape2D line, char[][] currentState) {
		Line l = (Line) line;
		int x1 = l.getLeftPoint().getX();
		int y1 = l.getLeftPoint().getY();
		int x2 = l.getRightPoint().getX();
		int y2 = l.getRightPoint().getY();
		int w = l.getWidth();
		int h = l.getHeight();
		boolean result = lineValidation.valid(l);
		if (result) {
			if (borderValidation.withinBorder(x1, y1, w, h) && borderValidation.withinBorder(x2, y2, w, h)) {

				if (x1 != x2) {
					for (int i = x1; i <= x2; i++) {
						currentState[y1][i] = X;
					}
				} else {
					for (int i = y1; i <= y2; i++) {
						currentState[i][x1] = X;
					}
				}
			} else {
				borderValidation.printInvalidInputMessage();
				result = false;
			}
			;
		} else {
			lineValidation.printInvalidInputMessage();
			result = false;
		}
		return result;
	}
}
