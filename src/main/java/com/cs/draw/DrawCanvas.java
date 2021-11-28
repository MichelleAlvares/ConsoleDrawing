package com.cs.draw;

import com.cs.model.Shape2D;
import com.cs.validation.CanvasValidation;

import static com.cs.constants.AppConstants.*;

public class DrawCanvas implements Draw {

	private CanvasValidation canvasValidation;

	public DrawCanvas() {
		this.canvasValidation = new CanvasValidation();
	}

	@Override
	public boolean draw(Shape2D canvas, char[][] currentState) {
		boolean result = canvasValidation.valid(canvas);
		if (result) {
			int w = canvas.getWidth();
			int h = canvas.getHeight();
			w += 2;
			

			// i iterates along the y axis
			for (int i = 0; i <= h + 1; i++) {
				// j iterates along the x axis
				for (int j = 0; j < w; j++) {
					if (i == 0 || i == h + 1) {
						currentState[i][j] = DASH;
					} else if (j == 0 || j == w - 1) {
						currentState[i][j] = PIPE;
					} else {
						currentState[i][j] = SPACE;
					}
				}
			}
		} else {
			canvasValidation.printInvalidInputMessage();
			result = false;
		}
		return result;
	}
}
