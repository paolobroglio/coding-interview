package com.paolobroglio.learn.codinginterview.datastructure.linkedlist;

import com.paolobroglio.learn.codinginterview.datastructure.linkedlist.node.SingleLinkNode;

public interface List {

    int size();

    Boolean isEmpty();

    Integer at(int index);

    void pushFront(Integer item);

    Integer popFront();

    void pushBack(Integer item);

    Integer popBack();

    Integer front();

    Integer back();

    void insert(int index, Integer item);

    void erease(int index);

    Integer nthFromEnd(int index);

    void remove(Integer item);

    void reverse();
}
