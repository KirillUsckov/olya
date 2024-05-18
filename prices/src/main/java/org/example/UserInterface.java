package org.example;

import org.example.db.DBConnector;
import org.example.enums.Commands;
import org.example.model.Shop;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
    /*
        1. Убрать из интерфейса команды для магазинов
        2. Добавить команды для продуктов
        3. Обновить сообщение для помощи
     */
    private static String HELP_COMMAND_TEXT = "\nДоступыне команды:\nhelp - вывод команд\ncreate shop - создание магазина\nshow shops - вывод всех магазинов\nexit - выход из программы\n";
    public static void setUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(HELP_COMMAND_TEXT);
        while (true) {
            System.out.println("\nВведите команду > ");
            String input = scanner.nextLine();
            Commands commands = Commands.valueFrom(input);
            switch (commands) {
                case HELP:
                    System.out.println(HELP_COMMAND_TEXT);
                    break;
                case CREATE_SHOP:
                    createShop();
                    break;
                case SHOW_SHOPS:
                    showShops();
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

    private static void createShop() {
        System.out.println("Создание магазина");
        System.out.print("Введите название магазина > ");
        Scanner scanner = new Scanner(System.in);
        String shopName = scanner.nextLine();
        DBConnector.getInstance().createShop(new Shop(shopName));
        Shop createdShop = DBConnector.getInstance().selectShop(shopName);
        boolean isCreated = Objects.nonNull(createdShop);
        if(isCreated)
            System.out.println("Магазин '" + shopName + "' Был создан");
        else
            System.out.println("Магазин '" + shopName + "' не был создан");
    }

    private static void showShops() {
        System.out.println("Список магазинов");
        List<Shop> shops = DBConnector.getInstance().selectAllShops();
        for(Shop shop : shops) {
            System.out.println(shop);
        }
    }
}
