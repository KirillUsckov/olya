package org.example.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.DBConnection;
import org.example.model.Price;
import org.example.model.Shop;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
     Создать методы update, create, delete для продуктов
 */
public class DBConnector {
    private static DBConnector instance = null;
    private static DBConnection dbCM;
    private Connection connection;

    private DBConnector() {}

    public static DBConnector getInstance() {
        if (instance == null) {
            setDBConnection();
            instance = new DBConnector();
        }
        return instance;
    }

    private static void setDBConnection() {
        try {
            String json = String.join("", Files.readAllLines(Paths.get(".", "src/main/resources/dbConf.json")));
            dbCM = new ObjectMapper().readValue(json, DBConnection.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(dbCM.getUrl(), dbCM.getUsername(), dbCM.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shop> selectAllShops() {
        List<Shop> allShops = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM shop;");

            while (rs.next()) {
                allShops.add(
                        new Shop(
                                rs.getInt("Id"),
                                rs.getString("Name")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allShops;
    }

    public Shop selectShop(String shopName) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM shop WHERE Name = \"%s\";", shopName));

            while (rs.next()) {
                return new Shop(
                                rs.getInt("Id"),
                                rs.getString("Name")
                        );
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    public void createShop(Shop shop) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format("INSERT INTO shop(Name) value (\"%s\");", shop.getName()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean deleteShop(int shopId) {
        try {
            Statement statement = connection.createStatement();
            return statement.execute(String.format("DELETE from shop WHERE Id=%d;", shopId));
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteShop(String shopName) {
        try {
            Statement statement = connection.createStatement();
            return statement.execute(String.format("DELETE from shop WHERE Name=\"%s\";", shopName));
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateShop(Shop shop) {
        try {
            Statement statement = connection.createStatement();
            return statement.execute(String.format("UPDATE shop SET Name = \"%s\" WHERE Id=%d;", shop.getName(), shop.getId()));
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Price> selectAllPricesByShopId(int shopID) {
        List<Price> allPrices = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM price WHERE Shop=%d;", shopID));

            while (rs.next()) {
                allPrices.add(
                        new Price(
                                rs.getInt("Id"),
                                rs.getString("Name"),
                                rs.getInt("Shop"),
                                rs.getLong("Price")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allPrices;
    }
}
