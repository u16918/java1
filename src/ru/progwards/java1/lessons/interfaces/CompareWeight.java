package ru.progwards.java1.lessons.interfaces;

public interface CompareWeight {
    CompareResult compareWeight(CompareWeight smthHasWeigt);
    double getB = 0;
    double smthHasWeigt = getB;
    public enum CompareResult{
        LESS,
        EQUAL,
        GREATER
    }

}
