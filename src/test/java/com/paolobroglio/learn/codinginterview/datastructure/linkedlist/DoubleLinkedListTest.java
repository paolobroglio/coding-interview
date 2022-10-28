package com.paolobroglio.learn.codinginterview.datastructure.linkedlist;

import com.paolobroglio.learn.codinginterview.datastructure.exception.EmptyListException;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {
    DoubleLinkedList cut;

    @Before
    public void setUp() throws Exception {
        cut = new DoubleLinkedList(1,2,3,4,5);
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
    public void atOutOfBoundsMustThrowIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.at(30));
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
    public void popBackThrowsEmptyListExceptionIfListIsEmpty() {
        cut = new DoubleLinkedList();
        assertThrows(EmptyListException.class, () -> cut.popBack());
    }

    @Test
    public void front() {
        assertEquals(Integer.valueOf(1), cut.front());
    }

    @Test
    public void frontThrowsEmptyListExceptionIfListIsEmpty() {
        cut = new DoubleLinkedList();
        assertThrows(EmptyListException.class, () -> cut.front());
    }

    @Test
    public void back() {
        assertEquals(Integer.valueOf(5), cut.back());
    }

    @Test
    public void backThrowsEmptyListExceptionIfListIsEmpty() {
        cut = new DoubleLinkedList();
        assertThrows(EmptyListException.class, () -> cut.back());
    }

    @Test
    public void insert() {
        cut.insert(2, -1);
        assertEquals(Integer.valueOf(-1), cut.at(2));
    }

    @Test
    public void erease() {
        cut.erease(2);
        assertEquals(Integer.valueOf(4), cut.at(2));
    }

    @Test
    public void ereaseThrowsIndexOutOfBoundsExceptionIfIndexIsOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.erease(12));
    }

    @Test
    public void nthFromEnd() {
        assertEquals(Integer.valueOf(4), cut.nthFromEnd(2));
    }

    @Test
    public void nthFromEndThrowsIndexOutOfBoundsIfIndexIsOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> cut.nthFromEnd(12));
    }

    @Test
    public void nthFromEndThrowsIllegalArgumentExceptionIfIndexIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> cut.nthFromEnd(-5));
    }

    @Test
    public void remove() {
        cut.remove(2);
        assertEquals(Integer.valueOf(4), cut.at(2));
    }

    @Test
    public void removeThrowsNoSuchElementExceptionIfItemDoesNotExist() {
        assertThrows(NoSuchElementException.class, () -> cut.remove(18));
    }

    @Test
    public void reverse() {
        cut.reverse();
        assertEquals(Integer.valueOf(5), cut.popFront());
    }
}