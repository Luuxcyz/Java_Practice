package com.iweb.P18.demo2;

public class Basket {
    private int eggs = 0;

    public synchronized void putEgg() throws InterruptedException {
        int MAX_CAPACITY = 10;
        while (eggs >= MAX_CAPACITY) {
            wait(); // 篮子满了，kun线程等待
        }
        eggs++;
        System.out.println("放入一个蛋，现在篮子里有 " + eggs + " 个蛋。");
        notifyAll();
    }

    public synchronized void takeEgg() throws InterruptedException {
        while (eggs <= 0) {
            wait(); // 篮子空了，小黑子线程等待
        }
        eggs--;
        System.out.println("取出一个蛋，现在篮子里有 " + eggs + " 个蛋。");
        notifyAll();
    }
}

