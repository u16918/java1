package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;
    public static class CacheInfo{
        public int n;
        public int fibo;
    }

    public static int fiboNumber(int n){
        CacheInfo cacheInfo = new CacheInfo();
        if (n == cacheInfo.n){
            return cacheInfo.fibo;
        } else if (n < 1){
            return 0;
        } else if (n == 1){
            return 1;
            } else {
                int n1 = fiboNumber(n - 1) + fiboNumber(n - 2);
            cacheInfo.n = n;
            cacheInfo.fibo = n1;
            return n1;
        }
    }

    public static CacheInfo getLastFibo(){
        return lastFibo;
    }
    public static void clearLastFibo(){
        lastFibo = null;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(2));
        System.out.println(getLastFibo());
    }
}
