package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Creator {
    public static Collection<Integer> fillEven(int n){
        Collection<Integer> num = new ArrayList();
        for (int i = 1; i <= n; i++) {
            num.add(i * 2);
        }
        return num;
    }
    public static Collection<Integer> fillOdd(int n){
        Collection<Integer> num1 = new ArrayList();
        for (int i = n; i >= 1; i--) {
            num1.add(i * 2 - 1);
        }
        return num1;
    }
    public static Collection<Integer> fill3(int n){
        Collection<Integer> num2 = new ArrayList();
        int m;
        for (int i = 0; i < n; i++) {
            m = i * 3;
            num2.add(m);
            num2.add(m * m);
            num2.add(m * m * m);
        }
        return num2;
    }
    public static void main(String[] args) {
        Collection<Integer> res = fillEven(-1);
        for (Integer i : res) {
            System.out.println(i);
        }

        res = fillOdd(0);
        for (Integer i : res) {
            System.out.println(i);
        }

        res = fill3(3);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
/*
Задача 1, класс Creator
1.1 Реализовать метод
public static Collection<Integer> fillEven(int n)
- создать коллекцию и заполнить последовательностью четных возрастающих чисел начиная с 2,
 количество элементов в коллекции n

1.2 Реализовать метод
public static Collection<Integer> fillOdd(int n)
 - создать коллекцию и заполнить последовательностью нечетных убывающих чисел,
  минимальное число в коллекции 1, количество элементов в коллекции n

1.3 Реализовать метод
public static Collection<Integer> fill3(int n)
 - создать коллекцию и заполнить ее тройками чисел.
 Каждая тройка создается по алгоритму: первое число тройки
  - индекс числа в коллекции, второе - индекс в квадрате, третье
  - индекс в кубе, количество элементов в коллекции n*3

 */