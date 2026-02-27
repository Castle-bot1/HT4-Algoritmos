package com.template;

/**
 * Implementación de Stack usando una Lista (simplemente o doblemente encadenada)
 */
public class ListStack<T> extends AbstractStack<T> {

    private Lista<T> lista;

    public ListStack(Lista<T> lista) {
        this.lista = lista;
    }

    @Override
    public void push(T element) {
        lista.addLast(element);
    }

    @Override
    protected T popElement() {
        return lista.removeLast();
    }

    @Override
    protected T peekElement() {
        return lista.getLast();
    }

    @Override
    public int size() {
        return lista.size();
    }
}
