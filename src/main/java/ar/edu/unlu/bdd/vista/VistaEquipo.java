package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorEquipo;
import ar.edu.unlu.bdd.utilidades.Listado;

public class VistaEquipo {
    public VistaEquipo(ControladorEquipo controladorEquipo) {
        Listado.listarMenu("Equipo");
    }
}
