package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.modelo.Equipo;
import ar.edu.unlu.bdd.vista.VistaEquipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControladorEquipo {
    private final Logger logger = LoggerFactory.getLogger(ControladorEquipo.class);
    private final SessionFactory sessionFactory;

    public ControladorEquipo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaEquipo(this);
    }

    public Equipo alta(String nombre, String pais, Integer temporadas) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Equipo equipo = new Equipo(nombre, pais, temporadas);
        session.persist(equipo);
        session.getTransaction().commit();
        session.close();
        logger.info("Equipo {} creado correctamente", equipo.getNombre());
        return equipo;
    }

    public void baja() {
    }

    public void modificacion() {
    }

    public void consulta() {
    }


}
