package ru.progwards.java1.lessons.io2;

public class Translator {
    private String [] inLang;
    private String [] outLang;

    Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang=outLang;
    }
    public String translate(String sentence){
        String line = sentence.toLowerCase();
        String line1 =sentence.toLowerCase();
        for (int i = 0; i < inLang.length; i++){
            if(line.contains(inLang[i])){
                int n = line.indexOf(inLang[i]);
                if(Character.isUpperCase(sentence.charAt(line1.indexOf(inLang[i])))){
                    line = line.replace(inLang[i],outLang[i].replaceFirst(String.valueOf(outLang[i].charAt(0)),String.valueOf(Character.toUpperCase(outLang[i].charAt(0)))));
                } else {
                    line = line.replace(inLang[i],outLang[i]);
                }
            }
        }
        return line;
    }

    public static void main(String[] args) {
        Translator trans = new Translator(new String[]{"hello", "world"},new String[]{"привет", "мир"});
        System.out.println(trans.translate("Hello World!"));
    }
}
/*
Задача 2. Класс Translator
Создать класс Translator - переводчик, который будет переводить предложения с одного языка на другой

2.1 Конструктор Translator(String[] inLang, String[] outLang), где inLang и outLang -
массивы слов на разных языках, например русском и английском. Сохранить значения параметров в приватных
свойствах класса

2.2  Метод public String translate(String sentence), в котором найти слова, содержащиеся в sentence и
в inLang и заменить их на соответствующие в outLang. Пунктуация должна быть соблюдена (скопирована
из оригинальной строки). При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
В inLang и outLang все слова хранятся в нижнем регистре.

Например, фраза
"Hello World!" будет переведена как "Привет Мир!"
при наличии слов "hello", "world" в inLang и "привет", "мир" в outLang
 */











