package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.modelo.Carrera;
import ar.edu.unlu.bdd.modelo.Equipo;
import ar.edu.unlu.bdd.vista.VistaCarrera;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.lang.module.Configuration;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// TODO: Guss
public class ControladorCarrera {
    private SessionFactory sessionFactory;

    public ControladorCarrera(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaCarrera(this);
    }

    public void alta(int idc, String circuito, String pais, int vueltas, Timestamp fecha, int ganador){
        Session session = sessionFactory.openSession();
        try{
            Carrera carrera = new Carrera(idc, circuito, pais, fecha, vueltas, ganador);
            session.beginTransaction();
            session.persist(carrera);
            session.getTransaction().commit();
            sessionFactory.close();

        }catch(Exception e)
        {e.printStackTrace();}

    }

    public void baja(int idc){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Carrera> query;
        query = session.createQuery("FROM Carrera WHERE idc = :idc", Carrera.class);
        query.setParameter("idc", idc);

        Carrera c = query.uniqueResult();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
    }

    public void modificacion(int idc, String circuito, String pais, int vueltas, Timestamp fecha, int ganador){
        Session session = sessionFactory.openSession();
        try{
            Carrera carrera = new Carrera(idc, circuito, pais, fecha, vueltas, ganador);
            session.beginTransaction();
            session.update(carrera);
            session.getTransaction().commit();
            sessionFactory.close();

        }catch(Exception e)
        {e.printStackTrace();}
    }

    public void consulta(int idc){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Carrera> query;
        if (idc == 0) {
            query = session.createQuery("FROM Carrera", Carrera.class);
        } else {
            query = session.createQuery("FROM Carrera WHERE idc = :idc", Carrera.class);
            query.setParameter("idc", idc);
        }
        List<Carrera> lista = query.list();
        for (Carrera c : lista) {
            System.out.println(c.toString() + "\n");
        }
        session.close();

    }
}
