package ar.edu.unlu.bdd.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CFZValidatorUtils {
    private CFZValidatorUtils() {
    }

    /**
     * Funcion para solicitar un número por teclado
     *
     * @return número ingresado por el usuario
     */
    public static int pedirCantidadProductoTeclado() {
        //Inicializaciones
        int numero = 0;
        boolean entrada;
        Scanner teclado = new Scanner(System.in);
        //Funcion
        do {
            try {
                entrada = true;
                numero = teclado.nextInt();
            } catch (InputMismatchException ex) {
                teclado.nextLine();
                entrada = false;
                System.out.println("\n***********************************************");
                System.out.println("Debe introducir un numero.");
                System.out.println("Intente otra vez.");
                System.out.println("***********************************************\n");
            }
        } while (!entrada);
        return numero;
    }

}
