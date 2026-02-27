package com.template;

/**
 * Clase abstracta para el ADT Lista
 */
public abstract class AbstractLista<T> implements Lista<T> {

    protected int size;

    public AbstractLista() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Error: La lista está vacía");
        }
        return removeLastElement();
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Error: La lista está vacía");
        }
        return getLastElement();
    }

    protected abstract T removeLastElement();
    protected abstract T getLastElement();
}
