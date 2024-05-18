package org.example;

public class Main {
    public static void main(String[] args) {
//        Conf conf = Conf.getInstance();
//        conf.t1 = "12";
//        System.out.println("Set new t1");
//        prinT1();

        ConfInterface confInterface = new BrowserConf();
        p(confInterface);
    }


    public static void p(ConfInterface c) {
        System.out.println(c.getApplicationName());
    }

    public static void prinT1(){
        Conf cong = Conf.getInstance();
        System.out.println(cong.t1);
    }
}