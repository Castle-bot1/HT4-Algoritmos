package com.template;

/**
 * Evaluador de expresiones postfix
 * Implementa Calculator para las operaciones aritméticas
 */
public class PostfixCalculator implements Calculator {

    private Stack<Integer> pila;

    public PostfixCalculator(Stack<Integer> pila) {
        this.pila = pila;
    }

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }

    @Override
    public int restar(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }

    @Override
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: División entre cero");
        }
        return a / b;
    }

    /**
     * Evalúa una expresión postfix
     * @param postfix expresión con tokens separados por espacio (ej: "10 20 + 9 *")
     * @return resultado entero
     */
    public int evaluarPostfix(String postfix) {
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (esOperador(token)) {
                if (pila.size() < 2) {
                    throw new RuntimeException("Error: Insuficientes operandos para la operación");
                }
                int b = pila.pop();
                int a = pila.pop();
                pila.push(realizarOperacion(a, b, token));
            } else {
                try {
                    pila.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new RuntimeException("Error: Token inválido '" + token + "'");
                }
            }
        }

        if (pila.size() != 1) {
            throw new RuntimeException("Error: Expresión postfix inválida (sobran operandos)");
        }

        return pila.pop();
    }

    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }

    private int realizarOperacion(int a, int b, String operador) {
        switch (operador) {
            case "+": return sumar(a, b);
            case "-": return restar(a, b);
            case "*": return multiplicar(a, b);
            case "/": return dividir(a, b);
            default:
                throw new RuntimeException("Error: Operador desconocido '" + operador + "'");
        }
    }
}
