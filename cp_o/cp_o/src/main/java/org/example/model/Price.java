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

    @Override
    public String toString() {
        long fPartOfPrice = price / 100;
        long lPartOfPrice = price % 100;
        return String.format("'Name': '%s'; 'shopId' : '%d'; 'price':%d,%d", name, shop, fPartOfPrice, lPartOfPrice);
    }
}