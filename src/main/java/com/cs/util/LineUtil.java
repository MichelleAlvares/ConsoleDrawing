package com.cs.util;

import com.cs.model.Line;
import com.cs.model.Point;
import com.cs.model.Shape2D;

import static com.cs.constants.AppConstants.LINE;

public class LineUtil implements GetShape {

    @Override
    public Shape2D getShape(String[] userInputArray, Shape2D shape2D) {
        return new Line(shape2D.getWidth(), shape2D.getHeight(), LINE, new Point(Integer.parseInt(userInputArray[1]),
                Integer.parseInt(userInputArray[2])), new Point(Integer.parseInt(userInputArray[3]),
                Integer.parseInt(userInputArray[4])));
    }
}
