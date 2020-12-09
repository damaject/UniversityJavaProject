package com.university.java.lesson_2020_11_26;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь исходного файла: ");
        String fileIn = scanner.next();

        System.out.println("Куда копировать: ");
        String fileOut = scanner.next();

        StringBuilder builder = new StringBuilder();

        try {
            FileReader fr = new FileReader(new File(fileIn));
            Scanner fScan = new Scanner(fr);
            while (fScan.hasNextLine()) builder.append(fScan.nextLine());
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(builder.toString());

//        FileWriter fw = new FileWriter(fileOut);
//        fw.close();
    }

}
