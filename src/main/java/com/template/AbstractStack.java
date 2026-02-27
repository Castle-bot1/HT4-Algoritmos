package com.template;

/**
 * Clase abstracta para el ADT Pila (Stack)
 * Implementa comportamientos comunes y deja los específicos a las subclases
 */
public abstract class AbstractStack<T> implements Stack<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Error: La pila está vacía");
        }
        return peekElement();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Error: La pila está vacía");
        }
        return popElement();
    }

    // Métodos que cada implementación debe proveer
    protected abstract T peekElement();
    protected abstract T popElement();

    @Override
    public String toString() {
        return "Stack[size=" + size() + "]";
    }
}
