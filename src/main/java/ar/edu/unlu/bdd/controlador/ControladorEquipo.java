package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.modelo.Equipo;
import ar.edu.unlu.bdd.vista.VistaEquipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    public void consulta(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Equipo> query;
        if (id == 0) {
            query = session.createQuery("FROM Equipo", Equipo.class);
        } else {
            query = session.createQuery("FROM Equipo WHERE ide = :id", Equipo.class);
            query.setParameter("id", id);
        }
        List<Equipo> lista = query.list();
        for (Equipo equipo : lista) {
            System.out.println(equipo.getNombre() + "\n");
        }
        session.close();
    }
}
