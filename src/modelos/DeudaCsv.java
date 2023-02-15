package modelos;

import java.io.Serializable;

public class DeudaCsv implements Serializable {

    private String id;
    private String cliente;
    private String producto;
    private String fecha;
    private String deuda;

    public DeudaCsv(String id, String cliente, String producto, String fecha, String deuda) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.deuda = deuda;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

}
