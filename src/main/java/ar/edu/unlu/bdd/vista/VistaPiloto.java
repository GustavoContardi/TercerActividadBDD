package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorPiloto;
import ar.edu.unlu.bdd.utilidades.Listado;

import java.util.Scanner;

public class VistaPiloto {
    public VistaPiloto(ControladorPiloto controladorPiloto) {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        do {
            Listado.listarMenu("Piloto");

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
                case 1 -> controladorPiloto.alta();
                case 2 -> controladorPiloto.baja();
                case 3 -> controladorPiloto.modificacion();
                case 4 -> controladorPiloto.consulta();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);
        scanner.close();
    }
}
