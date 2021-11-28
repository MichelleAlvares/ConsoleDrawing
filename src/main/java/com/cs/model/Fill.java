package com.cs.model;


public class Fill extends Shape2D {

    private Point fillStartPoint;
    private char newColour;
    private char oldColour;

    public Fill() {
    }

    public Fill(int width, int height, String type, Point fillStartPoint, char oldColour) {
        super(width, height, type);
        this.fillStartPoint = fillStartPoint;
        this.newColour = oldColour;
    }

    public Point getFillStartPoint() {
        return fillStartPoint;
    }

    public char getNewColour() {
        return newColour;
    }

    public char getOldColour() {
        return oldColour;
    }

    public void setOldColour(char oldColour) {
        this.oldColour = oldColour;
    }

    @Override
    public String toString() {
        return "BucketFill{" +
                "fillStartPoint=" + fillStartPoint +
                ", newColour=" + newColour +
                ", oldColour=" + oldColour +
                '}';
    }
}
