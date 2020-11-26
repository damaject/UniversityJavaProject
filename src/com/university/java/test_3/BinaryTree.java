package com.university.java.test_3;

public class BinaryTree {

    private class Node {
        private Node left, right;
        private int value;
        private Node(int value) {
            this.value = value;
            if (isPrintInfo) System.out.println("Добавлен элемент: " + value);
        }
    }

    private Node root;
    private int formatWidth;
    private boolean isPrintInfo;

    /**
     * Включение вывода информации об операциях в дереве
     */
    public void enablePrintInfo() {
        isPrintInfo = true;
    }

    /**
     * Выключение вывода информации об операциях в дереве
     */
    public void disablePrintInfo() {
        isPrintInfo = false;
    }

    /**
     * Добавление элемента
     */
    public void add(int value) {
        root = add(root, value);
    }

    /**
     * Добавление множества элементов
     */
    public void add(int... values) {
        for (int value : values) add(value);
    }

    /**
     * Удаление элемента
     */
    public void remove(int value) {
        if (isPrintInfo) System.out.println("Удаление элемента: " + value);
        root = remove(root, value);
    }

    /**
     * Удаление множества элементов
     */
    public void remove(int... values) {
        for (int value : values) remove(value);
    }

    /**
     * Удаление всех элементов
     */
    public void removeAll() {
        root = null;
        if (isPrintInfo) System.out.println("Все элементы дерева удалены");
    }

    /**
     * Поиск элемента
     */
    public boolean hasValue(int value) {
        boolean has = hasValue(root, value);
        if (isPrintInfo) System.out.println("Поиск элемента " + value + " - " + (has ? "":"НЕ ") + "найден");
        return has;
    }

    /**
     * Поиск множества элементов
     */
    public void hasValue(int... values) {
        for (int value : values) hasValue(value);
    }

    /**
     * Рассчет максимальной глубины дерева
     */
    public int maxLength() {
        int len = maxLength(root, 1);
        if (isPrintInfo) System.out.println("Максимальная глубина дерева: " + len);
        return len;
    }

    /**
     * Перегрузка метода, для ширины по умолчанию - 5
     */
    public void print() {
        print(5);
    }

    /**
     * Структурный вывод дерева в консоль
     */
    public void print(int formatWidth) {
        this.formatWidth = Math.min(formatWidth, 6);
        String emptyCell = "      ".substring(0, this.formatWidth);

        int m = maxLength();
        int n = ((int) Math.pow(2, m - 1)) * 2 - 1;

        if (root == null) {
            System.out.println("\nБинарное дерево не имеет ни одного элемента\n");
            return;
        }

        String[][] lines = new String[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                lines[i][j] = emptyCell;
            }
        }

        print(root, lines, n / 2, 0, m);

        System.out.println("\nБинарное дерево");
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(lines[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Закрытый рекурсивный метод - формирование из элементов дерева
     * строкового двумерного массива для дальнейшего вывода в консоль
     */
    private void print(Node node, String[][] lines, int i, int j, int m) {
        if (node != null) {
            lines[i][j] = formatValue(node);
            j++;
            int lineOffset = (int) Math.pow(2, m - j - 1);
            print(node.left, lines, i - lineOffset, j, m);
            print(node.right, lines, i + lineOffset, j, m);
        }
    }

    /**
     * Закрытый рекурсивный метод - реализация добавления элемента в дерево
     */
    private Node add(Node node, int value) {
        if (node == null) return new Node(value);
        if (node.value < value) node.right = add(node.right, value);
        else if (node.value > value) node.left = add(node.left, value);
        return node;
    }

    /**
     * Закрытый рекурсивный метод - реализация удаления элемента из дерева
     */
    private Node remove(Node node, int value) {
        if (node == null) return null;
        if (node.value < value) node.right = remove(node.right, value);
        else if (node.value > value) node.left = remove(node.left, value);
        else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            int minValue = searchMinValue(node.right);
            node.value = minValue;
            node.right = remove(node.right, minValue);
            return node;
        }
        return node;
    }

    /**
     * Закрытый рекурсивный метод - реализация поиска минимального значения в узле
     */
    private int searchMinValue(Node node) {
        return node.left == null ? node.value : searchMinValue(node.left);
    }

    /**
     * Закрытый рекурсивный метод - реализация поиска элемента в дереве
     */
    private boolean hasValue(Node node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        return hasValue(node.value < value ? node.right : node.left, value);
    }

    /**
     * Закрытый рекурсивный метод - реализация рассчета максимальной глубины дерева
     */
    private int maxLength(Node node, int i) {
        if (node == null) return i - 1;
        else {
            i++;
            return Math.max(maxLength(node.left, i), maxLength(node.right, i));
        }
    }

    /**
     * Метод для форматирования элемента, используется для вывода дерева в консоль
     */
    private String formatValue(Node node) {
        String value = Integer.toString(node.value);
        while (value.length() < formatWidth) value = String.format(" %s ", value);
        return value.substring(0, formatWidth);
    }
}
