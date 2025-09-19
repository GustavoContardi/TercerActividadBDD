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
        Listado.listarMenu("Carrera");
        seleccionarOpcion();
    }


    private void seleccionarOpcion(){
        int opcion;
        Scanner sc = new Scanner(System.in);

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

        Scanner sc = new Scanner(System.in);

        System.out.print("ID de la carrera: ");
        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado();

        System.out.print("Nombre del circuito: ");
        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado();

        System.out.print("Cantidad de vueltas: ");
        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado();

        System.out.print("Pais: ");
        pais = CFZValidatorUtils.solicitarEntradaPorTeclado();

        System.out.print("Fecha (dd/MM/yyyy): ");
        String inFecha = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            // Parseamos la fecha
            LocalDate fecha2 = LocalDate.parse(inFecha, formatter);

            // Generamos Timestamp con hora 00:00:00
            LocalDateTime fechaHora = fecha2.atStartOfDay();
            fecha = Timestamp.valueOf(fechaHora);

        } catch (Exception e) {
            System.out.println("⚠️ Fecha inválida. Use el formato dd/MM/yyyy.");
        }

        System.out.print("Ganador: ");
        ganador = CFZValidatorUtils.solicitarNumeroPorTeclado();

        controlador.alta(0, circuito, pais, vueltas, fecha, ganador);
    }

    private void gestionarBorrar() {
        int idCarrera, vueltas, ganador;
        String circuito, pais;
        Timestamp fecha = null; // qsy

        Scanner sc = new Scanner(System.in);

        System.out.print("ID de la carrera: ");
        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado();

        System.out.print("Nombre del circuito: ");
        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado();

        System.out.print("Cantidad de vueltas: ");
        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado();

        System.out.print("Pais: ");
        pais = CFZValidatorUtils.solicitarEntradaPorTeclado();

        System.out.print("Fecha (dd/MM/yyyy): ");
        String inFecha = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            // Parseamos la fecha
            LocalDate fecha2 = LocalDate.parse(inFecha, formatter);

            // Generamos Timestamp con hora 00:00:00
            LocalDateTime fechaHora = fecha2.atStartOfDay();
            fecha = Timestamp.valueOf(fechaHora);

        } catch (Exception e) {
            System.out.println("⚠️ Fecha inválida. Use el formato dd/MM/yyyy.");
        }

        System.out.print("Ganador: ");
        ganador = CFZValidatorUtils.solicitarNumeroPorTeclado();

        controlador.baja(idCarrera, circuito, pais, vueltas, fecha, ganador);
    }

    private void gestionarModificar() {
        int idCarrera, vueltas, ganador;
        String circuito, pais;
        Timestamp fecha = null; // qsy

        Scanner sc = new Scanner(System.in);

        System.out.print("ID de la carrera: ");
        idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado();

        System.out.print("Nombre del circuito: ");
        circuito = CFZValidatorUtils.solicitarEntradaPorTeclado();

        System.out.print("Cantidad de vueltas: ");
        vueltas = CFZValidatorUtils.solicitarNumeroPorTeclado();

        System.out.print("Pais: ");
        pais = CFZValidatorUtils.solicitarEntradaPorTeclado();

        System.out.print("Fecha (dd/MM/yyyy): ");
        String inFecha = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            // Parseamos la fecha
            LocalDate fecha2 = LocalDate.parse(inFecha, formatter);

            // Generamos Timestamp con hora 00:00:00
            LocalDateTime fechaHora = fecha2.atStartOfDay();
            fecha = Timestamp.valueOf(fechaHora);

        } catch (Exception e) {
            System.out.println("⚠️ Fecha inválida. Use el formato dd/MM/yyyy.");
        }

        System.out.print("Ganador: ");
        ganador = CFZValidatorUtils.solicitarNumeroPorTeclado();

        controlador.modificacion(idCarrera, circuito, pais, vueltas, fecha, ganador);
    }


    private void gestionarConsulta() {
        System.out.print("ID de la carrera: ");
        int idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado();

        controlador.consulta(idCarrera);
    }


    private void salir(){

    }
}
