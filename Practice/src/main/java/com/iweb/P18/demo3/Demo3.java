package com.iweb.P18.demo3;

import com.iweb.P18.demo3.TaskHall;

public class Demo3 {
    public static void main(String[] args) {
        TaskHall taskHall = new TaskHall();

        // 模拟NPC线程发布任务
        for (int i = 0; i < 5; i++) {
            final int npcId = i;
            new Thread(() -> {
                try {
                    while (true) {
                        Task task = new Task("任务" + System.currentTimeMillis(), npcId);
                        taskHall.publishTask(task);
                        Thread.sleep(500); // 假设NPC发布任务的间隔
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 模拟玩家线程接受任务
        for (int i = 0; i < 10; i++) {
            final int playerId = i;
            new Thread(() -> {
                try {
                    while (true) {
                        taskHall.acceptTask(playerId);
                        Thread.sleep(1000); // 假设玩家完成任务的间隔
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
