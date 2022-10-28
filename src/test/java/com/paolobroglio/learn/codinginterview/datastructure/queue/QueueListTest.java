package com.paolobroglio.learn.codinginterview.datastructure.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class QueueListTest {

    QueueList cut;

    private void enqueue10Messages() {
        IntStream.range(0, 10)
                .forEach(cut::enqueue);
    }

    @Before
    public void setUp() throws Exception {
        cut = new QueueList();
    }

    @Test
    public void enqueue() {
        enqueue10Messages();
        assertFalse(cut.isEmpty());
    }

    @Test
    public void dequeue() {
        enqueue10Messages();
        IntStream.range(0, 10)
                .forEach(i -> assertEquals(Integer.valueOf(i), cut.dequeue()));
    }

    @Test
    public void isEmpty() {
        assertTrue(cut.isEmpty());
        enqueue10Messages();
        assertFalse(cut.isEmpty());
    }
}