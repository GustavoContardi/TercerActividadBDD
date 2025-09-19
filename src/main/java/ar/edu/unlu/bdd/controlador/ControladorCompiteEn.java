package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.vista.VistaCompiteEn;
import org.hibernate.SessionFactory;

// TODO: El que termina primero
public class ControladorCompiteEn {
    private SessionFactory sessionFactory;

    public ControladorCompiteEn(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaCompiteEn(this);
    }
}
