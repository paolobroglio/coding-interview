package com.paolobroglio.learn.codinginterview.datastructure.queue;

public interface Queue {
    void enqueue(Integer value);

    Integer dequeue();

    Boolean isEmpty();
}
