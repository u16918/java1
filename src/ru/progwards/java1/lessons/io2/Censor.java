package ru.progwards.java1.lessons.io2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class Censor {
    static class CensorException extends RuntimeException {
        private String message;
        private String nameofFile;
        public CensorException(String msg,String File){
            super();
            message=msg;
            nameofFile = File;
        }
        public CensorException(){
            super();
        }
        @Override
        public String toString(){
            return message+":"+nameofFile;
        }
    }
    private static String censorSens(String s){
        StringBuilder str = new StringBuilder();
        for (char c: s.toCharArray()){
            str.append('*');
        }
        return str.toString();
    }
    public static void censorFile(String inoutFileName, String[] obscene){
        int main=0;
        try(RandomAccessFile file = new RandomAccessFile(inoutFileName,"rw")){
            while (file.getFilePointer() < file.length()){
                long start = file.getFilePointer();
                if (start!=0){
                    file.seek(file.getFilePointer()-1);
                    int num = file.read();
                    while (!(num ==0x0D || num==0x0A)){
                        num=file.read();
                    }
                }
                String tems = file.readLine();

                tems = new String(tems.getBytes());
                for (String s : obscene) {
                    if (tems.contains(s)) {
                        tems = tems.replace(s, censorSens(s));
                    }
                }
                if (file.getFilePointer()+1<file.length())
                    tems+='\n';
                main++;
                byte [] b = tems.getBytes();
                file.seek(start);
                file.write(b);
            }
        } catch (Exception ex){
            throw new CensorException(ex.getMessage(),inoutFileName);
        }
    }

    public static void main(String[] args) {
        System.out.println();
        censorFile("tems",new String[]{"Java", "Oracle", "Sun", "Microsystems"});
    }
}

/*
Задача 3. Класс Censor
Создать статический метод public static void censorFile(String inoutFileName, String[] obscene),
в котором прочитать файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*',
соответствующие количеству символов в слове, изменения записать в исходный файл.
В случае возникновения ошибки, выбросить свое собственное исключение
CensorException в котором сохранить - строку, полученную у оригинального exception
через метод getMessage() и имя файла, в котором возникла ошибка.
В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
Класс CensorException разместить в классе Censor

Например файл содержит:
Java — строго типизированный объектно-ориентированный язык программирования,
разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
obscene = {"Java", "Oracle", "Sun", "Microsystems"}

Должен выдать результат:
**** — строго типизированный объектно-ориентированный язык программирования,
разработанный компанией *** ************ (в последующем приобретённой компанией ******).
 */



















