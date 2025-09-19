package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorCarrera;
import ar.edu.unlu.bdd.utilidades.CFZValidatorUtils;
import ar.edu.unlu.bdd.utilidades.Listado;

import java.sql.SQLOutput;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VistaCarrera {
    private ControladorCarrera controlador;

    public VistaCarrera(ControladorCarrera controladorCarrera) {
        this.controlador = controladorCarrera;
        Listado.listarMenu("Carrera");
        seleccionarOpcion();
    }


    private void seleccionarOpcion(){
        int opcion;

        opcion = CFZValidatorUtils.solicitarNumeroPorTeclado();

        switch (opcion){
            case 1 -> {
                gestionarAlta();
            }

            case 2 -> {
                gestionarBorrar();
            }

            case 3 -> {
                gestionarModificar();
            }

            case 4 -> {
                gestionarConsulta();
            }

            case 0 /* o salir */ -> {
                salir();
            }

            default -> Listado.listarMenu("Carrera");
        }

    }

    private void gestionarAlta(){
        int idCarrera, vueltas, ganador;
        String circuito, pais;
        Timestamp fecha = null; // qsy

        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado("Nombre del circuito: ");

        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado("Cantidad de vueltas: ");

        pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Pais: ");

        fecha = CFZValidatorUtils.solicitarTimeStampPorTeclado();

        ganador = CFZValidatorUtils.solicitarNumeroPorTeclado("Ganador: ");

        controlador.alta(0, circuito, pais, vueltas, fecha, ganador);
    }

    private void gestionarBorrar() {
        int idCarrera;

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");

        controlador.baja(idCarrera);
    }

    private void gestionarModificar() {
        int idCarrera, vueltas, ganador;
        String circuito, pais;
        Timestamp fecha = null; // qsy

        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");

        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado("Nombre del circuito: ");

        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado("Cantidad de vueltas: ");

        pais = CFZValidatorUtils.solicitarEntradaPorTeclado("Pais: ");

        fecha = CFZValidatorUtils.solicitarTimeStampPorTeclado();

        ganador = CFZValidatorUtils.solicitarNumeroPorTeclado("Ganador: ");

        controlador.modificacion(idCarrera, circuito, pais, vueltas, fecha, ganador);
    }


    private void gestionarConsulta() {
        int idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");

        controlador.consulta(idCarrera);
    }


    private void salir(){

    }
}
