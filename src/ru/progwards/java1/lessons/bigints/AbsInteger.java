package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class AbsInteger {
    int number;

    public String toString() {
        return Integer.toString(number);
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {

        IntInteger n1 = new IntInteger(Integer.parseInt(num1.toString()));
        IntInteger n2 = new IntInteger(Integer.parseInt(num2.toString()));
        return n1.add(n2);

    }

    public static void main(String[] args) {
        IntInteger a1 = new IntInteger( 5);
        ByteInteger a2 = new ByteInteger((byte)55);
        ShortInteger a3 = new ShortInteger((short)66);

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println(add(a1, a2));
        System.out.println(add(a1, a3));
    }
}

/*
Задача 2. Класс AbsInteger и потомки

2.1 Реализовать класс AbsInteger - абстрактное целое число

2.2 Реализовать потомков ByteInteger, ShortInteger, IntInteger, хранящих значение целого числа соответствующего типа.
 У каждого типа реализовать конструктор, принимающей значение числа соответствующего типа,
 для ByteInteger - byte, ShortInteger - short и IntInteger - int. Реализовать унаследованные публичные методы String toString(),
 посредством которых возвращать приведенное к строке значение соответствующего классу типа.

2.3 У класса AbsInteger реализовать метод static AbsInteger add(AbsInteger num1, AbsInteger num2) -
который вычисляет сумму num1 и num2. При этом надо учесть, что num1 и num2 могут быть разных типов. Для того,
чтобы это реализовать продумать, какие дополнительные методы нужно сделать у AbsInteger и его потомков.

Привести результат к наиболее подходящему типу, т.е. -128..127 это ByteInteger и т.д.
 */