package MyProgect.Test.T8_2;

public class Dog implements Speaking, Eating {
    @Override
    public String eat() {
        return "Мясо";
    }

    @Override
    public String say() {
        return "Гав";
    }
}
/*
реализовать 2 класса, Dog и Goat.
У класса Dog метод say() должен вернуть "Гав"
У класса Dog метод eat() должен вернуть "Мясо"
У класса Goat метод say() должен вернуть "Мее"
У класса Goat метод eat() должен вернуть "Сено"


 */