package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator <T> implements Iterator<T> {
    private T[][] array;
    private int num1;
    private int num2;

    MatrixIterator(T[][] array) {
        this.array = array;
        num1 = 0;
        num2 = 0;
    }

    @Override
    public boolean hasNext() {
        return num2<array[num1].length || num1<array.length-1;
    }

    @Override
    public T next() {
        if (num2==array[num1].length) {
            num1 = num1+1;
            num2 = 0;
        }
        num2 = num2+1;
        return array[num1][num2-1];
    }

    public static void main(String[] args) {
        Integer[][] ar = {{1,3}, {9,0,5}, {4}};

        MatrixIterator mi = new MatrixIterator(ar);
        while (mi.hasNext()) {
            System.out.println(mi.next());
        }
    }

}
/*
3.2 Класс MatrixIterator

Сделать итератор MatrixIterator по двумерному массиву (матрице),
который разворачивает матрицу в линейную последовательность построчно:
a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]

Шаблон для итератора взять от ArrayIterator
 */