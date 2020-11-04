package ru.progwards.java1.lessons.datetime;

public class StatisticInfo implements Comparable<StatisticInfo> {
    public String sectionName;
    public int fullTime;
    public int selfTime;
    public int count;

    StatisticInfo(String name, int ft, int st, int cnt) {
        sectionName = name;
        fullTime = ft;
        selfTime = st;
        count = cnt;
    }

    @Override
    public int compareTo(StatisticInfo o) {
        return sectionName.compareTo(o.sectionName);
    }
}