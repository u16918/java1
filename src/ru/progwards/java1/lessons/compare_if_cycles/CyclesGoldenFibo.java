package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static final double K_GOLD = 1.61803;

    public static boolean containsDigit(int number, int digit) {
        int i;
        for (i = 0; number > 0;) {
            i = number % 10;
            if (i == digit) return true;
            else {
                i = number / 10;
            }
        }
        return false;
    }
        public static int fiboNumber(int n){
            if (n == 1 || n == 2) {
                return 1;
            } else {
                return fiboNumber(n - 1) + fiboNumber(n - 2);
            }
        }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        double v = a; double n = b; double m = c;
        if (((v == n) & ((1.61703 < v / m) & (v / m < 1.61903)))) return true;
        if (((v == m) & ((1.61703 < v / n) & (v / n < 1.61903)))) return true;
        if (((m == n) & ((1.61703 < m / v) & (m / v < 1.61903)))) return true;

        else return false;
    }


    public static void main(String[] args) {
        System.out.println(containsDigit(12345, 1));
        System.out.println(isGoldenTriangle(55, 55, 34));

        int a = 0, b = 1, c;
        for (int i = 0; i <= 15; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(a);
        }
        double l = 2;
        for (double i = 1; i <= 100; i++) {
            for (l = 2; l <= 100; l++)
            if (1.61703 < (l / i) & (l / i) < 1.61903)
            System.out.println(l);
        }
    }
}

/*
Задача 3. Класс CyclesGoldenFibo
3.1 Реализовать функцию
public static boolean containsDigit(int number, int digit), которая будет возвращать true, если число number содержит цифру digit.
Теперь проведём исследование. Есть ли у Золотого треугольника связь с числами Фибоначчи. Золотой треугольник это равнобедренный
треугольник у которого ребро относится к основанию как 1.61803 (приблизительно), то есть по правилу Золотого сечения. Числа Фибоначчи
это ряд чисел 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ... в котором первые два элемента равны 1, а каждый следующий равен сумме двух
предыдущих.
Для проведения этого исследования нам придётся решить две задачи.

3.2 Реализовать, используя любой цикл, функцию
public static int fiboNumber(int n), которая будет возвращать n-ое число Фибоначчи (нумерация начинается с 1, то есть при n = 3 должно
вернуться число Фибоначчи 2, а при n = 10 число 55).

3.3 Реализовать функцию
public static boolean isGoldenTriangle(int a, int b, int c), которая будет возвращать true, если треугольник со сторонами a, b, c является
Золотым. Определим критерии. Он должен быть равнобедренным и отношение ребра к основанию должно лежать между значениями 1.61703 и 1.61903.
Далее в функции public static void main(String[] args) вывести на консоль, используя цикл, 15 первых чисел Фибоначчи. После этого, используя
 вложенные циклы, определить: есть ли среди треугольников, длины сторон которых являются натуральными числами не превышающими 100, Золотые
 треугольники. И если есть, вывести на консоль длины основания и рёбер этих треугольников.
Если всё получилось, посмотрите на консоль и сделайте вывод: есть ли связь между числами Фибоначчи и Золотыми треугольниками.
 */