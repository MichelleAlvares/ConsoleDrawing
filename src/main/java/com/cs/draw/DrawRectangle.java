package com.cs.draw;

import com.cs.model.Line;
import com.cs.model.Point;
import com.cs.model.Rectangle;
import com.cs.model.Shape2D;
import com.cs.validation.BorderValidation;
import com.cs.validation.RectangleValidation;

import static com.cs.constants.AppConstants.LINE;

public class DrawRectangle implements Draw {

    private RectangleValidation rectangleValidation;
    private BorderValidation borderValidation;
    private DrawLine drawLine;

    public DrawRectangle() {
        this.rectangleValidation = new RectangleValidation();
        this.borderValidation = new BorderValidation();
        this.drawLine = new DrawLine();
    }

    @Override
    public void draw(Shape2D rectangle, char[][] drawing) {
        Rectangle r = (Rectangle) rectangle;
        int x1 = r.getTopLeft().getX();
        int y1 = r.getTopLeft().getY();
        int x2 = r.getBottomRight().getX();
        int y2 = r.getBottomRight().getY();
        int h = r.getHeight();
        int w = r.getWidth();

        if (rectangleValidation.valid(r)) {
            if (borderValidation.withinBorder(x1, y1, w, h)
                    && borderValidation.withinBorder(x2, y2, w, h)) {

                drawLine.draw(new Line(w, h, LINE, new Point(x1, y1), new Point(x2, y1)), drawing);
                drawLine.draw(new Line(w, h, LINE, new Point(x1, y1), new Point(x1, y2)), drawing);
                drawLine.draw(new Line(w, h, LINE, new Point(x1, y2), new Point(x2, y2)), drawing);
                drawLine.draw(new Line(w, h, LINE, new Point(x2, y1), new Point(x2, y2)), drawing);
            } else borderValidation.displayInvalidInputMessage();
        } else rectangleValidation.displayInvalidInputMessage();
    }
}
