package com.swyep;

public class ArrayQueueImpl<T> implements Queue<T> {

    @Override
    synchronized public ArrayQueueImpl<T> enqueue(T item) {
        return this;
    }

    @Override
    synchronized public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
       return null;
    }

}
