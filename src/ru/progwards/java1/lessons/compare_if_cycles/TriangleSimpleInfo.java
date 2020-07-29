package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        if (a <= b && b < c) return c;
        if (b <= c && c < a) return a;
        if (a <= c && c < b) return b;
        else return 0;
    }
    public static int minSide(int a, int b, int c){
        if (a < b && b <= c) return a;
        if (b < c && c <= a) return b;
        if (c < a && a <= b) return c;
        else return 0;
    }
    public static boolean isEquilateralTriangle(int a, int b, int c){
        if (a == b && b == c) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(maxSide(5, 7, 9));
        System.out.println(minSide(5, 7, 9));
        System.out.println(isEquilateralTriangle(5, 5, 5));
    }
}




/*
Задача 1. Класс TriangleSimpleInfo
1.1 Реализовать функцию
public static int maxSide(int a, int b, int c), которая получает параметрами длины сторон треугольника,
а вернуть должна наибольшую длину стороны.
1.2 Реализовать функцию
public static int minSide(int a, int b, int c), которая получает параметрами длины сторон треугольника,
а вернуть должна наименьшую длину стороны.
1.3 Реализовать функцию
public static boolean isEquilateralTriangle(int a, int b, int c), которая получает параметрами длины сторон
треугольника, а вернуть должна true, если треугольник равносторонний и false в противном случае.
 */





