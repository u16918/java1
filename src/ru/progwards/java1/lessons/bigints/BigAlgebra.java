package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigAlgebra {
    public static BigDecimal fastPow(BigDecimal num, int pow) {
        if (pow >= 0) {
            BigDecimal res = num.pow(pow);
            return res;
        }
        if ( pow < 0) {
            BigDecimal res = BigDecimal.ONE.divide(num.pow(pow*(-1)), 5, RoundingMode. HALF_UP);
            return res;
        }
        return num;
    }
    public static BigInteger fibonacci(int n){
        BigInteger[] fib = new BigInteger[n+1];
        fib[0] = BigInteger.valueOf(0);
        fib[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= n ; i++) {
            fib[i] = fib[i-1].add(fib[i-2]);
            //return fib[n];
        }

        return fib[n];
    }
        public static void main (String[]args){

            System.out.println(fastPow(BigDecimal.valueOf(2), -1));
            System.out.println(fibonacci(100));
        }

}
/*
Задача 1. Класс BigAlgebra
Реализовать класс BigAlgebra, содержащий следующие статические методы:

1.1 Метод BigDecimal fastPow(BigDecimal num, int pow)
Реализовать алгоритм быстрого возведения в степень pow числа num в BigDecimal,
описание алгоритма можно прочитать например в Википедии


1.2 Метод BigInteger fibonacci(int n)
Реализовать алгоритм вычисления n-го числа фибоначчи в BigInteger. Последовательность чисел Фибоначчи, это когда каждое последующее число равно сумме двух предыдущих чисел. Первые 2 числа последовательности 1, 1. Итого получаем 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 и т.д.
 */

