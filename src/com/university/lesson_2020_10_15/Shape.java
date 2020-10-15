package com.university.lesson_2020_10_15;

public abstract class Shape {

    private int width;
    private int height;
    private int length;

    public Shape() {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public abstract double getArea();
}
