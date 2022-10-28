package com.paolobroglio.learn.codinginterview.datastructure.array;

import java.util.Arrays;
import java.util.Objects;

public class Array {

    private Integer[] array;
    private int capacity;

    private int size;

    private void newInstance(int capacity) {
        this.array = new Integer[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public Array() {
        this.newInstance(2);
    }

    public Array(int capacity) {
        this.newInstance(capacity);
    }

    public Array(Integer... elements) {
        this.array = elements;
        this.capacity = elements.length;
        this.size = elements.length;
    }

    private void modifySizeBy(int value){
        this.size += value;
    }

    private void incrementSize(){
        this.modifySizeBy(1);
    }

    private void decrementSize(){
        this.modifySizeBy(-1);
    }

    private void resize(int newCapacity) {
        Integer[] tempArray = new Integer[newCapacity];
        System.arraycopy(this.array, 0, tempArray, 0, this.size);
        this.array = tempArray;
        this.capacity = newCapacity;
    }

    private Boolean isUnderloadedInCapacity() {
        return this.size * 4 <= this.capacity;
    }

    private Integer[] slice(int from, int to) {
        if (from < 0 || to < 0) {
            throw new IllegalArgumentException("'from' and 'to' arguments cannot be negative");
        }
        if (from > to){
            throw new IllegalArgumentException("'from' cannot be greater than 'to'");
        }
        int cap = to - from + 1;
        Integer[] slice = new Integer[cap];
        int index = 0;
        for(int i = from; i <= to; i++) {
            slice[index] = this.array[i];
            index++;
        }
        return slice;
    }

    public Array range(int from, int to) {
        return new Array(this.slice(from, to));
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return this.capacity;
    }

    public Boolean isEmpty() {
        return this.size() == 0;
    }

    public Integer at(int index) throws IndexOutOfBoundsException {
        return this.array[index];
    }

    public void push(Integer item) {
        int currentSize = this.size();
        if (currentSize == this.capacity) {
            resize(this.capacity * 2);
        }
        if (isUnderloadedInCapacity()) {
            resize(this.capacity / 2);
        }
        this.array[currentSize] = item;
        this.incrementSize();
    }

    public void insert(int index, Integer item) {
        if (this.capacity >= this.size()){
            resize(this.capacity * 2);
        }
        if (isUnderloadedInCapacity()) {
            resize(this.capacity / 2);
        }
        if (index == 0) {
            Integer[] newArray = new Integer[this.capacity];
            newArray[0] = item;
            int j = 1;
            for (int i = 0; i < this.size; i++){
                newArray[j] = this.array[i];
            }
            this.array = newArray;
            this.incrementSize();
        } else if (index < this.size() - 1){
            Integer[] firstChunk = this.slice(0, index - 1);
            Integer[] secondChunk = this.slice(index, this.size() - 1);
            Integer[] tempNewArray = new Integer[this.size()+1];
            System.arraycopy(firstChunk, 0, tempNewArray, 0, firstChunk.length);
            tempNewArray[index] = item;
            int j = index + 1;
            for (Integer integer : secondChunk) {
                tempNewArray[j] = integer;
                j++;
            }
            this.array = tempNewArray;
            this.incrementSize();
        } else {
            this.push(item);
        }
    }

    public void prepend(Integer item) {
        this.insert(0, item);
    }

    public Integer pop() {
        if (this.size() * 4 == this.capacity) {
            resize(this.capacity / 2);
        }
        if (isUnderloadedInCapacity()) {
            resize(this.capacity / 2);
        }
        Integer lastElement = this.array[this.size() - 1];
        this.array = this.slice(0, this.size() - 2);
        this.decrementSize();
        return lastElement;
    }

    public void delete(int index) {
        if (this.size() * 4 == this.capacity) {
            resize(this.capacity / 2);
        }
        if (isUnderloadedInCapacity()) {
            resize(this.capacity / 2);
        }
        Integer[] tempNewArray = new Integer[this.capacity];
        int j = 0;
        for(int i = 0; i < this.size(); i++) {
            if (i == index) continue;
            tempNewArray[j] = this.array[i];
            j++;
        }
        this.array = tempNewArray;
        this.decrementSize();
    }

    public void remove(Integer item) {
        if (this.size() * 4 == this.capacity) {
            resize(this.capacity / 2);
        }
        if (isUnderloadedInCapacity()) {
            resize(this.capacity / 2);
        }
        Integer[] tempNewArray = new Integer[this.capacity];
        int j = 0;
        for(int i = 0; i < this.size(); i++) {
            Integer found = this.array[i];
            if (Objects.equals(found, item)) continue;
            tempNewArray[j] = this.array[i];
            j++;
        }
        this.array = tempNewArray;
        this.decrementSize();
    }

    public Integer find(Integer item) {
        for(int i = 0; i < this.size(); i++) {
            Integer found = this.array[i];
            if (Objects.equals(found, item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
