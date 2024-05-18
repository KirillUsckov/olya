package org.example;

/**
 * Наследовать можно ТОЛЬКО 1 класс - extends Conf
 * Имплементировать интерфейсов можэно сколько захочешь - implements ConfInterface
 */
public class BrowserConf implements ConfInterface {
    @Override
    public String getUrl() {
        return "Browser URL";
    }
    @Override
    public String getApplicationName() {
        String name ="1111";
        /**....**/
        return name + " name";
    }
}
