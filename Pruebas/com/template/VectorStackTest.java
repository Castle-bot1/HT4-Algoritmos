package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class VectorStackTest {
	
	private VectorStack<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new VectorStack<>();
    }

    @Test
    void agregarElementos() {
        pila.push(10);
        pila.push(20);
        pila.push(30);
        assertEquals(3, pila.size());
    }

    @Test
    void obtenerUltimoElemento() {
        pila.push(5);
        pila.push(15);
        assertEquals(15, pila.peek());
        assertEquals(2, pila.size());
    }

    @Test
    void eliminarUltimoElemento() {
        pila.push(1);
        pila.push(2);
        pila.push(3);
        int eliminar = pila.pop();
        assertEquals(3, eliminar);
        assertEquals(2, pila.size());
        assertEquals(2, pila.peek());
    }

    @Test
    void ordenCorrecto() {
        pila.push(100);
        pila.push(200);
        pila.push(300);
        assertEquals(300, pila.pop());
        assertEquals(200, pila.pop());
        assertEquals(100, pila.pop());
        assertEquals(0, pila.size());
    }

    @Test
    void eliminarElementosListaVacia() {
        assertThrows(RuntimeException.class, () -> {
            pila.pop();
        });
    }

    @Test
    void obtenerElementosListaVacia() {
        assertThrows(RuntimeException.class, () -> {
            pila.peek();
        });
    }

}
