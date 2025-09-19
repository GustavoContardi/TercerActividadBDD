package ar.edu.unlu.bdd.utilidades;

import ar.edu.unlu.bdd.vista.VistaCarrera;
import ar.edu.unlu.bdd.vista.VistaCompiteEn;
import ar.edu.unlu.bdd.vista.VistaEquipo;
import ar.edu.unlu.bdd.vista.VistaPiloto;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Listado {
    private Listado() {

    }

    public static void listarMenu(String nombreTabla) {
        System.out.println("\n----------------------------------------------");
        System.out.println(" - " + nombreTabla + " - ");
        System.out.println("Seleccione la opción que desea realizar sobre la entidad");
        System.out.println("1 - Alta");
        System.out.println("2 - Baja");
        System.out.println("3 - Modificación");
        System.out.println("4 - Consultar");
        System.out.println("5 - Volver");
        System.out.print("Ingrese su opcion: ");
    }

}

