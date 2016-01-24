package com.swyep;

public interface Queue<T> {

    public Queue<T> enqueue(T item);
    public T dequeue();
    public T peek();

}
