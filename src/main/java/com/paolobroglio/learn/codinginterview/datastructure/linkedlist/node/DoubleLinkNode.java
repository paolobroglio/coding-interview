package com.paolobroglio.learn.codinginterview.datastructure.linkedlist.node;

import java.util.Objects;

public class DoubleLinkNode implements Traversable {
    private DoubleLinkNode previous;
    private DoubleLinkNode next;

    private Integer info;

    public DoubleLinkNode(Integer info, DoubleLinkNode previous, DoubleLinkNode next) {
        this.previous = previous;
        this.next = next;
        this.info = info;
    }

    public DoubleLinkNode(Integer info) {
        this.info = info;
        this.previous = null;
        this.next = null;
    }

    public DoubleLinkNode getPrevious() {
        return previous;
    }

    public DoubleLinkNode setPrevious(DoubleLinkNode previous) {
        this.previous = previous;
        return this;
    }

    public DoubleLinkNode getNext() {
        return next;
    }

    public DoubleLinkNode setNext(DoubleLinkNode next) {
        this.next = next;
        return this;
    }

    @Override
    public Boolean hasNext() {
        return this.next != null;
    }

    @Override
    public Boolean hasPrevious() {
        return this.previous != null;
    }

    public Integer getInfo() {
        return info;
    }

    public DoubleLinkNode setInfo(Integer info) {
        this.info = info;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkNode that = (DoubleLinkNode) o;
        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
