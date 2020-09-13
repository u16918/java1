package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number{
    public IntNumber(int num){

    }
    public Number mul(Number num){
        return null;
    }

    @Override
    public Number div(Number num) {
        return super.div(num);
    }

    @Override
    public Number newNumber(String strNum) {
        return super.newNumber(strNum);
    }

    @Override
    public String toString() {
        return "IntNumber{}";
    }
}

/*
2. Реализовать класс IntNumber, который содержит
2.1 конструктор
public IntNumber(int num), который будет сохранять в классе значение целого числа.
2.2 переопределение метода
public Number mul(Number num), который будет возвращать произведение содержимого класса на num.
2.3 переопределение метода
public Number div(Number num), который будет возвращать частное от деления содержимого класса на num.
2.4 переопределение метода
public Number newNumber(String strNum), который будет возвращать новый экземпляр класса IntNumber
со значением параметра strNum, содержащим целое число,, например 4 или 3.
Надо будет правильно распарсить строку и привести значение к целому типу.
2.5 public String toString() - привести значение числа к строке
 */












