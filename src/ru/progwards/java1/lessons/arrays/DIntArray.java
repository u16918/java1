package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
          int num;
    private int[] arrayNum = new int[0];

         public DIntArray(){
         }

         public void add(int num) {
             this.num = num;
             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length + 1);
             arrayNum[arrayNum.length - 1] = num;
             System.out.println(Arrays.toString(arrayNum));
         }
         public void atInsert(int pos, int num){
             this.num = num;
             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length+pos-1);
             arrayNum[pos] = num;
             System.out.println(Arrays.toString(arrayNum));
         }
         public void atDelete(int pos){
             System.arraycopy(arrayNum, 0, arrayNum, 0, pos);
             System.arraycopy(arrayNum, pos + 1, arrayNum, pos, arrayNum.length - pos - 1);
             arrayNum = Arrays.copyOf(arrayNum, arrayNum.length-1);
             System.out.println(Arrays.toString(arrayNum));

         }
        public int at(int pos){

            DIntArray tmp;
            DIntArray tmpIns;
            DIntArray tmpDel;

             return arrayNum[pos];
        }


    public static void main(String[] args) {

        int[] arrayNum = {-83,-15,51,84,-84,-72,63,-61,-6,-5,35,72,-75,-52,68,43,-37,-57};

            DIntArray tmp = new DIntArray();
              tmp.add(5);

             DIntArray tmpIns = new DIntArray();
               tmpIns.atInsert(2,-30);

            DIntArray tmpDel = new DIntArray();
               tmpDel.atDelete(2);

            DIntArray tmpAt = new DIntArray();
             System.out.println(tmpAt.at(2));
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
