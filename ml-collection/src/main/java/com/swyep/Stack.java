package com.swyep;

public interface Stack<T> extends Peekable<T> {

    public Stack<T> push(T item);

    public T pop();

}
