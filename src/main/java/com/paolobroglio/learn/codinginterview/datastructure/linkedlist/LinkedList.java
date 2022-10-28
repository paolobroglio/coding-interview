package com.paolobroglio.learn.codinginterview.datastructure.linkedlist;

import com.paolobroglio.learn.codinginterview.datastructure.exception.EmptyListException;
import com.paolobroglio.learn.codinginterview.datastructure.linkedlist.node.SingleLinkNode;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList implements List {
    private SingleLinkNode list;

    public LinkedList(Integer... elements) {
        Arrays.stream(elements)
                .forEach(this::pushBack);
    }

    private SingleLinkNode getNodeAt(int index) {
        if (index < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        SingleLinkNode tmp = list;
        for (int i = 0; i < index; i++){
            if (tmp == null)
                throw new IndexOutOfBoundsException();
            tmp = tmp.getNext();
        }
        if (tmp == null)
            throw new IndexOutOfBoundsException();
        return tmp;
    }

    public int size() {
        SingleLinkNode tmp = list;
        int count = 0;
        while(tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    public Boolean isEmpty() {
        return list == null;
    }

    public Integer at(int index) {
        return getNodeAt(index)
                .getInfo();
    }

    public void pushFront(Integer item) {
        this.list = new SingleLinkNode(item, list);
    }

    public Integer popFront() {
        if (isEmpty())
            throw new EmptyListException();
        SingleLinkNode tmp = list;
        list = list.getNext();
        return tmp.getInfo();
    }

    public void pushBack(Integer item) {
        SingleLinkNode newSingleLinkNode = new SingleLinkNode(item, null);
        if (isEmpty()){
            this.list = newSingleLinkNode;
        } else {
            SingleLinkNode tmp = list;
            while (tmp.hasNext()){
                tmp = tmp.getNext();
            }
            tmp.setNext(newSingleLinkNode);
        }
    }

    public Integer popBack() {
        if (isEmpty())
            throw new EmptyListException();
        int size = size();
        int lastIndex = size - 1;
        int newLastIndex = size - 2;
        if (lastIndex == 0) {
            Integer front = front();
            this.list = null;
            return front;
        }
        SingleLinkNode last = getNodeAt(lastIndex);
        SingleLinkNode newLast = getNodeAt(newLastIndex);
        Integer item = last.getInfo();
        newLast.setNext(null);
        return item;
    }

    public Integer front() {
        if (isEmpty())
            throw new EmptyListException();
        return list.getInfo();
    }

    public Integer back() {
        if (isEmpty())
            throw new EmptyListException();
        SingleLinkNode tmp = list;
        while (tmp.getNext() != null){
            tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    public void insert(int index, Integer item) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        SingleLinkNode tmp = list;
        for (int i = 0; i < index-1; i++){
            if (tmp == null)
                throw new IndexOutOfBoundsException();
            if (i == index - 1){
                break;
            }
            tmp = tmp.getNext();
        }
        SingleLinkNode next = tmp.getNext();
        SingleLinkNode newSingleLinkNode = new SingleLinkNode(item, next);
        tmp.setNext(newSingleLinkNode);
    }

    public void erease(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        SingleLinkNode tmp = list;
        for (int i = 0; i < index-1; i++){
            if (tmp == null)
                throw new IndexOutOfBoundsException();
            if (i == index - 1){
                break;
            }
            tmp = tmp.getNext();
        }
        if (tmp.getNext() != null){
            SingleLinkNode next = tmp.getNext().getNext();
            tmp.setNext(next);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Integer nthFromEnd(int index) {
        if (index < 0){
            throw new IllegalArgumentException("Index cannot be negative");
        }
        int normalizedIndex = size() - index;
        if (normalizedIndex < 0)
            throw new IndexOutOfBoundsException();
        return at(normalizedIndex);
    }

    public void remove(Integer item) {
        SingleLinkNode tmp = list;
        int index = 0;
        boolean found = false;
        while (tmp != null && !found){
            if (tmp.getInfo().equals(item)) {
                found = true;
                continue;
            }
            tmp = tmp.getNext();
            index++;
        }
        if (!found) {
            throw new NoSuchElementException("Item " + item + " doesn't exist");
        }
        erease(index);
    }

    public void reverse() {
        LinkedList newList = new LinkedList();
        for (int i = 0; i < size(); i++){
            newList.pushFront(at(i));
        }
        this.list = newList.list;
    }

    @Override
    public String toString() {
        SingleLinkNode tmp = list;
        StringBuilder sb = new StringBuilder("LinkedList{list={");
        while (tmp != null){
            sb.append(tmp.getInfo());
            if (tmp.hasNext()){
                sb.append(" -> ");
            }
            tmp = tmp.getNext();
        }
        sb.append("}");
        sb.append(" size=");
        sb.append(size());
        sb.append("}");
        return sb.toString();
    }
}
