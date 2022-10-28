package com.paolobroglio.learn.codinginterview.datastructure.linkedlist;

import com.paolobroglio.learn.codinginterview.datastructure.exception.EmptyListException;
import com.paolobroglio.learn.codinginterview.datastructure.linkedlist.node.DoubleLinkNode;
import com.paolobroglio.learn.codinginterview.datastructure.linkedlist.node.SingleLinkNode;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoubleLinkedList implements List {
    private DoubleLinkNode list;

    public DoubleLinkedList(Integer... elements) {
        Arrays.stream(elements)
                .forEach(this::pushBack);
    }

    @Override
    public int size() {
        DoubleLinkNode tmp = list;
        int count = 0;
        while(tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    @Override
    public Boolean isEmpty() {
        return list == null;
    }

    @Override
    public Integer at(int index) {
        DoubleLinkNode tmp = list;
        for (int i = 0; i < index; i++){
            if (tmp == null)
                throw new IndexOutOfBoundsException();
            tmp = tmp.getNext();
        }
        if (tmp == null)
            throw new IndexOutOfBoundsException();
        return tmp.getInfo();
    }

    @Override
    public void pushFront(Integer item) {
        if (isEmpty()){
            list = new DoubleLinkNode(item, null, null);
        }else {
            DoubleLinkNode tmp = list;
            list = new DoubleLinkNode(item, null, tmp);
            tmp.setPrevious(list);
        }
    }

    @Override
    public Integer popFront() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        DoubleLinkNode tmp = list;
        list = list.getNext();
        list.setPrevious(null);
        return tmp.getInfo();
    }

    @Override
    public void pushBack(Integer item) {
        if (isEmpty()){
            list = new DoubleLinkNode(item, null, null);
        } else {
            DoubleLinkNode tmp = list;
            while(tmp.hasNext()){
                tmp = tmp.getNext();
            }
            DoubleLinkNode newNode = new DoubleLinkNode(item, tmp, null);
            tmp.setNext(newNode);
        }
    }

    @Override
    public Integer popBack() {
        if (isEmpty())
            throw new EmptyListException("List is empty");
        DoubleLinkNode tmp = list;
        while(tmp.hasNext()){
            tmp = tmp.getNext();
        }
        Integer item = tmp.getInfo();
        if (Objects.isNull(tmp.getPrevious())){
            this.list = null;
        } else {
            tmp.getPrevious().setNext(null);
        }
        return item;
    }

    @Override
    public Integer front() {
        if (isEmpty())
            throw new EmptyListException();
        return list.getInfo();
    }

    @Override
    public Integer back() {
        if (isEmpty())
            throw new EmptyListException();
        DoubleLinkNode tmp = list;
        while (tmp.hasNext()){
            tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    @Override
    public void insert(int index, Integer item) {
        DoubleLinkNode tmp = list;
        for (int i = 0; i < index; i++){
            if (tmp == null)
                throw new IndexOutOfBoundsException();
            tmp = tmp.getNext();
        }
        DoubleLinkNode node = new DoubleLinkNode(item, tmp.getPrevious(), tmp);
        tmp.getPrevious().setNext(node);
        tmp.getNext().setPrevious(node);
    }

    @Override
    public void erease(int index) {
        DoubleLinkNode tmp = list;
        for (int i = 0; i < index; i++){
            if (tmp == null)
                throw new IndexOutOfBoundsException();
            tmp = tmp.getNext();
        }
        DoubleLinkNode next = tmp.getNext();
        DoubleLinkNode prev = tmp.getPrevious();
        prev.setNext(next);
        next.setPrevious(prev);
    }

    @Override
    public Integer nthFromEnd(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        int normalizedIndex = size() - index;
        if (normalizedIndex < 0)
            throw new IndexOutOfBoundsException();
        return at(normalizedIndex);
    }

    @Override
    public void remove(Integer item) {
        DoubleLinkNode tmp = list;
        int index = 0;
        boolean found = false;
        while (tmp.hasNext() && !found){
            if (tmp.getInfo().equals(item)){
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

    @Override
    public void reverse() {
        DoubleLinkedList newList = new DoubleLinkedList();
        for (int i = 0; i < size(); i++){
            newList.pushFront(at(i));
        }
        this.list = newList.list;
    }

    @Override
    public String toString() {
        DoubleLinkNode tmp = list;
        StringBuilder sb = new StringBuilder("DoubleLinkedList{list={");
        while (tmp != null){
            sb.append(tmp.getInfo());
            if (tmp.hasNext()){
                sb.append(" -> ");
            }
            tmp = tmp.getNext();
        }
        sb.append("}}");
        return sb.toString();
    }
}
