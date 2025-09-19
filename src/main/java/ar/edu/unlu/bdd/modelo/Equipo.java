package ar.edu.unlu.bdd.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_EQUIPO")
public class Equipo {
    @Id
    @Column(name = "IDE", nullable = false)
    private int ide;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "PAIS_ORIGEN", nullable = false, length = 100)
    private String paisOrigen;

    @Column(name = "TEMPORADAS_COMPETIDAS", nullable = false)
    private int temporadasCompetidas;

    public Equipo() {
    }

    public Equipo(String nombre, String paisOrigen, int temporadasCompetidas) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.temporadasCompetidas = temporadasCompetidas;
    }

    public int getIde() {
        return ide;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public int getTemporadasCompetidas() {
        return temporadasCompetidas;
    }

    public void setTemporadasCompetidas(int temporadasCompetidas) {
        this.temporadasCompetidas = temporadasCompetidas;
    }
}
