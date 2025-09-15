package ar.edu.unlu.bdd.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="COMPITE_EN")
public class CompiteEn {

    // FK FK FK
    @Column(name = "PILOTO", nullable = false)
    private int piloto;

    // FK FK FK
    @Column(name = "CARRERA", nullable = false)
    private int carrera;

    // los que no tienen el nulleable es porque pueden ser nulls en caso de que no se finalize la carrera
    @Column(name = "POS_ARRANQUE")
    private int posArranque;

    @Column(name = "POS_FINAL")
    private int posFinal;

    @Column(name = "PTS_OBTENIDOS")
    private int ptsObtenidos;

    @Column(name = "SAFETY_CAR", nullable = false)
    private int pioloto;

}
