package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger{
    int i;
    IntInteger(int i){
        this.i = i;
    }

    public IntInteger add(IntInteger num){
      return new IntInteger(this.number + num.number);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
