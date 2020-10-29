package com.university.java;

public class Matrix {

    private int[][] arr;

    public Matrix(int n, int m) {
        arr = new int[n][m];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                set(i, j, (int) (Math.random() * 3 + 1));
    }

    public Matrix(int n, int m, int val) {
        arr = new int[n][m];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                set(i, j, val);
    }

    public Matrix(int[][] a) {
        arr = a;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Matrix sumMatrix(Matrix matrix) {
        int[][] arr2 = matrix.getMatrix();
        Matrix newMatrix = new Matrix(arr.length, arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newMatrix.set(i, j, arr[i][j] + arr2[i][j]);
            }
        }
        return newMatrix;
    }

    public Matrix subMatrix(Matrix matrix) {
        int[][] arr2 = matrix.getMatrix();
        Matrix newMatrix = new Matrix(arr.length, arr[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newMatrix.set(i, j, arr[i][j] - arr2[i][j]);
            }
        }
        return newMatrix;
    }

    public void set(int i, int j, int val) {
        arr[i][j] = val;
    }

    public int get(int i, int j) {
        return arr[i][j];
    }

    public int[][] getMatrix() {
        return arr;
    }
}
