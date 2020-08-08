package MyProgect;

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

    Rectangle anRectangle(double a, double b) {
        this.a = a;
        this.b = b;
        return new Rectangle(a, b);
    }

    public int compareTo(Rectangle anRectangle){
        int s1,s2;
        s1 = (int) Rectangle.this.area();
        s2 = (int) anRectangle.area();
        if (s1 > s2) return 1;
        if (s1 == s2) return 0;
        else return -1;

    }

    public static void main(String[] args) {

        System.out.println(new Rectangle(2,3).compareTo(new Rectangle(3, 2)));
    }
}

/*
реализуйте метод compareTo с сигнатурой
public int compareTo(Rectangle anRectangle) который должен сравнивать прямоугольники по величине их площади.
При сравнении a.compareTo(b) метод должен возвращать
a   > b : 1
a == b : 0
a   < b : -1

Например

прямоугольник 2x2  >  прямоугольника 1x1 - результат 1
прямоугольник 2x3 == прямоугольнику 3x2 - результат 0
прямоугольник 2x2  <  прямоугольника 3x3 - результат -1




 */

