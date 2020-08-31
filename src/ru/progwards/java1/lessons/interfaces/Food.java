package ru.progwards.java1.lessons.interfaces;

import static ru.progwards.java1.lessons.interfaces.CompareWeight.CompareResult.*;

public class Food implements CompareWeight{
    private int weight;
    public Food(int weight){
        this.weight = weight;
    }
    public double getWeight(){
        return (double) weight;
    }
    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        if (getWeight() < smthHasWeigt.getWeight()) return LESS;
        if (getWeight() == smthHasWeigt.getWeight()) return EQUAL;
        if (getWeight() > smthHasWeigt.getWeight()) return GREATER;
        return null;
    }

    public static void main(String[] args) {


    }
}
