package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c){
        if (a + b > c && a + c > b && c + b > a) return true;
        else return false;
    }
    public static boolean isRightTriangle(int a, int b, int c){
        if (a * a + b * b == c * c || a * a + c * c == b * b || c * c + b * b == a * a) return true;
        else return false;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        if (a == b || b == c || a == c) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isTriangle(5, 1, 4));
        System.out.println(isRightTriangle(5, 7, 9));
        System.out.println(isIsoscelesTriangle(7, 8, 9));
    }
}

/*
Задача 2. Класс TriangleInfo
2.1 Реализовать функцию
public static boolean isTriangle(int a, int b, int c), которая возвращает true, если по данным трём сторонам
 (a, b, c) можно построить треугольник. Из геометрии известно, что в треугольнике длина каждой из
 сторон меньше суммы длин двух других сторон.

2.2 Реализовать функцию
public static boolean isRightTriangle(int a, int b, int c), которая возвращает true, если треугольник
со сторонами a, b, c является прямоугольным. Из геометрии известно, что для прямоугольного треугольника
выполняется теорема Пифагора (сумма квадратов катетов равна квадрату гипотенузы).

2.3 Реализовать функцию
public static boolean isIsoscelesTriangle(int a, int b, int c), которая возвращает true, если треугольник
со сторонами a, b, c является равнобедренным. Из геометрии известно, что в равнобедренном треугольнике
есть две равные стороны.
 */