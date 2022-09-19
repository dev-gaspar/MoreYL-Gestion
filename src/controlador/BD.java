package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import modelos.Cliente;
import modelos.Deuda;
import modelos.Producto;

public class BD implements Serializable {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Deuda> deudas;

    int contador_deudas;

    public BD() {
        contador_deudas = 0;

        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        deudas = new ArrayList<>();

    }

    public void guardarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente guardado");
    }

    public void guardarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto guardado");
    }

    public void guardarDeuda(Deuda deuda) {
        deudas.add(deuda);
        contador_deudas++;
        System.out.println("Deuda guardada");
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

    public void actualizarGanacia(String nombre, double abono) {
        int pos = posProducto(nombre);

        Producto producto = productos.get(pos);
        producto.sumarGanancia(abono);
        productos.set(pos, producto);

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

}
