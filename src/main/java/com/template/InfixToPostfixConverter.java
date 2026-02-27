package com.template;

/**
 * Convierte una expresión infix a postfix usando una pila (Stack)
 */
public class InfixToPostfixConverter {

    private Stack<String> pila;

    public InfixToPostfixConverter(Stack<String> pila) {
        this.pila = pila;
    }

    /**
     * Convierte una expresión infix a postfix
     * @param infix  expresión infix (ej: "(10+20)*9")
     * @return       expresión postfix con tokens separados por espacio (ej: "10 20 + 9 *")
     */
    public String convertir(String infix) {
        StringBuilder postfix = new StringBuilder();
        // Limpiar espacios para recorrer carácter a carácter
        String expresion = infix.replaceAll("\\s+", "");

        int i = 0;
        while (i < expresion.length()) {
            char ch = expresion.charAt(i);

            if (Character.isDigit(ch)) {
                // Leer el número completo (puede ser multi-dígito)
                StringBuilder numero = new StringBuilder();
                while (i < expresion.length() && Character.isDigit(expresion.charAt(i))) {
                    numero.append(expresion.charAt(i));
                    i++;
                }
                postfix.append(numero).append(" ");
                continue; // ya incrementamos i dentro del while

            } else if (ch == '(') {
                pila.push(String.valueOf(ch));

            } else if (ch == ')') {
                // Desapilar hasta encontrar '('
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    postfix.append(pila.pop()).append(" ");
                }
                if (!pila.isEmpty()) {
                    pila.pop(); // descartar '('
                } else {
                    throw new RuntimeException("Error: Paréntesis no balanceados en la expresión");
                }

            } else if (esOperador(String.valueOf(ch))) {
                // Desapilar mientras la precedencia del tope >= precedencia del ch
                while (!pila.isEmpty()
                        && !pila.peek().equals("(")
                        && precedencia(pila.peek()) >= precedencia(String.valueOf(ch))) {
                    postfix.append(pila.pop()).append(" ");
                }
                pila.push(String.valueOf(ch));

            } else {
                throw new RuntimeException("Error: Carácter no válido '" + ch + "'");
            }

            i++;
        }

        // Vaciar los operadores restantes en la pila
        while (!pila.isEmpty()) {
            String top = pila.pop();
            if (top.equals("(") || top.equals(")")) {
                throw new RuntimeException("Error: Paréntesis no balanceados en la expresión");
            }
            postfix.append(top).append(" ");
        }

        return postfix.toString().trim();
    }

    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/");
    }

    private int precedencia(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
