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

    // FK FK FK
    @Column(name = "EQUIPO", nullable = false)
    private int equipo;
}
