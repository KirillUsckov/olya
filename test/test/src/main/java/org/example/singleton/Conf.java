package org.example.singleton;

import java.util.Objects;

/**
 *  Singleton - Одиночка
 *  Храним 1 объект на протяжении выполнения всей программы
 *  И чтобы иметь доступ чере 1 точку входа - getInstance()
 */
public class Conf {
    public String t1 = "111";
    private static Conf instance;

    private Conf() {}

    public static Conf getInstance() {
        if(Objects.isNull(instance)) {
            System.out.println("New object");
            instance = new Conf();
        }
        System.out.println("Return");
        return instance;
    }
}
