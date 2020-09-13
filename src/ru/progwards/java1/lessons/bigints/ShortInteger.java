package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger{
    short s;
    ShortInteger(short s){
        this.s = s;
    }

    @Override
    public String toString() {
        return Integer.toString(s);
    }

}
