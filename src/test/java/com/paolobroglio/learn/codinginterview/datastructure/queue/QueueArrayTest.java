package com.paolobroglio.learn.codinginterview.datastructure.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class QueueArrayTest {

    QueueArray cut;

    private void enqueueNMessages(int n) {
        IntStream.range(1, n+1)
                .forEach(cut::enqueue);
    }

    @Before
    public void setUp() throws Exception {
        cut = new QueueArray();
    }

    @Test
    public void enqueue() {
        enqueueNMessages(10);
        System.out.println(cut);
        assertFalse(cut.isEmpty());
    }

    @Test
    public void dequeue() {
        enqueueNMessages(10);
        IntStream.range(1, 10)
                .forEach(i -> {
                    System.out.println(cut);
                    assertEquals(Integer.valueOf(i), cut.dequeue());
                });
    }

    @Test
    public void isEmpty() {
        assertTrue(cut.isEmpty());
        enqueueNMessages(10);
        assertFalse(cut.isEmpty());
    }
}