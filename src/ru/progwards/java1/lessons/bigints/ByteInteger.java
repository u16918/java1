package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte numer;

    ByteInteger(byte n) {
        this.numer = n;
    }

    @Override
    public String toString() {
        return Integer.toString(numer);
    }

}
