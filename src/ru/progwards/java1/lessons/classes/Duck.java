package ru.progwards.java1.lessons.classes;

public class Duck extends Animal{
    public Duck(double weight) {
        super(weight);
    }
    public AnimalKind getKind() {
        AnimalKind DUCK = AnimalKind.DUCK;
        return DUCK;
    }
    public FoodKind getFoodKind(){
        FoodKind CORN = FoodKind.CORN;
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







