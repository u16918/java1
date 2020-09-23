package ru.progwards.java1.lessons.io1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            int num = 0;
            String scan;
            while (scanner.hasNextLine()) {
                scan = scanner.nextLine();
                    if (scan.isEmpty()) {
                        num++;
                    }
                }
                reader.close();
                scanner.close();
            return num;
            }catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(calcEmpty("C:\\Users\\Alex\\Documents\\file.txt"));
    }
}
/*
Задача 1. Класс LineCount
Создать статический метод public static int calcEmpty(String fileName),
в котором посчитать количество пустых строк в файле. В случае возникновения ошибок, вернуть -1
 */