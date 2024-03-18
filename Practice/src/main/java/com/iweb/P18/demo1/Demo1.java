package com.iweb.P18.demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo1 {
    public static void main(String[] args) {
        // 创建一个容量为20的阻塞队列
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(20);

        // 创建30个生产者线程
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        // 向队列中放入元素，如果队列满了，线程会被阻塞
                        queue.put("item");
                        System.out.println("已放入数据，当前队列大小: " + queue.size());
                    }
                } catch (InterruptedException e) {
                    // 如果线程被中断，设置线程的中断状态
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        // 创建30个消费者线程
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        // 从队列中取出元素，如果队列空了，线程会被阻塞
                        String item = queue.take();

                        System.out.println("已取出数据，当前队列大小: " + queue.size());
                    }
                } catch (InterruptedException e) {
                    // 如果线程被中断，设置线程的中断状态
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
