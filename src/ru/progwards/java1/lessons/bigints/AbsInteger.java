package ru.progwards.java1.lessons.bigints;

import java.io.*;
import java.util.Scanner;

public class AbsInteger {
    int numer;

    public String toString() {
        return Integer.toString(numer);
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        IntInteger n1 = new IntInteger(Integer.parseInt(num1.toString()));
        IntInteger n2 = new IntInteger(Integer.parseInt(num2.toString()));
        IntInteger result = n1.add(n2);

        if (result.numer < Byte.MAX_VALUE && result.numer > Byte.MIN_VALUE) {
            return new ByteInteger((byte) result.numer);
        }
        if (result.numer < Short.MAX_VALUE && result.numer > Short.MIN_VALUE) {
            return new ShortInteger((short) result.numer);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        IntInteger a1 = new IntInteger(15);
        ByteInteger a2 = new ByteInteger((byte) 25);
        ShortInteger a3 = new ShortInteger((short) 35);

        System.out.println(add(a1, a2));
        System.out.println(add(a1, a3));
        System.out.println(add(a2, a3));

        AbsInteger nid = new AbsInteger();

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