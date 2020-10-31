package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class SalesInfo {
    ArrayList<String> fio = new ArrayList();
    ArrayList<String> product = new ArrayList();
    ArrayList<Integer> number = new ArrayList();
    ArrayList<Double> sum = new ArrayList();

    public int loadOrders(String fileName) {
        int count = 0;
        try {
            File files = new File(fileName);
            try (Scanner scaner = new Scanner(files).useDelimiter("\\n")) {
                while (scaner.hasNext()) {
                    String total = scaner.next();
                    String[] num = total.split(",");
                    if (num.length!=4) {
                        continue;
                    }
                    try {
                        int num1 = Integer.parseInt(num[2].trim());
                        double num2 = Double.parseDouble(num[3]);;
                        fio.add(num[0]);
                        product.add(num[1].trim());
                        number.add(num1);
                        sum.add(num2);
                    } catch (Exception e) {
                        continue;
                    }
                    count++;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public Map<String, Double> getGoods() {
        Map<String, Double> res = new TreeMap();
        for (int i=0; i<product.size(); i++) {
            String key = product.get(i);
            if (res.containsKey(key)) {
                res.put(key, res.get(key) + sum.get(i));
            } else {
                res.put(key, sum.get(i));
            }
        }
        return res;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        Map<String, AbstractMap.SimpleEntry<Double, Integer>> res = new TreeMap();
        for (int i=0; i<fio.size(); i++) {
            String key = fio.get(i);
            if (res.containsKey(key)) {
                AbstractMap.SimpleEntry<Double, Integer> entry = res.get(key);
                Double amount = entry.getKey() + sum.get(i);
                Integer count = entry.getValue() + number.get(i);

                AbstractMap.SimpleEntry<Double, Integer> newentry = new AbstractMap.SimpleEntry(amount, count);
                res.put(key, newentry);
            } else {
                AbstractMap.SimpleEntry<Double, Integer> entry = new AbstractMap.SimpleEntry(sum.get(i), number.get(i));
                res.put(key, entry);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        SalesInfo a = new SalesInfo();
        try {
            System.out.println(a.loadOrders("E:\\file.csv"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a.getGoods());
        System.out.println(a.getCustomers());

        try (FileWriter writer = new FileWriter("E:\\file.csv")) {
            writer.write("Иванов Сергей, iPhone 10X, 2, 150000\n");
            writer.write("Петрова Анна, наушники JBL, 2, 7000\n");
            writer.write("Иванов Сергей, чехол для iPhone, 1, 1000\n");
            writer.write("Петрова Анна, пакет пластиковый, 1, 3\n");
            writer.write("Радж Кумар, батарейка ААА, 1, 150\n");
            writer.write("Михаил Цикло, iPhone 10X, 1, 75000\n");
            writer.write("Радж Кумар, пакет пластиковый, 1, 3\n");
            writer.write("Михаил Цикло, пакет пластиковый, 1, 3\n");
            writer.write("Иванов Сергей, стекло защитное, 1, 1000\n");
            writer.write("Василий Пупкин, спички, 10, 10\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
Задача 3, Класс SalesInfo
Информация по продажам

Во входном файле находятся данные в CSV формате, CSV - Comma Separated Values, значения разделенные запятыми.
Каждая строка - данные об одной покупке. Входные данные

ФИ покупателя, наименование товара, количество, сумма

String, String, int, double


Пример


Иванов Сергей, iPhone 10X, 2, 150000
Петрова Анна, наушники JBL, 2, 7000
Иванов Сергей, чехол для iPhone, 1, 1000
Петрова Анна, пакет пластиковый, 1, 3
Радж Кумар, батарейка ААА, 1, 150
Михаил Цикло, iPhone 10X, 1, 75000
Радж Кумар, пакет пластиковый, 1, 3
Михаил Цикло, пакет пластиковый, 1, 3
Иванов Сергей, стекло защитное, 1, 1000
Василий Пупкин, спички, 10, 10

…


3.1 Реализовать метод public int loadOrders(String fileName) - вернуть количество успешно загруженных строк.
Если в строке более или менее 4-x полей, или количество и сумма не преобразуются в числа - эту строку не загружаем.

3.2 Реализовать метод public Map<String, Double> getGoods() - вернуть список товаров, отсортированный
по наименованию товара. В String - наименование товара, в Double - общая сумма продаж по товару

3.3 Реализовать метод public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() -
вернуть список покупателей, отсортированный по алфавиту. В String  - ФИ, в Double - сумма всех покупок покупателя,
в Integer - количество покупок

3.4 Протестировать на данных из примера выше


wiki.test.tokens wiki.test.tokens

wiki.train.tokens wiki.train.tokens

 */