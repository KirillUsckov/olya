package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Shop {
    private int id;
    private String name;

    public Shop(String name) {
        this.name = name;
    }
}
