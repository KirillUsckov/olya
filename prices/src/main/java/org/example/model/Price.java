package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
public class Price {
    private int id;
    private String name;
    private int shop;
    private long price;

    public Price(String name, int shop, long price) {
        this.name = name;
        this.shop = shop;
        this.price = price;
    }

    public long getPriceIntPart() {
        return price / 100;
    }

    public long getPriceDecimalPart() {
        return price % 100;
    }
    public String getStringPrice() {
        return String.format("%d,%d", getPriceIntPart(), getPriceDecimalPart());
    }

    @Override
    public String toString() {
        return String.format("'Name': '%s'; 'shopId' : '%d'; 'price':%s", name, shop, getStringPrice());
    }
}