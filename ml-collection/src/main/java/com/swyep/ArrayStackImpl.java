package com.swyep;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStackImpl<T> extends AbstractArrayBased<T> implements Stack<T> {

    public ArrayStackImpl () {
        arr = (T[]) (new Object[2]);
    }

    @Override
    synchronized public ArrayStackImpl<T> push(T item) {
        if (arr.length == total) resize(total * getFactor());
        arr[total++] = item;
        return this;
    }

    @Override
    synchronized public T pop() {
        if (total == 0) throw new NoSuchElementException();
        T value = arr[--total];
        arr[total] = null;
        if (total > 0 && total == arr.length / getFactor()) resize(arr.length / getFactor());
        return value;
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, tmp, 0, total);
        arr = tmp;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stack)) return false;

        AbstractArrayBased that = (AbstractArrayBased) o;

        if (!Arrays.equals(arr, that.arr)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return arr != null ? Arrays.hashCode(arr) : 0;
    }
}
