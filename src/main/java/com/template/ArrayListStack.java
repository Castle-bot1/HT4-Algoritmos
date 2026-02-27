package com.template;

import java.util.ArrayList;

/**
 * Implementación de Stack usando ArrayList
 */
public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> elementos;

    public ArrayListStack() {
        elementos = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        elementos.add(element);
    }

    @Override
    protected T popElement() {
        return elementos.remove(elementos.size() - 1);
    }

    @Override
    protected T peekElement() {
        return elementos.get(elementos.size() - 1);
    }

    @Override
    public int size() {
        return elementos.size();
    }
}

