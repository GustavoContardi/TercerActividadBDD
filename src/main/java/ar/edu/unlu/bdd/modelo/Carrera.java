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

    public Carrera() {
        this.idc = 0;
    }

    public Carrera(int idc, String nombreCircuito, String pais, Timestamp fecha, int vueltas, int ganador) {
        this.idc = idc;
        this.nombreCircuito = nombreCircuito;
        this.pais = pais;
        this.fecha = fecha;
        this.vueltas = vueltas;
        Ganador = ganador;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNombreCircuito() {
        return nombreCircuito;
    }

    public void setNombreCircuito(String nombreCircuito) {
        this.nombreCircuito = nombreCircuito;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public int getGanador() {
        return Ganador;
    }

    public void setGanador(int ganador) {
        Ganador = ganador;
    }

    @Override
    public String toString() {
        return "Carrera -" +
                "IDC=" + idc +
                ", Nombre circuito='" + nombreCircuito +
                ", País=" + pais +
                ", Fecha=" + fecha +
                ", Cantidad de vueltas=" + vueltas +
                ", Ganador=" + Ganador;
    }
}
