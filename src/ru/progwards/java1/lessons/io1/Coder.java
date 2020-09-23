package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName){
        try {
            StringBuilder fileOut = new StringBuilder();
            try (FileReader reader = new FileReader(inFileName); FileWriter writer = new FileWriter(outFileName)) {
                int i;
                while ((i = reader.read()) != -1) {
                    char symbol = (char) i;
                    fileOut.append(code[(int) symbol]);
                }
                writer.write(fileOut.toString());
            }
        } catch (Exception e) {
            try {
                try (FileWriter logFile = new FileWriter(logName)) {
                    logFile.write(e.getMessage());
                }
            } catch (Exception e1) {
                System.out.println("не судьба..");
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[65535];
        for (int i=0; i<65535; i++) {
            code[i] = (char)(65535-i);
        }

        try {
            FileWriter writer = new FileWriter("C:\\Users\\Alex\\Documents\\file.txt");
            writer.write("Java - язык программирования, разработанный компанией Sun Microsystems.");
            writer.close();
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        codeFile("C:\\Users\\Alex\\Documents\\file.txt",
                "C:\\Users\\Alex\\Documents\\file_out.txt",
                code, "C:\\Users\\Alex\\Documents\\log.txt");
    }
}



/*
Задача 2. Класс Coder
Создать статический метод public static void codeFile(String inFileName, String outFileName, char[] code,
String logName), в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным
шифром, результат записать в outFileName. Шифр задается маcсивом char[] code,
где каждому символу symbol оригинального файла соответствует символ code[(int)symbol] выходного файла.
В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()


 */

