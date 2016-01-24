package com.swyep;

import java.util.NoSuchElementException;

public class ArrayStackImpl<T> implements Stack<T> {

    private T[] arr;
    private int total;

    public ArrayStackImpl () {
        arr = (T[]) (new Object[2]);
    }

    @Override
    synchronized public ArrayStackImpl<T> push(T item) {
        if (arr.length == total) resize(total * 2);
        arr[total++] = item;
        return this;
    }

    @Override
    synchronized public T pop() {
        if (total == 0) throw new NoSuchElementException();
        T value = arr[--total];
        arr[total] = null;
        if (total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return value;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, tmp, 0, total);
        arr = tmp;
    }

    @Override
    public T peek() {
        if (total == 0) throw new NoSuchElementException();
        return arr[total - 1];
    }

    @Override
    public String toString()
    {
        return java.util.Arrays.toString(arr);
    }

}
