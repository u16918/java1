package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value){

        int summ = 0;
        byte b = value;
        for (int i = 0; i <= 7; i++) {
            summ += b >> i & 1;

        }

        return summ;
    }

    public static void main(String[] args) {
        System.out.println(sumBits((byte) 0b0100101));
    }
}

/*
Задача 1. Класс SumBits
1.1 Реализовать функцию public static int sumBits(byte value), которая суммирует все биты параметра value.
Например, для двоичного числа 0100101 функция должна вернуть 3.

Подсказки:
используйте & с числом 1 для того, чтобы оставить только один правый значащий бит;
используйте сдвиг вправо для того, чтобы проверить следующий бит.
 */
