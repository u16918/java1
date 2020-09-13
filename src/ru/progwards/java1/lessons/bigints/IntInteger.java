package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger{
    int numer;

    IntInteger(int n) {
        this.numer = n;
    }

    @Override
    public String toString() {
        return Integer.toString(numer);
    }

    public IntInteger add(IntInteger num) {
        IntInteger res = new IntInteger(this.numer + num.numer);
        return res;
    }
}
