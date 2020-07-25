package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public  static final double PI = 3.14;
    public  static final double R_EARFH = 6371.2;
    public  static final double R_MERCURY = 2439.7;
    public  static final double R_JUPITER = 71492.0;

    public static Double sphereSquare(Double r){
        double S = 4 * (PI) * r * r;
            return S;
    }
    public static Double earthSquare(){
        double se = sphereSquare(R_EARFH);
        return se;
    }
    public static Double mercurySquare(){
        double sm = sphereSquare(R_MERCURY);
        return sm;
    }
    public static Double jupiterSquare(){
        double sj = sphereSquare(R_JUPITER);
        return sj;
    }
    public static Double earthVsMercury(){
        double l =earthSquare() / mercurySquare();
        return l;
    }
    public static Double earthVsJupiter(){
        double l =earthSquare() / jupiterSquare();
        return l;
    }

    public static void main(String[] args) {
        System.out.println(sphereSquare(R_EARFH));
        System.out.println(earthSquare());
        System.out.println(mercurySquare());
        System.out.println(jupiterSquare());
        System.out.println(earthVsMercury());
        System.out.println(earthVsJupiter());
    }
}
/*В этой задаче нужно будет реализовать функции, вычисляющих разные астрономические величины. Во всех функциях, где это необходимо,
считаем число π = 3.14

2.1 Реализовать функцию public static Double sphereSquare(Double r), которая вычисляет площадь поверхности сферы
радиуса R по формуле S = 4πR2.

2.2 Реализовать функцию public static Double earthSquare(), которая вычисляет площадь поверхности Земли,
считая радиус равным 6 371.2 км и используют функцию sphereSquare

2.3 Реализовать функцию public static Double mercurySquare(), которая вычисляет площадь поверхности Меркурия,
считая радиус равным 2 439,7 км  и используют функцию sphereSquare

2.4 Реализовать функцию public static Double jupiterSquare(), которая вычисляет площадь поверхности Юпитера,
считая радиус равным 71 492 км  и используют функцию sphereSquare

2.5 Реализовать функцию public static Double earthVsMercury(), которая вычисляет отношение площади поверхности Земли
к площади поверхности Меркурия используя готовые функции площадей планет

2.6 Реализовать функцию
public static Double earthVsJupiter(), которая вычисляет отношение площади поверхности Земли к площади поверхности Юпитера
используя готовые функции площадей планет
*/