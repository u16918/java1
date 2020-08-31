package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {
    public static <compareWeight> void sort(compareWeight[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length;j++) {
                if (a[i] != a[j]) {
                    compareWeight m = a[j];
                    a[j] = a[i];
                    a[i] = m;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

