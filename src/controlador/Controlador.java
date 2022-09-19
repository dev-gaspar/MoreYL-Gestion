package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Abono;
import modelos.Cliente;
import modelos.Deuda;
import modelos.Producto;
import vistas.Dashboard;

public class Controlador implements ActionListener {

    Dashboard vista;
    BD bd;

    public Controlador() {

        vista = new Dashboard();
        bd = new BD();

        vista.getBtn_registrar_cliente().addActionListener(this);
        vista.getBtn_eliminar_cliente().addActionListener(this);

        vista.getBtn_registrar_producto().addActionListener(this);
        vista.getBtn_eliminar_producto().addActionListener(this);

        vista.getBtn_generar_deuda().addActionListener(this);
        vista.getBtn_eliminar_deuda().addActionListener(this);

        vista.getBtn_registra_abono().addActionListener(this);
        vista.getBtn_ver_abonos().addActionListener(this);
        vista.getBtn_eliminar_abono().addActionListener(this);

        vista.getBtn_ver_cerrar().addActionListener(this);

    }

    public void iniciar() {
        recuperarArchivo();
        vista.setTitle("More yl - Gestion");
        vista.setSize(840, 500);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        listarClientes();
        listarProductos();
        listarDeudas();

        llenarComboClientes();
        llenarComboDeudas();
        llenarComboProductos();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*Eventos de clientes*/
        if (e.getSource() == vista.getBtn_registrar_cliente()) {
            guardarCliente();
            listarClientes();
            llenarComboClientes();
        }
        if (e.getSource() == vista.getBtn_eliminar_cliente()) {
            eliminarCliente();
            listarClientes();
            llenarComboClientes();
        }

        /*Eventos de productos*/
        if (e.getSource() == vista.getBtn_registrar_producto()) {
            guardarProducto();
            listarProductos();
            llenarComboProductos();
        }
        if (e.getSource() == vista.getBtn_eliminar_producto()) {
            eliminarProducto();
            listarProductos();
            llenarComboProductos();
        }

        /*Eventos de deudas*/
        if (e.getSource() == vista.getBtn_generar_deuda()) {
            generarDeuda();
            listarDeudas();
            llenarComboDeudas();
        }

        if (e.getSource() == vista.getBtn_eliminar_deuda()) {
            eliminarDeuda();
            listarDeudas();
            llenarComboDeudas();
        }

        /*Eventos de abonos*/
        if (e.getSource() == vista.getBtn_registra_abono()) {
            registrarAbono();
            listarDeudas();
            listarProductos();
            verAbonos();
        }

        if (e.getSource() == vista.getBtn_ver_abonos()) {
            verAbonos();
        }

        if (e.getSource() == vista.getBtn_eliminar_abono()) {
            eliminarAbono();
            listarDeudas();
            listarProductos();
            verAbonos();
        }

        /*Eventos de cerrar*/
        if (e.getSource() == vista.getBtn_ver_cerrar()) {
            guardarArchivo();
            bd.guardarContador();
            System.exit(0);
        }

    }

    /*Metodos de clientes*/
    public void guardarCliente() {
        try {
            String nombre = vista.getTxt_nombre().getText().toUpperCase();
            String direccion = vista.getCb_direccion().getSelectedItem().toString();
            String telefono = vista.getTxt_telefono().getText();
            if (!nombre.equals("") && !telefono.equals("")) {

                Cliente nuevoCliente = new Cliente(nombre, direccion, telefono);

                bd.guardarCliente(nuevoCliente);
                mensaje("Cliente guardado");
            } else {
                mensaje("Le falta el nombre o telefono al cliente");
            }
        } catch (Exception e) {
            mensaje("Error al guardar cliente");
        }
    }

    public void eliminarCliente() {
        String nombre = vista.getTxt_nombre().getText().toUpperCase();
        boolean respuesta = bd.eliminarCliente(nombre);
        if (respuesta) {
            mensaje("Cliente elimindao correctamente");
        } else {
            mensaje("Error el eliminar cliente");
        }
    }

    public void listarClientes() {
        ArrayList<Cliente> clientes = bd.getClientes();
        ArrayList<Object[]> list = new ArrayList();

        for (Cliente e : clientes) {
            list.add(new Object[]{
                e.getNombre(),
                e.getDireccion(),
                e.getTelefono()
            });
        }

        DefaultTableModel tabla_clientes = new DefaultTableModel(list.toArray(new Object[][]{}),
                new String[]{"Nombre", "Direccion", "Telefono"});

        vista.getTabla_clientes().setModel(tabla_clientes);

    }

    /*Metodos de productos*/
    public void guardarProducto() {
        try {
            String producto = vista.getTxt_producto().getText().toUpperCase();
            double precio = Double.parseDouble(vista.getTxt_precio().getText());
            double cantidad = Double.parseDouble(vista.getCb_cantidad_producto().getSelectedItem().toString());
            double credito = Double.parseDouble(vista.getTxt_credito().getText());

            if (!producto.equals("")) {
                Producto nuevoProducto = new Producto(producto, precio, cantidad, credito);
                bd.guardarProducto(nuevoProducto);
                mensaje("Producto guardado");
            } else {
                mensaje("Le falta el nombre al producto");
            }
        } catch (NumberFormatException e) {
            mensaje("Error al guardar producto compruebe los campos");
        }
    }

    public void eliminarProducto() {
        String nombre = vista.getTxt_producto().getText().toUpperCase();
        boolean respuesta = bd.eliminarProducto(nombre);
        if (respuesta) {
            mensaje("Producto elimindao correctamente");
        } else {
            mensaje("Error el eliminar producto");
        }
    }

    public void listarProductos() {
        ArrayList<Producto> productos = bd.getProductos();
        ArrayList<Object[]> list = new ArrayList();

        for (Producto p : productos) {
            list.add(new Object[]{
                p.getProducto(),
                p.getPrecio(),
                p.getCantidad(),
                p.getInvertido(),
                p.getCredito(),
                p.getGanacia_estimada(),
                p.getGanacia_totales()
            });
        }

        DefaultTableModel tabla_productos = new DefaultTableModel(list.toArray(new Object[][]{}),
                new String[]{"Producto", "Precio", "Cantidad", "Invertido", "Credito", "Estimado", "Ganancias"});

        vista.getTabla_productos().setModel(tabla_productos);

    }

    /*Metodos de deudas*/
    public void generarDeuda() {
        try {
            String producto = vista.getCb_producto().getSelectedItem().toString();
            String cliente = vista.getCb_cliente().getSelectedItem().toString();
            double cantidad = Double.parseDouble(vista.getCb_cantidad_deuda().getSelectedItem().toString());
            String fecha = fecha();

            double deuda = -(cantidad * bd.buscarProducto(producto).getCredito());

            if (!producto.equals("")) {
                Deuda nuevaDeuda = new Deuda(bd.contador.getContador_deudas(), cliente, producto, fecha, deuda);
                bd.guardarDeuda(nuevaDeuda);
                mensaje("Deuda generada");
            } else {
                mensaje("Por favor veridica los campos");
            }
        } catch (NumberFormatException e) {
            mensaje("Error al generar deuda");
        }
    }

    public void eliminarDeuda() {
        int id = Integer.parseInt(vista.getCb_id_deuda().getSelectedItem().toString());
        boolean respuesta = bd.eliminarDeuda(id);
        if (respuesta) {
            mensaje("Deuda eliminada orrectamente");
        } else {
            mensaje("Error el eliminar deuda");
        }
    }

    public void listarDeudas() {
        ArrayList<Deuda> deudas = bd.getDeudas();
        ArrayList<Object[]> list = new ArrayList();

        for (Deuda d : deudas) {
            list.add(new Object[]{
                d.getId_deuda(),
                d.getCiente(),
                d.getProducto(),
                d.getFecha(),
                d.getDeuda()
            });
        }

        DefaultTableModel tabla_deudas = new DefaultTableModel(list.toArray(new Object[][]{}),
                new String[]{"Id", "Cliente", "Producto", "Fecha", "Deuda"});

        vista.getTabla_dudas().setModel(tabla_deudas);

    }

    /*Metodos de abonos*/
    public void registrarAbono() {

        try {
            Deuda deuda = bd.buscarDeuda(Integer.parseInt(vista.getCb_id_deuda_abono().getSelectedItem().toString()));
            double abono = Double.parseDouble(vista.getTxt_abono().getText());
            if (deuda.getDeuda() <= 0 && abono <= ((deuda.getDeuda()) * -1)) {

                deuda.nuevoAbono(abono);

                bd.actualizarGanacia(deuda.getProducto(), abono);
                bd.actualizarDeuda(deuda);
            } else {
                mensaje("El cliente ya esta paz y salvo. o el monto se eccede a lo que debe");
            }

        } catch (NumberFormatException e) {
            mensaje("Ha ocurrido un error al generar el abono");
        }
    }

    public void eliminarAbono() {

        try {
            int id = Integer.parseInt(vista.getCb_id_deuda_abono().getSelectedItem().toString());
            double abono = Double.parseDouble(vista.getTxt_abono().getText());

            Deuda deuda = bd.buscarDeuda(id);
            int posDeuda = bd.posDeuda(id);

            bd.actualizarGanacia(deuda.getProducto(), -(abono));

            bd.actualizarDeuda(deuda);

            double deudaActualizada = bd.getDeudas().get(posDeuda).getDeuda() - abono;
            bd.getDeudas().get(posDeuda).setDeuda(deudaActualizada);

            boolean respuesta = bd.eliminarAbono(id, abono);

            if (respuesta) {
                mensaje("Abono eliminado correctamente");
            } else {
                mensaje("Error el eliminar abono");
            }
        } catch (NumberFormatException e) {
            mensaje("Verifique los campos, ha ocurrido algun error");
        }
    }

    public void verAbonos() {

        Deuda deuda = bd.buscarDeuda(Integer.parseInt(vista.getCb_id_deuda_abono().getSelectedItem().toString()));

        vista.getLabel_abonos().setText("Abonos de " + deuda.getCiente() + " a " + deuda.getProducto());

        ArrayList<Abono> abonos = deuda.getAbonos();
        ArrayList<Object[]> list = new ArrayList();

        for (Abono d : abonos) {
            list.add(new Object[]{
                d.getAbono(),
                d.getFecha()
            });
        }

        DefaultTableModel tabla_abonos = new DefaultTableModel(list.toArray(new Object[][]{}),
                new String[]{"Abono", "Fecha"});

        vista.getTabla_abonos().setModel(tabla_abonos);

    }

    /*Metodos de llenar combobox*/
    public void llenarComboClientes() {
        vista.getCb_cliente().removeAllItems();
        for (Cliente c : bd.getClientes()) {
            vista.getCb_cliente().addItem(c.getNombre());
        }
    }

    public void llenarComboProductos() {
        vista.getCb_producto().removeAllItems();
        for (Producto p : bd.getProductos()) {
            vista.getCb_producto().addItem(p.getProducto());
        }
    }

    public void llenarComboDeudas() {
        vista.getCb_id_deuda().removeAllItems();
        vista.getCb_id_deuda_abono().removeAllItems();

        for (Deuda d : bd.getDeudas()) {
            vista.getCb_id_deuda().addItem(String.valueOf(d.getId_deuda()));
            vista.getCb_id_deuda_abono().addItem(String.valueOf(d.getId_deuda()));
        }
    }

    //Metodo retorna la fecha de hoy como string
    public String fecha() {
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        return formattedDate;
    }

    public void mensaje(String msg) {
        JOptionPane.showMessageDialog(vista, msg);
    }

    //Archivos DAT
    public void guardarArchivo() {
        try {
            FileOutputStream archivo = new FileOutputStream("BaseDeDatos.dat");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(bd);
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

    public void recuperarArchivo() {
        try {
            FileInputStream archivo = new FileInputStream("BaseDeDatos.dat");
            ObjectInputStream entrada = new ObjectInputStream(archivo);
            bd = (BD) entrada.readObject();
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

}
