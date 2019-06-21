package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        boolean result = false;
        for (int i = 0; i < this.tasks.size(); i++) {
            if (task.getPriority() <= this.tasks.get(i).getPriority()) {
               this.tasks.add(i, task);
               result = true;
               break;
            }
        }
        if (!result) {
            this.tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}