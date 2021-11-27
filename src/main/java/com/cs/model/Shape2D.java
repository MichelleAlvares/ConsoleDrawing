package com.cs.model;

public class Shape2D {

    private int width;
    private int height;
    private String type;

    public Shape2D() {
    }

    Shape2D(int width, int height, String type) {
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "width=" + width +
                ", height=" + height +
                ", type='" + type + '\'' +
                '}';
    }
}
