package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone)throws Exception{
        StringBuilder num= new StringBuilder();
        for (char n: phone.toCharArray()){
            if (Character.isDigit(n))
                num.append(n);
        }
        if (num.length() == 10)
            num.insert(0,"7");
        else {
            if (num.length() == 11){
                if(num.charAt(0)=='8' || (num.charAt(0)=='7'))
                    num.setCharAt(0,'7');
                else throw new Exception("Enter the correct number");
            }else throw new Exception("Enter the correct number");
        }
        num.insert(0,'+').insert(2,'(').insert(6,')').insert(10,'-');
        return num.toString();
    }
    public static void main(String[] args) throws Exception {
        System.out.println(format("8158050282311"));
    }
}

/*
Задача 1. Класс PhoneNumber
Создать статический метод public static String format(String phone), который форматирует телефон
под формат +7(999)111-2233, входящий формат может быть различным:
- 79991112233
- 8(999)111-22-33
- 8 999 111 22 33

формальное задание на форматирование:
- выделить все цифры, отбросить все разделители
- проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
- убрать спереди 8
- добавить, если нужно +7
- отформатировать под выходной шаблон
 */









