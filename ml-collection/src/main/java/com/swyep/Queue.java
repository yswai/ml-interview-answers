package com.swyep;

public interface Queue<T> {

    public void enqueue(T item);
    public T dequeue();

}
