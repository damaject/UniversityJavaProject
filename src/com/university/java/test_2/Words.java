package com.university.java.test_2;

import java.util.Scanner;

public class Words {

    private String[] strings;

    public Words(int length) {
        strings = new String[length];
    }

    public void fill(Scanner scan) { // Метод ввода массива
        System.out.println("\nВвод списка Words");

        for (int i = 0; i < strings.length; i++) {
            System.out.print("Введите слово " + (i + 1) + ": ");
            strings[i] = scan.next();
        }
    }

    public void print() { // Метод вывода массива
        System.out.println("\nВывод списка Words");

        for (int i = 0; i < strings.length; i++) {
            System.out.println((i + 1) + ". " + strings[i]);
        }
    }

    public boolean check() { // Метод проверки массива на условие
        for (int i = 1; i < strings.length; i++) { // Цикл начинаем не с 0, потому что надо проверять с предыдущим

            char firstChar = strings[i].toLowerCase().charAt(0);
            char lastChar = strings[i - 1].toLowerCase().charAt(strings[i - 1].length() - 1);

            if (firstChar != lastChar) return false;
        }

        return true;
    }
}
