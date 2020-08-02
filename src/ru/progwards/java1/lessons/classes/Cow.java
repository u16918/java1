package ru.progwards.java1.lessons.classes;

public class  Cow extends Animal{
    public Cow(double weight) {
        super(weight);
    }
    public AnimalKind getKind() {
        AnimalKind COW = AnimalKind.COW;
        return COW;
    }
    public FoodKind getFoodKind(){
        FoodKind HAY = FoodKind.HAY;
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

















