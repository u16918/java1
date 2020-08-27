package MyProgect.Test;

import java.util.Objects;

public class Rectangle {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {

        return a*b;
    }


    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Rectangle rectangle = (Rectangle) anObject;

        Rectangle a1 = new Rectangle(a, b);
        Rectangle a2 = new Rectangle(a, b);


        return Double.compare(a1.area(), ((Rectangle) anObject).area()) == 0;
    }

        public static void main(String[] args) {

        System.out.println(new Rectangle(3,4).equals(new Rectangle(6, 2)));
    }
}

/*
переопределите метод equals с сигнатурой
public boolean equals(Object anObject) который должен сравнивать прямоугольники по величине их площади.

Например

прямоугольник 2x2 != прямоугольнику 1x1
прямоугольник 2x3 == прямоугольнику 3x2





 */
