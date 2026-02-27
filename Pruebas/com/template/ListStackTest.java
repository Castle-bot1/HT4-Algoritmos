package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ListStackTest {
	
	private ListStack<Integer> pila;
	
	@BeforeEach
	void setUp() {
		pila = new ListStack<>(new DoublyLinkedList<>());
	}
	
	@Test
	void subirElementos() {
	    pila.push(1);
	    pila.push(2);
	    pila.push(3);
	    assertEquals(3, pila.size());
	}

	@Test
	void ultimoElemento() {
	    pila.push(5);
	    pila.push(15);
	    assertEquals(15, pila.peek());
	    assertEquals(2, pila.size());
	}

	@Test
	void eliminarUltimoElemento() {
	    pila.push(8);
	    pila.push(64);
	    pila.push(512);
	    int removido = pila.pop();
	    assertEquals(512, removido);
	    assertEquals(2, pila.size());
	    assertEquals(64, pila.peek());
	}

	@Test
	void ordenCorrecto() {
	    pila.push(3);
	    pila.push(6);
	    pila.push(9);
	    assertEquals(9, pila.pop());
	    assertEquals(6, pila.pop());
	    assertEquals(3, pila.pop());
	}

	@Test
	void errorPop() {
	    assertThrows(RuntimeException.class, () -> {
	        pila.pop();
	    });
	}

	@Test
	void errorPeek() {
	    assertThrows(RuntimeException.class, () -> {
	        pila.peek();
	    });
	}
}