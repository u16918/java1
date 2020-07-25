package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number){
        int a = number % 10;
        int b = number / 10;
        int c = b % 10;
        int d = b / 10;
        int e = d % 10;
        int a1 = a * 100;
        int c1 = c * 10;
        return (a1 + c1 + e);
    }


    public static void main(String[] args) {
        System.out.println(reverseDigits(989));
    }
}

//1.1 Реализовать функцию
//public static int reverseDigits(int number), которая получает параметром number трёхзначное положительное число, а вернуть
// должна число в котором цифры идут в обратном порядке (например, если на вход передаётся 123, то функция должна вернуть 321).
//Подсказки:для реализации задачи вспомните особенности деления в Java (в середине лекции "БНФ, константы, операторы, приоритеты").
