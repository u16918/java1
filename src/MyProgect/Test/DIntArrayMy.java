package MyProgect.Test;

import java.util.Arrays;

public class DIntArrayMy {
    public static void main(String[] args) {
        int num = 5;
        int pos = 4;
        int[] arrayNum = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(arrayNum));
        arrayNum = Arrays.copyOf(arrayNum, arrayNum.length + 1);
        arrayNum[arrayNum.length - 1] = num;
        System.out.println(Arrays.toString(arrayNum));

        arrayNum = Arrays.copyOf(arrayNum, arrayNum.length / 2 + pos);
        arrayNum[pos] = num;
        System.out.println(Arrays.toString(arrayNum));

        arrayNum = Arrays.copyOf(arrayNum, arrayNum.length - pos);
        System.out.println(Arrays.toString(arrayNum));

        arrayNum = Arrays.copyOf(arrayNum, arrayNum.length / 2 + pos);
        arrayNum[pos] = num;
        System.out.println(Arrays.toString(arrayNum));
    }
}
