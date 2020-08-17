package MyProgect.Test;

public class SumArray {
    public int sumArrayItems(int[] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }
        return s;
    }

}

/*
Напишите функцию, суммирующие значения элементов одномерного массива, содержащего целые числа. Сигнатура:

public int sumArrayItems(int[] a)
 */