package ar.edu.unlu.bdd.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_COMPITE_EN")
public class CompiteEn {

    // FK FK FK
    @Id
    @Column(name = "PILOTO", nullable = false)
    private int piloto;

    // FK FK FK
    @Id
    @Column(name = "CARRERA", nullable = false)
    private int carrera;

    // los que no tienen el nulleable es porque pueden ser nulls en caso de que no se finalize la carrera
    @Column(name = "POS_ARRANQUE")
    private int posArranque;

    @Column(name = "POS_FINAL")
    private int posFinal;

    @Column(name = "PTS_OBTENIDOS")
    private int ptsObtenidos;

    // El piloto cometió safety car (1). Si no cometió safety car (0).
    @Column(name = "SAFETY_CAR", nullable = false)
    private int pioloto;

    public CompiteEn() {
    }


    public CompiteEn(int piloto, int carrera, int posArranque, int posFinal, int ptsObtenidos, int pioloto) {
        this.piloto = piloto;
        this.carrera = carrera;
        this.posArranque = posArranque;
        this.posFinal = posFinal;
        this.ptsObtenidos = ptsObtenidos;
        this.pioloto = pioloto;
    }


    public int getPiloto() {
        return piloto;
    }

    public void setPiloto(int piloto) {
        this.piloto = piloto;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getPosArranque() {
        return posArranque;
    }

    public void setPosArranque(int posArranque) {
        this.posArranque = posArranque;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }

    public int getPtsObtenidos() {
        return ptsObtenidos;
    }

    public void setPtsObtenidos(int ptsObtenidos) {
        this.ptsObtenidos = ptsObtenidos;
    }

    public int getPioloto() {
        return pioloto;
    }

    public void setPioloto(int pioloto) {
        this.pioloto = pioloto;
    }

    @Override
    public String toString() {
        return "Participacion - " +
                "piloto=" + piloto +
                ", carrera=" + carrera +
                ", posArranque=" + posArranque +
                ", posFinal=" + posFinal +
                ", ptsObtenidos=" + ptsObtenidos +
                ", safetyCar=" + pioloto;
    }
}
