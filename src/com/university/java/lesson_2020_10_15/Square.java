package com.university.java.lesson_2020_10_15;

public class Square extends Figure {

    public Square(int width, int height, int length) {
        super(width, height, length);
    }

    public double getArea(int h) {
        return h * h;
    }

}
