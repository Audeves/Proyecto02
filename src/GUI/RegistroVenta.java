/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ClienteRepository;
import DAO.ProductoRepository;
import DAO.RPVRepository;
import DAO.VentaRepository;
import ObjetosNegocio.Cliente;
import ObjetosNegocio.Producto;
import ObjetosNegocio.RelProductosVentas;
import ObjetosNegocio.Venta;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class RegistroVenta extends javax.swing.JInternalFrame {

    ClienteRepository cR;
    ProductoRepository pR;
    RPVRepository rpvR;
    VentaRepository vR;

    /**
     * Creates new form Producto
     */
    public RegistroVenta() {
        cR = new ClienteRepository();
        pR = new ProductoRepository();
        rpvR = new RPVRepository();
        vR = new VentaRepository();
        initComponents();
        llenarListaClientes();
        hacerTabla();
    }

    private void hacerTabla() {
        eliminarDatosTablaProductos();

        String[] dato = new String[4];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        List<Producto> productos = pR.mostrarTodas();
        try {
            for (Producto producto : productos) {
                dato[0] = Integer.toString(producto.getId());
                dato[1] = producto.getNombre();
                dato[2] = Float.toString(producto.getPrecioActual());
                dato[3] = Integer.toString(producto.getStock());
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorNombre() {
        eliminarDatosTablaProductos();
        String[] dato = new String[4];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        List<Producto> productos = pR.buscarPorNombre(campoBusqueda.getText());
        try {
            for (Producto producto : productos) {
                dato[0] = Integer.toString(producto.getId());
                dato[1] = producto.getNombre();
                dato[2] = String.valueOf(producto.getPrecioActual());
                dato[3] = String.valueOf(producto.getStock());

                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorID() {
        eliminarDatosTablaProductos();
        String[] dato = new String[4];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(campoBusqueda.getText()));
        producto = pR.buscarPorId(producto);
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());
            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorPrecio() {
        eliminarDatosTablaProductos();
        String[] dato = new String[4];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setPrecioActual(Float.parseFloat(campoBusqueda.getText()));
        producto = pR.buscarPorPrecio(producto);
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());

            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorStock() {
        eliminarDatosTablaProductos();
        String[] dato = new String[4];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setStock(Integer.parseInt(campoBusqueda.getText()));
        producto = pR.buscarPorStock(producto);
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());

            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

    private void calcularCosto() {
        float subTotal = 0;
        float descuento;
        float total;

        float valores[] = new float[tablaProductosSeleccionados.getRowCount()];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = Float.parseFloat(tablaProductosSeleccionados.getModel().getValueAt(i, 4).toString());
            subTotal += valores[i];
        }

        textoSubTotal.setText(subTotal + "");

        descuento = subTotal * (Float.parseFloat(textoDescuento.getText()) / 100);

        total = subTotal - descuento;
        textoTotal.setText(total + "");

    }

    private boolean conseguirCantidad(DefaultTableModel tb, int fila) {
        int filaSeleccionada = 0;

        boolean bol = false;
        float precioActual;
        float montoTotal;
        int cantidad;
        int stockRestado;

        int idProducto = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 0).toString());

        while (filaSeleccionada < tablaProductosSeleccionados.getRowCount()) {
            if (idProducto == Integer.parseInt(tablaProductosSeleccionados.getModel().getValueAt(filaSeleccionada, 0).toString())) {
                cantidad = Integer.parseInt(tablaProductosSeleccionados.getModel().getValueAt(filaSeleccionada, 3).toString()) + 1;

                stockRestado = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 3).toString()) - 1;
                tablaProductos.getModel().setValueAt(stockRestado, fila, 3);

                Producto a = new Producto();
                int id = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 0).toString());
                a.setId(id);
                Producto actualizado = pR.buscarPorId(a);

                actualizado.setStock(stockRestado);
                pR.actualizar(actualizado);

                tb.setValueAt(cantidad, filaSeleccionada, 3);
                precioActual = Float.parseFloat(tb.getValueAt(filaSeleccionada, 2).toString());
                montoTotal = precioActual * cantidad;
                tb.setValueAt(montoTotal, filaSeleccionada, 4);
                bol = true;
                return bol;
            } else {
                filaSeleccionada++;
            }
        }
        return bol;

    }

    private void eliminarDatosTablaProductos() {
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        tb.setRowCount(0);
    }

    private void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tablaProductosSeleccionados.getModel();
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

    private void validarFloat(java.awt.event.KeyEvent evt, int longitud, String mensaje) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[0-9.\b]") && letra.length() <= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        } else {
            calcularCosto();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoSubTotal = new javax.swing.JTextField();
        textoDescuento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textoTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botonRegistro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cboCliente = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        campoBusqueda = new javax.swing.JTextField();
        jScrollPaneTabla1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        BotonBuscar = new javax.swing.JButton();
        opcionBusqueda1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tablaProductosSeleccionados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventana registro venta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registroVenta.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cliente*");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Subtotal:");

        textoSubTotal.setEnabled(false);

        textoDescuento.setText("0");
        textoDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoDescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoDescuentoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Descuento:");

        textoTotal.setEnabled(false);
        textoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoTotalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Total:");

        botonRegistro.setText("Registrar");
        botonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistroActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoSubTotal)
                            .addComponent(cboCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoDescuento)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(textoTotal)
                                        .addGap(2, 2, 2))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(botonRegistro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRegistro)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Nombre", "Precio Actual", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPaneTabla1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
        }

        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        opcionBusqueda1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nombre", "Precio Actual", "Stock" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoBusqueda)
                        .addGap(20, 20, 20)
                        .addComponent(opcionBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(BotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPaneTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscar)
                    .addComponent(opcionBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPaneTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos seleccionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        tablaProductosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Producto", "Nombre", "Precio Actual", "Cantidad", "Monto total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductosSeleccionados.getTableHeader().setReorderingAllowed(false);
        tablaProductosSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosSeleccionadosMouseClicked(evt);
            }
        });
        jScrollPaneTabla.setViewportView(tablaProductosSeleccionados);
        if (tablaProductosSeleccionados.getColumnModel().getColumnCount() > 0) {
            tablaProductosSeleccionados.getColumnModel().getColumn(0).setResizable(false);
            tablaProductosSeleccionados.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaProductosSeleccionados.getColumnModel().getColumn(1).setResizable(false);
            tablaProductosSeleccionados.getColumnModel().getColumn(2).setResizable(false);
            tablaProductosSeleccionados.getColumnModel().getColumn(3).setResizable(false);
            tablaProductosSeleccionados.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPaneTabla)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
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

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void textoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoTotalActionPerformed

    private void botonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistroActionPerformed

        Cliente cliente = new Cliente();
        String[] separacionCliente = cboCliente.getSelectedItem().toString().split(":");
        int idCliente = Integer.parseInt(separacionCliente[0]);
        cliente.setId(idCliente);

        Calendar cal = Calendar.getInstance();

        Venta v = new Venta(cal, Float.parseFloat(textoDescuento.getText()), Float.parseFloat(textoTotal.getText()), cliente);
        vR.agregar(v);

        Producto producto = new Producto();
        RelProductosVentas[] rpvs = new RelProductosVentas[tablaProductosSeleccionados.getRowCount()];
        int fila = 0;
        for (RelProductosVentas rpv : rpvs) {
            producto.setId(Integer.parseInt(tablaProductosSeleccionados.getModel().getValueAt(fila, 0).toString()));
            rpv = new RelProductosVentas(Float.parseFloat(tablaProductosSeleccionados.getModel().getValueAt(fila, 2).toString()),
                    Integer.parseInt(tablaProductosSeleccionados.getModel().getValueAt(fila, 3).toString()),
                    Float.parseFloat(tablaProductosSeleccionados.getModel().getValueAt(fila, 4).toString()),
                    pR.buscarPorId(producto), vR.buscarPorId(v));
            rpvR.agregar(rpv);

            fila++;
        }


    }//GEN-LAST:event_botonRegistroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        try {
            String[] dato = new String[5];

            int fila = tablaProductos.getSelectedRow();
            int stockRestante = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 3).toString());
            if (stockRestante < 1) {
                JOptionPane.showMessageDialog(this, "Se han acabado las existencias del producto seleccionado");
                return;
            }
            DefaultTableModel tb = (DefaultTableModel) tablaProductosSeleccionados.getModel();

            if (tablaProductosSeleccionados.getRowCount() > 0) {

                if (conseguirCantidad(tb, fila)) {
//                       
                    System.out.println("Se agrego");
                } else {

                    int stockRestado = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 3).toString()) - 1;
                tablaProductos.getModel().setValueAt(stockRestado, fila, 3);

                Producto a = new Producto();
                int id = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 0).toString());
                a.setId(id);
                Producto actualizado = pR.buscarPorId(a);

                actualizado.setStock(stockRestado);
                pR.actualizar(actualizado);
                    dato[0] = tablaProductos.getModel().getValueAt(fila, 0).toString();
                    dato[1] = tablaProductos.getModel().getValueAt(fila, 1).toString();
                    dato[2] = tablaProductos.getModel().getValueAt(fila, 2).toString();
                    dato[3] = Integer.toString(1);
                    dato[4] = tablaProductos.getModel().getValueAt(fila, 2).toString();
                    System.out.println("se intenta agregar");
                    tb.addRow(dato);
                    // contador++;
                }
//                }
//            
            } else {
                //  DefaultTableModel tb = (DefaultTableModel) tablaProductosSeleccionados.getModel();
                /*
                soos
                aaa
                a
                a
                a
                a
                a
                */
                 int stockRestado = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 3).toString()) - 1;
                tablaProductos.getModel().setValueAt(stockRestado, fila, 3);

                Producto a = new Producto();
                int id = Integer.parseInt(tablaProductos.getModel().getValueAt(fila, 0).toString());
                a.setId(id);
                Producto actualizado = pR.buscarPorId(a);

                actualizado.setStock(stockRestado);
                pR.actualizar(actualizado);
                
                dato[0] = tablaProductos.getModel().getValueAt(fila, 0).toString();
                dato[1] = tablaProductos.getModel().getValueAt(fila, 1).toString();
                dato[2] = tablaProductos.getModel().getValueAt(fila, 2).toString();
                
                dato[3] = Integer.toString(1);
                dato[4] = tablaProductos.getModel().getValueAt(fila, 2).toString();

                tb.addRow(dato);
            }

            calcularCosto();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void tablaProductosSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosSeleccionadosMouseClicked
        DefaultTableModel tb = (DefaultTableModel) tablaProductosSeleccionados.getModel();
        int id = Integer.parseInt(tb.getValueAt(tablaProductosSeleccionados.getSelectedRow(), 0).toString());
        int stock = Integer.parseInt(tb.getValueAt(tablaProductosSeleccionados.getSelectedRow(), 3).toString());
        for (int i = 0; i < tablaProductos.getModel().getRowCount(); i++) {
            if (id == Integer.parseInt(tablaProductos.getModel().getValueAt(i, 0).toString())) {
                int stockSumado = stock + Integer.parseInt(tablaProductos.getModel().getValueAt(i, 3).toString());
                tablaProductos.getModel().setValueAt(stockSumado, i, 3);

                Producto a = new Producto();

                a.setId(id);
                Producto actualizado = pR.buscarPorId(a);

                actualizado.setStock(stockSumado);
              
                pR.actualizar(actualizado);
                  System.out.println("Funciono");
                break;
            }
        }

        tb.removeRow(tablaProductosSeleccionados.getSelectedRow());
        calcularCosto();


    }//GEN-LAST:event_tablaProductosSeleccionadosMouseClicked

    private void textoDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDescuentoKeyTyped
        String a = textoDescuento.getText();

        validarFloat(evt, 11, "Solo se aceptan numeros decimales en este campo");
        //        if (!a.matches("-?(\\d*\\.)?\\d+")) {
//            textoDescuento.setText("0");
//
//        } else {
//            calcularCosto();
//        }


    }//GEN-LAST:event_textoDescuentoKeyTyped

    private void textoDescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoDescuentoKeyPressed

    }//GEN-LAST:event_textoDescuentoKeyPressed

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        switch (opcionBusqueda1.getSelectedItem().toString()) {
            case "Todos":
                hacerTabla();
                break;
            case "Nombre":
                hacerTablaPorNombre();
                break;
            case "ID":
                hacerTablaPorID();
                break;
            case "Precio Actual":
                hacerTablaPorPrecio();
                break;
            case "Stock":
                hacerTablaPorStock();
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_BotonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton botonRegistro;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JScrollPane jScrollPaneTabla1;
    private javax.swing.JComboBox<String> opcionBusqueda1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProductosSeleccionados;
    private javax.swing.JTextField textoDescuento;
    private javax.swing.JTextField textoSubTotal;
    private javax.swing.JTextField textoTotal;
    // End of variables declaration//GEN-END:variables
}
