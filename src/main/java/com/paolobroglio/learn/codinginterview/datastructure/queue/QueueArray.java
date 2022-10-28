package com.paolobroglio.learn.codinginterview.datastructure.queue;

import com.paolobroglio.learn.codinginterview.datastructure.array.Array;

public class QueueArray implements Queue{

    private final Array queue;

    public QueueArray() {
        this.queue = new Array();
    }

    @Override
    public void enqueue(Integer value) {
        this.queue.push(value);
    }

    @Override
    public Integer dequeue() {
        Integer value = this.queue.at(0);
        this.queue.delete(0);
        return value;
    }

    @Override
    public Boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public Boolean isFull() {
        return this.queue.size() == this.queue.capacity();
    }

    @Override
    public String toString() {
        return "QueueArray{" +
                "queue=" + queue +
                '}';
    }
}
