package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;

public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        this.digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        String array = value.toString();
        int arrayOl = array.length();
        this.digits = new byte[arrayOl];
        for (int i=0; i<arrayOl; i++) {
            char ar = array.charAt(arrayOl-i-1);
            String temp = String.valueOf(ar);
            byte b = Byte.parseByte(temp);
            this.digits[i]=b;
        }
    }

    BigInteger toInt() {
        String array = "";
        for (int i=0; i<digits.length; i++) {
            array = digits[i] + array;
        }
        return new BigInteger(array);
    }

    boolean add(ArrayInteger num) {
        int objLen = this.digits.length;
        int numLen = num.digits.length;
        if (objLen != numLen) {
            if (objLen > numLen) {
                int diff = objLen - numLen;
                byte[] temp = new byte[numLen];
                System.arraycopy(num.digits, 0, temp, 0, numLen);
                num.digits = new byte[numLen+diff];
                System.arraycopy(temp, 0, num.digits, 0, temp.length);
            } else {
                int diff = numLen - objLen;
                byte[] temp = new byte[objLen];
                System.arraycopy(this.digits, 0, temp, 0, objLen);
                this.digits = new byte[objLen+diff];
                System.arraycopy(temp, 0, this.digits, 0, temp.length);
            }
        }

        byte addition = 0;
        for (int i=0; i<digits.length; i++) {
            if (this.digits[i]+num.digits[i]+addition<=9) {
                this.digits[i] = (byte)(this.digits[i]+num.digits[i]+addition);
                addition = 0;
            } else {
                this.digits[i] = (byte)(this.digits[i]+num.digits[i]+addition-10);
                addition = 1;
            }
        }
        if (addition==1) {
            for (int i=0; i<digits.length; i++) {
                this.digits[i] = 0;
            }
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayInteger a1 = new ArrayInteger(8);
        a1.fromInt(new BigInteger("1111111"));

        ArrayInteger a2 = new ArrayInteger(6);
        a2.fromInt(new BigInteger("2222222"));

        BigInteger b1 = a1.toInt();
        System.out.println(b1);
    }
}

/*
Задача 3. Класс ArrayInteger

Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;

Реализовать методы:

3.1 ArrayInteger(int n) - инициализирует класс, с максимальной точностью n цифр (размер массива)

3.2 void fromInt(BigInteger value) - установить свое значение, взяв его из value
(уложить BigInteger во внутренний массив)

3.3 BigInteger toInt() - привести свое значение к BigInteger (преобразовать из массива в BigInteger)

3.4 boolean add(ArrayInteger num) - сложить 2 числа, не используя BigInteger,
а  используя массив digits, результат поместить в экземпляр ArrayInteger,
у которого был вызван метод. При переполнении вернуть false, при этом само число сбросить в 0
 */