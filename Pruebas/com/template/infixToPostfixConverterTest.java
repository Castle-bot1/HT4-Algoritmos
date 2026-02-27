package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class infixToPostfixConverterTest {
	
	private InfixToPostfixConverter vuelta;
	
	@BeforeEach
	void setUp() {
		Stack<String> pila = new ListStack<>(new DoublyLinkedList<>());
		vuelta = new InfixToPostfixConverter(pila);
	} 
	
	@Test void adicionSimple() {
		String resultado = vuelta.convertir("10+20");
		assertEquals("10 20 +", resultado);
	}
	
	@Test void precedenciaOperadores() {
		String resultado = vuelta.convertir("10+20*9");
		assertEquals("10 20 9 * +", resultado);
	}
	
	@Test void parentesisFuncion() {
		String resultado = vuelta.convertir("(10+20)*9");
		assertEquals("10 20 + 9 *", resultado);
	}
	
	@Test void multiplesOperadores() {
		String resultado = vuelta.convertir("5+6*2-3");
		assertEquals("5 6 2 * + 3 -", resultado);
	} 
	
	@Test void multiplesDigitos() {
		String resultado = vuelta.convertir("100*(25+5)");
		assertEquals("100 25 5 + *", resultado);
	}
	
	@Test void expresionesEspacios() {
		String resultado = vuelta.convertir(" ( 10 + 20 ) * 9 ");
		assertEquals("10 20 + 9 *", resultado);
	}
	
	@Test void errorParentesis() {
		assertThrows(RuntimeException.class, () -> {
			vuelta.convertir("(10+20*9");
			});
	} 
	
	@Test void caracteresInvalidos() {
		assertThrows(RuntimeException.class, () -> {
			vuelta.convertir("10+a");
			});
	}

}
