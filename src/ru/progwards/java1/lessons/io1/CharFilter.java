package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws Exception {
        try {String fileIn;
            String fileOut = "";
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            FileWriter writer = new FileWriter(outFileName);
            boolean text;
            while (scanner.hasNextLine()) {
                fileIn = scanner.nextLine();
                for (int i=0; i<fileIn.length(); i++) {
                    text = true;
                    for (int j=0; j<filter.length(); j++) {
                        if (fileIn.charAt(i) == filter.charAt(j)) {
                            text = false;
                            break;
                        }
                    }
                    if (text) {
                        fileOut = fileOut + fileIn.charAt(i);
                    }
                }
                writer.write(fileOut);
            }

            reader.close();
            scanner.close();
            writer.close();

           } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        try {FileWriter writer = new FileWriter("C:\\Users\\Alex\\Documents\\file.txt");
            writer.write("Java - строго типизированный объектно-ориентированный язык программирования, " +
                    "разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String obscene = " -,.()";
        filterFile("C:\\Users\\Alex\\Documents\\file.txt", "C:\\Users\\Alex\\Documents\\file_out.txt", obscene);
    }
}

/*
Задача 3. Класс CharFilter
Создать статический метод public static void filterFile(String inFileName, String outFileName, String filter),
 в котором прочитать файл inFileName и удалить символы, содержащиеся в String filter,
  результат записать в выходной файл. В случае возникновения ошибки, пробросить стандартное исключение выше,
  корректно закрыв все ресурсы

Например файл содержит:
Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией
Sun Microsystems (в последующем приобретённой компанией Oracle).
obscene = " -,.()"
Должен выдать результат:
JavaстроготипизированныйобъектноориентированныйязыкпрограммированияразработанныйкомпаниейSun
MicrosystemsвпоследующемприобретённойкомпаниейOracle

 */







