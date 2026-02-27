package com.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal del programa
 * Lee expresiones infix desde datos.txt, las convierte a postfix y las evalúa
 */
public class Main {

    public static void main(String[] args) {
        String nombreArchivo = "src/datos.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   CALCULADORA INFIX --> POSTFIX");
        System.out.println("==============================================");

        // El usuario elige la implementación de Stack para la conversión y evaluación
        System.out.println("\n--- Configuracion del Stack para CONVERSION infix -> postfix ---");
        Stack<String> pilaConversion = StackFactory.crearStack(scanner);

        System.out.println("\n--- Configuracion del Stack para EVALUACION postfix ---");
        Stack<Integer> pilaEvaluacion = StackFactory.crearStack(scanner);

        InfixToPostfixConverter converter = new InfixToPostfixConverter(pilaConversion);
        PostfixCalculator calculadora = new PostfixCalculator(pilaEvaluacion);

        System.out.println("\n==============================================");
        System.out.println("  Procesando expresiones del archivo...");
        System.out.println("==============================================\n");

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) {
                    continue;
                }

                System.out.println("Linea " + numeroLinea + ":");
                System.out.println("  Expresion Infix  : " + linea.trim());

                try {
                    String postfix = converter.convertir(linea.trim());
                    System.out.println("  Expresion Postfix: " + postfix);

                    int resultado = calculadora.evaluarPostfix(postfix);
                    System.out.println("  Resultado        : " + resultado);

                } catch (Exception e) {
                    System.out.println("  ERROR: " + e.getMessage());
                }

                System.out.println("----------------------------------------------");
            }

            System.out.println("\nFin del programa.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo '" + nombreArchivo + "': " + e.getMessage());
            System.err.println("Asegurese de que el archivo 'datos.txt' existe en el directorio de ejecucion.");
        } finally {
            scanner.close();
        }
    }
}
