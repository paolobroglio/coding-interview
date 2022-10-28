package com.paolobroglio.learn.codinginterview.datastructure.linkedlist.node;

import java.util.Objects;

public class SingleLinkNode implements Traversable {
    private Integer info;
    private SingleLinkNode next;

    public SingleLinkNode(Integer info) {
        this.info = info;
        this.next = null;
    }

    public SingleLinkNode(Integer info, SingleLinkNode next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public Boolean hasNext() {
        return this.next != null;
    }

    @Override
    public Boolean hasPrevious() {
        return false;
    }

    public Integer getInfo() {
        return info;
    }

    public SingleLinkNode setInfo(Integer info) {
        this.info = info;
        return this;
    }

    public SingleLinkNode getNext() {
        return next;
    }

    public SingleLinkNode setNext(SingleLinkNode next) {
        this.next = next;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleLinkNode that = (SingleLinkNode) o;
        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}
