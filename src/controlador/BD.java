package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import modelos.Cliente;
import modelos.Deuda;
import modelos.DeudaCsv;
import modelos.Producto;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

public class BD implements Serializable {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Deuda> deudas;

    ContadorDeudas contador;

    public BD() {

        contador = new ContadorDeudas();
        recuperarContador();

        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        deudas = new ArrayList<>();

    }

    /*Acciones de clientes*/
    public void guardarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente guardado");
    }

    public Cliente buscarCliente(String nombre) {
        Cliente resultado = null;

        for (Cliente c : getClientes()) {
            if (c.getNombre().equals(nombre)) {
                resultado = c;
                System.out.println("Cliente encontrado");
            }
        }
        return resultado;
    }

    public boolean eliminarCliente(String nombre) {
        int i = 0;
        for (Cliente c : getClientes()) {
            if (c.getNombre().equals(nombre)) {
                clientes.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    public void guardarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto guardado");
    }

    public void guardarDeuda(Deuda deuda) {
        deudas.add(deuda);
        contador.aumentarContador();
        System.out.println("Deuda guardada");
    }

    /*Acciones de productos*/
    public Producto buscarProducto(String nombre) {
        Producto resultado = null;

        for (Producto p : getProductos()) {
            if (p.getProducto().equals(nombre)) {
                resultado = p;
                System.out.println("Producto encontrado");
            }
        }
        return resultado;
    }

    public int posProducto(String nombre) {
        int pos = -1;
        int i = 0;
        for (Producto p : getProductos()) {
            if (p.getProducto().equals(nombre)) {
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }

    public boolean eliminarProducto(String producto) {
        int i = 0;
        for (Producto p : getProductos()) {
            if (p.getProducto().equals(producto)) {
                productos.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    public void actualizarGanacia(String nombre, double abono) {
        int pos = posProducto(nombre);

        Producto producto = productos.get(pos);
        producto.sumarGanancia(abono);
        productos.set(pos, producto);

    }

    /*Acciones para deudas*/
    public Deuda buscarDeuda(int id) {
        Deuda resultado = null;
        for (Deuda d : getDeudas()) {
            if (d.getId_deuda() == id) {
                resultado = d;
            }
        }
        return resultado;
    }

    public void actualizarDeuda(Deuda deuda) {
        int pos = posDeuda(deuda.getId_deuda());
        deudas.set(pos, deuda);
    }

    public int posDeuda(int id) {
        int pos = -1;
        int i = 0;
        for (Deuda d : getDeudas()) {
            if (d.getId_deuda() == id) {
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }

    public boolean eliminarDeuda(int id) {
        int i = 0;
        for (Deuda d : getDeudas()) {
            if (d.getId_deuda() == id) {
                deudas.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    /*Acciones para abonos*/
    public boolean eliminarAbono(int id_deuda, double abono) {
        for (int i = 0; i < deudas.size(); i++) {
            if (deudas.get(i).getId_deuda() == id_deuda) {
                for (int j = 0; j < deudas.get(i).getAbonos().size(); j++) {
                    if (true) {
                        if (deudas.get(i).getAbonos().get(j).getAbono() == abono) {
                            deudas.get(i).getAbonos().remove(j);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /*Setter and Getter*/
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Deuda> getDeudas() {
        return deudas;
    }

    public void setDeudas(ArrayList<Deuda> deudas) {
        this.deudas = deudas;
    }

    /*Archivo de contador*/
    //Archivos DAT
    public void guardarContador() {
        try {
            FileOutputStream archivo = new FileOutputStream("Contador.dat");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(contador);
            salida.close();
            archivo.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se puede crear o encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Hubo un error en el sistema");
            e.printStackTrace();
        }
    }

    public void recuperarContador() {
        try {
            FileInputStream archivo = new FileInputStream("Contador.dat");
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            contador = (ContadorDeudas) entrada.readObject();
            entrada.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se puede crear o encontrar el archivo");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro o no existen clases serializadas");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Hubo un error en el sistema");
            e.printStackTrace();
        }
    }

    /*Archivo CSV*/
    public void generarCSVDeudas() {

        ArrayList<DeudaCsv> deudasCsv = new ArrayList<>();

        for (Deuda d : deudas) {
            deudasCsv.add(new DeudaCsv(String.valueOf(d.getId_deuda()), d.getCliente(), d.getProducto(), d.getFecha(), String.valueOf(d.getDeuda())));
        }

        String ruta = System.getProperty("user.home");

        String csvFileruta = ruta + "/Desktop/Deudas.csv";
        ICsvBeanWriter beanWriter = null;

        //Diseñamos las celdas de nuestro csv
        CellProcessor[] procesador = new CellProcessor[]{
            new NotNull(), //id
            new NotNull(), //cliente
            new NotNull(), //producto
            new NotNull(), //fecha
            new NotNull(), //deuda
        };

        try {
            beanWriter = new CsvBeanWriter(new FileWriter(csvFileruta), CsvPreference.STANDARD_PREFERENCE);//Crear el archivo csv con preferencias estandar
            String[] header = {"id", "cliente", "producto", "fecha", "deuda"};//Diseñamos el encabezado
            beanWriter.writeHeader(header);//forzar la escritura del encabezado

            for (DeudaCsv d : deudasCsv) {//recorremos cada estudiante de la lista
                beanWriter.write(d, header, procesador);//Forzar la escritura de cada estudiante segun las celdas diseñadas
            }

            System.out.println("Archivo creado");//Banderita OK!!

            //manejamos excepciones
        } catch (IOException e) {
            System.out.println("Error csv");
            e.printStackTrace();
        } finally {
            if (beanWriter != null) {
                try {
                    beanWriter.close();
                } catch (IOException e) {
                    System.out.println("Error csv");
                }
            }
        }
    }

}
