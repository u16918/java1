package ru.progwards.java1.lessons.queues;

public class Order implements Comparable<Order> {
    static int auto = 1;
    private double sum;
    private int num;
    private int s;

    public Order(double sum) {
        this.sum = sum;
        if (sum>=20000.0) {
            this.s = 1;
        } else if (sum>=1000.0) {
            this.s = 2;
        } else {
            this.s = 3;
        }
        num = auto;
        auto++;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Order o) {
        if (this.s > o.s) {
            return -1;
        }
        if (this.s < o.s) {
            return 1;
        }
        // если одного класса
        if (this.num > o.num) {
            return 1;
        }
        if (this.num < o.num) {
            return -1;
        }

        return 0;
    }
}

/*
2.1 Создать отдельный класс Order

2.2 Создать приватное свойство double sum  - сумма заказа

2.3 Создать приватное свойство int num  - номер заказа

2.4 Создать конструктор public Order(double sum) - для номера заказа создать систему автонумерации, начиная с 1
2.5 Создать геттер public double getSum()

2.6 Создать геттер public int getNum()
 */