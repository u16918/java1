package ru.progwards.java1.lessons.queues;
import java.util.ArrayDeque;

public class StackCalc {
    ArrayDeque<Double> stack = new ArrayDeque();

    public void push(double value) {
        stack.addFirst(value);
    }

    public double pop() {
        return stack.pollFirst();
    }

    public void add() {
        Double d1 = pop();
        Double d2 = pop();
        stack.addFirst(d1+d2);
    }

    public void sub() {
        Double d1 = pop();
        Double d2 = pop();
        stack.addFirst(d2-d1);
    }

    public void mul() {
        Double d1 = pop();
        Double d2 = pop();
        stack.addFirst(d2*d1);
    }

    public void div() {
        Double d1 = pop();
        Double d2 = pop();
        stack.addFirst(d2/d1);
    }
}
/*
Задача 3. Класс StackCalc
Стековый калькулятор (есть даже такой стековый язык программирования - Forth). Стек,
это структура данных, работающая по принципу LIFO - last in first out (последний вошедший выходит первый),
это противоположность привычной очереди FIFO - first in first out - первый вошедший выходит первый


Реализовать class StackCalc, который содержит стек чисел с плавающей точкой (double).
Выбрать наиболее удобную для этого коллекцию. Реализовать методы работы со стеком:

3.1 public void push(double value) - положить value на вершину стека

3.2 public double pop() - взять (убрать) значение с вершины стека

3.3 public void add() - сложить 2 верхних значения на стеке, результат положить на стек.
В итогу в стеке должно быть на один элемент меньше

3.4 public void sub() - вычесть верхнее значение на стеке, из следующего по глубине, результат положить на стек.
 В итоге в стеке должно быть на один элемент меньше

3.5 public void mul() - умножить 2 верхних значения на стеке, результат положить на стек.
В итогу в стеке должно быть на один элемент меньше

3.6 public void div() - поделить на верхнее значение на стеке, следующее по глубине, результат положить на стек.
В итоге в стеке должно быть на один элемент меньше


 */