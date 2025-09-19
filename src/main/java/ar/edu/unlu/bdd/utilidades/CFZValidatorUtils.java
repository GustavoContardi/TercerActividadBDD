package ar.edu.unlu.bdd.utilidades;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CFZValidatorUtils {
    private static final Scanner teclado = new Scanner(System.in);

    private CFZValidatorUtils() {
    }

    /**
     * Solicita un número por teclado mostrando un mensaje personalizado.
     * Reintenta hasta que el usuario ingrese un número válido.
     *
     * @param mensaje mensaje que se mostrará al usuario
     * @return número ingresado por el usuario
     */
    public static Integer solicitarNumeroPorTeclado(String mensaje) {
        Integer numero = null;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            String linea = teclado.nextLine().trim(); // Leemos la línea completa y eliminamos espacios

            if (linea.isEmpty()) { // Si solo presionó Enter
                System.out.println("\n***********************************************");
                System.out.println("La entrada no puede estar vacía. Intente otra vez.");
                System.out.println("***********************************************\n");
                continue;
            }

            try {
                numero = Integer.parseInt(linea);
                valido = true;
            } catch (NumberFormatException ex) {
                System.out.println("\n***********************************************");
                System.out.println("Debe introducir un número válido. Intente otra vez.");
                System.out.println("***********************************************\n");
            }
        } while (!valido);

        return numero;
    }

    public static Integer solicitarNumeroPorTeclado() {
        return solicitarNumeroPorTeclado("Ingrese un número:");
    }

    /**
     * Solicita una cadena por teclado mostrando un mensaje personalizado.
     * Reintenta hasta que el usuario ingrese algo no vacío.
     *
     * @param mensaje mensaje que se mostrará al usuario
     * @return texto ingresado por el usuario
     */
    public static String solicitarEntradaPorTeclado(String mensaje) {
        String entrada;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            entrada = teclado.nextLine().trim(); // Eliminamos espacios al inicio y fin

            if (entrada.isEmpty()) {
                System.out.println("\n***********************************************");
                System.out.println("La entrada no puede estar vacía. Intente otra vez.");
                System.out.println("***********************************************\n");
            } else {
                valido = true;
            }
        } while (!valido);

        return entrada;
    }

    public static String solicitarEntradaPorTeclado() {
        return solicitarEntradaPorTeclado("Ingrese un valor:");
    }

    public static Timestamp solicitarTimeStampPorTeclado(){
        Timestamp fecha = null;
        String inFecha;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean fechaValida = false;

        do {
            System.out.print("Ingrese una fecha (dd/MM/yyyy): ");
            inFecha = teclado.nextLine();

            try {
                // Parseamos la fecha
                LocalDate fecha2 = LocalDate.parse(inFecha, formatter);

                // Generamos Timestamp con hora 00:00:00
                LocalDateTime fechaHora = fecha2.atStartOfDay();
                fecha = Timestamp.valueOf(fechaHora);

                fechaValida = true; // si llegamos acá, la fecha es válida

            } catch (Exception e) {
                System.out.println("\n***********************************************");
                System.out.println("Debe ingresar una fecha valida (dd/MM/yyyy)");
                System.out.println("***********************************************\n");
            }
        } while (!fechaValida);

        return fecha;

    }

}
