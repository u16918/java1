package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

import static ru.progwards.java1.lessons.interfaces.CompareWeight.CompareResult.*;

public class Food implements CompareWeight{
    private int weight;
    public Food(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (getB > weight) return LESS;
        if (getB == weight) return EQUAL;
        if (getB < weight) return GREATER;
        return null;
    }

    public static <compareWeight> void sort(compareWeight[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length;j++) {
                if (a[i] != a[j]) {
                    compareWeight m = (compareWeight) a[j];
                    a[j] = a[i];
                    a[i] = m;
                }
            }
        }
    }
    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Food[]{new Food(23)}));
    }
}
