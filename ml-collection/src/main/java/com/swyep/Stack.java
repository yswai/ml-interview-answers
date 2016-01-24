package com.swyep;

public interface Stack<T> {

    public Stack<T> push(T item);
    public T pop();
    public T peek();

}
