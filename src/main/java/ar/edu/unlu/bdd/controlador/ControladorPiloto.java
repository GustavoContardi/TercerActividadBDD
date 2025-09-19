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
        v.menuVistaPiloto();
    }

    // Alta
    public void alta(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        Session session = sessionFactory.openSession();
        try {
            Piloto p = new Piloto(idp, apeNom, nacionalidad, puntos, equipo);
            session.beginTransaction();
            session.persist(p);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Baja
    public void baja(int idp) {
        Session session = sessionFactory.openSession();
        try {
            Piloto p = new Piloto(idp, "", "", 0, 0);
            session.beginTransaction();
            session.remove(p);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Modificacion
    public void modificacion(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        Session session = sessionFactory.openSession();
        try {
            Piloto p = new Piloto(idp, apeNom, nacionalidad, puntos, equipo);
            session.beginTransaction();
            session.update(p);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Consulta
    public void consulta(int id) {
        Session session = sessionFactory.openSession();
        String retornoConsulta = "";
        try {
            session.beginTransaction();
            Query<Piloto> query;
            if (id == 0) {
                query = session.createQuery("FROM Piloto", Piloto.class);
            } else {
                query = session.createQuery("FROM Piloto WHERE idp = :id", Piloto.class);
                query.setParameter("id", id);
            }
            List<Piloto> list = query.list();
            if (!list.isEmpty()) {
                for (Piloto p : list) {
                    retornoConsulta = p.toString();
                    v.mostrarConsulta(retornoConsulta);
                }
            } else {
                if (id == 0) {
                    retornoConsulta = "La tabla de pilotos está vacía...";
                    v.mostrarConsulta(retornoConsulta);
                } else {
                    retornoConsulta = "No se encontró el Piloto buscado...";
                    v.mostrarConsulta(retornoConsulta);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }
}
