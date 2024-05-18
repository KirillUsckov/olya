package org.example.enums;

public enum Commands {
    HELP("help"),
    EXIT("exit"),
    CREATE_SHOP("create shop"),
    SHOW_SHOPS("show shops"),
    DELETE_SHOP("delete shop"),
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
