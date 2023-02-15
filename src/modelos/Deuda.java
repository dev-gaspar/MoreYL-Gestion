package modelos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Deuda implements Serializable{

    private int id_deuda;
    private String cliente;
    private String producto;
    private String fecha;
    private double deuda;
    private ArrayList<Abono> abonos = new ArrayList<>();

    public Deuda(int id_deuda, String ciente, String producto, String fecha, double deuda) {
        this.id_deuda = id_deuda;
        this.cliente = ciente;
        this.producto = producto;
        this.fecha = fecha;
        this.deuda = deuda;
    }

    public Deuda() {
    }

    public int getId_deuda() {
        return id_deuda;
    }

    public void setId_deuda(int id_deuda) {
        this.id_deuda = id_deuda;
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

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public ArrayList<Abono> getAbonos() {
        return abonos;
    }

    public void setAbonos(ArrayList<Abono> abonos) {
        this.abonos = abonos;
    }

    public void nuevoAbono(double abono) {

        this.deuda += abono;

        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);

        Abono nuevoAbono = new Abono(abono, formattedDate);
        abonos.add(nuevoAbono);
    }

}
