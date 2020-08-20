package MyProgect.Test;

public class BatyValue {

    public static void main(String[] args) {
        byte value = 0;
        int result = value & 00000001;
        System.out.println(result);
    }

}
/*
Написать программный код, который возвращает младший (нулевой) бит переменной byte value.
 Ответ нужно поместить в переменную int result.

Таким образом, если младший бит параметра value равен 0, то result должен быть равен 0.
Если младший бит равен 1, то и result должен быть равен 1.
 */