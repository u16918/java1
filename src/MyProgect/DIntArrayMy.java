package MyProgect;

import java.util.Arrays;

public class DIntArrayMy {
    public static void main(String[] args) {
        int[] arrayNum = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(arrayNum));
        arrayNum = Arrays.copyOf(arrayNum, arrayNum.length + 1);
        arrayNum[arrayNum.length - 1] = 4;
        System.out.println(Arrays.toString(arrayNum));
    }
}
