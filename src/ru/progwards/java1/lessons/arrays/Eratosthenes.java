package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;
    private static int [] generatePrimes(int max) {
        int [] sieve = new int [max];
        sieve [0] = 2;
        int index = 1;
        int prime = 1;
        boolean isPrime = false;
        while((prime += 2) <= max) {
            isPrime = true;
            for(int i = 0; i < index; i++) {
                if(prime % sieve [i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                sieve [index++] = prime;
            }
        }
        int [] primes = new int [index];
        while(--index >= 0) {
            primes [index] = sieve [index];
        }
        return primes;
    }
    public Eratosthenes(int N){
        Arrays.fill(sieve, true);
    }
    private void sift(){

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
