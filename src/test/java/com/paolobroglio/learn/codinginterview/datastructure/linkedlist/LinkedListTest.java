package com.paolobroglio.learn.codinginterview.datastructure.linkedlist;

import com.paolobroglio.learn.codinginterview.datastructure.exception.EmptyListException;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList cut;

    @Before
    public void setUp() throws Exception {
        cut = new LinkedList(1,2,3,4,5);
    }

    @Test
    public void size() {
        assertEquals(5, cut.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(cut.isEmpty());
    }

    @Test
    public void at() {
        assertEquals(Integer.valueOf(3), cut.at(2));
    }

    @Test
    public void atThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.at(10));
    }

    @Test
    public void pushFront() {
        cut.pushFront(0);
        assertEquals(Integer.valueOf(0), cut.at(0));
    }

    @Test
    public void popFront() {
        assertEquals(Integer.valueOf(1), cut.popFront());
    }

    @Test
    public void popFrontThrowsEmptyListException() {
        cut = new LinkedList();
        assertThrows(EmptyListException.class, () -> cut.popFront());
    }

    @Test
    public void pushBack() {
        cut.pushBack(6);
        assertEquals(Integer.valueOf(6), cut.popBack());
    }

    @Test
    public void popBack() {
        assertEquals(Integer.valueOf(5), cut.popBack());
        assertEquals(Integer.valueOf(4), cut.popBack());
        assertEquals(Integer.valueOf(3), cut.popBack());
        assertEquals(Integer.valueOf(2), cut.popBack());
        assertEquals(Integer.valueOf(1), cut.popBack());
    }

    @Test
    public void popBackThrowsEmptyListException() {
        assertEquals(Integer.valueOf(5), cut.popBack());
        assertEquals(Integer.valueOf(4), cut.popBack());
        assertEquals(Integer.valueOf(3), cut.popBack());
        assertEquals(Integer.valueOf(2), cut.popBack());
        assertEquals(Integer.valueOf(1), cut.popBack());
        System.out.println(cut);
        assertThrows(EmptyListException.class, () -> cut.popBack());
    }

    @Test
    public void front() {
        assertEquals(Integer.valueOf(1), cut.front());
    }

    @Test
    public void frontThrowsEmpttListException() {
        cut = new LinkedList();
        assertThrows(EmptyListException.class, () -> cut.front());
    }

    @Test
    public void back() {
        assertEquals(Integer.valueOf(5), cut.back());
    }

    @Test
    public void backThrowsEmpttListException() {
        cut = new LinkedList();
        assertThrows(EmptyListException.class, () -> cut.back());
    }

    @Test
    public void insert() {
        cut.insert(2, -1);
        assertEquals(Integer.valueOf(-1), cut.at(2));
    }

    @Test
    public void insertThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.insert(12, 0));
    }

    @Test
    public void insertThrowsIllegalArgumentExceptionWithNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> cut.insert(-1, 0));
    }

    @Test
    public void erease() {
        cut.erease(2);
        assertEquals(Integer.valueOf(4), cut.at(2));
    }

    @Test
    public void ereaseThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.erease(12));
    }

    @Test
    public void ereaseThrowsIllegalArgumentExceptionWithNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> cut.erease(-1));
    }

    @Test
    public void nthFromEnd() {
        assertEquals(Integer.valueOf(4), cut.nthFromEnd(2));
    }

    @Test
    public void nthFromEndThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.nthFromEnd(20));
    }

    @Test
    public void nthFromEndThrowsIllegalArgumentExceptionWithNegativeIndex() {
        assertThrows(IllegalArgumentException.class, () -> cut.nthFromEnd(-1));
    }

    @Test
    public void remove() {
        cut.remove(2);
        assertEquals(Integer.valueOf(4), cut.at(2));
    }

    @Test
    public void removeThrowsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> cut.remove(180));
    }

    @Test
    public void reverse() {
        cut.reverse();
        assertEquals(Integer.valueOf(5), cut.popFront());
    }
}