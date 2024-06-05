package org.example.enums;

public enum Commands {
    HELP("help"),
    EXIT("exit"),
    CREATE_PRODUCT("create product"),
    SHOW_PRODUCTS("show products"),
    DELETE_PRODUCT("delete product"),
    UNKNOWN_COMMAND("unknown command");

    public String stringName;

    Commands(String stringName) {
        this.stringName = stringName;
    }

    public static Commands valueFrom(String input) {
       for (Commands c : Commands.values()) {
           if(c.stringName.equals(input)) {
               return c;
           }
       }
       return UNKNOWN_COMMAND;
    }
}
