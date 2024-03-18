package com.iweb.P18.demo3;

/**
 * Created by Luu on 2024/3/19.
 */
import java.util.LinkedList;
import java.util.List;

public class TaskHall {
    private final int MAX_TASKS = 20;
    private final List<Task> tasks = new LinkedList<>();

    public synchronized void publishTask(Task task) throws InterruptedException {
        while (tasks.size() == MAX_TASKS) {
            wait(); // 任务大厅满了，NPC等待
        }
        tasks.add(task); // 发布新任务
        System.out.println("NPC编号 " + task.getNpcId() + " 发布了一个新任务,任务名称: " + task.getName());
        notifyAll(); // 唤醒等待的玩家
    }

    public synchronized Task acceptTask(int playerId) throws InterruptedException {
        while (tasks.isEmpty()) {
            wait(); // 任务大厅空了，玩家等待
        }
        Task task = tasks.remove(0); // 玩家接受任务
        System.out.println("玩家编号 " + playerId + " 接受了任务: " + task.toString());
        notifyAll(); // 唤醒等待的NPC
        return task;
    }

}

