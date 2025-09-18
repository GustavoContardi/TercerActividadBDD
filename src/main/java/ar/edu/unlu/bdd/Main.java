package ar.edu.unlu.bdd;

import ar.edu.unlu.bdd.utils.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // probando si anda la conexion -- despues hay que hacer el archivo persistence.xml

        // Se inicia la conexión a la base de datos.
        String url = "jdbc:mariadb://10.101.0.12:3306/ormPrueba10";
        String user = "user10";
        String password = "user10";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            logger.info("Conexión exitosa a la base de datos.");
            new Menu(con);
        } catch (SQLException e) {
            logger.error("No se pudo conectar a la base de datos. Error: {}", e.getMessage(), e);
        } finally {
            logger.info("Se ha finalizado la ejecución.");
        }
    }
}