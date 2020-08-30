package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.COW;
import static ru.progwards.java1.lessons.interfaces.Animal.FoodKind.HAY;

public class  Cow extends Animal{
    public Cow(double weight) {
        super(weight);
    }
    public AnimalKind getKind() {
        return COW;
    }
    public FoodKind getFoodKind(){
        return HAY;
    }
    @Override
    public double getFoodCoeff(){
        return 0.05;
    }
}

/*
Задача 1
Реализовать класс Cow, потомок класса Animal, переопределяющий методы:
1.4 public AnimalKind getKind(), который возвращает COW.
1.5 public FoodKind getFoodKind(), который возвращает HAY

Задача 2
2.3 Для класса Cow, переопределить метод:
public double getFoodCoeff(), который должен возвращать 0.05

Задача 3
 */

















