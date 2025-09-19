package ar.edu.unlu.bdd.utilidades;

import ar.edu.unlu.bdd.vista.VistaCarrera;
import ar.edu.unlu.bdd.vista.VistaCompiteEn;
import ar.edu.unlu.bdd.vista.VistaEquipo;
import ar.edu.unlu.bdd.vista.VistaPiloto;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Menu {
    public Menu(SessionFactory sessionFactory) {

        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("\n----------------------------------------------");
            System.out.println("ACTIVIDAD Nº3 BD 2 - GRUPO 10");
            System.out.println("Seleccione la tabla con la que desea operar:");
            System.out.println("1 - Pilotos");
            System.out.println("2 - Equipos");
            System.out.println("3 - Carreras");
            System.out.println("4 - Participaciones");
            System.out.println("5 - Salir");
            System.out.print("Ingrese su opcion: ");

            // leer opción
            if (scanner.hasNextInt()) {
                opc = scanner.nextInt();
                scanner.nextLine(); // limpiar el buffer
            } else {
                System.out.println("Entrada inválida, ingrese un número.");
                scanner.nextLine(); // descartar entrada incorrecta
                continue;
            }

            switch (opc) {
                case 1 -> operarPilotos();
                case 2 -> operarEquipos();
                case 3 -> operarCarreras();
                case 4 -> operarParticipaciones();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);

        scanner.close();
    }

    private static void operarPilotos() {
        new VistaPiloto();
    }

    private static void operarEquipos() {
        new VistaEquipo();
    }

    private static void operarCarreras() {
        new VistaCarrera();
    }

    private static void operarParticipaciones() {
        new VistaCompiteEn();
    }

}
