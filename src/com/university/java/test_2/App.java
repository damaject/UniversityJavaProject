package com.university.java.test_2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Давыдов Максим Сергеевич ПИ19-1в");

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите размер Words: ");

        int wordsLength;

        // Обработка ошибки ввода
        try {
            wordsLength = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Вы ввели не целое число, а что то другое...");
            return;
        }

        if (wordsLength < 0) {
            System.out.println("Вы ввели отрицательное число...");
            return;
        }

        Words words = new Words(wordsLength);
        words.fill(scan);
        words.print();

        System.out.println("\nНачинаются ли все слова массива символом,\nкоторым заканчиваются предыдущие: "
                + (words.check() ? "Да" : "Нет"));
    }

}
