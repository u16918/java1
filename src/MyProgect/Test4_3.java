package MyProgect;

public class Test4_3 {
    static long factorial(long n){
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(29));
    }
}



//Напишите метод, вычисляющий факториал числа - n!. Сигнатура метода static long factorial(long n)
//Напомним, что факториал n это произведение всех чисел от 1 до n и факториал 0 == 1