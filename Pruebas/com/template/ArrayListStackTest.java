package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListStackTest {
	
	private ArrayListStack<String> stack;
	
	@BeforeEach
	void setUp() {
		stack = new ArrayListStack<>();
	}
	
	@Test
	void identificarVacio() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	@Test
	void agregarElemento() {
		stack.push("A");
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.size());
	}
	
	@Test
	void retornarUltimoElemento() {
		stack.push("A");
		stack.push("B");
		String ultimo = stack.peek();
		assertEquals("B", ultimo);
		assertEquals(2, stack.size());
	}
	
	@Test
	void eliminarUltimo() {
		stack.push("A");
		stack.push("B");
		String eliminado = stack.pop();
		assertEquals("B", eliminado);
		assertEquals(1, stack.size());
	}
	
	@Test
	void popExcepcion_Vacio() {
	    assertThrows(RuntimeException.class, () -> {
	        stack.pop();
	    });
	}
	
	@Test
	void peekExcepcion_Vacio() {
	    assertThrows(RuntimeException.class, stack::peek);
	}
}
