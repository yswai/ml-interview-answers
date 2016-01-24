package com.swyep;

import java.util.NoSuchElementException;

public abstract class AbstractArrayBased<T> implements Peekable<T> {

    protected T[] arr;
    protected int total;
    private int factor = 2;

    public int getFactor() {
        return factor;
    }

    @Override
    public T peek() {
        if (total == 0) throw new NoSuchElementException();
        return arr[total - 1];
    }

}
