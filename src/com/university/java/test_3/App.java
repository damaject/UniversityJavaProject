package com.university.java.test_3;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("\nДавыдов Максим Сергеевич ПИ19-1в");
        Scanner scanner = new Scanner(System.in);



        System.out.println("\n\n - - - - - Задание 1 - - - - - ");
        System.out.print("Вывести все числа от 1 до n.\nВведите n: ");
        int n = scanner.nextInt();
        outNumbers(1, n);



        System.out.println("\n\n\n - - - - - Задание 2 - - - - - ");
        System.out.print("Проверить вхождение элемента в массив двумя способами.\nВведите размер массива: ");
        n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = (int) (Math.random() * 100 + 1);
        System.out.println("Сгенерированный массив:\n" + Arrays.toString(arr));

        System.out.print("\nВведите искомый элемент: ");
        int x = scanner.nextInt();

        System.out.println("\nПоиск методом перебора");
        long time = System.nanoTime();
        int index = findItemInArray1(x, arr, 0);
        time = System.nanoTime() - time;
        System.out.println("Элемент " + x + (index == -1 ? " не найден" : " найден, индекс: " + index));
        System.out.println("Прошло " + time + " наносекунд");

        System.out.println("\nПоиск бинарным методом");
        Arrays.sort(arr);
        System.out.println("Отсортированный массив:\n" + Arrays.toString(arr));
        time = System.nanoTime();
        index = findItemInArray2(x, arr, 0, arr.length - 1);
        time = System.nanoTime() - time;
        System.out.println("Элемент " + x + (index == -1 ? " не найден" : " найден, индекс: " + index));
        System.out.println("Прошло " + time + " наносекунд");



        System.out.println("\n\n - - - - - Задание 3 - - - - - ");
        System.out.println("Найти корень уравнения");
        double fx = findFx(0, 10, 0.001);
        System.out.printf("Корень равен: %.5f\n", fx);
        System.out.printf("Значение уравнения: %.5f\n", f(fx));



        System.out.println("\n\n - - - - - Задание 4 - - - - - ");
        System.out.println("Реализовать бинарное дерево поиска");
        BinaryTree tree = new BinaryTree();
        tree.enablePrintInfo();
        tree.add(20);
        tree.add(10);
        tree.add(30);
        tree.print(3);
        tree.add(5, 15, 25, 35, 32, 17, 21, 3, 28, 39, 7, 14);
        tree.hasValue(5);
        tree.hasValue(8);
        tree.hasValue(40, 28, 7);
        tree.print(3);
        tree.remove(5, 14, 30);
        tree.print(3);
        tree.removeAll();
        tree.print();
        tree.add(100, 80, 150, 200, 140);
        tree.print(5);
    }


    /**
     * Статический рекурсивный метод для вывода чисел от i до n
     */
    private static void outNumbers(int i, int n) {
        System.out.print(i + " ");
        if (i < n) outNumbers(i + 1, n);
    }


    /**
     * Статический рекурсивный метод для поиска элемента в массиве методом перебора.
     * Возвращает индекс элемента или -1 в случае его отсутствия
     */
    private static int findItemInArray1(int x, int[] array, int i) {
        if (i >= array.length) return -1;
        else if (array[i] == x) return i;
        else return findItemInArray1(x, array, i + 1);
    }


    /**
     * Статический рекурсивный метод для поиска элемента в массиве бинарным методом.
     * Возвращает индекс элемента или -1 в случае его отсутствия
     */
    private static int findItemInArray2(int x, int[] array, int left, int right) {
        int center = (left + right) / 2;
        int value = array[center];
        if (value == x) return center;

        if (value > x) right = center - 1;
        else left = center + 1;

        if (left > right) return -1;

        return findItemInArray2(x, array, left, right);
    }


    /**
     * Статический метод функции уравнения
     */
    private static double f(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    /**
     * Статический рекурсивный метод для поиска корня уравнения
     */
    private static double findFx(double a, double b, double eps) {
        double x = (a + b) / 2;
        if (f(a) * f(x) < 0) b = x;
        else a = x;
        if (Math.abs(b - a) > eps) return findFx(a, b, eps);
        return x;
    }
}
