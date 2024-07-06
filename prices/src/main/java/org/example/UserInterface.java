package org.example;

import org.example.db.DBConnector;
import org.example.enums.Commands;
import org.example.model.Price;
import org.example.model.Shop;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {
    private static final int MAX_ATTEMPT_NUMBER = 3;
    private static final DBConnector DB_CONNECTOR = DBConnector.getInstance();
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zа-яА-ЯA-Z ]+$");
    // 1223123.31 intPrice -> 1223123; decimalPrice -> 31
    private static final Pattern PRICE_PATTERN = Pattern.compile("(?<intPrice>^\\d+)((,|.)(?<decimalPrice>\\d{1,2}))?$");
    private static final String HELP_COMMAND_TEXT = "\nДоступыне команды:\nhelp - вывод команд\ncreate product - создание продукта\ndelete product - удаление продукта\nshow products - вывод продуктов для определенного магазина\nexit - выход из программы\n";

    public static void setUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(HELP_COMMAND_TEXT);
        while (true) {
            System.out.print("\nВведите команду > ");
            String input = scanner.nextLine();
            Commands commands = Commands.valueFrom(input);
            switch (commands) {
                case HELP:
                    System.out.println(HELP_COMMAND_TEXT);
                    break;
                case CREATE_PRODUCT:
                    createProduct();
                    break;
                case SHOW_PRODUCTS:
                    showProducts();
                    break;
                case DELETE_PRODUCT:
                    deleteProduct();
                    break;
                case EXIT:
                    System.exit(0);
                case UNKNOWN_COMMAND:
                    System.out.println("Вы ввели неверную команду, попробуйте снова\n");
                    break;
                default:
                    System.out.println("Exception");
            }
        }
    }

    private static void deleteProduct() {
        System.out.println("Удаление продукта");
        String shopName = scanShopName();
        if (Objects.isNull(shopName)) {
            return;
        }
        int shopId = DBConnector.getInstance().selectShop(shopName).getId();

        String productName = scanProductName();
        if (Objects.nonNull(productName)) {
            Price p = DB_CONNECTOR.selectPrice(shopId, productName);
            DB_CONNECTOR.deletePrice(p.getId());
        }
        if (Objects.isNull(DB_CONNECTOR.selectPrice(shopId, productName))) {
            System.out.println("Продукт был удален.");
            return;
        }
        System.out.println("Продукт не был удален.");
    }

    private static void createProduct() {
        System.out.println("Создание продукта");
        String shopName = scanShopName();
        if (Objects.isNull(shopName)) {
            return;
        }
        int shopId = DBConnector.getInstance().selectShop(shopName).getId();

        String productName = scanProductName();
        if (Objects.nonNull(productName)) {
            long price = scanProductPrice();
            if (price != -1)
                DB_CONNECTOR.createPrice(new Price(productName, shopId, price));
        }
        if (Objects.nonNull(DB_CONNECTOR.selectPrice(shopId, productName))) {
            System.out.println("Продукт был создан.");
            return;
        }
        System.out.println("Продукт не был создан.");
    }

    private static void showProducts() {
        String shopName = scanShopName();
        if (Objects.isNull(shopName)) {
            return;
        }
        int shopId = DB_CONNECTOR.selectShop(shopName).getId();
        List<Price> prices = DB_CONNECTOR.selectAllPricesByShopId(shopId);
        if (prices.isEmpty()) {
            System.out.println("Товары для этого магазина не были найдены");
            return;
        }
        System.out.println("Вывод списка товаров для магазина");

        for (Price price : prices) {
            System.out.println(price);
        }
    }

    private static void showShops() {
        System.out.println("Список магазинов");
        List<Shop> shops = DB_CONNECTOR.selectAllShops();
        for (Shop shop : shops) {
            System.out.println(shop);
        }
    }

    public static String scanShopName() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < MAX_ATTEMPT_NUMBER; i++) {
            System.out.print("Введите название магазина > ");
            String shopName = scanner.nextLine();
            if (Objects.isNull(DB_CONNECTOR.selectShop(shopName))) {
                System.out.println("Вы ввели несуществующий магазин.");
                showShops();
            } else {
                return shopName;
            }
        }
        System.out.println("Превышено количество попыток ввода.");
        return null;
    }

    public static String scanProductName() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < MAX_ATTEMPT_NUMBER; i++) {
            System.out.print("Введите название продукта > ");
            String productName = scanner.nextLine();
            if (NAME_PATTERN.matcher(productName).matches()) {
                return productName;
            }
            System.out.println("Введено некорректное название. Введите слово без спецсимволов.");
        }
        System.out.println("Превышено количество попыток ввода.");
        return null;
    }

    public static long scanProductPrice() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < MAX_ATTEMPT_NUMBER; i++) {
            System.out.print("Введите цену продукта > ");
            String productPrice = scanner.nextLine();
            // 12.3
            if (PRICE_PATTERN.matcher(productPrice).matches()) {
                String decimalPart = getDecimalPart(productPrice);
                String intPart = getIntPart(productPrice);
                // в БД цена хранится в long, где послежние 2 цифры - число копеек
                while (decimalPart.length() < 2)
                    decimalPart += "0";
                // intPart = "12"; decimalPart = "30";
                // return Long.parseLong("1230");
                return Long.parseLong(intPart + decimalPart);
            } else {
                System.out.println("Введена неверная цена. Корректный формат '12', или '12,33', или '12.33'");
            }
        }
        System.out.println("Превышено количество попыток ввода.");
        return -1;
    }

    public static String getDecimalPart(String input) {
        Matcher m = PRICE_PATTERN.matcher(input);
        if(m.matches()) {
            String res = m.group("decimalPrice");
            return Objects.isNull(res) ? "" : res;
        }
        return "";
    }

    public static String getIntPart(String input) {
       Matcher m = PRICE_PATTERN.matcher(input);
        if(m.matches()) {
            String res = m.group("intPrice");
            return Objects.isNull(res) ? "" : res;
        }
        return "";
    }
}
