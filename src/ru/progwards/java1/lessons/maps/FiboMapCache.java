package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache = new HashMap();
    boolean fibOn;

    public FiboMapCache(boolean cacheOn) {
        fibOn = cacheOn;
    }

    public BigDecimal fiboNumber(int n) {
        if (fibOn) {
            if (fiboCache==null) {
                fiboCache = new HashMap();
            }
            if (fiboCache.containsKey(n)) {
                return fiboCache.get(n);
            }
            BigDecimal s = fiboNum(n);
            fiboCache.put(n, s);
            return s;
        } else {
            return fiboNum(n);
        }
    }

    public static BigDecimal fiboNum(int n) {
        if (n==1 || n==2) {
            return BigDecimal.ONE;
        }
        BigDecimal num = BigDecimal.ZERO;
        BigDecimal num1 = BigDecimal.ONE;
        BigDecimal num2 = BigDecimal.ONE;
        for (int i = 3; i<=n; i++) {
            num = num1.add(num2);
            num1 = num2;
            num2 = num;
        }
        return num;
    }

    public void clearCahe() {
        fiboCache = null;
    }

    public static void test() {
        FiboMapCache test1 = new FiboMapCache(true);
        long start = System.currentTimeMillis();
        for (int i=1; i<=1000; i++) {
            test1.fiboNumber(i);
            test1.clearCahe();
        }
        long end = System.currentTimeMillis()-start;
        System.out.println("fiboNumber cacheOn=true время выполнения " + end);

        FiboMapCache test2 = new FiboMapCache(false);
        start = System.currentTimeMillis();
        for (int i=1; i<=1000; i++) {
            test2.fiboNumber(i);
        }
        end = System.currentTimeMillis()-start;
        System.out.println("fiboNumber cacheOn=false время выполнения " + end);
    }

    public static void main(String[] args) {
        test();
    }
}
/*
Задача 1, класс FiboMapCache
Кеш для чисел Фибоначчи на Map. Кеш имитирует таковой на сервере, когда идут запросы со случайными параметрами
от разных пользователей. Сам алгоритм чисел Фибоначчи - это просто пример некоего алгоритма, который долго работает,
в сравнении с вытаскиванием значения из кэша. Считается, что кеш ничего не знает об алгоритме,
и умеет только сохранять и доставать значения по ключу.


1.1 Определить приватную локальную переменную fiboCache как Map<Integer, BigDecimal>

1.2 Определить конструктор public FiboMapCache(boolean cacheOn) - включен ли кэш. При cacheOn = true кэш работает,
при cacheOn = false - выключен

1.3 Реализовать public BigDecimal fiboNumber(int n). Алгоритм работы следующий:

в функции проверить, находится ли вычисленное значение для n в кэше, и если да - вернуть его из кэша,
если нет - рассчитать и добавить в кэш. Учитывать значение переменной cacheOn

1.4 Реализовать метод public void clearCahe() который устанавливает переменную fiboCache в null

1.5 Для проверки работы реализовать public static void test() - тест для расчета
чисел Фибоначчи от n = 1 до 1000 включительно и замерить разницу во времени с on = true и on = false,
результат вывести на экран в формате "fiboNumber cacheOn=??? время выполнения ???" для cacheOn=true и cacheOn=false,
вместо ??? вывести реальные значения в мсек.
 */