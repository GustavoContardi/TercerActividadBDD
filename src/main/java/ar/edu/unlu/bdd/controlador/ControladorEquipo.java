package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.vista.VistaEquipo;
import org.hibernate.SessionFactory;

public class ControladorEquipo {
    // TODO: Franco
    private final SessionFactory sessionFactory;

    public ControladorEquipo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaEquipo(this);
    }
}
