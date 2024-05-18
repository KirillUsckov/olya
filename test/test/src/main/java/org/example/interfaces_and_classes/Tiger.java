package org.example.interfaces_and_classes;

public class Tiger extends Cat implements Runnable {
    @Override
    public void run() {
        System.out.println("tiger runs");
    }

    @Override
    public String saySmth() {
        return null;
    }
}
