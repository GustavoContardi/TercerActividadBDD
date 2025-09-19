package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.modelo.Carrera;
import ar.edu.unlu.bdd.modelo.CompiteEn;
import ar.edu.unlu.bdd.modelo.Piloto;
import ar.edu.unlu.bdd.vista.VistaCompiteEn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

// TODO: El que termina primero
public class ControladorCompiteEn {
    private SessionFactory sessionFactory;

    public ControladorCompiteEn(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaCompiteEn(this);
    }

    public void alta(int carrera, int piloto, int arranque, int fin, int pts, int safety){
        Session session = sessionFactory.openSession();
        try{
            CompiteEn compite = new CompiteEn(piloto, carrera, arranque, fin, pts, safety);
            if(!validarPK(piloto, carrera)) {
                session.close();
                return;
            }
            session.beginTransaction();
            session.persist(compite);
            session.getTransaction().commit();
            session.close();

        }catch(Exception e)
        {e.printStackTrace();}

    }



    public void baja(int carrera, int piloto){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CompiteEn> query;
        query = session.createQuery("FROM CompiteEn WHERE carrera = :carrera and piloto = :piloto", CompiteEn.class);
        query.setParameter("carrera", carrera);
        query.setParameter("piloto", piloto);

        CompiteEn c = query.uniqueResult();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
    }

    public void modificacion(int carrera, int piloto, int arranque, int fin, int pts, int safety){
        Session session = sessionFactory.openSession();
        try{
            CompiteEn compite = new CompiteEn(piloto, carrera, arranque, fin, pts, safety);
            if(!validarPK(piloto, carrera)) {
                System.out.println("No exite o no se pudo modificar");
                session.close();
                return;
            }
            session.beginTransaction();
            session.update(compite);
            session.getTransaction().commit();
            session.close();

        }catch(Exception e)
        {e.printStackTrace();}
    }

    public void consulta(int carrera, int piloto){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<CompiteEn> query;
        if (carrera == 0 && piloto == 0) {
            query = session.createQuery("FROM CompiteEn", CompiteEn.class);
        } else {
            query = session.createQuery("FROM CompiteEn WHERE carrera = :c and piloto = :p", CompiteEn.class);
            query.setParameter("c", carrera);
            query.setParameter("p", piloto);
        }
        List<CompiteEn> lista = query.list();
        if(lista.isEmpty()) System.out.println("No se encontraron resultados");
        else {
            for (CompiteEn c : lista) {
                System.out.println(c.toString() + "\n");
            }
        }
        session.close();

    }



    private boolean validarPK(int piloto, int carrera) {
        boolean result = true;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Carrera> query;
        query = session.createQuery("FROM Carrera WHERE idc = :carrera", Carrera.class);
        query.setParameter("carrera", carrera);
        List<Carrera> lista = query.list();
        if(lista.isEmpty()) return false;

        Query<Piloto> query2;
        query2 = session.createQuery("FROM Piloto WHERE idp = :piloto", Piloto.class);
        query2.setParameter("piloto", piloto);
        List<Piloto> lista2 = query2.list();
        if(lista2.isEmpty()) return false;

        session.close();

        return true;
    }
}
