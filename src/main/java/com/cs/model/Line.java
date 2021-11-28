package com.cs.model;


public class Line extends Shape2D {

    private Point leftPoint;
    private Point rightPoint;

    public Line() {
    }

    public Line(int width, int height, String type, Point leftPoint, Point rightPoint) {
        super(width, height, type);
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public Point getLeftPoint() {
        return leftPoint;
    }

    public Point getRightPoint() {
        return rightPoint;
    }

    @Override
    public String toString() {
        return "LineCopy{" +
                "point1=" + leftPoint +
                ", point2=" + rightPoint +
                '}';
    }
}
