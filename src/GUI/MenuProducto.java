/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CategoriaRepository;
import DAO.ProductoRepository;
import DAO.ProveedorRepository;
import ObjetosNegocio.Categoria;
import ObjetosNegocio.Producto;
import ObjetosNegocio.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class MenuProducto extends javax.swing.JInternalFrame {

    private CategoriaRepository cR;
    private ProductoRepository pR;
    private ProveedorRepository proveR;

    /**
     * Creates new form Producto
     */
    public MenuProducto() {
        proveR = new ProveedorRepository();
        pR = new ProductoRepository();
        cR = new CategoriaRepository();
        initComponents();
        hacerTabla();
    }

    private void hacerTabla() {
        eliminarDatos();
        llenarListaProveedores();
        llenarListaCategorias();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        List<Producto> productos = pR.mostrarTodas();
        try {
            for (Producto producto : productos) {
                dato[0] = Integer.toString(producto.getId());
                dato[1] = producto.getNombre();
                dato[2] = Float.toString(producto.getPrecioActual());
                dato[3] = Integer.toString(producto.getStock());
                dato[4] = producto.getProveedor().getNombre();
                dato[5] = producto.getCategoria().getNombre();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorID() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(campoBusqueda.getText()));
        producto = pR.buscarPorId(producto);
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());
            dato[4] = producto.getProveedor().getNombre();
            dato[5] = producto.getCategoria().getNombre();
            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorPrecio() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setPrecioActual(Float.parseFloat(campoBusqueda.getText()));
        producto = pR.buscarPorPrecio(producto);
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());
            dato[4] = producto.getProveedor().getNombre();
            dato[5] = producto.getCategoria().getNombre();
            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorStock() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setStock(Integer.parseInt(campoBusqueda.getText()));
        producto = pR.buscarPorStock(producto);
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());
            dato[4] = producto.getProveedor().getNombre();
            dato[5] = producto.getCategoria().getNombre();
            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

   private void validarLetras(java.awt.event.KeyEvent evt, int longitud,String mensaje,String textoCompleto) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[a-z A-Z\b]") || textoCompleto.length()>= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        }
    }

    private void validarFloat(java.awt.event.KeyEvent evt, int longitud,String mensaje) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[0-9.\b]") && letra.length() <= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this,mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        }
    }
    
    private void validarNumero(java.awt.event.KeyEvent evt, int longitud, String mensaje,String textoCompleto) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[0-9\b]") || textoCompleto.length() >= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        }
    }


    private void hacerTablaPorNombre() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        List<Producto> productos = pR.buscarPorNombre(campoBusqueda.getText());
        try {
            for (Producto producto : productos) {
                dato[0] = Integer.toString(producto.getId());
                dato[1] = producto.getNombre();
                dato[2] = String.valueOf(producto.getPrecioActual());
                dato[3] = String.valueOf(producto.getStock());
                dato[4] = producto.getProveedor().getNombre();
                dato[5] = producto.getCategoria().getNombre();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorIDProveedor() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(campoBusqueda.getText()));
        producto = pR.buscarPorIDProveedor(Integer.parseInt(campoBusqueda.getText()));
        try {
            dato[0] = Integer.toString(producto.getId());
            dato[1] = producto.getNombre();
            dato[2] = String.valueOf(producto.getPrecioActual());
            dato[3] = String.valueOf(producto.getStock());
            dato[4] = producto.getProveedor().getNombre();
            dato[5] = producto.getCategoria().getNombre();
            tb.addRow(dato);
        } catch (Exception e) {
        }
    }

    private void llenarListaProveedores() {
        listaProveedores.removeAllItems();
        List<Proveedor> proveedores = proveR.mostrarTodas();
        for (Proveedor proveedor : proveedores) {
            listaProveedores.addItem(proveedor.getId() + ":" + proveedor.getNombre());
            //listaProveedores.addItem(proveedor.getNombre());
        }
    }

    private void llenarListaCategorias() {
        listaCategorias.removeAllItems();
        List<Categoria> categorias = cR.mostrarTodas();
        for (Categoria categoria : categorias) {
            listaCategorias.addItem(categoria.getId() + ":" + categoria.getNombre());
            //listaCategorias.addItem(categoria.getNombre());

        }
    }

    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tablaProductos.getModel();
        tb.setRowCount(0);

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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        listaCategorias = new javax.swing.JComboBox<>();
        listaProveedores = new javax.swing.JComboBox<>();
        campoNombre = new javax.swing.JTextField();
        campoID = new javax.swing.JTextField();
        campoPrecioActual = new javax.swing.JTextField();
        campoStock = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        campoBusqueda = new javax.swing.JTextField();
        opcionBusqueda = new javax.swing.JComboBox<>();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        bActualizarProv = new javax.swing.JButton();
        bEliminarProv = new javax.swing.JButton();
        bAgregarProv = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventana producto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/producto.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1300, 448));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("ID Producto");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Nombre*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Precio Actual*");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Stock*");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Proveedor*");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Categoria*");

        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        campoID.setEditable(false);
        campoID.setEnabled(false);
        campoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIDActionPerformed(evt);
            }
        });

        campoPrecioActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPrecioActualKeyTyped(evt);
            }
        });

        campoStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoStockKeyTyped(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBusquedaKeyTyped(evt);
            }
        });

        opcionBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nombre", "Precio Actual", "Stock" }));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto ", "Nombre", "Precio Actual", "Stock", "Proveedor", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPaneTabla.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(4).setResizable(false);
            tablaProductos.getColumnModel().getColumn(5).setResizable(false);
        }

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(campoBusqueda)
                        .addGap(20, 20, 20)
                        .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buscar)))
                .addGap(10, 10, 10))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(8, 8, 8)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        bActualizarProv.setText("Actualizar");
        bActualizarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarProvActionPerformed(evt);
            }
        });

        bEliminarProv.setText("Eliminar");
        bEliminarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarProvActionPerformed(evt);
            }
        });

        bAgregarProv.setText("Agregar");
        bAgregarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listaProveedores, javax.swing.GroupLayout.Alignment.LEADING, 0, 240, Short.MAX_VALUE)
                    .addComponent(campoStock, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecioActual, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAgregarProv)
                .addGap(20, 20, 20)
                .addComponent(bEliminarProv)
                .addGap(20, 20, 20)
                .addComponent(bActualizarProv)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(campoPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(listaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17)
                        .addGap(0, 0, 0)
                        .addComponent(listaCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregarProv)
                    .addComponent(bEliminarProv)
                    .addComponent(bActualizarProv))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIDActionPerformed

    private void bAgregarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarProvActionPerformed
        // TODO add your handling code here:
        Categoria categoriaParaBusqueda = new Categoria();
        String[] separacionCategoria = listaCategorias.getSelectedItem().toString().split(":");
        int idCategoria = Integer.parseInt(separacionCategoria[0]);
        categoriaParaBusqueda.setId(idCategoria);

        Proveedor proveedorParaBusqueda = new Proveedor();
        String[] separacionProveedor = listaProveedores.getSelectedItem().toString().split(":");
        int idProveedor = Integer.parseInt(separacionProveedor[0]);
        proveedorParaBusqueda.setId(idProveedor);
        proveedorParaBusqueda.setId(idProveedor);

        Producto p = new Producto(campoNombre.getText(),
                Float.parseFloat(campoPrecioActual.getText()),
                Integer.parseInt(campoStock.getText()), cR.buscarPorId(categoriaParaBusqueda),
                proveR.buscarPorId(proveedorParaBusqueda));
        pR.agregar(p);
        hacerTabla();
    }//GEN-LAST:event_bAgregarProvActionPerformed

    private void bEliminarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarProvActionPerformed
        // TODO add your handling code here:
        Producto p = new Producto();
        p.setId(Integer.parseInt(campoID.getText()));
        pR.eliminar(p);
        hacerTabla();
    }//GEN-LAST:event_bEliminarProvActionPerformed

    private void bActualizarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarProvActionPerformed
        Categoria categoriaParaBusqueda = new Categoria();
        String[] separacionCategoria = listaCategorias.getSelectedItem().toString().split(":");
        int idCategoria = Integer.parseInt(separacionCategoria[0]);
        categoriaParaBusqueda.setId(idCategoria);

        Proveedor proveedorParaBusqueda = new Proveedor();
        String[] separacionProveedor = listaProveedores.getSelectedItem().toString().split(":");
        int idProveedor = Integer.parseInt(separacionProveedor[0]);
        proveedorParaBusqueda.setId(idProveedor);
        proveedorParaBusqueda.setId(idProveedor);

        Producto p = new Producto(campoNombre.getText(),
                Float.parseFloat(campoPrecioActual.getText()),
                Integer.parseInt(campoStock.getText()), cR.buscarPorId(categoriaParaBusqueda),
                proveR.buscarPorId(proveedorParaBusqueda));
        p.setId(Integer.parseInt(campoID.getText()));
        pR.actualizar(p);
        hacerTabla();
    }//GEN-LAST:event_bActualizarProvActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        try {

            int fila = tablaProductos.getSelectedRow();
            String[] proveedores = tablaProductos.getModel().getValueAt(fila, 4).toString().split(":");
            campoID.setText(tablaProductos.getModel().getValueAt(fila, 0).toString());
            campoNombre.setText(tablaProductos.getModel().getValueAt(fila, 1).toString());
            campoPrecioActual.setText(tablaProductos.getModel().getValueAt(fila, 2).toString());
            campoStock.setText(tablaProductos.getModel().getValueAt(fila, 3).toString());
            listaProveedores.setSelectedItem(proveedores[1]);
            listaCategorias.setSelectedItem(tablaProductos.getModel().getValueAt(fila, 5).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        switch (opcionBusqueda.getSelectedItem().toString()) {
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
    }//GEN-LAST:event_buscarActionPerformed

    private void campoPrecioActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioActualKeyTyped
        validarFloat(evt, 11,"Solo poner numeros decimales en el campo de precio actual");

    }//GEN-LAST:event_campoPrecioActualKeyTyped

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        validarLetras(evt, 100,"Solo poner letras en el campo nombre con una longitud no mayor a 100 caracteres",campoNombre.getText());
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyTyped
          switch (opcionBusqueda.getSelectedItem().toString()) {
            case "Todos":
              
                break;
            case "Nombre":
                validarLetras(evt, 100,"Solo poner letras en el campo busqueda con una longitud no mayor a 100 caracteres",campoBusqueda.getText());
                break;
            case "ID":
                validarNumero(evt, 11,"Solo poner numeros en el campo busqueda",campoBusqueda.getText());
                break;
            case "Precio Actual":
                validarFloat(evt, 11,"Solo poner numeros decimales en el campo de busqueda");
                break;
            case "Stock":
                validarNumero(evt, 11,"Solo poner numeros en el campo de busqueda",campoBusqueda.getText());
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_campoBusquedaKeyTyped

    private void campoStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoStockKeyTyped
       validarNumero(evt, 11,"Solo poner numeros en el campo de busqueda",campoStock.getText());
    }//GEN-LAST:event_campoStockKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizarProv;
    private javax.swing.JButton bAgregarProv;
    private javax.swing.JButton bEliminarProv;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioActual;
    private javax.swing.JTextField campoStock;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JComboBox<String> listaCategorias;
    private javax.swing.JComboBox<String> listaProveedores;
    private javax.swing.JComboBox<String> opcionBusqueda;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
