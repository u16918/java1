package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger{
    short numer;

    ShortInteger(short n) {
        this.numer = n;
    }

    @Override
    public String toString() {
        return Integer.toString(numer);
    }

}
