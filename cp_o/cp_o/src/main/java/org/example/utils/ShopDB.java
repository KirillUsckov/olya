package org.example.utils;

import org.example.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDB {
    private List<Shop> shops = new ArrayList();

    public ShopDB() {
        shops.add(new Shop(1, "Shop1"));
        shops.add(new Shop(2, "Shop2"));
        shops.add(new Shop(3, "Shop3"));
    }

    public Shop findShop(String shopName) {
        for (Shop shop : shops) {
            if(shop.getName().equals(shopName)) {
                return shop;
            }
        }
        return null;
    }
}
