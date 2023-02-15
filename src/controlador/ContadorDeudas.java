package controlador;

import java.io.Serializable;

public class ContadorDeudas implements Serializable {

    private int contador_deudas = 1;

    public ContadorDeudas() {
    }

    public int getContador_deudas() {
        return contador_deudas;
    }

    public void setContador_deudas(int contador_deudas) {
        this.contador_deudas = contador_deudas;
    }

    public void aumentarContador() {
        contador_deudas++;
    }

}
