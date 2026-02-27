package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
	private SinglyLinkedList<Integer> lista;

    @BeforeEach
    void setUp() {
        lista = new SinglyLinkedList<>();
    }

    @Test
    void agregarElementosUltimo() {
        lista.addLast(10);
        lista.addLast(20);
        lista.addLast(30);
        assertEquals(3, lista.size());
    }

    @Test
    void obtenerElementoUltimo() {
        lista.addLast(5);
        lista.addLast(15);
        assertEquals(15, lista.getLast());
    }

    @Test
    void removerElementoUltimo() {
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        int eliminado = lista.removeLast();
        assertEquals(3, eliminado);
        assertEquals(2, lista.size());
        assertEquals(2, lista.getLast());
    }

    @Test
    void removerElementoUltimoListaVacia() {
        lista.addLast(100);
        int eliminado = lista.removeLast();
        assertEquals(100, eliminado);
        assertEquals(0, lista.size());
    }

    @Test
    void removerElementosTodos() {
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);

        assertEquals(3, lista.removeLast());
        assertEquals(2, lista.removeLast());
        assertEquals(1, lista.removeLast());
        assertEquals(0, lista.size());
    }

    @Test
    void removerErrorListaVacia() {
        assertThrows(RuntimeException.class, () -> {
            lista.removeLast();
        });
    }

    @Test
    void obtenerUltimoElementoListaVacia() {
        assertThrows(RuntimeException.class, () -> {
            lista.getLast();
        });
    }

}
