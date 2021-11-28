package com.cs.parse;

import com.cs.draw.DrawCanvas;
import com.cs.model.Canvas;
import com.cs.model.Shape2D;
import com.cs.util.CanvasUtil;
import com.cs.validation.InputParameterValidation;

import static com.cs.constants.AppConstants.CANVAS;

public class ParseCanvasInput {

    private InputParameterValidation inputParameterValidation;
    private CanvasUtil canvasUtil;
    private DrawCanvas drawCanvas;

    public ParseCanvasInput() {
        this.inputParameterValidation = new InputParameterValidation();
        this.canvasUtil = new CanvasUtil();
        this.drawCanvas = new DrawCanvas();
    }

    public boolean parseCanvas(String[] userInputArray, Shape2D shape2D,char[][] drawing) {
    	boolean res = inputParameterValidation.validate();
        if (res) {
            Canvas c = (Canvas) canvasUtil.getShape(userInputArray, shape2D);
             drawing = new char[c.getHeight() + 2][c.getWidth() + 2];
            drawCanvas.draw(c, drawing);
        } 
        return res;
    }
}
