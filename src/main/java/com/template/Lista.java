package com.template;
/**
 * Interfaz genérica para el ADT Lista
 */
public interface Lista<T> {
    void addLast(T element);   // equivale a push (agregar al final)
    T removeLast();            // equivale a pop (remover del final)
    T getLast();               // equivale a peek (ver el último)
    boolean isEmpty();
    int size();
}
