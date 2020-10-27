package ru.progwards.java1.lessons.queues;
import java.util.*;

public class CollectionsSort {
    public static void mySort(Collection<Integer> data) {
        Integer[] a = new Integer[data.size()];
        data.toArray(a);
        for (int i=0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i]>a[j]) {
                    int a1 = a[i];
                    a[i] = a[j];
                    a[j] = a1;
                }
            }
        }
        data.clear();
        for (int i=0; i<a.length; i++) {
            data.add(a[i]);
        }
    }

    public static void minSort(Collection<Integer> data) {
        Collection<Integer> result = new ArrayList();
        while (!data.isEmpty()) {
            Integer i1 = Collections.min(data);
            data.remove(i1);
            result.add(i1);
        }
        data.addAll(result);
    }

    static void collSort(Collection<Integer> data) {
        List<Integer> result = new ArrayList(data);
        Collections.sort(result);
        data.clear();
        data.addAll(result);
    }

    static class SortInfo implements Comparable<SortInfo> {
        String name;
        long time;

        SortInfo(String name, long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(SortInfo o) {
            if (this.time>o.time) {
                return 1;
            }
            if (this.time<o.time) {
                return -1;
            }
            if (this.name.charAt(0)>o.name.charAt(0)) {
                return 1;
            }
            if (this.name.charAt(0)<o.name.charAt(0)) {
                return -1;
            }
            if (this.name.charAt(1)>o.name.charAt(1)) {
                return 1;
            }
            if (this.name.charAt(1)<o.name.charAt(1)) {
                return -1;
            }

            return 0;
        }
    }

    public static Collection<String> compareSort() {
        Collection<Integer> data = new ArrayList();
        for (int i=0; i<1000; i++) {
            Integer ddt;
            if (i%2==0) {
                ddt = i;
            } else {
                ddt = i*3;
            }
            data.add(ddt);
        }
        long start = System.currentTimeMillis();
        mySort(data);
        long end = System.currentTimeMillis()-start;
        SortInfo sinf = new SortInfo("mySort", end);

        data.clear();
        for (int i=0; i<1000; i++) {
            Integer ddr;
            if (i%2==0) {
                ddr = i;
            } else {
                ddr = i*3;
            }
            data.add(ddr);
        }
        start = System.currentTimeMillis();
        minSort(data);
        end = System.currentTimeMillis() - start;
        SortInfo min = new SortInfo("minSort", end);

        data.clear();
        for (int i=0; i<1000; i++) {
            Integer itr;
            if (i%2==0) {
                itr = i;
            } else {
                itr = i*3;
            }
            data.add(itr);
        }
        start = System.currentTimeMillis();
        collSort(data);
        end = System.currentTimeMillis() - start;
        SortInfo coll = new SortInfo("collSort", end);

        Queue<SortInfo> t = new PriorityQueue();
        t.add(sinf);
        t.add(min);
        t.add(coll);

        ArrayList res = new ArrayList();
        Iterator<SortInfo> ddn = t.iterator();
        while (ddn.hasNext()) {
            SortInfo isort = t.poll();
            res.add(isort.name);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(compareSort());
    }
}

/*
Задача 1. Класс CollectionsSort
Сравнение методов сортировки коллекций
1.1 Реализовать метод public static void mySort(Collection<Integer> data)
 - переделать алгоритм из класса ArraySort из ДЗ про массивы, на коллекции.
 Не использовать встроенные методы сортировок

1.2 Реализовать метод public static void minSort(Collection<Integer> data) по следующему алгоритму
- создать новую коллекцию
- найти минимальный элемент с использованием функции min()
- переместить его в новую коллекцию
- делать так до тех пор, пока все элементы не окажутся в новой коллекции
- скопировать новую коллекцию в старую

1.3 Реализовать метод public static void collSort(Collection<Integer> data) используя метод sort из Collections

1.4 Реализовать метод public static Collection<String> compareSort()
 в котором сравнить производительность методов и вернуть их имена,
 отсортированные в порядке производительности, первый - самый быстрый.
 В случае равенства производительности каких-то методов, возвращать их названия в алфавитном порядке.
 */