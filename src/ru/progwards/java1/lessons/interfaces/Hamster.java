package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.HAMSTER;
import static ru.progwards.java1.lessons.interfaces.Animal.FoodKind.CORN;

public class Hamster extends Animal{
    public Hamster(double weight) {
        super(weight);
    }
    public AnimalKind getKind() {
        return HAMSTER;
    }
    public FoodKind getFoodKind(){
        return CORN;
    }
    @Override
    public double getFoodCoeff(){return 0.03;}
}

/*
Задача 1
Реализовать класс Hamster, потомок класса Animal, переопределяющий методы:
1.6  public AnimalKind getKind(), который возвращает HAMSTER.
1.7 public FoodKind getFoodKind(), который возвращает CORN

Задача 2
2.4 Для класса Hamster, переопределить метод:
public double getFoodCoeff(), который должен возвращать 0.03

Задача 3
 */










