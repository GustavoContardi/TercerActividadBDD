package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.utilidades.Menu;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            logger.info("Conexión exitosa a la base de datos.");
            new Menu(sessionFactory);
        } catch (Exception e) {
            logger.error("No se pudo conectar a la base de datos. Error: {}", e.getMessage(), e);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
            logger.info("Se ha finalizado la ejecución.");
        }
    }
}
