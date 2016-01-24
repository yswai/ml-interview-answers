package com.swyep;

public class ArrayQueueImpl<T> extends AbstractArrayBased<T> implements Queue<T> {

    @Override
    synchronized public ArrayQueueImpl<T> enqueue(T item) {
        if (arr.length == total) resize(total * getFactor());

        return this;
    }

    @Override
    synchronized public T dequeue() {
        return null;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, tmp, 0, total);
        arr = tmp;
    }

}
