package ar.edu.unlu.bdd.modelo;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "TBL_CARRERA")
public class Carrera {
    @Id
    @Column(name = "IDC", nullable = false)
    private int idc;

    @Column(name = "NOMBRE_CIRCUITO", nullable = false, length = 100)
    private String nombreCircuito;

    @Column(name = "PAIS", nullable = false, length = 100)
    private String pais;

    @Column(name = "FECHA", nullable = false)
    private Timestamp fecha;

    @Column(name = "CANTIDAD_VUELTAS", nullable = false, length = 100)
    private int vueltas;

    // hay que ver como poner las FK
    //@ForeignKey
    @Column(name = "GANADOR", nullable = false)
    private int Ganador;



}
