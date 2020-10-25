package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> num = new HashSet(set1);
        num.addAll(set2);
        return num;
    }
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> num = new HashSet(set1);
        num.retainAll(set2);
        return num;
    }
    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> num = new HashSet(set1);
        num.removeAll(set2);
        return num;
    }
    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> num = union(set1, set2);
        Set<Integer> intersec = intersection(set1, set2);
        num.removeAll(intersec);
        return num;
    }

    public static void main(String[] args) {
        Set<Integer> i1 = Set.of(1,2,3,8,9);
        Set<Integer> i2 = Set.of(2,5,8,9);

        Set<Integer> i3 = union(i1,i2);
        System.out.println(i3);

        Set<Integer> i4 = intersection(i1,i2);
        System.out.println(i4);

        Set<Integer> i5 = difference(i1,i2);
        System.out.println(i5);

        Set<Integer> i6 = symDifference(i1,i2);
        System.out.println(i6);
    }
}

/*
Задача 1. Класс SetOperations
Реализовать класс SetOperations, операции над множествами целых чисел.

1.1 Метод public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) - объединение множеств

1.2 Метод public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) - пересечение множеств

1.3 Метод public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) - разница множеств

1.4 Метод public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) - симметрическая разница

Кто подзабыл что значит каждая операция, можно глянуть тут
 https://studopedia.ru/14_138615_operatsii-nad-mnozhestvami-i-ih-svoystva.html или OK - google
 */