package modelos;

import java.io.Serializable;

public class Abono implements Serializable{

    private double abono;
    private String fecha;

    public Abono() {
    }

    public Abono(double abono, String fecha) {
        this.abono = abono;
        this.fecha = fecha;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
