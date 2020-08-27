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
        } else if (n<=1){
            return n;
        } else {
            int l = 0;
            int k = 1;
            for (int i = 0; i <= n ; i++) {
                int num = l+k;
                l=k;
                k=num;
            }
            cacheInfo.n = n;
            cacheInfo.fibo = k;
            return k;
        }
    }

    public static CacheInfo getLastFibo(){
        return lastFibo;
    }
    public static void clearLastFibo(){
        lastFibo = null;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(5));
    }
}
