package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal{
    public Hamster(double weight) {
        super(weight);
    }
    public AnimalKind getKind() {
        AnimalKind HAMSTER = AnimalKind.HAMSTER;
        return HAMSTER;
    }
    public FoodKind getFoodKind(){
        FoodKind CORN = FoodKind.CORN;
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










