package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorPiloto;
import ar.edu.unlu.bdd.utilidades.Listado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaPiloto {

    private final ControladorPiloto controladorPiloto;

    public VistaPiloto(ControladorPiloto controladorPiloto) {
        this.controladorPiloto = controladorPiloto;
    }

    public void menuVistaPiloto() {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        do {
            Listado.listarMenu("Piloto");

            // leer opción
            if (scanner.hasNextInt()) {
                opc = scanner.nextInt();
                scanner.nextLine(); // limpiar el buffer
            } else {
                System.out.println("Entrada inválida, ingrese un número.");
                scanner.nextLine(); // descartar entrada incorrecta
                continue;
            }

            switch (opc) {
                case 1 -> inputAlta(controladorPiloto);
                case 2 -> inputBaja(controladorPiloto);
                case 3 -> inputModificacion(controladorPiloto);
                case 4 -> inputConsulta(controladorPiloto);
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);
        scanner.close();
    }

    private void inputAlta(ControladorPiloto controladorPiloto) {
        Scanner scanner = new Scanner(System.in);

        int idp = 0;
        String apeNom = "";
        String nacionalidad = "";
        int puntos = 0;
        int equipo = 0;

        // En alta el IDP es generado automaticamente

        // Entrada APENOM
        while (true) {
            System.out.print("Ingrese el Apellido y Nombre del Piloto: ");
            apeNom = scanner.nextLine().trim();
            if (!apeNom.isEmpty() && apeNom.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }

        // Entrada NACIONALIDAD
        while (true) {
            System.out.print("Ingrese la Nacionalidad del Piloto: ");
            nacionalidad = scanner.nextLine().trim();
            if (!nacionalidad.isEmpty() && nacionalidad.length() <= 100) break;
            else System.out.println("La nacionalidad no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        //En el alta PUNTOS = 0

        // Entrada EQUIPO
        while (true) {
            try {
                System.out.print("Ingrese ID del Equipo del Piloto: ");
                equipo = scanner.nextInt();
                scanner.nextLine();
                if (equipo > 0) break;
                else System.out.println("El ID del equipo debe ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine();
            }
        }

        controladorPiloto.alta(idp, apeNom, nacionalidad, puntos, equipo);

    }

    private void inputBaja(ControladorPiloto controladorPiloto) {
        Scanner scanner = new Scanner(System.in);

        int idp = 0;

        // Entrada IDP
        while (true) {
            try {
                System.out.print("Ingrese ID del Piloto: ");
                idp = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                if (idp > 0) break;
                else System.out.println("El ID debe ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine(); // descartar entrada inválida
            }
        }

        controladorPiloto.baja(idp);

    }

    private void inputModificacion(ControladorPiloto controladorPiloto) {
        Scanner scanner = new Scanner(System.in);

        int idp = 0;
        String apeNom = "";
        String nacionalidad = "";
        int puntos = 0;
        int equipo = 0;

        //  ++ Busqueda del Piloto

        // Entrada IDP
        while (true) {
            try {
                System.out.print("Ingrese ID del Piloto: ");
                idp = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                if (idp > 0) break;
                else System.out.println("El ID debe ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine(); // descartar entrada inválida
            }
        }

        //  ++ Modificacion del Piloto

        // Entrada APENOM
        while (true) {
            System.out.print("Ingrese el Apellido y Nombre del Piloto: ");
            apeNom = scanner.nextLine().trim();
            if (!apeNom.isEmpty() && apeNom.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }

        // Entrada NACIONALIDAD
        while (true) {
            System.out.print("Ingrese la Nacionalidad del Piloto: ");
            nacionalidad = scanner.nextLine().trim();
            if (!nacionalidad.isEmpty() && nacionalidad.length() <= 100) break;
            else System.out.println("La nacionalidad no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        //En el alta hardcodear a 0
        // Entrada PUNTOS
        while (true) {
            try {
                System.out.print("Ingrese los Puntos del Piloto: ");
                puntos = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                if (puntos >= 0) break;
                else System.out.println("Los puntos no pueden ser negativos.");
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine();
            }
        }

        // Entrada EQUIPO
        while (true) {
            try {
                System.out.print("Ingrese ID del Equipo del Piloto: ");
                equipo = scanner.nextInt();
                scanner.nextLine();
                if (equipo > 0) break;
                else System.out.println("El ID del equipo debe ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine();
            }
        }

        controladorPiloto.modificacion(idp, apeNom, nacionalidad, puntos, equipo);

    }

    private void inputConsulta(ControladorPiloto controladorPiloto) {
        Scanner scanner = new Scanner(System.in);

        int idp = 0;

        // Entrada IDP
        while (true) {
            try {
                System.out.print("Ingrese ID del Piloto: ");
                idp = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
                if (idp >= 0) break;
                else System.out.println("El ID debe ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine(); // descartar entrada inválida
            }
        }

        controladorPiloto.consulta(idp);

    }

    public void mostrarConsulta(String mensaje) {
        System.out.println("\n----------------------------------------------");
        System.out.println(mensaje);
        System.out.println("\n----------------------------------------------");
    }
}
