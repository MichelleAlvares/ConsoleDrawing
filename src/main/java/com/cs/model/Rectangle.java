package com.cs.model;


public class Rectangle extends Shape2D {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle() {
    }

    public Rectangle(int width, int height, String type, Point topLeft, Point bottomRight) {
        super(width, height, type);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @Override
    public String toString() {
        return "RectangleCopy{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }
}
