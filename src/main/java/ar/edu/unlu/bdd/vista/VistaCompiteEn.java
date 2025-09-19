package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorCompiteEn;
import ar.edu.unlu.bdd.utilidades.CFZValidatorUtils;
import ar.edu.unlu.bdd.utilidades.Listado;

import java.sql.Timestamp;
import java.util.Scanner;

public class VistaCompiteEn {
    ControladorCompiteEn controlador;

    public VistaCompiteEn(ControladorCompiteEn controladorCompiteEn) {
        Listado.listarMenu("Participación");
        this.controlador = controladorCompiteEn;
        seleccionarOpcion();
    }

    private void seleccionarOpcion() {
        int opcion;

        opcion = CFZValidatorUtils.solicitarNumeroPorTeclado();

        switch (opcion) {
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

        private void gestionarAlta () {
            int idCarrera;
            int idPiloto;
            int pts, arranque, fin, safety;

            idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
            idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");
            arranque = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion arranque: ");
            fin = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion final: ");
            pts = CFZValidatorUtils.solicitarNumeroPorTeclado("Puntos obtenidos: ");
            safety = CFZValidatorUtils.solicitarNumeroPorTeclado("Safety Car: ");

            controlador.alta(idCarrera, idPiloto, arranque, fin, pts, safety);
        }

        private void gestionarBorrar () {
            int idCarrera;
            int idPiloto;

            idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
            idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");

            controlador.baja(idCarrera, idPiloto);
        }

        private void gestionarModificar () {
            int idCarrera;
            int idPiloto;
            int pts, arranque, fin, safety;

            idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
            idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");
            arranque = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion arranque: ");
            fin = CFZValidatorUtils.solicitarNumeroPorTeclado("Posicion final: ");
            pts = CFZValidatorUtils.solicitarNumeroPorTeclado("Puntos obtenidos: ");
            safety = CFZValidatorUtils.solicitarNumeroPorTeclado("Safety Car: ");

            controlador.modificacion(idCarrera, idPiloto, arranque, fin, pts, safety);
        }


        private void gestionarConsulta () {
            int idCarrera;
            int idPiloto;

            idCarrera = CFZValidatorUtils.solicitarNumeroPorTeclado("ID de la carrera: ");
            idPiloto = CFZValidatorUtils.solicitarNumeroPorTeclado("ID del Piloto: ");

            controlador.consulta(idCarrera, idPiloto);
        }


        private void salir () {

        }

}
