package com.template;

/**
 * Interfaz genérica para el ADT Pila (Stack)
 */
public interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
