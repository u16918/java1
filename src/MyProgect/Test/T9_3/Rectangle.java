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
    public BigDecimal area() {
        return a.multiply(b);
    }

    boolean rectCompare(Rectangle r1, Rectangle r2){
        r1 = new Rectangle(a, b);
        r2 = new Rectangle(a, b);
       return r1.area().equals(r1.area());
    }

    public static void main(String[] args) {

        System.out.println();

    }


}

}