package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {
    CompareResult compareWeight(CompareWeight smthHasWeigt);

    double getWeight();

    public enum CompareResult{
        LESS,
        EQUAL,
        GREATER
    }

}
