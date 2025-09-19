package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.modelo.Piloto;
import ar.edu.unlu.bdd.vista.VistaPiloto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

// TODO: Matt
public class ControladorPiloto {
    private final SessionFactory sessionFactory;

    private VistaPiloto v;

    public ControladorPiloto(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        this.v = new VistaPiloto(this);
    }

    // Alta
    public void alta(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Piloto p = new Piloto(idp, apeNom, nacionalidad, puntos, equipo);
            session.beginTransaction();
            session.persist(p);
            session.getTransaction().commit();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Baja
    public void baja(int idp) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Piloto p = new Piloto(idp, "", "", 0, 0);
            session.beginTransaction();
            session.remove(p);
            session.getTransaction().commit();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Modificacion
    public void modificacion(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Piloto p = new Piloto(idp, apeNom, nacionalidad, puntos, equipo);
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
        session.close();
    }

    //Consulta
    public void consulta(int idp) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String retornoConsulta = "";

        try {
            session.beginTransaction();
            Query query;
            if (idp == 0) {
                query = session.createQuery("select IDP , APENOM , NACIONALIDAD , PUNTOS , EQUIPO FROM TBL_PILOTO");
            }
            else {
                query = session.createQuery("select IDP , APENOM , NACIONALIDAD , PUNTOS , EQUIPO FROM TBL_PILOTO where IDP = " + Integer.toString(idp));
            }
            List<Piloto> list = query.list();
            if (!list.isEmpty()) {
                for(Piloto p: list) {
                    retornoConsulta = p.toString();
                }
            }
            else {
                if (idp == 0) {
                    retornoConsulta = "La tabla de pilotos está vacía...";
                } else {
                    retornoConsulta = "No se encontró el Piloto buscado...";
                }
            }
            v.mostrarConsulta(retornoConsulta);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        sessionFactory.close();
    }
}
