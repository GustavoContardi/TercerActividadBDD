package ar.edu.unlu.bdd.utilidades;

import ar.edu.unlu.bdd.controlador.ControladorCarrera;
import ar.edu.unlu.bdd.controlador.ControladorCompiteEn;
import ar.edu.unlu.bdd.controlador.ControladorEquipo;
import ar.edu.unlu.bdd.controlador.ControladorPiloto;
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
                case 1 -> operarPilotos(sessionFactory);
                case 2 -> operarEquipos(sessionFactory);
                case 3 -> operarCarreras(sessionFactory);
                case 4 -> operarParticipaciones(sessionFactory);
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);

        scanner.close();
    }

    private static void operarPilotos(SessionFactory sessionFactory) {
        ControladorPiloto controller = new ControladorPiloto(sessionFactory);
        controller.iniciarVista();
    }

    private static void operarEquipos(SessionFactory sessionFactory) {
        ControladorEquipo controller = new ControladorEquipo(sessionFactory);
        controller.iniciarVista();
    }

    private static void operarCarreras(SessionFactory sessionFactory) {
        ControladorCarrera controller = new ControladorCarrera(sessionFactory);
        controller.iniciarVista();
    }

    private static void operarParticipaciones(SessionFactory sessionFactory) {
        ControladorCompiteEn controller = new ControladorCompiteEn(sessionFactory);
        controller.iniciarVista();
    }
}
