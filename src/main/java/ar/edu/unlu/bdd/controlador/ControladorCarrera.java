package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.modelo.Carrera;
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
            Carrera carrera = new Carrera(circuito, pais, fecha, vueltas, ganador);
            session.beginTransaction();
            session.persist(carrera);
            session.getTransaction().commit();
            sessionFactory.close();

        }catch(Exception e)
        {e.printStackTrace();}

    }

    public void baja(int idc, String circuito, String pais, int vueltas, Timestamp fecha, int ganador){
        Session session = sessionFactory.openSession();
        try{
            Carrera carrera = new Carrera(circuito, pais, fecha, vueltas, ganador);
            session.beginTransaction();
            session.remove(carrera);
            session.getTransaction().commit();
            sessionFactory.close();

        }catch(Exception e)
        {e.printStackTrace();}
    }

    public void modificacion(int idc, String circuito, String pais, int vueltas, Timestamp fecha, int ganador){
        Session session = sessionFactory.openSession();
        try{
            Carrera carrera = new Carrera(circuito, pais, fecha, vueltas, ganador);
            session.beginTransaction();
            session.update(carrera);
            session.getTransaction().commit();
            sessionFactory.close();

        }catch(Exception e)
        {e.printStackTrace();}
    }

    public void consulta(int idc){
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Query query ;
            if (idc == 0) {
                query = session.createQuery("select IDC, NOMBRE_CIRCUITO, PAIS, CANTIDAD_VUELTAS, FECHA, GANADOR  FROM TBL_CARRERA");
            }
            else {
                query = session.createQuery("select IDC, NOMBRE_CIRCUITO, PAIS, CANTIDAD_VUELTAS, FECHA, GANADOR  FROM TBL_CARRERA WHERE = " + idc);
            }

            List<Carrera> list = query.list();
            if (!list.isEmpty()) {
                for(Carrera c: list) {
                    System.out.println(c.toString());
                }
            }
        }

        catch(Exception e)
        {e.printStackTrace();}

        session.close();

    }
}
