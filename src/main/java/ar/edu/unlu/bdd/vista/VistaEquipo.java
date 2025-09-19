package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorEquipo;
import ar.edu.unlu.bdd.modelo.Equipo;
import ar.edu.unlu.bdd.utilidades.CFZValidatorUtils;
import ar.edu.unlu.bdd.utilidades.Listado;

import java.util.Scanner;

public class VistaEquipo {
    public VistaEquipo(ControladorEquipo controladorEquipo) {
        int opc;
        do {
            Listado.listarMenu("Equipo");
            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");

            switch (opc) {
                case 1 -> {
                    // Nombre
                    String nombre = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el nombre del equipo: ");
                    // País
                    String pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el país del equipo: ");
                    // Temporadas
                    Integer temporadas = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese la cantidad de temporadas: ");

                    Equipo equipo = controladorEquipo.alta(nombre, pais, temporadas);
                }
                case 2 -> {
                    // Solicitar datos

                    controladorEquipo.baja();
                }
                case 3 -> controladorEquipo.modificacion();
                case 4 -> {

                    controladorEquipo.consulta(CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese el ID del equipo: "));
                }
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);
    }
}
