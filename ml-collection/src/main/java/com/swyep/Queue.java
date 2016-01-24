package com.swyep;

public interface Queue<T> extends Peekable<T> {

    public Queue<T> enqueue(T item);
    public T dequeue();

}
