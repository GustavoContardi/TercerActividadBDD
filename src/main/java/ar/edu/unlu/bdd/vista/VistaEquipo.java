package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorEquipo;
import ar.edu.unlu.bdd.modelo.Equipo;
import ar.edu.unlu.bdd.utilidades.CFZValidatorUtils;
import ar.edu.unlu.bdd.utilidades.Listado;

import java.util.Scanner;

public class VistaEquipo {
    public VistaEquipo(ControladorEquipo controladorEquipo) {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        do {
            Listado.listarMenu("Equipo");

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
                case 1 -> {
                    // Solicitar datos de Equipo
                    // Nombre
                    String nombre = CFZValidatorUtils.solicitarEntradaPorTeclado();
                    // Pais
                    String pais = CFZValidatorUtils.solicitarEntradaPorTeclado();
                    // Temporadas
                    Integer temporadas = CFZValidatorUtils.solicitarNumeroPorTeclado();

                    Equipo equipo = controladorEquipo.alta(nombre, pais, temporadas);
                }
                case 2 -> {
                    // Solicitar datos

                    controladorEquipo.baja();
                }
                case 3 -> controladorEquipo.modificacion();
                case 4 -> controladorEquipo.consulta();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);
        scanner.close();
    }
}
