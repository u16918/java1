package MyProgect.Trening;

public class Mane {
    public static boolean isSimple(int n) {

        for (int i = 2; i < n; i++)  //по циклу начиная от 2 и до самого числа не включительно
        {
            if (n % i == 0)  //если остаток от деления числа на значение шага цикла равен нулю, то
            {
                return false;  //вернуть false, переданное число простым не является
            }
        }

        return true;  //вернуть true, переданное число простое
    }

    public static void main(String[] args) {
        System.out.println(isSimple(4));

    }
}
