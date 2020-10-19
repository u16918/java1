package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        Collection<Integer> result = new ArrayList();
        Integer[] num = new Integer[numbers.size()];
        numbers.toArray(num);
        int minSum = num[0]+num[1];
        for (int i=1; i<num.length-1; i++) {
            if (num[i]+num[i+1]<minSum) {
                minSum = num[i]+num[i+1];
                result.clear();
                result.add(i);
                result.add(i+1);
            }
        }
        return result;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        Collection<Integer> result = new ArrayList();
        Integer[] num = new Integer[numbers.size()];
        numbers.toArray(num);
        for (int i=1; i<num.length-1; i++) {
            if (num[i]>num[i-1] && num[i]>num[i+1]) {
                result.add(num[i]);
            }
        }
        return result;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        for (int i=1; i<=numbers.size(); i++) {
            if (!numbers.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        String[] find = new String[names.size()];
        names.toArray(find);
        int[] counts = new int[find.length];

        for (int i = 0; i < find.length; i++) {
            for (int j = 0; j < find.length; j++) {
                if (find[i].equals(find[j])) {
                    counts[i] = counts[i]+1;
                }
            }
        }

        int max = counts[counts.length-1];
        String res = find[counts.length-1] + ":" + counts[counts.length-1];
        for (int i=counts.length-2; i>=0; i--) {
            if (counts[i]>=max) {
                max = counts[i];
                res = find[i] + ":" + counts[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Collection<String> names = new ArrayList();
        names.add("Жигули");
        names.add("Москвич");
        names.add("Жигули");
        names.add("Мерседес");
        names.add("Запорожец");
        names.add("Жигули");
        System.out.println(findSimilar(names));
    }
}
/*
Задача 2, класс Finder

2.1 Реализовать метод
public static Collection<Integer> findMinSumPair(Collection<Integer> numbers)
- найти 2 соседних числа в коллекции сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел

2.2 Реализовать метод
public static Collection<Integer> findLocalMax(Collection<Integer> numbers)
 - найти локальные максимумы - числа, которые больше соседа справа и слева.
 Первый и последний элемент коллекции не может являться локальным  максимумом,
 вернуть коллекцию, содержащую значения этих максимумов

2.3 Реализовать метод
public static boolean findSequence(Collection<Integer> numbers)
- проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный

2.4 Реализовать метод

public static String findSimilar(Collection<String> names)
- найдите максимальное количество повторяющихся подряд элементов.
Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
 При равенстве максимального количества у разных повторяющихся элементов,
 вернуть результат для элемента, повторяющаяся последовательность которого началась с наименьшего индекса.
 */