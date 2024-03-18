package com.iweb.P18.demo2;

public class Demo2 {
    public static void main(String[] args) {
        Basket basket = new Basket();

        // 创建10个kun线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        basket.putEgg();
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 创建10个小黑子线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        basket.takeEgg();
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
