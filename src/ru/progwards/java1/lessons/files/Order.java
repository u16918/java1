package ru.progwards.java1.lessons.files;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    public String shopId;
    public String orderId;
    public String customerId;
    public LocalDateTime datetime;
    public List<OrderItem> items;
    public double sum;
}

/*
3.1 Реализовать class Order со следующим свойствами
public String shopId - идентификатор магазина
public String orderId - идентификатор заказа
public String customerId - идентификатор покупателя
public LocalDateTime datetime - дата-время заказа (из атрибутов файла - дата последнего изменения)
public List<OrderItem> items - список позиций в заказе, отсортированный по наименованию товара
public double sum - сумма стоимости всех позиций в заказе
 */