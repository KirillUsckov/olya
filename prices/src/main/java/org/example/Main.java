package org.example;

import org.example.db.DBConnector;
import org.example.model.DBConnection;
import org.example.model.Shop;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    /*
     *  Найти информацию о товарах, продающихся в магазине, название которого введено с клавиатуры
     */
    public static void main(String[] args) {

        DBConnector.getInstance().connect();
        UserInterface.setUp();
    }
}
