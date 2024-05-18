package org.example;

import org.example.db.DBConnector;
import org.example.model.Price;
import org.example.model.Shop;
import org.example.utils.PriceDB;
import org.example.utils.ShopDB;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DBConnector dbConnector = DBConnector.getInstance();

        dbConnector.connect();
//        String name1 = "Patka";
//        dbConnector.createShop(new Shop(name1));
//
//        List<Shop> shops = dbConnector.selectAllShops();
//        shops.forEach(s -> System.out.println(s));
//
//        System.out.println("-------");

        // Ashan <- целевой магазин, который будем менять
        // Patero4ka <- на что меняем

        /*
            1. Через SELECT найдем строку с магазином Ashan
            1.2. Создание модели класса Shop с Id от Ashan, но Name = Patero4ka
            2. Через Update обновим строку Ashan в БД
         */


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название для магазина, у которого хотите изменить название:");
        String firstShopName = scanner.nextLine();
        System.out.println("Введите новое название магазина:");
        String secondShopName = scanner.nextLine();
        System.out.println("-------");
        System.out.println("Все магаизны:");

        List<Shop> shops = dbConnector.selectAllShops();
        shops.forEach(s -> System.out.println(s));
        System.out.println("-------");

        Shop shop = dbConnector.selectShop(firstShopName);

        if(Objects.isNull(shop)) {
            System.out.println("Такого магазина нет");
        }
        else {
            shop.setName(secondShopName);
            dbConnector.updateShop(shop);

            System.out.println("Все магаизны:");
            shops = dbConnector.selectAllShops();
            shops.forEach(s -> System.out.println(s));
        }

//        dbConnector.deleteShop(name1);
//        shops = dbConnector.selectAllShops();
//        shops.forEach(s -> System.out.println(s));

//        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("If you want to exit - enter 0");
//            System.out.print("Enter shop name: ");
//
//            String shopName = scanner.nextLine();
//            if(shopName.equals("0")) {
//                return;
//            }
//            ShopDB shopDB = new ShopDB();
//            Shop shop = shopDB.findShop(shopName);
//            if (Objects.isNull(shop)) {
//                System.out.println("Enter different name of shop.");
//            } else {
//                List<Price> products = new PriceDB().findAllProductsForShopId(shop.getId());
//                if (products.isEmpty()) {
//                    System.out.println("No products for shop " + shop.getName());
//                } else {
//                    for (Price pr : products) {
//                        System.out.println(pr);
//                    }
//                }
//            }
//        }
    }
}
