package ru.progwards.java1.lessons.sets;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class LettersInFile {
    public static String process(String fileName) throws IOException {
        StringBuilder result = new StringBuilder();
        TreeSet res = new TreeSet();
        try (FileInputStream reader = new FileInputStream(fileName)) {
            InputStreamReader test = new InputStreamReader(reader);
            int b = test.read();
            while (b != -1) {
                char s = (char) b;
                if (Character.isLetter(s)) {
                    res.add(s);
                }
                b = test.read();
            }
            Iterator it = res.iterator();
            while (it.hasNext()) {
                result.append(it.next());
            }
        } catch (IOException e) {
            throw new IOException("The required file is missing!" + e.getMessage());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("E:\\file.txt")) {
            writer.write("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(process("E:\\file.txt"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}

/*
Задача 3. Класс LettersInFile

Реализовать класс, считывающий содержимое файла и возвращающего набор букв, которые встречались в этом файле.
Буквы, это латинские [A..Z[ и [a..z] и русские [А..Я] и [а..я], остальные символы надо игнорировать

3.1 Метод public static String process(String fileName) - вернуть все буквы,
которые встретились в файле, сконкатенированные в виде строки. Буквы должны быть упорядочены по алфавиту,
типа “ADEF...”. Все возникающие исключения, по работе с потоками, пробросить выше.
 */