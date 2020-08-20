package MyProgect.Trening;

public class SumBt {
    public static void main(String[] args) {
        int sum = 0;
        byte b = 0b0100101;
        for (int i = 0; i <= 7; i++) {
            sum += b>>i & 1;
        }
        System.out.println(sum);


    }



}
