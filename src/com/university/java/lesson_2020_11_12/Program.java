package com.university.java.lesson_2020_11_12;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        numbers.remove((Object)5);

        for(int i : numbers) System.out.println(i);
    }

}
