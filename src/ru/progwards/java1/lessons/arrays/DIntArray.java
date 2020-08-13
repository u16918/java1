package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

     public class DIntArray {
         public static void main(String[] args) {
             int num = 5;
             int pos = 4;
             int[] arrayNum = new int[] {1, 2, 3, 4};
             System.out.println(Arrays.toString(arrayNum));
             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length + 1);
             arrayNum[arrayNum.length - 1] = num;
             System.out.println(Arrays.toString(arrayNum));

             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length / 2 + pos);
             arrayNum[pos] = num;
             System.out.println(Arrays.toString(arrayNum));

             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length - pos);
             System.out.println(Arrays.toString(arrayNum));

             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length / 2 + pos);
             arrayNum[pos] = num;
             System.out.println(Arrays.toString(arrayNum));
         }

     }

/*
Задача 3. Класс DIntArray
Реализовать динамический, саморастущий массив целых чисел, по следующей спецификации:

3.1 в классе разместить private переменную - массив целых чисел.

3.2 конструктор - по умолчанию.
3.2 метод
public void add(int num) - добавляет элемент num в конец массива, при этом размер массива должен увеличиться на 1. Д
ля этого нужно будет разместить новый массив нужного размера, скопировать в него старый, и добавить в хвост элемент num.

3.3 метод
public void atInsert(int pos, int num) - добавляет элемент num в позицию pos массива, при этом размер массива должен
увеличиться на 1.
Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, c учетом того, что новый элемент окажется
где-то в середине, и потом положить в нужный индекс элемент num.

3.4 метод
public void atDelete(int pos) - удаляет элемент в позиции pos массива, при этом размер массива должен уменьшиться на 1.
Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, уже без элемента, который был в позиции pos.

3.5 метод
public int at(int pos) - возвращает элемент по индексу pos.

 */
