package MyProgect;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMax {
    public int arrayMax(int[] a){
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            if (s < a[i]) {
                s = a[i];
            }
        }
        return s;
    }

}

/*
Реализуйте функцию, возвращающую максимальный по значению элемент массива.
Если в массиве 0 элементов, вернуть 0. Сигнатура функции

public int arrayMax(int[] a)

Подсказка - для быстрой реализации удобно использовать функцию Arrays.sort()
 */














