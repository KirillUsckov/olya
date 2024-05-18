package org.example.singleton;

import org.example.ConfInterface;

public class AndroidConf implements ConfInterface {
    @Override
    public String getUrl() {
        return "Android url";
    }

    @Override
    public String getApplicationName() {
        return "Android";
    }
}
