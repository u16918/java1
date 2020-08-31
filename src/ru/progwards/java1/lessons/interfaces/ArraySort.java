package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {
    public static <compareWeight> void sort(compareWeight[] a) {
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - i - 1; j++)
                if (!a[j].equals(a[j + 1])) {
                    compareWeight temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
        }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Animal[]{new Animal(200.5), new Animal(10.3), new Animal(300.0)}));

    }
}

