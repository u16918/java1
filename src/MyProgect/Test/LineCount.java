package MyProgect.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class LineCount {

    private int lineCount(String filename) throws IOException {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int words = 0;
            while (scanner.hasNextLine()) {
                String[] array = scanner.nextLine().split(" ");
                words = words + array.length;
            }
            scanner.close();
            return words;
            }catch (IOException e) {

            return 0;
        }

    }

    public static void main(String[] args) throws IOException {
        LineCount nid = new LineCount();
        System.out.println(nid.lineCount("несуществующий путь/несуществующий файл"));
    }
}
/*
Реализовать метод с сигнатурой private int lineCount(String filename)
который возвращает количество строк в файле filename.
 В случае ошибки пробросить исключение IOException со строкой сообщения "файл не найден"
 */