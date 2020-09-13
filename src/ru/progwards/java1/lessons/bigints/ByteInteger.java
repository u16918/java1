package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte b;
    ByteInteger(byte b){
        this.b = b;
    }

    @Override
    public String toString() {
        return Integer.toString(b);
    }

}
