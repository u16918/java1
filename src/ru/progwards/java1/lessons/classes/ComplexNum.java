package ru.progwards.java1.lessons.classes;

public class ComplexNum {
        int a;
        int b;
public ComplexNum(int a, int b){
        this.a = a;
        this.b = b;
        }
public String toString(){
        return a+"+"+b+"i";
        }
public ComplexNum add(ComplexNum num) { // (a + c) + (b + d)i
    num.a += a;
    num.b += b;
    return new ComplexNum(num.a, num.b);
        }
public ComplexNum sub(ComplexNum num) { // (a - c) + (b - d)i
    num.a = a - num.a;
    num.b = b - num.b;
    return new ComplexNum(num.a, num.b);
        }
public ComplexNum mul(ComplexNum num) {   // (a*c - b*d) + (b*c + a*d)i
    num.a = a * num.a - b * num.b;
    num.b = b * num.a + a * num.b;
    return new ComplexNum(num.a, num.b);
        }
public ComplexNum div(ComplexNum num){ // (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
    num.a = (a * num.a + b * num.b) / (num.a * num.a + num.b * num.b);
    num.b = (b * num.a - a * num.b) / (num.a * num.a + num.b * num.b);
    return new ComplexNum(num.a, num.b);
}
    public static void main(String[] args) {
        System.out.println(new ComplexNum(1000, 1012).div(new ComplexNum(100, 88)).toString());
    }
}


/*
Задача 3. Класс ComplexNum
Реализовать класс ComplexNum, реализующий операции в комплексных числах. Напоминаем, что комплексное число записывается
как z = a + bi, где z это комплексное число, a действительная часть, b мнимая часть, i обозначение мнимой части.
a и b реализуем целыми числами

3.1 конструктор
public ComplexNum(int a, int b), который инициализирует комплексное число

3.2 метод
public String toString(), приведение к строке, выдать в формате a+bi, например, при a=1 и b=56 должно быть выдано 1+56i

3.3 метод
public ComplexNum add(ComplexNum num), сложение комплексных чисел по формуле:
(a + bi) + (c + di) = (a + c) + (b + d)i

3.4 метод
public ComplexNum sub(ComplexNum num), вычитание комплексных чисел по формуле:
(a + bi) - (c + di) = (a - c) + (b - d)i

3.5 метод
public ComplexNum mul(ComplexNum num), умножение комплексных чисел по формуле:
(a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i

3.5 метод
public ComplexNum div(ComplexNum num), деление комплексных чисел по формуле:
(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
 */









