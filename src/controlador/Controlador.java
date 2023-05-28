package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
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
        vista.getBtn_generar_cvs().addActionListener(this);

        vista.getBtn_registra_abono().addActionListener(this);
        vista.getBtn_ver_abonos().addActionListener(this);
        vista.getBtn_eliminar_abono().addActionListener(this);

        vista.getBtn_ver_cerrar().addActionListener(this);

        vista.getBtn_guardar().addActionListener(this);

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

    Connection cn = conectar();

    public Connection conectar() {
        try {
            Properties props = new Properties();
            props.setProperty("user", "kiw19ijmqj5uga0ggi5j");
            props.setProperty("password", "pscale_pw_WUXMeukx6JULnXsbBJmLTcn7me5dfdGqjwGSsLJ2yTe");
            props.setProperty("useSSL", "true");

            return DriverManager.getConnection(
                    "jdbc:mysql://us-east.connect.psdb.cloud/more-yl-gestion",
                    props);
        } catch (Exception e) {
            error("Error al conectar a la base de datos"
                    + "\nCausas:"
                    + "\n    - No tienes conexion a internet"
                    + "\n    - Esta apagada la base de datos\n    -Se han cambiado las credenciales de la base de datos"
                    + "\nEn algunos de los dos casos anteriores contacte con el administrador");
            System.err.println(e);
            return null;
        }
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

        if (e.getSource() == vista.getBtn_generar_cvs()) {
            bd.generarCSVDeudas();
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
            cerrar();
        }

        /*Eventos de guardar*/
        if (e.getSource() == vista.getBtn_guardar()) {
            guardar();
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
                aMoneda(p.getPrecio()),
                p.getCantidad(),
                aMoneda(p.getInvertido()),
                aMoneda(p.getCredito()),
                aMoneda(p.getGanacia_estimada()),
                aMoneda(p.getGanacia_totales())
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

                try {
                    Deuda nuevaDeuda = new Deuda(bd.contador.getContador_deudas(), cliente, producto, fecha, deuda);

                    PreparedStatement pst = cn.prepareStatement("insert into deudas values(?,?,?,?,?)");

                    pst.setString(1, String.valueOf(bd.contador.getContador_deudas()));
                    pst.setString(2, cliente);
                    pst.setString(3, producto);
                    pst.setString(4, fecha);
                    pst.setString(5, String.valueOf(deuda));
                    pst.executeUpdate();

                    bd.guardarDeuda(nuevaDeuda);
                    mensaje("Deuda generada");
                } catch (Exception e) {
                    error("Error al guardar la deuda, verifica tu conexion a internet");
                    System.err.println(e);
                }

            } else {
                error("Por favor verificar los campos");
            }
        } catch (NumberFormatException e) {
            error("Error al generar deuda");
        }
    }

    public void eliminarDeuda() {
        try {
            int id = Integer.parseInt(vista.getCb_id_deuda().getSelectedItem().toString());
            boolean respuesta = bd.eliminarDeuda(id);

            PreparedStatement pstmt = cn.prepareStatement("DELETE FROM deudas WHERE id=?");// Establece los valores de los parámetros en la consulta

            pstmt.setInt(1, id);

            // Ejecuta la consulta de actualización
            pstmt.executeUpdate();

            if (respuesta) {
                mensaje("Deuda eliminada orrectamente");
            } else {
                error("Error el eliminar deuda");
            }
        } catch (SQLException e) {
            error("Error al eliminar la deuda, verifica tu conexion a internet o datos ingresados");

        }

    }

    public void listarDeudas() {
        ArrayList<Deuda> deudas = bd.getDeudas();
        ArrayList<Object[]> list = new ArrayList();

        double total_deudas = 0;

        for (Deuda d : deudas) {
            list.add(new Object[]{
                d.getId_deuda(),
                d.getCliente(),
                d.getProducto(),
                d.getFecha(),
                aMoneda(d.getDeuda())
            });
            total_deudas += d.getDeuda();
        }

        DefaultTableModel tabla_deudas = new DefaultTableModel(list.toArray(new Object[][]{}),
                new String[]{"Id", "Cliente", "Producto", "Fecha", "Deuda"});

        vista.getTabla_dudas().setModel(tabla_deudas);
        vista.getLabel_total_deudas().setText("Total deudas: " + aMoneda(total_deudas));

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

                PreparedStatement pstmt = cn.prepareStatement("UPDATE deudas SET deuda=? WHERE id=?");
                // Establece los valores de los parámetros en la consulta
                pstmt.setDouble(1, deuda.getDeuda());
                pstmt.setInt(2, deuda.getId_deuda());

                // Ejecuta la consulta de actualización
                int filasActualizadas = pstmt.executeUpdate();

                // Verifica si se actualizó al menos una fila
                if (filasActualizadas == 0) {
                    System.out.println("No se encontró la deuda con ID " + deuda.getId_deuda());
                } else {
                    System.out.println("Se actualizó la deuda con ID " + deuda.getId_deuda());
                }

            } else {
                mensaje("El cliente ya esta paz y salvo. o el monto se eccede a lo que debe");
            }

        } catch (NumberFormatException e) {
            error("Ha ocurrido un error al generar el abono");
        } catch (SQLException ex) {
            error("Ha ocurrido un error al generar el abono revisa tu conexion a internet");
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

            PreparedStatement pstmt = cn.prepareStatement("UPDATE deudas SET deuda=? WHERE id=?");
            // Establece los valores de los parámetros en la consulta
            pstmt.setDouble(1, deudaActualizada);
            pstmt.setInt(2, deuda.getId_deuda());

            // Ejecuta la consulta de actualización
            int filasActualizadas = pstmt.executeUpdate();

            // Verifica si se actualizó al menos una fila
            if (filasActualizadas == 0) {
                System.out.println("No se encontró la deuda con ID " + deuda.getId_deuda());
            } else {
                System.out.println("Se actualizó la deuda con ID " + deuda.getId_deuda());
            }

            boolean respuesta = bd.eliminarAbono(id, abono);

            if (respuesta) {
                mensaje("Abono eliminado correctamente");
            } else {
                error("Error el eliminar abono");
            }
        } catch (NumberFormatException e) {
            error("Verifique los campos, ha ocurrido algun error");
        } catch (SQLException ex) {
            error("Verifique su conexion a internet, ha ocurrido algun error");
        }
    }

    public void verAbonos() {

        Deuda deuda = bd.buscarDeuda(Integer.parseInt(vista.getCb_id_deuda_abono().getSelectedItem().toString()));

        vista.getLabel_abonos().setText("Abonos de " + deuda.getCliente() + " a " + deuda.getProducto());

        ArrayList<Abono> abonos = deuda.getAbonos();
        ArrayList<Object[]> list = new ArrayList();

        for (Abono d : abonos) {
            list.add(new Object[]{
                aMoneda(d.getAbono()),
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

    public void error(String msg) {
        JOptionPane.showMessageDialog(vista, msg, "Error", JOptionPane.ERROR_MESSAGE);
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
            error("No se puede crear o encontrar el archivo");
            System.out.println("No se puede crear o encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            error("Hubo un error en el sistema");
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
            error("No se puede crear o encontrar el archivo de base de datos");
            System.out.println("No se puede crear o encontrar el archivo");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            error("No se encontro o no existen clases serializadas");
            System.out.println("No se encontro o no existen clases serializadas");
            e.printStackTrace();
        } catch (IOException e) {
            error("Hubo un error en el sistema");
            System.out.println("Hubo un error en el sistema");
            e.printStackTrace();
        }
    }

    public String aMoneda(double cantidad) {
        cantidad = Math.round((cantidad * 100.0) / 100.0);
        DecimalFormat f = new DecimalFormat("$ #,###.##");
        return f.format(cantidad);
    }

    private void cerrar() {
        try {
            guardarArchivo();
            bd.guardarContador();
            System.exit(0);
        } catch (Exception e) {
            error("Error en el sistema");
        }
    }

    private void guardar() {
        try {
            guardarArchivo();
            bd.guardarContador();
        } catch (Exception e) {
            error("Error al guardar");
        }
    }
}
