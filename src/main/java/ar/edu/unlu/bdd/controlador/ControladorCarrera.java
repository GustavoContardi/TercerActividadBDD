package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.vista.VistaCarrera;
import org.hibernate.SessionFactory;

// TODO: Guss
public class ControladorCarrera {
    private SessionFactory sessionFactory;

    public ControladorCarrera(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaCarrera(this);
    }
}
