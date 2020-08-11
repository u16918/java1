package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

     public class DIntArray {
        private int[] arrayNum;


         public void add(int num){

             int[] arrayNum1 = Arrays. copyOf(arrayNum, arrayNum.length + num);
         }
         public void atInsert(int pos, int num){

             int[] arrayNum1 = Arrays. copyOf(arrayNum, arrayNum.length/2 + pos);

              arrayNum1[pos] = num;
         }
         public void atDelete(int arrayNum1[], int pos) {

                 for(int i = pos; i < (arrayNum1.length - 1); i++){
                     arrayNum1[i] = arrayNum1[i + 1];
                 }
             }
         public int at(int pos){
             int[] arrayNum1 = Arrays. copyOf(arrayNum, arrayNum.length/2 + pos);
             return pos;
         }


         public static void main(String[] args) {
             int[] arrayNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


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
