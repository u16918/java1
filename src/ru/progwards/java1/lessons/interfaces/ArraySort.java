package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;
import java.util.Collections;
import static ru.progwards.java1.lessons.interfaces.CompareWeight.CompareResult.*;

public class ArraySort {

    public static void sort(CompareWeight[] a) {
        CompareWeight resalt;
        for (int i=0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i].compareWeight(a[j]) == CompareWeight.CompareResult.GREATER) {
                    resalt = a[i];
                    a[i] = a[j];
                    a[j] = resalt;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

