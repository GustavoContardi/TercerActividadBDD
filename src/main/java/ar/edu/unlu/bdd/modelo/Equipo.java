package ar.edu.unlu.bdd.modelo;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "TBL_EQUIPO")
public class Equipo {

    @Id
    @Column(name="IDE", nullable = false)
    private int ide;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "PAIS_ORIGEN", nullable = false, length = 100)
    private String paisOrigen;

    @Column(name = "TEMPORADAS_COMPETIDAS", nullable = false)
    private int temporadasCompetidas;
}
