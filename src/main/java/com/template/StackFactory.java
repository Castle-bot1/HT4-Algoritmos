package com.template;
import java.util.Scanner;

/**
 * Fábrica (Factory Pattern) para crear la implementación de Stack deseada
 * El usuario elige qué implementación utilizar
 */
public class StackFactory {

    /**
     * Solicita al usuario la implementación deseada y retorna la pila correspondiente
     */
    public static <T> Stack<T> crearStack(Scanner scanner) {
        System.out.println("\n¿Qué implementación de Stack desea usar?");
        System.out.println("  1. ArrayList");
        System.out.println("  2. Vector");
        System.out.println("  3. Lista");
        System.out.print("Ingrese su opción (1-3): ");

        int opcion = leerOpcion(scanner, 1, 3);

        switch (opcion) {
            case 1:
                System.out.println("→ Usando Stack basado en ArrayList");
                return new ArrayListStack<>();
            case 2:
                System.out.println("→ Usando Stack basado en Vector");
                return new VectorStack<>();
            case 3:
                return crearListStack(scanner);
            default:
                throw new RuntimeException("Opción no válida");
        }
    }

    /**
     * Si se elige Stack basado en Lista, pide al usuario qué tipo de lista usar
     */
    private static <T> Stack<T> crearListStack(Scanner scanner) {
        System.out.println("\n¿Qué implementación de Lista desea usar para el Stack?");
        System.out.println("  1. Lista Simplemente Encadenada");
        System.out.println("  2. Lista Doblemente Encadenada");
        System.out.print("Ingrese su opción (1-2): ");

        int opcion = leerOpcion(scanner, 1, 2);

        switch (opcion) {
            case 1:
                System.out.println("→ Usando Stack basado en Lista Simplemente Encadenada");
                return new ListStack<>(new SinglyLinkedList<>());
            case 2:
                System.out.println("→ Usando Stack basado en Lista Doblemente Encadenada");
                return new ListStack<>(new DoublyLinkedList<>());
            default:
                throw new RuntimeException("Opción no válida");
        }
    }

    private static int leerOpcion(Scanner scanner, int min, int max) {
        while (true) {
            try {
                String linea = scanner.nextLine().trim();
                int valor = Integer.parseInt(linea);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.print("Por favor ingrese un número entre " + min + " y " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Opción inválida. Ingrese un número entre " + min + " y " + max + ": ");
            }
        }
    }
}
