package edu.kis.vh.nursery.storage;

public interface IntStorage {

    static final int IS_EMPTY = 0;
    void push(int value);
    int pop();
    int top();
    int getTotal();
    boolean isEmpty();
    boolean isFull();
}