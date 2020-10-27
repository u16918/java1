package ru.progwards.java1.lessons.queues;
import java.util.PriorityQueue;

public class OrderQueue {
    private PriorityQueue<Order> resOrder = new PriorityQueue<>();

    public void add(Order order) {
        resOrder.add(order);
    }

    public Order get() {
        return resOrder.poll();
    }

    public static void main(String[] args) {
        OrderQueue num = new OrderQueue();

        num.add(new Order(30000.0));
        num.add(new Order(11.0));
        num.add(new Order(15000.0));

        System.out.println(num.get().getNum());
    }
}

/*
Задача 2. Класс OrderQueue
Создать класс - очередь, на обслуживание заявок клиентов в зависимости от величины суммы заказа.

2.1 Создать отдельный класс Order

2.2 Создать приватное свойство double sum  - сумма заказа

2.3 Создать приватное свойство int num  - номер заказа

2.4 Создать конструктор public Order(double sum) - для номера заказа создать систему автонумерации, начиная с 1
2.5 Создать геттер public double getSum()

2.6 Создать геттер public int getNum()


Создать класс OrderQueue

2.7 Создать метод, public void add(Order order), размещающий заказы в очередь с приоритетом,
разбивая их по 3-м классам
3 - заказы до 10000 руб включительно
2 - заказы от 10000 до 20000 руб включительно
1 - заказы от 20000 руб

2.8 Создать метод, public Order get(), возвращающий первый заказ в очереди для обслуживания.
Вначале обслуживаются заказы класса 1, потом 2, потом 3.
Внутри каждого класса заказы должны обслуживаться в порядке поступления (по номеру заказа).
Метод не выбрасывает исключения, возвращает null в случае пустой очереди.

Продумать, и, при необходимости, добавить в классы нужные методы и свойства, для того, чтобы реализовать эту задачу.
 */