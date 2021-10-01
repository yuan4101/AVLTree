package AVL.ArbolTest;

import AVL.ArbolModelo.*;
import java.util.*;

public class ClienteMainAVL {

    static ArbolAVL atrArbol = new ArbolAVL();
    static int atrDato;

    static Scanner atrScanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int varOpcionM = 0, varOpcionS = 0;
        do {
            try {
                System.out.println("1. Ejemplos de la insercion\n"
                        + "2. Ejemplos de la eliminacion\n"
                        + "3. Salir\n" + "Elige una opcion...");
                varOpcionM = Integer.parseInt(atrScanner.nextLine());
                switch (varOpcionM) {
                    case 1 -> {
                        System.out.println("\nEJEMPLOS DE LA INSERCION");
                        do {
                            try {
                                System.out.println("1. Sin rotacion\n"
                                        + "2. Rotacion a la derecha\n"
                                        + "3. Rotacion a la izquierda\n"
                                        + "4. Rotacion a la derecha - izquierda\n"
                                        + "5. Rotacion a la izquierda - derecha\n"
                                        + "6. Regresar al menu anterior\n" + "Elige una opcion...");
                                varOpcionS = Integer.parseInt(atrScanner.nextLine());
                                switch (varOpcionS) {
                                    case 1 -> {
                                        System.out.println("-------- EJEMPLO SIN ROTACION --------");
                                        atrArbol.insertar(15);
                                        atrArbol.insertar(10);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a insertar el valor 30");
                                        atrArbol.insertar(30);
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("En este caso no necesitamos hacer ninguna rotacion\n"
                                                + "simplemente agregamos el nodo hoja");
                                    }
                                    case 2 -> {
                                        System.out.println("-------- EJEMPLO ROTACION HACIA LA DERECHA --------");
                                        atrArbol.insertar(13);
                                        atrArbol.insertar(7);
                                        atrArbol.insertar(15);
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(10);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a insertar el valor 3");
                                        atrArbol.insertar(3);
                                        System.out.println("En este caso podemos observar que el nodo 13 se encuentra desequilibrado\n"
                                                + "por lo cual realizamos una rotacion simple hacia la derecha");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        //Es el proceso mediante el cual rotamos hacia la derecha el hijo izquierdo alrededor del nodo padre
                                    }
                                    case 3 -> {
                                        System.out.println("-------- EJEMPLO ROTACION HACIA LA IZQUIERDA --------");
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(3);
                                        atrArbol.insertar(10);
                                        atrArbol.insertar(7);
                                        atrArbol.insertar(13);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a insertar el valor 15");
                                        atrArbol.insertar(15);
                                        System.out.println("En este caso podemos observar que el nodo 5 se encuentra desequilibrado\n"
                                                + "por lo cual realizamos una rotacion simple hacia la izquierda");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        //Es el proceso mediante el cual efectuamos una rotacion del hijo derecho hacia la izquierda alrededor del nodo padre"
                                    }
                                    case 4 -> {
                                        System.out.println("-------- EJEMPLO ROTACION DERECHA - IZQUIERDA --------");
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(3);
                                        atrArbol.insertar(13);
                                        atrArbol.insertar(10);
                                        atrArbol.insertar(15);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a insertar el valor 7");
                                        atrArbol.insertar(7);
                                        System.out.println("En este caso podemos observar que el nodo 5 se encuentra desequilibrado\n"
                                                + "por lo cual realizamos primero una rotacion a la derecha del nodo 13\n"
                                                + "luego realizamos la rotacion hacia la izquierda del nodo desequilibrado 5");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                    }
                                    case 5 -> {
                                        System.out.println("-------- EJEMPLO ROTACION IZQUIERDA - DERECHA --------");
                                        atrArbol.insertar(13);
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(15);
                                        atrArbol.insertar(3);
                                        atrArbol.insertar(7);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a insertar el valor 10");
                                        atrArbol.insertar(10);
                                        System.out.println("En este caso podemos observar que el nodo 13 se encuentra desequilibrado\n"
                                                + "por lo cual realizamos primero una rotacion a la izquierda del nodo 5\n"
                                                + "luego realizamos la rotacion hacia la derecha del nodo desequilibrado 13");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                    }
                                    case 6 ->
                                        System.out.println("REGRESANDO AL MENU ANTERIOR");
                                    default ->
                                        System.out.println("OPCION INCORRECTA");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR " + e.getMessage());
                            }
                            atrArbol = new ArbolAVL();
                            pressAnyKeyToContinue();
                        } while (varOpcionS != 6);
                    }
                    case 2 -> {
                        System.out.println("EJEMPLOS DE LA ELIMINACION"
                                + "De recordar que en la eliminacion cuando un nodo tiene su factor de equilibrio fuera de entre -1 y 1\n"
                                + "entonces ese nodo tiene que ser equilibrado mediante las tecnicas ya mostradas\n"
                                + "que se encuentran en el menu de insercion con los ejemplos");
                        do {
                            try {
                                System.out.println("1. Eliminar una hoja\n"
                                        + "2. Eliminar un nodo con un subArbol hijo\n"
                                        + "3. Eliminar un nodo con dos subArboles hijos\n"
                                        + "4. Regresar al menu anterior\n" + "Elige una opcion...");
                                varOpcionS = Integer.parseInt(atrScanner.nextLine());
                                switch (varOpcionS) {
                                    case 1 -> {
                                        System.out.println("-------- EJEMPLO ELIMINACION DE UNA HOJA --------");
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(2);
                                        atrArbol.insertar(7);
                                        atrArbol.insertar(1);
                                        atrArbol.insertar(3);
                                        atrArbol.insertar(6);
                                        atrArbol.insertar(9);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a eliminar el valor 3");
                                        atrArbol.eliminar(3);
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("En este caso no necesitamos hacer ninguna rotacion\n"
                                                + "simplemente eliminamos el nodo hoja");
                                    }
                                    case 2 -> {
                                        System.out.println("-------- EJEMPLO ELIMINACION DE UN NODO CON UN SUBARBOL --------");
                                        atrArbol.insertar(10);
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(17);
                                        atrArbol.insertar(2);
                                        atrArbol.insertar(16);
                                        atrArbol.insertar(19);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a eliminar el valor 5");
                                        atrArbol.eliminar(5);
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("En este caso no necesitamos hacer ninguna rotacion\n"
                                                + "y el subArbol de 5 reemplaza el nodo eliminado");
                                    }
                                    case 3 -> {
                                        System.out.println("-------- EJEMPLO ELIMINACION DE UN NODO CON UN SUBARBOL --------");
                                        atrArbol.insertar(10);
                                        atrArbol.insertar(5);
                                        atrArbol.insertar(17);
                                        atrArbol.insertar(2);
                                        atrArbol.insertar(8);
                                        atrArbol.insertar(16);
                                        atrArbol.insertar(19);
                                        atrArbol.insertar(1);
                                        atrArbol.insertar(3);
                                        atrArbol.insertar(6);
                                        atrArbol.insertar(9);
                                        System.out.println("Arbol de ejemplo:");
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("A continuacion procederemos a eliminar el valor 5");
                                        atrArbol.eliminar(5);
                                        ArbolBImprimir.imprimirNodo(atrArbol.getRaiz());
                                        System.out.println("En este caso no necesitamos hacer ninguna rotacion\n"
                                                + "y el nodo mas a la derecha del nodo izquierdo\nse reemplaza por el nodo eliminado 5");
                                    }
                                    case 4 ->
                                        System.out.println("REGRESANDO AL MENU ANTERIOR");
                                    default ->
                                        System.out.println("OPCION INCORRECTA");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR " + e.getMessage());
                            }
                            atrArbol = new ArbolAVL();
                            pressAnyKeyToContinue();
                        } while (varOpcionS != 4);
                    }
                    case 3 ->
                        System.out.println("APLICACION FINALIZADA");
                    default ->
                        System.out.println("OPCION INCORRECTA");
                }
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
            atrArbol = new ArbolAVL();
        } while (varOpcionM != 3);
    }

    static public void pressAnyKeyToContinue() {
        Scanner varTeclado = new Scanner(System.in);
        System.out.println("Press any key to continue...\n\n\n");
        varTeclado.nextLine();
    }
}
