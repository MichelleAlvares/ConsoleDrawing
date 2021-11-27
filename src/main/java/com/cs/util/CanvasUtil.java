package com.cs.util;

import com.cs.model.Canvas;
import com.cs.model.Shape2D;

import static com.cs.constants.AppConstants.CANVAS;

public class CanvasUtil implements GetShape {

    @Override
    public Shape2D getShape(String[] userInputArray, Shape2D shape2D) {
        shape2D.setWidth(Integer.parseInt(userInputArray[1]));
        shape2D.setHeight(Integer.parseInt(userInputArray[2]));
        return new Canvas(shape2D.getWidth(), shape2D.getHeight(), CANVAS);
    }
}
