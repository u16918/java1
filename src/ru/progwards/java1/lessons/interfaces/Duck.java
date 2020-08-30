package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.DUCK;
import static ru.progwards.java1.lessons.interfaces.Animal.FoodKind.CORN;

public class Duck extends Animal{
    public Duck(double weight) {
        super(weight);
    }
    public AnimalKind getKind() {
        return DUCK;
    }
    public FoodKind getFoodKind(){
        return CORN;
    }
    @Override
    public double getFoodCoeff(){return 0.04;}
}

/*
Задача 1
Реализовать класс Duck, потомок класса Animal, переопределяющий методы:
1.8 public AnimalKind getKind(), который возвращает DUCK.
1.9 public FoodKind getFoodKind(), который возвращает CORN

Задача 2
2.5 Для класса Duck, переопределить метод:
public double getFoodCoeff(), который должен возвращать 0.04

Задача 3
 */







