package com.template;

import java.util.Vector;

/**
 * Implementación de Stack usando Vector
 */
public class VectorStack<T> extends AbstractStack<T> {

    private Vector<T> elementos;

    public VectorStack() {
        elementos = new Vector<>();
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

