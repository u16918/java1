package ru.progwards.java1.lessons.datetime;

import java.util.*;

public class Profiler {
    static Map<String, StatisticInfo> Sections = new HashMap<>();
    static Map<String, Long> startTime = new HashMap<>();
    static Map<String, Integer> counts = new HashMap<>();
    static Deque<String> qSections = new ArrayDeque<>();

    public static void enterSection(String name) {
        if (startTime.size()==0 || !startTime.containsKey(name)) {
            counts.put(name, 1);
            qSections.addFirst(name);
        } else {
            counts.put(name, counts.get(name)+1);
            if (!name.equals(qSections.peekFirst())) {
                qSections.addFirst(name);
            }
        }
        startTime.put(name, System.currentTimeMillis());
    }

    public static void exitSection(String name) {
        long fullTime = System.currentTimeMillis() - startTime.get(name);
        long selfTime = fullTime;
        long prevTime = 0;
        boolean isNested = false;
        while (!name.equals(qSections.peekFirst())) {
            isNested = true;
            String prevname = qSections.pollFirst();
            StatisticInfo prev = Sections.get(prevname);
            prevTime = prevTime + prev.fullTime;
        }
        if (isNested) {
            if (!Sections.isEmpty() && Sections.containsKey(name)) {
                StatisticInfo val = Sections.get(name);
                fullTime += val.fullTime;
                selfTime = fullTime - prevTime;
            } else {
                selfTime = selfTime - prevTime;
            }
        } else {
            if (!Sections.isEmpty() && Sections.containsKey(name)) {
                StatisticInfo val = Sections.get(name);
                fullTime += val.fullTime;
                selfTime += val.selfTime;
            }
        }
        StatisticInfo newSI = new StatisticInfo(name, (int) fullTime, (int) selfTime, counts.get(name));
        Sections.put(name, newSI);
    }

    public static List<StatisticInfo> getStatisticInfo() {
        Collection<StatisticInfo> temp = Sections.values();
        List<StatisticInfo> res = new ArrayList<>(temp);
        res.sort(StatisticInfo::compareTo);
        return res;
    }

    public static void main(String[] args) {

        enterSection("Process1");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exitSection("Process1");
        enterSection("Process1");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exitSection("Process1");
        enterSection("Process1");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exitSection("Process1");
        enterSection("Process1");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        enterSection("Process2");
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        enterSection("Process3");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exitSection("Process3");
        exitSection("Process2");
        enterSection("Process2");
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        enterSection("Process3");
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        exitSection("Process3");
        exitSection("Process2");
        exitSection("Process1");

        List<StatisticInfo> result = getStatisticInfo();
        for (StatisticInfo tt : result) {
            System.out.println(tt.sectionName);
            System.out.println(tt.fullTime);
            System.out.println(tt.selfTime);
            System.out.println(tt.count);
        }
    }
}

/*
Задача 2. Класс Profiler

Реализовать класс для ручной профилировки производительности программного кода.
Профилировка программного кода - измерение времени выполнения отдельных фрагментов кода с целью
выявления узких мест в производительности.
Реализовать методы
2.1 public static void enterSection(String name) - войти в профилировочную секцию, замерить время входа.
2.2 public static void exitSection(String name) - выйти из профилировочной секции. Замерить время выхода,
вычислить промежуток времени между входом и выходом в миллисекундах.
2.3 public static List<StatisticInfo> getStatisticInfo() - получить профилировочную статистику,
отсортировать по наименованию секции
2.4 Реализовать class StatisticInfo
public String sectionName; - имя секции
public int fullTime - полное время выполнения секции в миллисекундах.
public int selfTime - чистое время выполнения секции в миллисекундах. Для вложенных секций, из времени
выполнения внешней секции нужно вычесть времена выполнения вложенных секций.
public int count - количество вызовов. В случае, если вызовов более одного, fullTime и selfTime содержат
суммарное время выполнения всех вызовов.
Секции могут быть только вложенные, как матрешки, и при этом поддержку рекурсии реализовывать не нужно.
Но каждая секция может встретиться несколько раз.
Например:
enterSection(“1”);
…
for(;;) {
     enterSection(“2”);
enterSection(“3”);
exittSection(“3”);

     …
     exittSection(“2”);
}


     enterSection(“4”);

     …
     exittSection(“4”);

...
exittSection(“1”);

И, допустим, мы получаем, что секция 1 выполнялась 1000 миллисекунд, а секция 2 - 700(суммарно), 3 - 500 (суммарно), 4 - 100, в итоге информация должна получиться такая



name

fulltime

selftime

count

1

1000

200

1

2

700

200

100

3

500

500

100

4

100

100

1



Обратите внимание, что сумма всех selfTime равна максимальному времени выполнения,
в данном примере это секция 1. Какая удобная структура данных для хранения информации в процессе работы -
продумать самому.

 */