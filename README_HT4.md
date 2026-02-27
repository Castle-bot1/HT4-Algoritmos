# Hoja de Trabajo 4 - Pilas, Listas y Patrones de Diseño

**Curso:** Algoritmos y Estructura de Datos  
**Desarrolladores:** Diego Castillo y Henry Guzman

---

## Descripción

Programa en Java que lee expresiones matemáticas en formato **infix** desde un archivo de texto (`datos.txt`), las convierte a formato **postfix** y las evalúa para obtener el resultado.

Por ejemplo:
- Infix: `(10+20)*9`
- Postfix: `10 20 + 9 *`
- Resultado: `270`

---

## Estructura del proyecto

El programa implementa dos ADTs principales:

**ADT Stack (Pila)**
- `Stack.java` — interfaz
- `AbstractStack.java` — clase abstracta
- `ArrayListStack.java` — implementación con ArrayList
- `VectorStack.java` — implementación con Vector
- `ListStack.java` — implementación usando una Lista

**ADT Lista**
- `Lista.java` — interfaz
- `AbstractLista.java` — clase abstracta
- `SinglyLinkedList.java` — lista simplemente encadenada
- `DoublyLinkedList.java` — lista doblemente encadenada

**Lógica principal**
- `Calculator.java` — interfaz de operaciones aritméticas
- `InfixToPostfixConverter.java` — convierte infix a postfix
- `PostfixCalculator.java` — evalúa expresiones postfix
- `StackFactory.java` — permite elegir la implementación de Stack
- `Main.java` — clase principal

---

## Cómo ejecutar

1. Compilar todos los archivos:
```
javac *.java
```

2. Ejecutar:
```
java Main
```

3. Al iniciar, el programa pedirá elegir la implementación de Stack a utilizar:
```
¿Qué implementación de Stack desea usar?
  1. ArrayList
  2. Vector
  3. Lista
```
Si se elige **Lista**, también pedirá elegir entre lista simplemente o doblemente encadenada.

4. Las expresiones se leen automáticamente del archivo `datos.txt` (debe estar en el mismo directorio).

---

## Formato de datos.txt

Cada línea debe contener una expresión infix. Se soportan los operadores `+`, `-`, `*`, `/` y paréntesis. Los números pueden ser de múltiples dígitos.

```
(10+20)*9
1+2*9
100/5+3
```
