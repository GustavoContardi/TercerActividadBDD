package ar.edu.unlu.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // main

        // probando si anda la conexion -- despues hay que hacer el archivo persistence.xml

        String url = "jdbc:mariadb://10.101.0.12:3306/SEGUNDA_EVALUACION10";
        String user = "user10";
        String password = "user10";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Conexión exitosa a MySQL!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}