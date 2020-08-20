package ru.progwards.java1.lessons.bitsworld;

public class Binary {
    private byte num;
    public Binary(byte num){
        this.num = num;
    }

    public String toString() {

         String result = "";
         for (int i = 7; i >= 0; i--) {
             result += (num >> i) & 0b00000001;
         }
         return result;
     }


    public static void main(String[] args) {
        Binary toSt = new Binary((byte) -128);
        System.out.println(toSt.toString());
       //System.out.println(String.format("%8s", Integer.toBinaryString(127)).replace(' ', '0'));

    }
}

/*
Задача 3. Класс Binary
3.1 Реализовать конструктор
public Binary(byte num).
3.2 Реализовать метод
public String toString(), который возвращает двоичное представление числа типа byte,
используя только битовые операции. В выводимом значении всегда должно быть 8 символов
Например:
0: "00000000"
1: "00000001"
127: "01111111"
-128: "10000000"
-1: "11111111"
 */
