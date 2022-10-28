package com.paolobroglio.learn.codinginterview.datastructure.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayTest {

    Array cut;

    @Before
    public void setUp() throws Exception {
        cut = new Array(1,2,3,4,5,6,7,8,9,10);
    }

    @Test
    public void size() {
        assertEquals(10, cut.size());
    }

    @Test
    public void sizeShouldBeZeroOnEmptyArray() {
        cut = new Array();
        assertEquals(0, cut.size());
    }

    @Test
    public void capacity() {
        assertEquals(10, cut.capacity());
    }

    @Test
    public void capacityShouldBeDoubledOnFullCapacity() {
        assertEquals(10, cut.capacity());
        cut.push(11);
        assertEquals(20, cut.capacity());
    }

    @Test
    public void isEmpty() {
        assertFalse(cut.isEmpty());
    }

    @Test
    public void isEmptyReturnsTrueOnEmptyArray() {
        cut = new Array();
        assertTrue(cut.isEmpty());
    }

    @Test
    public void at() {
        assertEquals(Integer.valueOf(5), cut.at(4));
    }

    @Test
    public void atOutOfBoundsShouldThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.at(50));
    }

    @Test
    public void push() {
        cut.push(11);
        assertEquals(Integer.valueOf(11), cut.at(10));
    }

    @Test
    public void pushOnEmptyArray() {
        cut = new Array();
        cut.push(1);
        assertEquals(Integer.valueOf(1), cut.at(0));
    }

    @Test
    public void insert() {
        cut.insert(1, 50);
        assertEquals(Integer.valueOf(50), cut.at(1));
    }

    @Test
    public void prepend() {
        cut.prepend(100);
        assertEquals(Integer.valueOf(100), cut.at(0));
    }

    @Test
    public void pop() {
        assertEquals(Integer.valueOf(10), cut.pop());
        assertEquals(Integer.valueOf(9), cut.at(8));
    }

    @Test
    public void delete() {
        cut.delete(3);
        assertEquals(Integer.valueOf(5), cut.at(3));
    }

    @Test
    public void remove() {
        cut = new Array(1,1,1,1,1,2);
        cut.remove(1);
        assertEquals(Integer.valueOf(2), cut.at(0));
    }

    @Test
    public void find() {
        assertEquals(Integer.valueOf(4), cut.find(5));
        assertEquals(Integer.valueOf(-1), cut.find(50));
    }

    @Test
    public void range() {
        Array range = cut.range(0, 4);
        assertEquals(Integer.valueOf(4), range.at(3));
    }

    @Test
    public void negativeFromRangeShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cut.range(-1, 4));
    }

    @Test
    public void fromGreaterThanToRangeShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> cut.range(5, 1));
    }

    @Test
    public void capacityMustBeReducedByHalfIfFourTimesTheSize() {
        cut = new Array(16);
        cut.push(1);
        System.out.println();
        assertEquals(8, cut.capacity());
    }
}