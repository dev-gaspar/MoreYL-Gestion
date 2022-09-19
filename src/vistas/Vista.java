package vistas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vista extends javax.swing.JFrame {

    public Vista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tp_pestañas = new javax.swing.JTabbedPane();
        panel_clientes = new javax.swing.JPanel();
        label_clientes = new javax.swing.JLabel();
        label_direccion = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        btn_eliminar_cliente = new javax.swing.JButton();
        btn_registrar_cliente = new javax.swing.JButton();
        cb_direccion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        label_nombre = new javax.swing.JLabel();
        panel_productos = new javax.swing.JPanel();
        label_credito = new javax.swing.JLabel();
        txt_credito = new javax.swing.JTextField();
        label_producto = new javax.swing.JLabel();
        txt_producto = new javax.swing.JTextField();
        label_cantidad = new javax.swing.JLabel();
        cb_cantidad_producto = new javax.swing.JComboBox<>();
        label_precio = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        btn_eliminar_producto = new javax.swing.JButton();
        btn_registrar_producto = new javax.swing.JButton();
        label_procuctos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        panel_deudas = new javax.swing.JPanel();
        cb_id_deuda = new javax.swing.JComboBox<>();
        cb_producto = new javax.swing.JComboBox<>();
        label_cliente = new javax.swing.JLabel();
        cb_cliente = new javax.swing.JComboBox<>();
        label_producto1 = new javax.swing.JLabel();
        label_id = new javax.swing.JLabel();
        cb_cantidad_deuda = new javax.swing.JComboBox<>();
        btn_generar_deuda = new javax.swing.JButton();
        btn_eliminar_deuda = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_dudas = new javax.swing.JTable();
        label_deudas = new javax.swing.JLabel();
        label_cantidad2 = new javax.swing.JLabel();
        panel_abonos = new javax.swing.JPanel();
        label_id_deuda = new javax.swing.JLabel();
        btn_ver_cerrar = new javax.swing.JButton();
        cb_id_deuda_abono = new javax.swing.JComboBox<>();
        label_precio1 = new javax.swing.JLabel();
        txt_abono = new javax.swing.JTextField();
        btn_ver_abonos = new javax.swing.JButton();
        btn_registra_abono = new javax.swing.JButton();
        label_abonos = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_abonos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tp_pestañas.setBackground(new java.awt.Color(255, 255, 255));
        tp_pestañas.setForeground(new java.awt.Color(0, 0, 0));

        panel_clientes.setBackground(new java.awt.Color(255, 255, 255));
        panel_clientes.setForeground(new java.awt.Color(255, 255, 255));
        panel_clientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_clientes.setBackground(new java.awt.Color(255, 255, 255));
        label_clientes.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        label_clientes.setForeground(new java.awt.Color(0, 0, 0));
        label_clientes.setText("Clientes");
        panel_clientes.add(label_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, 30));

        label_direccion.setBackground(new java.awt.Color(255, 255, 255));
        label_direccion.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_direccion.setForeground(new java.awt.Color(0, 0, 0));
        label_direccion.setText("Direccion:");
        panel_clientes.add(label_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 80, 25));

        label_telefono.setBackground(new java.awt.Color(255, 255, 255));
        label_telefono.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_telefono.setForeground(new java.awt.Color(0, 0, 0));
        label_telefono.setText("Telefono:");
        panel_clientes.add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 80, 25));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(0, 0, 0));
        panel_clientes.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 25));

        txt_telefono.setBackground(new java.awt.Color(255, 255, 255));
        txt_telefono.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(0, 0, 0));
        panel_clientes.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 120, 25));

        btn_eliminar_cliente.setBackground(new java.awt.Color(0, 0, 0));
        btn_eliminar_cliente.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_eliminar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_cliente.setText("Eliminar");
        panel_clientes.add(btn_eliminar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 120, 25));

        btn_registrar_cliente.setBackground(new java.awt.Color(0, 0, 0));
        btn_registrar_cliente.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_registrar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrar_cliente.setText("Registrar");
        panel_clientes.add(btn_registrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 120, 25));

        cb_direccion.setBackground(new java.awt.Color(255, 255, 255));
        cb_direccion.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_direccion.setForeground(new java.awt.Color(0, 0, 0));
        cb_direccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Severa", "Valparaiso", "Berengena", "Palotal", "Chorrillo" }));
        panel_clientes.add(cb_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 120, 25));

        jScrollPane1.setBackground(new java.awt.Color(71, 71, 71));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        tabla_clientes.setBackground(new java.awt.Color(255, 255, 255));
        tabla_clientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_clientes.setForeground(new java.awt.Color(0, 0, 0));
        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_clientes);
        if (tabla_clientes.getColumnModel().getColumnCount() > 0) {
            tabla_clientes.getColumnModel().getColumn(2).setHeaderValue("Telefono");
        }

        panel_clientes.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 560, 300));

        label_nombre.setBackground(new java.awt.Color(255, 255, 255));
        label_nombre.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(0, 0, 0));
        label_nombre.setText("Nombre:");
        panel_clientes.add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 25));

        tp_pestañas.addTab("Clientes", panel_clientes);

        panel_productos.setBackground(new java.awt.Color(255, 255, 255));
        panel_productos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_credito.setBackground(new java.awt.Color(255, 255, 255));
        label_credito.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_credito.setForeground(new java.awt.Color(0, 0, 0));
        label_credito.setText("Credito:");
        panel_productos.add(label_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 80, 25));

        txt_credito.setBackground(new java.awt.Color(255, 255, 255));
        txt_credito.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txt_credito.setForeground(new java.awt.Color(0, 0, 0));
        panel_productos.add(txt_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 120, 25));

        label_producto.setBackground(new java.awt.Color(255, 255, 255));
        label_producto.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_producto.setForeground(new java.awt.Color(0, 0, 0));
        label_producto.setText("Producto:");
        panel_productos.add(label_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 25));

        txt_producto.setBackground(new java.awt.Color(255, 255, 255));
        txt_producto.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txt_producto.setForeground(new java.awt.Color(0, 0, 0));
        panel_productos.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 25));

        label_cantidad.setBackground(new java.awt.Color(255, 255, 255));
        label_cantidad.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_cantidad.setForeground(new java.awt.Color(0, 0, 0));
        label_cantidad.setText("Cantidad");
        panel_productos.add(label_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 80, 25));

        cb_cantidad_producto.setBackground(new java.awt.Color(255, 255, 255));
        cb_cantidad_producto.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_cantidad_producto.setForeground(new java.awt.Color(0, 0, 0));
        cb_cantidad_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        panel_productos.add(cb_cantidad_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 120, 25));

        label_precio.setBackground(new java.awt.Color(255, 255, 255));
        label_precio.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_precio.setForeground(new java.awt.Color(0, 0, 0));
        label_precio.setText("Precio:");
        panel_productos.add(label_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, 25));

        txt_precio.setBackground(new java.awt.Color(255, 255, 255));
        txt_precio.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txt_precio.setForeground(new java.awt.Color(0, 0, 0));
        panel_productos.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, 25));

        btn_eliminar_producto.setBackground(new java.awt.Color(0, 0, 0));
        btn_eliminar_producto.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_eliminar_producto.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_producto.setText("Eliminar");
        panel_productos.add(btn_eliminar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 25));

        btn_registrar_producto.setBackground(new java.awt.Color(0, 0, 0));
        btn_registrar_producto.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_registrar_producto.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrar_producto.setText("Registrar");
        panel_productos.add(btn_registrar_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 120, 25));

        label_procuctos.setBackground(new java.awt.Color(255, 255, 255));
        label_procuctos.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        label_procuctos.setForeground(new java.awt.Color(0, 0, 0));
        label_procuctos.setText("Productos");
        panel_productos.add(label_procuctos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, 30));

        jScrollPane2.setBackground(new java.awt.Color(71, 71, 71));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        tabla_productos.setBackground(new java.awt.Color(255, 255, 255));
        tabla_productos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_productos.setForeground(new java.awt.Color(0, 0, 0));
        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Invertido", "Credito", "Estimado", "Ganancias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla_productos);
        if (tabla_productos.getColumnModel().getColumnCount() > 0) {
            tabla_productos.getColumnModel().getColumn(4).setResizable(false);
        }

        panel_productos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 560, 300));

        tp_pestañas.addTab("Productos", panel_productos);

        panel_deudas.setBackground(new java.awt.Color(255, 255, 255));
        panel_deudas.setForeground(new java.awt.Color(255, 255, 255));
        panel_deudas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_id_deuda.setBackground(new java.awt.Color(255, 255, 255));
        cb_id_deuda.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_id_deuda.setForeground(new java.awt.Color(0, 0, 0));
        panel_deudas.add(cb_id_deuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 90, 25));

        cb_producto.setBackground(new java.awt.Color(255, 255, 255));
        cb_producto.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_producto.setForeground(new java.awt.Color(0, 0, 0));
        panel_deudas.add(cb_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 25));

        label_cliente.setBackground(new java.awt.Color(255, 255, 255));
        label_cliente.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_cliente.setForeground(new java.awt.Color(0, 0, 0));
        label_cliente.setText("Cliente:");
        panel_deudas.add(label_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, 25));

        cb_cliente.setBackground(new java.awt.Color(255, 255, 255));
        cb_cliente.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_cliente.setForeground(new java.awt.Color(0, 0, 0));
        panel_deudas.add(cb_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, 25));

        label_producto1.setBackground(new java.awt.Color(255, 255, 255));
        label_producto1.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_producto1.setForeground(new java.awt.Color(0, 0, 0));
        label_producto1.setText("Producto:");
        panel_deudas.add(label_producto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 25));

        label_id.setBackground(new java.awt.Color(255, 255, 255));
        label_id.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_id.setForeground(new java.awt.Color(0, 0, 0));
        label_id.setText("Id:");
        panel_deudas.add(label_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 30, 25));

        cb_cantidad_deuda.setBackground(new java.awt.Color(255, 255, 255));
        cb_cantidad_deuda.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_cantidad_deuda.setForeground(new java.awt.Color(0, 0, 0));
        cb_cantidad_deuda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        panel_deudas.add(cb_cantidad_deuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 120, 25));

        btn_generar_deuda.setBackground(new java.awt.Color(0, 0, 0));
        btn_generar_deuda.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_generar_deuda.setForeground(new java.awt.Color(255, 255, 255));
        btn_generar_deuda.setText("Generar");
        panel_deudas.add(btn_generar_deuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 120, 25));

        btn_eliminar_deuda.setBackground(new java.awt.Color(0, 0, 0));
        btn_eliminar_deuda.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_eliminar_deuda.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminar_deuda.setText("Eliminar");
        panel_deudas.add(btn_eliminar_deuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 120, 25));

        jScrollPane3.setBackground(new java.awt.Color(71, 71, 71));
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));

        tabla_dudas.setBackground(new java.awt.Color(255, 255, 255));
        tabla_dudas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_dudas.setForeground(new java.awt.Color(0, 0, 0));
        tabla_dudas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Producto", "Fecha", "Deuda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabla_dudas);
        if (tabla_dudas.getColumnModel().getColumnCount() > 0) {
            tabla_dudas.getColumnModel().getColumn(2).setHeaderValue("Telefono");
            tabla_dudas.getColumnModel().getColumn(4).setResizable(false);
        }

        panel_deudas.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 560, 300));

        label_deudas.setBackground(new java.awt.Color(255, 255, 255));
        label_deudas.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        label_deudas.setForeground(new java.awt.Color(0, 0, 0));
        label_deudas.setText("Deudas");
        panel_deudas.add(label_deudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 130, 30));

        label_cantidad2.setBackground(new java.awt.Color(255, 255, 255));
        label_cantidad2.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_cantidad2.setForeground(new java.awt.Color(0, 0, 0));
        label_cantidad2.setText("Cantidad");
        panel_deudas.add(label_cantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 80, 25));

        tp_pestañas.addTab("Deudas", panel_deudas);

        panel_abonos.setBackground(new java.awt.Color(255, 255, 255));
        panel_abonos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_id_deuda.setBackground(new java.awt.Color(255, 255, 255));
        label_id_deuda.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_id_deuda.setForeground(new java.awt.Color(0, 0, 0));
        label_id_deuda.setText("Id deuda:");
        panel_abonos.add(label_id_deuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 25));

        btn_ver_cerrar.setBackground(new java.awt.Color(0, 0, 0));
        btn_ver_cerrar.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_ver_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_ver_cerrar.setText("Cerrar");
        panel_abonos.add(btn_ver_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 80, 25));

        cb_id_deuda_abono.setBackground(new java.awt.Color(255, 255, 255));
        cb_id_deuda_abono.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        cb_id_deuda_abono.setForeground(new java.awt.Color(0, 0, 0));
        panel_abonos.add(cb_id_deuda_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 120, 25));

        label_precio1.setBackground(new java.awt.Color(255, 255, 255));
        label_precio1.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        label_precio1.setForeground(new java.awt.Color(0, 0, 0));
        label_precio1.setText("Abono:");
        panel_abonos.add(label_precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, 25));

        txt_abono.setBackground(new java.awt.Color(255, 255, 255));
        txt_abono.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        txt_abono.setForeground(new java.awt.Color(0, 0, 0));
        panel_abonos.add(txt_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 120, 25));

        btn_ver_abonos.setBackground(new java.awt.Color(0, 0, 0));
        btn_ver_abonos.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_ver_abonos.setForeground(new java.awt.Color(255, 255, 255));
        btn_ver_abonos.setText("Ver");
        panel_abonos.add(btn_ver_abonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 120, 25));

        btn_registra_abono.setBackground(new java.awt.Color(0, 0, 0));
        btn_registra_abono.setFont(new java.awt.Font("Ink Free", 1, 14)); // NOI18N
        btn_registra_abono.setForeground(new java.awt.Color(255, 255, 255));
        btn_registra_abono.setText("Registrar");
        panel_abonos.add(btn_registra_abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 120, 25));

        label_abonos.setBackground(new java.awt.Color(255, 255, 255));
        label_abonos.setFont(new java.awt.Font("Ink Free", 1, 24)); // NOI18N
        label_abonos.setForeground(new java.awt.Color(0, 0, 0));
        label_abonos.setText("Abonos");
        panel_abonos.add(label_abonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 560, 30));

        jScrollPane4.setBackground(new java.awt.Color(71, 71, 71));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));

        tabla_abonos.setBackground(new java.awt.Color(255, 255, 255));
        tabla_abonos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabla_abonos.setForeground(new java.awt.Color(0, 0, 0));
        tabla_abonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Abono", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabla_abonos);

        panel_abonos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 560, 300));

        tp_pestañas.addTab("Abonos", panel_abonos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_pestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp_pestañas, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_cliente;
    private javax.swing.JButton btn_eliminar_deuda;
    private javax.swing.JButton btn_eliminar_producto;
    private javax.swing.JButton btn_generar_deuda;
    private javax.swing.JButton btn_registra_abono;
    private javax.swing.JButton btn_registrar_cliente;
    private javax.swing.JButton btn_registrar_producto;
    private javax.swing.JButton btn_ver_abonos;
    private javax.swing.JButton btn_ver_cerrar;
    private javax.swing.JComboBox<String> cb_cantidad_deuda;
    private javax.swing.JComboBox<String> cb_cantidad_producto;
    private javax.swing.JComboBox<String> cb_cliente;
    private javax.swing.JComboBox<String> cb_direccion;
    private javax.swing.JComboBox<String> cb_id_deuda;
    private javax.swing.JComboBox<String> cb_id_deuda_abono;
    private javax.swing.JComboBox<String> cb_producto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_abonos;
    private javax.swing.JLabel label_cantidad;
    private javax.swing.JLabel label_cantidad2;
    private javax.swing.JLabel label_cliente;
    private javax.swing.JLabel label_clientes;
    private javax.swing.JLabel label_credito;
    private javax.swing.JLabel label_deudas;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_id;
    private javax.swing.JLabel label_id_deuda;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_precio;
    private javax.swing.JLabel label_precio1;
    private javax.swing.JLabel label_procuctos;
    private javax.swing.JLabel label_producto;
    private javax.swing.JLabel label_producto1;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JPanel panel_abonos;
    private javax.swing.JPanel panel_clientes;
    private javax.swing.JPanel panel_deudas;
    private javax.swing.JPanel panel_productos;
    private javax.swing.JTable tabla_abonos;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTable tabla_dudas;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTabbedPane tp_pestañas;
    private javax.swing.JTextField txt_abono;
    private javax.swing.JTextField txt_credito;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_eliminar_cliente() {
        return btn_eliminar_cliente;
    }

    public void setBtn_eliminar_cliente(JButton btn_eliminar_cliente) {
        this.btn_eliminar_cliente = btn_eliminar_cliente;
    }

    public JButton getBtn_eliminar_deuda() {
        return btn_eliminar_deuda;
    }

    public void setBtn_eliminar_deuda(JButton btn_eliminar_deuda) {
        this.btn_eliminar_deuda = btn_eliminar_deuda;
    }

    public JButton getBtn_eliminar_producto() {
        return btn_eliminar_producto;
    }

    public void setBtn_eliminar_producto(JButton btn_eliminar_producto) {
        this.btn_eliminar_producto = btn_eliminar_producto;
    }

    public JButton getBtn_generar_deuda() {
        return btn_generar_deuda;
    }

    public void setBtn_generar_deuda(JButton btn_generar_deuda) {
        this.btn_generar_deuda = btn_generar_deuda;
    }

    public JButton getBtn_registra_abono() {
        return btn_registra_abono;
    }

    public void setBtn_registra_abono(JButton btn_registra_abono) {
        this.btn_registra_abono = btn_registra_abono;
    }

    public JButton getBtn_registrar_cliente() {
        return btn_registrar_cliente;
    }

    public void setBtn_registrar_cliente(JButton btn_registrar_cliente) {
        this.btn_registrar_cliente = btn_registrar_cliente;
    }

    public JButton getBtn_registrar_producto() {
        return btn_registrar_producto;
    }

    public void setBtn_registrar_producto(JButton btn_registrar_producto) {
        this.btn_registrar_producto = btn_registrar_producto;
    }

    public JButton getBtn_ver_abonos() {
        return btn_ver_abonos;
    }

    public void setBtn_ver_abonos(JButton btn_ver_abonos) {
        this.btn_ver_abonos = btn_ver_abonos;
    }

    public JComboBox<String> getCb_cantidad_deuda() {
        return cb_cantidad_deuda;
    }

    public void setCb_cantidad_deuda(JComboBox<String> cb_cantidad_deuda) {
        this.cb_cantidad_deuda = cb_cantidad_deuda;
    }

    public JComboBox<String> getCb_cantidad_producto() {
        return cb_cantidad_producto;
    }

    public void setCb_cantidad_producto(JComboBox<String> cb_cantidad_producto) {
        this.cb_cantidad_producto = cb_cantidad_producto;
    }

    public JComboBox<String> getCb_cliente() {
        return cb_cliente;
    }

    public void setCb_cliente(JComboBox<String> cb_cliente) {
        this.cb_cliente = cb_cliente;
    }

    public JComboBox<String> getCb_direccion() {
        return cb_direccion;
    }

    public void setCb_direccion(JComboBox<String> cb_direccion) {
        this.cb_direccion = cb_direccion;
    }

    public JComboBox<String> getCb_id_deuda() {
        return cb_id_deuda;
    }

    public void setCb_id_deuda(JComboBox<String> cb_id_deuda) {
        this.cb_id_deuda = cb_id_deuda;
    }

    public JComboBox<String> getCb_id_deuda_abono() {
        return cb_id_deuda_abono;
    }

    public void setCb_id_deuda_abono(JComboBox<String> cb_id_deuda_abono) {
        this.cb_id_deuda_abono = cb_id_deuda_abono;
    }

    public JComboBox<String> getCb_producto() {
        return cb_producto;
    }

    public void setCb_producto(JComboBox<String> cb_producto) {
        this.cb_producto = cb_producto;
    }

    public JTable getTabla_abonos() {
        return tabla_abonos;
    }

    public void setTabla_abonos(JTable tabla_abonos) {
        this.tabla_abonos = tabla_abonos;
    }

    public JTable getTabla_clientes() {
        return tabla_clientes;
    }

    public void setTabla_clientes(JTable tabla_clientes) {
        this.tabla_clientes = tabla_clientes;
    }

    public JTable getTabla_dudas() {
        return tabla_dudas;
    }

    public void setTabla_dudas(JTable tabla_dudas) {
        this.tabla_dudas = tabla_dudas;
    }

    public JTable getTabla_productos() {
        return tabla_productos;
    }

    public void setTabla_productos(JTable tabla_productos) {
        this.tabla_productos = tabla_productos;
    }

    public JTextField getTxt_abono() {
        return txt_abono;
    }

    public void setTxt_abono(JTextField txt_abono) {
        this.txt_abono = txt_abono;
    }

    public JTextField getTxt_credito() {
        return txt_credito;
    }

    public void setTxt_credito(JTextField txt_credito) {
        this.txt_credito = txt_credito;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public JTextField getTxt_precio() {
        return txt_precio;
    }

    public void setTxt_precio(JTextField txt_precio) {
        this.txt_precio = txt_precio;
    }

    public JTextField getTxt_producto() {
        return txt_producto;
    }

    public void setTxt_producto(JTextField txt_producto) {
        this.txt_producto = txt_producto;
    }

    public JTextField getTxt_telefono() {
        return txt_telefono;
    }

    public void setTxt_telefono(JTextField txt_telefono) {
        this.txt_telefono = txt_telefono;
    }

    public JLabel getLabel_abonos() {
        return label_abonos;
    }

    public void setLabel_abonos(JLabel label_abonos) {
        this.label_abonos = label_abonos;
    }

    public JButton getBtn_ver_cerrar() {
        return btn_ver_cerrar;
    }

    public void setBtn_ver_cerrar(JButton btn_ver_cerrar) {
        this.btn_ver_cerrar = btn_ver_cerrar;
    }
    
    

}
