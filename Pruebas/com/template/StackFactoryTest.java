package com.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class StackFactoryTest {
	
	@Test
    void crearMemoria_Lista() {
        Scanner scanner = new Scanner("1\n");
        Stack<Integer> pila = StackFactory.crearStack(scanner);
        assertTrue(pila instanceof ArrayListStack);
    }

    @Test
    void crearMemoria_Vector() {
        Scanner scanner = new Scanner("2\n");
        Stack<Integer> pila = StackFactory.crearStack(scanner);
        assertTrue(pila instanceof VectorStack);
    }

    @Test
    void crearMemoria_ListaSimple() {
        Scanner scanner = new Scanner("3\n1\n");
        Stack<Integer> pila = StackFactory.crearStack(scanner);
        assertTrue(pila instanceof ListStack);
    }

    @Test
    void crearMemoria_ListaDoble() {
        Scanner scanner = new Scanner("3\n2\n");
        Stack<Integer> pila = StackFactory.crearStack(scanner);
        assertTrue(pila instanceof ListStack);
    }

    @Test
    void ingresosInvalidos() {
        Scanner scanner = new Scanner("a\n1\n");
        Stack<Integer> pila = StackFactory.crearStack(scanner);
        assertTrue(pila instanceof ArrayListStack);
    }

    @Test
    void rangoInvalido() {
        Scanner scanner = new Scanner("5\n2\n");
        Stack<Integer> pila = StackFactory.crearStack(scanner);
        assertTrue(pila instanceof VectorStack);
    }
}
