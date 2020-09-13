package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;
    public static class CacheInfo {
        public int n;
        public int fibo;
    }
    public static int fiboNumber(int n) {
        int num = 0;
        int num1 = 1;
        int num2 = 1;
        if (lastFibo == null) {
            lastFibo = new CacheInfo();
        }

        if (lastFibo.n==n) {
            return lastFibo.fibo;
        }

        if (n==1 || n==2) {
            lastFibo.n = n;
            lastFibo.fibo = 1;
            return 1;
        }


        for (int i = 3; i<=n; i++) {
            num = num1 + num2;
            num1 = num2;
            num2 = num;
        }
        lastFibo.n = n;
        lastFibo.fibo = num;
        return num;
    }



    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static void main(String[] args) {

    }
}
