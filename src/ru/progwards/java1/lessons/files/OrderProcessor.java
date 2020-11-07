package ru.progwards.java1.lessons.files;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.*;
import java.util.*;

public class OrderProcessor {
    Path pathStorage;
    int ddt;
    List<Order> data = new ArrayList<>();
    public OrderProcessor(String startPath) {
        pathStorage = Paths.get(startPath);
    }
    public boolean isInPeriod(LocalDate start, LocalDate finish, LocalDate one) {
        if (start==null && finish==null) {
            return true;
        }
        if (start==null && (one.isEqual(finish) || one.isBefore(finish))) {
            return true;
        }
        if (finish==null && (one.isEqual(start) || one.isAfter(start))) {
            return true;
        }
        return (one.isEqual(start) || one.isAfter(start)) && (one.isEqual(finish) || one.isBefore(finish));
    }
    public Order fileProcess(Path path) throws IOException {
        Order result = new Order();
        String fileName = path.getFileName().toString();
        result.shopId = fileName.substring(0, 3);
        result.orderId = fileName.substring(4, 10);
        result.customerId = fileName.substring(11, 15);

        FileTime lmt = Files.getLastModifiedTime(path);
        Instant i = lmt.toInstant();
        ZoneId defaultZone = ZoneId.of("Europe/Moscow");
        result.datetime = LocalDateTime.ofInstant(i, defaultZone);

        result.items = null;
        result.sum = 0;
        try {
            List<String> fileLines = Files.readAllLines(path);
            result.items = new ArrayList<>();
            for (String fileLine : fileLines) {
                String[] item = fileLine.split(",");
                try {
                    OrderItem one = new OrderItem();
                    one.googsName = item[0];
                    one.count = Integer.parseInt(item[1].trim());
                    one.price = Double.parseDouble(item[2].trim());
                    result.items.add(one);
                    result.sum += one.price * one.count;
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " ошибка в структуре файла");
                    return null;
                }
            }

            result.items.sort(new Comparator<OrderItem>() {
                @Override
                public int compare(OrderItem o1, OrderItem o2) {
                    return o1.googsName.compareTo(o2.googsName);
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage() + " ошибка при чтении файла");
            return null;
        }
        return result;
    }

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        ddt = 0;
        String pattern = shopId;
        if (shopId==null) {
            pattern = "???";
        }
        PathMatcher receive = FileSystems.getDefault().getPathMatcher("glob:**/"+pattern+"-??????-????.csv");
        try {
            Files.walkFileTree(pathStorage, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path p, BasicFileAttributes attrs) {
                    if (receive.matches(p)) {
                        try {
                            FileTime timeN = Files.getLastModifiedTime(p);
                            Instant i = timeN.toInstant();
                            ZoneId defaultZone = ZoneId.of("Europe/Moscow");
                            LocalDateTime ldt = LocalDateTime.ofInstant(i, defaultZone);
                            if (isInPeriod(start, finish, ldt.toLocalDate())) {
                                Order one = fileProcess(p);
                                if (one!=null) {
                                    data.add(one);
                                } else {
                                    ddt++;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFileFailed(Path p, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ddt;
    }

    public List<Order> process(String shopId) {
        List<Order> result = new ArrayList<>();
        if (shopId==null) {
            result.addAll(data);
        } else {
            for (Order one : data) {
                if (one.shopId.equals(shopId)) {
                    result.add(one);
                }
            }
        }
        result.sort(new Comparator<>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.datetime.compareTo(o2.datetime);
            }
        });
        return result;
    }

    public Map<String, Double> statisticsByShop() {
        Map<String, Double> result = new TreeMap<>();
        for (Order one : data) {
            if (!result.isEmpty() && result.containsKey(one.shopId)) {
                result.put(one.shopId, result.get(one.shopId) + one.sum);
            } else {
                result.put(one.shopId, one.sum);
            }
        }
        return result;
    }

    public Map<String, Double> statisticsByGoods(){
        Map<String, Double> result = new TreeMap<>();
        for (Order one : data) {
            for (OrderItem one2 : one.items) {
                if (!result.isEmpty() && result.containsKey(one2.googsName)) {
                    result.put(one2.googsName, result.get(one2.googsName) + one2.price * one2.count);
                } else {
                    result.put(one2.googsName, one2.price * one2.count);
                }
            }
        }
        return result;
    }

    public Map<LocalDate, Double> statisticsByDay() {
        Map<LocalDate, Double> result = new TreeMap<>();
        for (Order one : data) {
            LocalDate oneDate = one.datetime.toLocalDate();
            if (!result.isEmpty() && result.containsKey(oneDate)) {
                result.put(oneDate, result.get(oneDate) + one.sum);
            } else {
                result.put(oneDate, one.sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("E:\\test\\S02-P01X12-0012.csv")) {
            writer.write("Пазл “Замок в лесу”, 2, 700");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        OrderProcessor a = new OrderProcessor("E:\\test");
        a.loadOrders(null, null, null);

        System.out.println(a.data);

    }

}

/*
Задача 3, Класс OrderProcessor
Информация о заказах поступает в виде файлов, которые лежат в под-папках разбитых по неделям,
имена папок не имеют значения. Имя каждого файла имеет формат: AAA-999999-ZZZZ.csv где AAA -
обязательные 3 символа shopId - идентификатор магазина, 999999 - обязательные 6 символов orderId
- номер заказа, ZZZZ - обязательные 4 символа customerId - идентификатор покупателя, расширение файла - csv,
например S02-P01X12-0012.csv: shopId=”S02”, orderId=”P01X12”, customerId=”0012”

Содержимое каждого файла имеет формат CSV (Comma Separated Values) со следующими данными
Наименование товара, количество, цена за единицу
Например:
Игрушка мягкая “Мишка”, 1, 1500
Пазл “Замок в лесу”, 2, 700
Книжка “Сказки Пушкина”, 1, 300
3.1 Реализовать class Order со следующим свойствами
public String shopId - идентификатор магазина
public String orderId - идентификатор заказа
public String customerId - идентификатор покупателя
public LocalDateTime datetime - дата-время заказа (из атрибутов файла - дата последнего изменения)
public List<OrderItem> items - список позиций в заказе, отсортированный по наименованию товара
public double sum - сумма стоимости всех позиций в заказе
3.2 Реализовать class OrderItem со следующим свойствами
public String googsName - наименование товара
public int count - количество
public double price - цена за единицу

Реализовать класс OrderProcessor со следующими методами
3.3 конструктор public OrderProcessor(String startPath) - инициализирует класс,
с указанием начальной папки для хранения файлов
3.4 метод public int loadOrders(LocalDate start, LocalDate finish, String shopId) -
загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
Если start == null, значит нет ограничения по дате слева, если finish == null,
значит нет ограничения по дате справа, если shopId == null - грузим для всех магазинов
При наличии хотя бы одной ошибке в формате файла, файл полностью игнорируется, т.е.
Не поступает в обработку. Метод возвращает количество файлов с ошибками.
При этом, если в классе содержалась информация, ее надо удалить
3.5 метод public List<Order> process(String shopId) - выдать список заказов в порядке обработки
(отсортированные по дате-времени), для заданного магазина. Если shopId == null, то для всех
3.6 метод public Map<String, Double> statisticsByShop() - выдать информацию по объему продаж по магазинам
(отсортированную по ключам): String - shopId, double - сумма стоимости всех проданных товаров в этом магазине
3.7 метод public Map<String, Double> statisticsByGoods() - выдать информацию по объему продаж по товарам
(отсортированную по ключам): String - goodsName, double - сумма стоимости всех проданных товаров
этого наименования
3.8 метод public Map<LocalDate, Double> statisticsByDay() - выдать информацию по объему продаж по дням
(отсортированную по ключам): LocalDate - конкретный день, double
 - сумма стоимости всех проданных товаров в этот день
 */