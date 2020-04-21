/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ClienteRepository;
import DAO.RPVRepository;
import DAO.VentaRepository;
import ObjetosNegocio.Cliente;
import ObjetosNegocio.RelProductosVentas;
import ObjetosNegocio.Venta;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class BusquedaVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Producto
     */
    ClienteRepository cR;
    VentaRepository vR;
    RPVRepository rpvR;

    public BusquedaVenta() {
        cR = new ClienteRepository();
        vR = new VentaRepository();
        rpvR = new RPVRepository();
        initComponents();
        hacerTablaVenta();
        llenarListaClientes();
    }
    private void hacerTablaVenta() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaVentas.getModel();

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-d");
            String fecha;
            Float subTotal;
            List<Venta> ventas = vR.mostrarTodas();
            for (Venta venta : ventas) {
                fecha =  venta.getFecha().get(Calendar.YEAR) + "-" + 
                        venta.getFecha().get(Calendar.MONTH) + "-" + 
                        venta.getFecha().get(Calendar.DAY_OF_MONTH)+" "+
                        venta.getFecha().get(Calendar.HOUR)+ ":"+
                        venta.getFecha().get(Calendar.MINUTE) +":"+venta.getFecha().get(Calendar.SECOND);
                subTotal = (venta.getMontoFinal() * 100) / (100 - venta.getDescuento());
                dato[0] = Integer.toString(venta.getId());
                dato[1] = venta.getCliente().getNombre();
                System.out.println(venta.getFecha().get(Calendar.YEAR));
                dato[2] = fecha;
                dato[3] = Float.toString(subTotal);
                dato[4] = Float.toString(venta.getDescuento());
                dato[5] = Float.toString(venta.getMontoFinal());
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaVenta(List<Venta> ventas) {
        eliminarDatos();

        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaVentas.getModel();

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-d");
            String fecha;
            Float subTotal;
            for (Venta venta : ventas) {
                fecha =  venta.getFecha().get(Calendar.YEAR) + "-" + 
                        venta.getFecha().get(Calendar.MONTH) + "-" + 
                        venta.getFecha().get(Calendar.DAY_OF_MONTH)+" "+
                        venta.getFecha().get(Calendar.HOUR)+ ":"+
                        venta.getFecha().get(Calendar.MINUTE) +":"+venta.getFecha().get(Calendar.SECOND);
                subTotal = (venta.getMontoFinal() * 100) / (100 - venta.getDescuento());
                dato[0] = Integer.toString(venta.getId());
                dato[1] = venta.getCliente().getNombre();
                System.out.println(venta.getFecha().get(Calendar.YEAR));
                dato[2] = fecha;
                dato[3] = Float.toString(subTotal);
                dato[4] = Float.toString(venta.getDescuento());
                dato[5] = Float.toString(venta.getMontoFinal());
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaRPV(List<RelProductosVentas> rpvs) {
        eliminarDatosRPV();

        String[] dato = new String[5];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();

        try {

            for (RelProductosVentas rpv : rpvs) {
                dato[0] = Integer.toString(rpv.getProducto().getId());
                dato[1] = rpv.getProducto().getNombre();
                dato[2] = Float.toString(rpv.getPrecio());
                dato[3] = Integer.toString(rpv.getCantidad()); //= venta.getFecha().YEAR+"-"+venta.getFecha().MONTH+"-"+venta.getFecha().DAY_OF_MONTH;
                dato[4] = Float.toString(rpv.getMontoTotal());
                tb.addRow(dato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tablaVentas.getModel();
        tb.setRowCount(0);

        //cargaTicket();
    }

    private void eliminarDatosRPV() {
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        tb.setRowCount(0);

        //cargaTicket();
    }

    private void llenarListaClientes() {

        List<Cliente> clientes = cR.mostrarTodas();
        for (Cliente cliente : clientes) {
            cboCliente.addItem(cliente.getId() + ":" + cliente.getNombre());
            //listaProveedores.addItem(proveedor.getNombre());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        dcInicio = new com.toedter.calendar.JDateChooser();
        dcFinal = new com.toedter.calendar.JDateChooser();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textoID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textoCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textoSubTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoTotal = new javax.swing.JTextField();
        textoDescuenta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventana busqueda venta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busquedaVenta.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador de Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cliente*");

        cboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Fechas");

        dcInicio.setDateFormatString("yyyy-MM-d");

        dcFinal.setDateFormatString("yyyy-MM-d");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Venta", "Cliente", "Fecha", "Subtotal", "Descuento", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.getTableHeader().setReorderingAllowed(false);
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);
        if (tablaVentas.getColumnModel().getColumnCount() > 0) {
            tablaVentas.getColumnModel().getColumn(0).setResizable(false);
            tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaVentas.getColumnModel().getColumn(1).setResizable(false);
            tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(80);
            tablaVentas.getColumnModel().getColumn(2).setResizable(false);
            tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(80);
            tablaVentas.getColumnModel().getColumn(3).setResizable(false);
            tablaVentas.getColumnModel().getColumn(4).setResizable(false);
            tablaVentas.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(dcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(botonBuscar)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("ID");

        textoID.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Cliente ");

        textoCliente.setEnabled(false);
        textoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoClienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Subtotal");

        textoSubTotal.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Total");

        textoTotal.setEnabled(false);

        textoDescuenta.setEnabled(false);
        textoDescuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDescuentaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Descuento");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(textoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(textoID)
                                .addGap(10, 10, 10))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textoSubTotal)
                            .addComponent(textoDescuenta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoTotal, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoDescuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Nombre", "Precio Actual", "Cantidad", "Monto Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2)
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoClienteActionPerformed

    private void textoDescuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDescuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoDescuentaActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:

        if (cboCliente.getSelectedItem().toString().equalsIgnoreCase("todos")) {
             hacerTablaVenta(vR.mostrarEntre(dcInicio.getCalendar(), dcFinal.getCalendar()));
        } else{
             Cliente cliente = new Cliente();
        String[] separacionCliente = cboCliente.getSelectedItem().toString().split(":");
                int idCliente = Integer.parseInt(separacionCliente[0]);
        cliente.setId(idCliente);
             hacerTablaVenta(vR.mostrarEntre(dcInicio.getCalendar(), dcFinal.getCalendar(),cliente));
        }
       


    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        int seleccion = tablaVentas.getSelectedRow();
        Venta venta = new Venta();
        venta.setId(Integer.parseInt(tablaVentas.getValueAt(seleccion, 0).toString()));
        List<RelProductosVentas> rpvs = rpvR.mostrarTodasConIdVenta(venta);
        hacerTablaRPV(rpvs);
        textoID.setText(tablaVentas.getModel().getValueAt(seleccion, 0).toString());
        textoCliente.setText(tablaVentas.getModel().getValueAt(seleccion, 1).toString());
        textoDescuenta.setText(tablaVentas.getModel().getValueAt(seleccion, 3).toString());
        textoSubTotal.setText(tablaVentas.getModel().getValueAt(seleccion, 2).toString());
        textoTotal.setText(tablaVentas.getModel().getValueAt(seleccion, 4).toString());

    }//GEN-LAST:event_tablaVentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JComboBox<String> cboCliente;
    private com.toedter.calendar.JDateChooser dcFinal;
    private com.toedter.calendar.JDateChooser dcInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JTextField textoCliente;
    private javax.swing.JTextField textoDescuenta;
    private javax.swing.JTextField textoID;
    private javax.swing.JTextField textoSubTotal;
    private javax.swing.JTextField textoTotal;
    // End of variables declaration//GEN-END:variables
}
