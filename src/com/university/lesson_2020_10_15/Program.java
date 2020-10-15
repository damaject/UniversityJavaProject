package com.university.lesson_2020_10_15;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("Hello");

        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int length = scanner.nextInt();

        Triangle t = new Triangle(width, height, length);
        System.out.println("Периметр " + t.getPerimeter());
    }
}
