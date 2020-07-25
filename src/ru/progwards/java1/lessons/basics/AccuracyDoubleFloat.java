package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public  static final double PI = 3.14;
    public  static final double R_EARFH = 6371.2;
    public  static final float PI_F = 3.14f;
    public  static final float R_EARFH_F = 6371.2f;

    public static double volumeBallDouble(double radius){
        double Sd = (4 * (PI) * radius * radius * radius) / 3;
        return Sd;
    }
    public static float volumeBallFloat(float radius){
        float Sf = (4 * (PI_F) * radius * radius * radius) / 3;
        return Sf;
    }
    public static double calculateAccuracy(double radius){
        double n = volumeBallDouble(radius);
        double m = (double) volumeBallFloat((float) radius);
        return n - m;
    }

    public static void main(String[] args) {
        System.out.println(volumeBallDouble(R_EARFH));
        System.out.println(calculateAccuracy(1));
    }

}
/*
Проведём простое исследование типов double и float на разницу в точности. Посчитаем объём земли в кубических километрах двумя сходными функциями. Одна из них будет основана на типе double, а вторая на менее точном типе float. После чего мы сможем узнать разницу между этими значениями в кубических километрах. Радиус земли R будем считать равным 6371.2 км (для проверки работы методов используйте это значение), а число π возьмём равным 3.14
Формула объёма шара 4/3πR3. Для решения задачи следует.
3.1 Реализовать функцию
public static double volumeBallDouble(double radius), которая будет возвращать объём шара с радиусом radius и основана на типе double.
3.2 Реализовать функцию
public static float volumeBallFloat(float radius), которая будет возвращать объём шара с радиусом radius и основана на типе float.
3.3 Реализовать функцию
public static double calculateAccuracy(double radius), которая будет возвращать разницу между функциями volumeBallDouble и volumeBallFloat
 (они должны быть вызваны из неё с параметром radius).

Подсказки:
вспомните, каким символом заканчиваются константы типа float в Java;
в функции calculateAccuracy для получения значения типа float из параметра типа double используйте конструкцию: (float) radius;
после создания функций для вычисления объёма проверьте результат на радиусе равном 1, если функция вернёт Pi, то думайте... .

 */