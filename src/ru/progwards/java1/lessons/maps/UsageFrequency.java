package ru.progwards.java1.lessons.maps;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsageFrequency {
    private String[] total;

    public void processFile(String fileName) {
        total = new String[0];
        int numer = 0;
        try {
            File files = new File(fileName);
            Scanner scan = new Scanner(files);
                while (scan.hasNext()) {
                    String text = scan.next();
                    numer++;
                    String[] s = new String[total.length];
                    System.arraycopy(total,0,s,0,total.length);

                    total = new String[numer];
                    System.arraycopy(s,0,total,0,s.length);
                    total[numer-1] = text;
                }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Map<Character, Integer> getLetters() {
        Map<Character, Integer> res = new HashMap();
        for (int i=0; i<total.length; i++) {
            for (int j=0; j<total[i].length(); j++) {
                Character key = total[i].charAt(j);
                if (Character.isLetter(key) || Character.isDigit(key)) {
                    if (res.containsKey(key)) {
                        res.put(key, res.get(key) + 1);
                    } else {
                        res.put(key, 1);
                    }
                }
            }
        }
        return res;
    }

    public void symbol(String key, Map<String, Integer> res) {
        String key2 = "";
        for (char c : key.toCharArray())
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                key2 = key2 + c;
            }

        if ("".equals(key2)) {
            return;
        }

        if (res.containsKey(key2)) {
            res.put(key2, res.get(key2) + 1);
        } else {
            res.put(key2, 1);
        }
    }

    public Map<String, Integer> getWords() {
        Map<String, Integer> res = new HashMap();
        for (int i=0; i<total.length; i++) {
            if (total[i].contains("-")) {
                String[] text = new String[2];
                int ind = total[i].indexOf("-");
                text[0] = total[i].substring(0, ind);
                text[1] = total[i].substring(ind+1);

                symbol(text[0], res);
                symbol(text[1], res);
            } else if (total[i].contains("'")) {
                String[] word2 = new String[2];
                int ind = total[i].indexOf("'");
                word2[0] = total[i].substring(0, ind);
                word2[1] = total[i].substring(ind+1);

                symbol(word2[0], res);
                symbol(word2[1], res);
            } else {
                symbol(total[i], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UsageFrequency test = new UsageFrequency();

        test.processFile("E:\\wiki.test.tokens");

        System.out.println(test.getLetters());
        System.out.println(test.getWords());
    }
}
/*
Задача 2, класс UsageFrequency

Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов. Методы:

2.1 public void processFile(String fileName) - загрузить содержимое файла

2.2 public Map<Character, Integer> getLetters() - вернуть Map, который содержит все найденные буквы и цифры,
и количество раз, которое встретился каждый искомый символ. Знаки препинания, такие как “.,!? @” и др не учитывать.

2.3 public Map<String, Integer> getWords() - вернуть Map, который содержит все найденные слова и количество раз,
 которое каждое слово встретилось. Знаки препинания, такие как “.,!? @” и др являются разделителями.

2.4 Протестировать на файле wiki.train.tokens (во вложении), для отладки можно использовать wiki.test.tokens
 */