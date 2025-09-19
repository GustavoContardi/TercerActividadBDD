package ar.edu.unlu.bdd.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PILOTO")
public class Piloto {

    @Id
    @Column(name = "IDP", nullable = false)
    private int idp;

    @Column(name = "APENOM", nullable = false, length = 100)
    private String apeNom;

    @Column(name = "NACIONALIDAD", nullable = false, length = 100)
    private String nacionalidad;

    @Column(name = "PUNTOS", nullable = false)
    private int puntos;

    // FK
    @Column(name = "EQUIPO", nullable = false)
    private int equipo;

    public Piloto() {
    }

    public Piloto(int idp, String apeNom, String nacionalidad, int puntos, int equipo) {
        this.idp = idp;
        this.apeNom = apeNom;
        this.nacionalidad = nacionalidad;
        this.puntos = puntos;
        this.equipo = equipo;
    }

    public int getIdp() {
        return idp;
    }

    public String getApeNom() {
        return apeNom;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        return "=== PILOTO ===\n" +
                "ID: " + idp + "\n" +
                "Apellido y Nombre: " + apeNom + "\n" +
                "Nacionalidad: " + nacionalidad + "\n" +
                "Puntos: " + puntos + "\n" +
                "Equipo (ID): " + equipo;
    }

}
