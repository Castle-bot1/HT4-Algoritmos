package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PosffixCalculatorTest {
	private PostfixCalculator calculadora;
	
	@BeforeEach
	void setUp() {
		Stack<Integer> pila = new ListStack<>(new DoublyLinkedList<>());
		calculadora = new PostfixCalculator(pila);
	}
	
	@Test
	void sumaDigitos() {
		int resultado = calculadora.evaluarPostfix("10 20 +");
		assertEquals(30, resultado);
	}
	
	@Test
	void multiplicacionDigitos() {
		int resultado = calculadora.evaluarPostfix("10 20 + 9 *");
		assertEquals(270, resultado);
	}
	
	@Test void restaDigitos() {
		int resultado = calculadora.evaluarPostfix("10 5 -");
		assertEquals(5, resultado);
	}
	
	@Test void divisionDigitos() {
		int resultado = calculadora.evaluarPostfix("20 4 /");
		assertEquals(5, resultado);
	}
	
	@Test void operacionesMultiples() {
		int resultado = calculadora.evaluarPostfix("5 6 2 * + 3 -");
		assertEquals(14, resultado);
	}
	
	@Test void errorDivisionCero() {
		assertThrows(ArithmeticException.class, () -> {
			calculadora.evaluarPostfix("10 0 /");
			});
	}
	
	@Test void caracteresInvalidos() {
		assertThrows(RuntimeException.class, () -> {
			calculadora.evaluarPostfix("10 a +");
			});
	}
	
	@Test void operandosFaltantes() {
		assertThrows(RuntimeException.class, () -> {
			calculadora.evaluarPostfix("10 +");
			});
	}
	
	@Test void operandosSobrantes() {
		assertThrows(RuntimeException.class, () -> {
			calculadora.evaluarPostfix("10 20 30 +");
			});
	}

}
