package com.template;

/**
 * Implementación de Lista Doblemente Encadenada
 */
public class DoublyLinkedList<T> extends AbstractLista<T> {

    // Nodo interno con referencias a siguiente y anterior
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    protected T removeLastElement() {
        T data = tail.data;
        if (head == tail) {
            // Solo un nodo
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    @Override
    protected T getLastElement() {
        return tail.data;
    }
}

