package com.university.java.lesson_2020_10_15;

public class Triangle extends Figure {

    public Triangle(int width, int height, int length) {
        super(width, height, length);
    }

    public int getPerimeter() {
        return getWidth() + getHeight() + getLength();
    }
}
