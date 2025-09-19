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
        logger.info("Equipo -{}- creado correctamente", equipo.getNombre());
        return equipo;
    }

    public void baja(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Equipo> query;
        query = session.createQuery("FROM Equipo WHERE ide = :id", Equipo.class);
        query.setParameter("id", id);

        List<Equipo> result = query.list();
        if (result.isEmpty()) {
            logger.warn("El id -{}- NO existe.", id);
        } else {
            Equipo equipo = result.getFirst();
            session.remove(equipo);
            session.getTransaction().commit();
        }
        session.close();
    }

    public Equipo modificacion(Integer id, String nombre, String pais, Integer temporadas) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Equipo equipo = new Equipo(id, nombre, pais, temporadas);
        session.update(equipo);
        session.getTransaction().commit();

        session.close();
        return equipo;
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
        if (lista.isEmpty()) {
            logger.warn("No se encuentra el ID: {}", id);
        } else {
            for (Equipo equipo : lista) {
                System.out.println(equipo.getNombre() + "\n");
            }
        }
        session.close();
    }
}
