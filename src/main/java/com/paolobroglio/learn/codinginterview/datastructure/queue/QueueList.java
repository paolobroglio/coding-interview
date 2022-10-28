package com.paolobroglio.learn.codinginterview.datastructure.queue;

import com.paolobroglio.learn.codinginterview.datastructure.linkedlist.LinkedList;

public class QueueList implements Queue{
    private final LinkedList queue;

    public QueueList() {
        this.queue = new LinkedList();
    }

    public void enqueue(Integer value) {
        queue.pushBack(value);
    }

    public Integer dequeue() {
        return queue.popFront();
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueList{" +
                "queue=" + queue +
                '}';
    }
}
