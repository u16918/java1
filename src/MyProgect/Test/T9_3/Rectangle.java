package MyProgect.Test.T9_3;

import MyProgect.Test.Rectangle;

import java.math.BigDecimal;
import java.math.BigInteger;

class Vound {

static class Rectangle {
    public BigDecimal a;
    public BigDecimal b;

    Rectangle(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }
    boolean rectCompare(Rectangle r1, Rectangle r2){

        return r1.a.multiply(r1.b).compareTo(r2.a.multiply(r2.b)) == 0;
    }

    public static void main(String[] args) {

    }
 }
}

