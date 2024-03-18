package com.iweb.P18.demo3;

public class Task {
    private final String name;
    private final int npcId; // 添加NPC的ID

    public Task(String name, int npcId) {
        this.name = name;
        this.npcId = npcId;
    }

    public String getName() {
        return name;
    }

    public int getNpcId() {
        return npcId;
    }

    @Override
    public String toString() {
        return String.format("任务名称: %s, 来自NPC编号: %d", name, npcId);
    }
}
