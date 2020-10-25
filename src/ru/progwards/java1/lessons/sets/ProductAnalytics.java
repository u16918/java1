package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductAnalytics {
    private List<Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.products = products;
        this.shops = shops;
    }
    public Set<Product> existInAll() {
        Set<Product> result = new HashSet();
        Iterator<Shop> pr1 = shops.iterator();
        Iterator<Shop> pr2 = shops.iterator();

        Shop rp1 = pr1.next();
        Set<Product> sp1set = new HashSet(rp1.getProducts());
        while (pr2.hasNext()) {
            Shop rp2 = pr2.next();
            Set<Product> sp2set = new HashSet(rp2.getProducts());
            sp1set.retainAll(sp2set);
            if (sp1set.isEmpty()) {
                break;
            }
        }
        if (!sp1set.isEmpty()) {
            Iterator<Product> spr = sp1set.iterator();
            while (spr.hasNext()) {
                result.add(spr.next());
            }
        }

        return result;
    }
    public Set<Product> existAtListInOne() {
        Set<Product> result = new HashSet();
        Iterator<Shop> ppr = shops.iterator();
        while (ppr.hasNext()) {
            Shop sp = ppr.next();
            Iterator<Product> ipr = sp.getProducts().iterator();
            while (ipr.hasNext()) {
                result.add(ipr.next());
            }
        }
        return result;
    }
    public Set<Product> notExistInShops() {
        Set<Product> result = new HashSet(products);
        result.removeAll(existAtListInOne());
        return result;
    }
    public Set<Product> existOnlyInOne() {
        Set<Product> result = new HashSet();
        Set<Product> retain = new HashSet();
        Iterator<Shop> pr1 = shops.iterator();

        Shop dns1 = pr1.next();
        Set<Product> sp1set = new HashSet(dns1.getProducts());
        Shop dns2 = pr1.next();
        Set<Product> sp2set = new HashSet(dns2.getProducts());

        result.addAll(sp1set);
        result.addAll(sp2set);

        sp2set.retainAll(sp1set);
        retain.addAll(sp2set);

        result.removeAll(retain);

        while (pr1.hasNext()) {
            Shop spn = pr1.next();
            Set<Product> spnset = new HashSet(spn.getProducts());

            spnset.retainAll(result);
            retain.addAll(spnset);

            Set<Product> spnset2 = new HashSet(spn.getProducts());
            result.addAll(spnset2);

            result.removeAll(retain);
        }

        result.removeAll(retain);
        return result;
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
/*
Задача 2. Класс ProductAnalytics
2.1 Создать класс Product - товар,
2.2. Создать private String code - уникальный артикул товара
2.3 Создать конструктор public Product(String code)
2.4 Метод public String getCode()
2.5 Создать класс Shop - магазин
2.6 Создать private List<Product> products - товары имеющиеся в магазине
2.7 Создать конструктор public Shop(List<Product> products)
2.8 Создать метод public List<Product> getProducts()
2.9 Создать класс ProductAnalytics
2.10 Создать private List<Shop> shops - список магазинов
2.11 Создать private List<Product> products - список всех имеющихся в ассортименте товаров.
Все товары, присутствующие в магазинах, обязательно присутствуют в products,
но так же тут могут быть и товары, которых нет в магазинах
2.12 Создать конструктор  public ProductAnalytics(List<Product> products, List<Shop> shops)
2.13 Создать функцию public Set<Product> existInAll() - товары из products, которые имеются во всех магазинах
2.14 Создать функцию public Set<Product> existAtListInOne() - товары из products,
которые имеются хотя бы в одном магазине
2.15 Создать функцию public Set<Product> notExistInShops() - товары из products, которых нет ни в одном магазине
2.16 Создать функцию public Set<Product> existOnlyInOne() - товары из products, которые есть только в одном магазине
 */