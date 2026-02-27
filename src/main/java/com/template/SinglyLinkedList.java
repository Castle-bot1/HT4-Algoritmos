package com.template;

/**
 * Implementación de Lista Simplemente Encadenada
 */
public class SinglyLinkedList<T> extends AbstractLista<T> {

    // Nodo interno
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    protected T removeLastElement() {
        if (head.next == null) {
            // Solo un elemento
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }

    @Override
    protected T getLastElement() {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }
}

