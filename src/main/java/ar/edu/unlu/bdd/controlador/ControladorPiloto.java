package ar.edu.unlu.bdd.controlador;

import ar.edu.unlu.bdd.vista.VistaPiloto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

// TODO: Matt
public class ControladorPiloto {
    private final SessionFactory sessionFactory;

    public ControladorPiloto(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void iniciarVista() {
        new VistaPiloto(this);
    }

    // Alta
    public void alta(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // BLA BLA BLA BLA

        session.getTransaction().commit();
        session.close();
    }

    //Baja
    //Modificacion
    //Consulta
}
