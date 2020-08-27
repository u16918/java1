package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

import static ru.progwards.java1.lessons.interfaces.CompareWeight.CompareResult.*;

public class Animal implements FoodCompare, CompareWeight {
    double weight;
    public Animal(double weight){
    this.weight = weight;
    }
    enum AnimalKind{ANIMAL, COW, HAMSTER, DUCK}
    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }
    enum FoodKind {UNKNOWN, HAY, CORN}
    public FoodKind getFoodKind(){
        return FoodKind.UNKNOWN;
    }
    public String toString(){
        return "I am " + getKind() + ", " + "eat " + getFoodKind();
    }
    public double getWeight(){
        return weight;
    }
    public double getFoodCoeff(){ return 0.02; }
    public double calculateFoodWeight(){
        return getWeight() * getFoodCoeff();
    }
    public String toStringFull(){
        return "I am " + getKind() + ", " + "eat " + getFoodKind() + " " + calculateFoodWeight();
    }

   // H8 Домашнее задание

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return Double.compare(animal.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    public double getFood1kgPrice(){
        FoodKind fp = FoodKind.UNKNOWN;
        switch(fp) {
            case HAY: return 20;
            case CORN: return 50;
            case UNKNOWN: return 0;
        }
        return 0;
    }

    public double getFoodPrice(){
        return calculateFoodWeight() * getFood1kgPrice();
    }
    @Override
    public int compareFoodPrice(Animal aminal) {
       if (Double.compare(getA, getFoodPrice())>0){
           return getA;
       }
        if (Double.compare(getA, getFoodPrice())<0){
            return (int) getFoodPrice();
        } else {
        return 0;
        }
    }
    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt){

            if (getB > weight) return LESS;
            if (getB == weight) return EQUAL;
            if (getB < weight) return GREATER;

        return null;
    }



    public static void main(String[] args) {
        System.out.println(new Animal(295));
        System.out.println(new Animal(20).equals(new Animal(21)));

    }


}
/*
    H8 Домашнее задание
Задача 1. Классы Animal, Cow, Hamster, Duck
1.1 Для класса Animal из задач 1 и 2, домашнего задания к уроку 5 реализовать метод:
public boolean equals(Object anObject), который возвращает true, если объекты равны и false если не равны по параметру - вес животного.
Убедится, что при равном весе, утка все равно не равна хомяку. Обратите внимание на тип принимаемого параметра и подумайте над тем,
что будет делать ваша программа, если в качестве параметра будет передан объект не являющийся экземпляром Animal.

Для класса Animal реализовать интерфейс FoodCompare, который сравнивает животных по цене потребляемой еды.
public interface FoodCompare {
    public int compareFoodPrice();
}

Для этого
1.2 В класс Animal добавить метод
public double getFood1kgPrice(), который возвращает информацию о цене 1 кг еды.
метод реализовать в виде switch по FoodKind со следующими значениями
HAY : 20
CORN: 50
UNKNOWN: 0

1.3 В класс Animal добавить метод
public double getFoodPrice(), который возвращает информацию о цене еды для данного животного по формуле
calculateFoodWeight() * getFood1kgPrice()

1.4 В отдельном файле объявить interface FoodCompare
interface FoodCompare {
    public int compareFoodPrice(Animal animal);
}

1.5 В класс Animal реализовать
public int compareFoodPrice(Animal aminal), который возвращает результаты сравнения цены еды для данного животного
с ценой еды для другого животного, используя Double.compare;






Задача 1
Реализовать класс Animal, содержащий:
1.0 Реализовать конструктор
public Animal(double weight), который сохраняет вес животного.
1.1 Метод:
public AnimalKind getKind(), который возвращает вид животного (enum AnimalKind - ANIMAL, COW, HAMSTER, DUCK). В данном классе вернуть ANIMAL
1.2 Метод
public FoodKind getFoodKind(), который возвращает вид еды, (enum FoodKind - UNKNOWN, HAY, CORN). В данном классе вернуть UNKNOWN
1.3 Метод
public String toString(), который возвращает информацию о животном в формате:
I am <AnimalKind>, eat <FoodKind>

Задача 2
2.1 В классе Animal реализовать метод:
public double getWeight(), который возвращает вес животного

2.2 Реализовать метод
public double getFoodCoeff(), который возвращает коэффициент веса еды к весу тела животного. Для класса Animal это 0.02
2.6 Для класса Animal, реализовать метод:
public double calculateFoodWeight(), который рассчитывает необходимый вес еды, по формуле - вес-еды = вес-животного * коэффициент веса тела.

2.7 Для класса Animal, создать метод
public String toStringFull(), что бы он возвращал информацию о животном в формате:
I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight>

Задача 3
 */










