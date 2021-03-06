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
    public void draw(Shape2D canvas, char[][] drawing) {
        if (canvasValidation.valid(canvas)) {
            int w = canvas.getWidth();
            int h = canvas.getHeight();
            w += 2;

            //i iterates along the y axis
            for (int i = 0; i <= h + 1; i++) {
                //j iterates along the x axis
                for (int j = 0; j < w; j++) {
                    if (i == 0 || i == h + 1) {
                        drawing[i][j] = DASH;
                    } else if (j == 0 || j == w - 1) {
                        drawing[i][j] = PIPE;
                    } else {
                        drawing[i][j] = SPACE;
                    }
                }
            }
        } else canvasValidation.displayInvalidInputMessage();
    }
}
