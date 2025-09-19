package ar.edu.unlu.bdd.vista;

import ar.edu.unlu.bdd.controlador.ControladorPiloto;
import ar.edu.unlu.bdd.utilidades.CFZValidatorUtils;
import ar.edu.unlu.bdd.utilidades.Listado;

public class VistaPiloto {

    private final ControladorPiloto controladorPiloto;

    public VistaPiloto(ControladorPiloto controladorPiloto) {
        this.controladorPiloto = controladorPiloto;
    }

    public void menuVistaPiloto() {
        int opc = 0;
        do {
            Listado.listarMenu("Piloto");
            opc = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese su opcion: ");
            switch (opc) {
                case 1 -> inputAlta(controladorPiloto);
                case 2 -> inputBaja(controladorPiloto);
                case 3 -> inputModificacion(controladorPiloto);
                case 4 -> inputConsulta(controladorPiloto);
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opc != 5);
    }

    private void inputAlta(ControladorPiloto controladorPiloto) {
        int idp = 0;
        String apeNom = "";
        String nacionalidad = "";
        int puntos = 0;
        int equipo = 0;

        // En alta el IDP es generado automaticamente

        // Entrada APENOM
        while (true) {
            apeNom = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el Apellido y Nombre del Piloto: ");
            if (!apeNom.isEmpty() && apeNom.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }

        // Entrada NACIONALIDAD
        while (true) {
            nacionalidad = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese la Nacionalidad del Piloto: ");
            if (!nacionalidad.isEmpty() && nacionalidad.length() <= 100) break;
            else System.out.println("La nacionalidad no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        //En el alta PUNTOS = 0

        // Entrada EQUIPO
        while (true) {
            equipo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese ID del Equipo del Piloto: ");
            if (equipo > 0) break;
            else System.out.println("El ID del equipo debe ser positivo.");
        }
        controladorPiloto.alta(idp, apeNom, nacionalidad, puntos, equipo);

    }

    private void inputBaja(ControladorPiloto controladorPiloto) {
        int idp = 0;

        // Entrada IDP
        while (true) {
            idp = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese ID del Piloto: ");
            if (idp > 0) break;
            else System.out.println("El ID debe ser positivo.");
        }
        controladorPiloto.baja(idp);
    }

    private void inputModificacion(ControladorPiloto controladorPiloto) {
        int idp = 0;
        String apeNom = "";
        String nacionalidad = "";
        int puntos = 0;
        int equipo = 0;

        //  ++ Busqueda del Piloto

        // Entrada IDP
        while (true) {
            idp = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese ID del Piloto: ");
            if (idp > 0) break;
            else System.out.println("El ID debe ser positivo.");
        }

        //  ++ Modificacion del Piloto

        // Entrada APENOM
        while (true) {
            apeNom = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese el Apellido y Nombre del Piloto: ");
            if (!apeNom.isEmpty() && apeNom.length() <= 100) break;
            else System.out.println("El nombre no puede estar vacío y debe tener menos de 100 caracteres.");
        }

        // Entrada NACIONALIDAD
        while (true) {
            nacionalidad = CFZValidatorUtils.solicitarEntradaPorTeclado("Ingrese la Nacionalidad del Piloto: ");
            if (!nacionalidad.isEmpty() && nacionalidad.length() <= 100) break;
            else System.out.println("La nacionalidad no puede estar vacía y debe tener menos de 100 caracteres.");
        }

        //En el alta hardcodear a 0
        // Entrada PUNTOS
        while (true) {
            puntos = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese los Puntos del Piloto: ");
            if (puntos >= 0) break;
            else System.out.println("Los puntos no pueden ser negativos.");
        }

        // Entrada EQUIPO
        while (true) {
            equipo = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese ID del Equipo del Piloto: ");
            if (equipo > 0) break;
            else System.out.println("El ID del equipo debe ser positivo.");
        }
        controladorPiloto.modificacion(idp, apeNom, nacionalidad, puntos, equipo);

    }

    private void inputConsulta(ControladorPiloto controladorPiloto) {
        int idp;
        // Entrada IDP
        while (true) {
            idp = CFZValidatorUtils.solicitarNumeroPorTeclado("Ingrese ID del Piloto: ");
            if (idp >= 0) break;
            else System.out.println("El ID debe ser positivo.");
        }
        controladorPiloto.consulta(idp);

    }

    public void mostrarConsulta(String mensaje) {
        System.out.println("\n----------------------------------------------");
        System.out.println(mensaje);
        System.out.println("\n----------------------------------------------");
    }
}
