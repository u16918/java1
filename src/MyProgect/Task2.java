package MyProgect;

public class Task2 {
    public static void printJava(){
        String a ="Хорошо идут дела";
        String b ="Изучаю Java я!";
        String c =" ";
        System.out.println(a);
        System.out.println(b);
        System.out.print(a);
        System.out.print(c);
        System.out.println(b);
        System.out.print(b);
        System.out.print(c);
        System.out.println(a);
    }
    public static int subtraction (int x, int y) {
        System.out.print("Вызвана функция subtraction() с параметрами x = "  +x);
        System.out.println (", y = " +y);
        return x-y;
    }
    public static int addition (int x, int y) {
        System.out.print("Вызвана функция addition() с параметрами x = "  +x);
        System.out.println (", y = "  +y);
        return x+y;
    }
    public static int multiplication (int x, int y) {
        System.out.print("Вызвана функция multiplication() с параметрами x = "  +x);
        System.out.println (", y = "  +y);
        return x*y;
    }
    public static void calculation(){
        int a = 34;
        int b = 55;
        System.out.println("a = " +a);
        System.out.println("b = " +b);
        int c= addition (a,b);
        System.out.println("a + b = " +c);
        c= subtraction (a,b);
        System.out.println("a - b = " +c);
        c= multiplication(a,b);
        System.out.println("a * b = " +c);
    }
    public static void main (String[] args) {
        printJava();
        subtraction(45, 12);
        subtraction(23, 55);
        addition(128, 787);
        addition(528, 387);
        multiplication(124, 87);
        multiplication(1528, 3);
    }

}
