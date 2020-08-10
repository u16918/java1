package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;

    public Eratosthenes(int N) {

        sieve = new boolean[N];
        Arrays.fill(sieve, true);

    }
    private void sift() {
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i] == false) System.out.print(i + " ");
            for (int j = i + 1; j < sieve.length; j++) {
                if ((j % i) == 0) {
                    sieve[j] = true;
                }
            }
        }
    }
    public boolean isSimple(int n){
        for (int i = 2; i < sieve.length; i++) {
            if (n % i == 0) {
                return true;

            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println();

    }
}
/*
1.1 Реализовать класс Eratosthenes, содержащий:
массив чисел, собственно, "решето"
private boolean[] sieve, для того, чтобы узнать, я является ли число n простым, нужно взять значение
 по индексу в массиве. sieve[n].
Значение true, означает простое число, false - составное.

1.2 Реализовать конструктор
public Eratosthenes(int N), который должен разместить массив sieve с размером в N и заполнить его
значениями true, после чего вызвать метод sift()

1.3 Реализовать метод
private void sift(), который, собственно и реализует алгоритм Эратосфена, просеивая составные числа.
Подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1, и внутренний,
например по j который будет просеивать числа,
 кратные переменной внешнего цикла i*j.

1.4 Реализовать метод
public boolean isSimple(int n), который возвращает sieve[n], что бы можно было узнать, простое число n
или составное
 */
