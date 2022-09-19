package modelos;

import java.io.Serializable;

public class Producto implements Serializable{

    private String producto;
    private double precio;
    private double cantidad;

    private double invertido;

    private double credito;
    private double ganacia_estimada;
    private double ganancia_totales;

    public Producto(String producto, double precio, double cantidad, double credito) {

        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.credito = credito;

        this.invertido = cantidad * precio;
        this.ganacia_estimada = cantidad * credito;
        this.ganancia_totales = 0;
    }

    public Producto() {
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double invertido) {
        this.cantidad = cantidad;
    }

    public double getInvertido() {
        return invertido;
    }

    public void setInvertido(double invertido) {
        this.invertido = invertido;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public double getGanacia_estimada() {
        return ganacia_estimada;
    }

    public void setGanacia_estimada(double ganacia_estimada) {
        this.ganacia_estimada = ganacia_estimada;
    }

    public double getGanacia_totales() {
        return ganancia_totales;
    }

    public void setGanacia_totales(double ganacia_totales) {
        this.ganacia_estimada = ganacia_totales;
    }

    public void sumarGanancia(double cantidad) {
        ganancia_totales += cantidad;
    }

}
