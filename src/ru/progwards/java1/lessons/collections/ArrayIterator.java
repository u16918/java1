package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int num;

    ArrayIterator(T[] array) {
        this.array = array;
        num = 0;
    }

    @Override
    public boolean hasNext() {
        return num<array.length;
    }

    @Override
    public T next() {
        num = num+1;
        return array[num-1];
    }
}
/*
Задача 3, Итераторы
3.1 Класс ArrayIterator
Сделать итератор по одномерному массиву, реализовать методы hasNext() и next(). Шаблон пустого итератора:
public class ArrayIterator<T> implements Iterator<T> {
private T[] array;
		ArrayIterator(T[] array) {
			this.array = array;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
	}




3.2 Класс MatrixIterator

Сделать итератор MatrixIterator по двумерному массиву (матрице),
который разворачивает матрицу в линейную последовательность построчно:
a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]

Шаблон для итератора взять от ArrayIterator
 */