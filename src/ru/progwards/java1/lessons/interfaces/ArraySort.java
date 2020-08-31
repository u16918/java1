package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {
    public static <compareWeight> void sort(compareWeight[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length - i - 1;j++) {
                if (a[j] != a[j+1]) {
                    compareWeight m = a[j];
                    a[j] = a[j+1];
                    a[j+1] = m;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Animal[]{new Animal(200.5), new Animal(10.3), new Animal(300.0)}));

    }
}

