package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
	DoublyLinkedList<String> lista;
	
	@BeforeEach
	void setUp() {
	    lista = new DoublyLinkedList<>();
	}
	
	@Test
	void identificarVacio() {
		assertTrue(lista.isEmpty());
		assertEquals(0, lista.size());
	}
	
	@Test
    void agregarElemento() {
        lista.addLast("Hola");
        lista.addLast("Comida");

        assertEquals("Comida", lista.getLastElement());
    }

    @Test
    void removerElemento() {
        lista.addLast("Pollo");
        lista.addLast("Escritorio");

        String removido = lista.removeLastElement();

        assertEquals("Escritorio", removido);
        assertEquals("Pollo", lista.getLastElement());
    }
}
