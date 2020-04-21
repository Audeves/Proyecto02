/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ProveedorRepository;
import ObjetosNegocio.Categoria;
import ObjetosNegocio.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class MenuProveedor extends javax.swing.JInternalFrame {

    ProveedorRepository pR;

    /**
     * Creates new form Producto
     */
    public MenuProveedor() {
        pR = new ProveedorRepository();
        initComponents();
        hacerTabla();
    }

    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        tb.setRowCount(0);

        //cargaTicket();
    }

    private void hacerTabla() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        List<Proveedor> proveedores = pR.mostrarTodas();
        try {
            for (Proveedor proveedor : proveedores) {
                dato[0] = Integer.toString(proveedor.getId());
                dato[1] = proveedor.getRfc();
                dato[2] = proveedor.getNombre();
                dato[3] = proveedor.getDireccion();
                dato[4] = proveedor.getTelefono();
                dato[5] = proveedor.getPaginaWeb();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }

    }

    private void hacerTablaPorID() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        Proveedor proveedor = new Proveedor();
        proveedor.setId(Integer.parseInt(campoBusqueda.getText()));
        proveedor = pR.buscarPorId(proveedor);
        try {
            dato[0] = Integer.toString(proveedor.getId());
            dato[1] = proveedor.getRfc();
            dato[2] = proveedor.getNombre();
            dato[3] = proveedor.getDireccion();
            dato[4] = proveedor.getTelefono();
            dato[5] = proveedor.getPaginaWeb();
            tb.addRow(dato);
        } catch (Exception e) {
        }

    }

    private void hacerTablaPorRFC() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        List<Proveedor> proveedores = pR.buscarPorRFC(campoBusqueda.getText());
        try {
            for (Proveedor proveedor : proveedores) {
                dato[0] = Integer.toString(proveedor.getId());
                dato[1] = proveedor.getRfc();
                dato[2] = proveedor.getNombre();
                dato[3] = proveedor.getDireccion();
                dato[4] = proveedor.getTelefono();
                dato[5] = proveedor.getPaginaWeb();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorNombre() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        List<Proveedor> proveedores = pR.buscarPorNombre(campoBusqueda.getText());
        try {
            for (Proveedor proveedor : proveedores) {
                dato[0] = Integer.toString(proveedor.getId());
                dato[1] = proveedor.getRfc();
                dato[2] = proveedor.getNombre();
                dato[3] = proveedor.getDireccion();
                dato[4] = proveedor.getTelefono();
                dato[5] = proveedor.getPaginaWeb();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorDireccion() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        List<Proveedor> proveedores = pR.buscarPorDireccion(campoBusqueda.getText());
        try {
            for (Proveedor proveedor : proveedores) {
                dato[0] = Integer.toString(proveedor.getId());
                dato[1] = proveedor.getRfc();
                dato[2] = proveedor.getNombre();
                dato[3] = proveedor.getDireccion();
                dato[4] = proveedor.getTelefono();
                dato[5] = proveedor.getPaginaWeb();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void hacerTablaPorPagina() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaProveedores.getModel();
        List<Proveedor> proveedores = pR.buscarPorPagina(campoBusqueda.getText());
        try {
            for (Proveedor proveedor : proveedores) {
                dato[0] = Integer.toString(proveedor.getId());
                dato[1] = proveedor.getRfc();
                dato[2] = proveedor.getNombre();
                dato[3] = proveedor.getDireccion();
                dato[4] = proveedor.getTelefono();
                dato[5] = proveedor.getPaginaWeb();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }

    private void validarLetras(java.awt.event.KeyEvent evt, int longitud, String mensaje, String textoCompleto) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[a-z A-Z\b]") || textoCompleto.length() >= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
        }
    }

    private void validarNumero(java.awt.event.KeyEvent evt, int longitud, String mensaje, String textoCompleto) {

        String letra = String.valueOf(evt.getKeyChar());
        if (!letra.matches("[0-9\b]") || textoCompleto.length() >= longitud) {
            evt.consume();
            JOptionPane.showMessageDialog(this, mensaje, "Codigo de informacion", INFORMATION_MESSAGE);
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
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        campoRFC = new javax.swing.JTextField();
        campoID = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        campoBusqueda = new javax.swing.JTextField();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        opcionBusqueda = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        campoTelefono = new javax.swing.JTextField();
        campoSitioWeb = new javax.swing.JTextField();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventana proveedro");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1300, 40));
        setPreferredSize(new java.awt.Dimension(1300, 454));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("ID Proveedor");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("RFC*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Nombre*");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Dirección*");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Telefono*");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Sitio Web*");

        campoID.setEditable(false);
        campoID.setEnabled(false);
        campoID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIDActionPerformed(evt);
            }
        });

        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador de Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        campoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBusquedaActionPerformed(evt);
            }
        });
        campoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoBusquedaKeyTyped(evt);
            }
        });

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RFC", "Nombre", "Direccion", "Telefono", "Pagina web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProveedores.getTableHeader().setReorderingAllowed(false);
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPaneTabla.setViewportView(tablaProveedores);
        if (tablaProveedores.getColumnModel().getColumnCount() > 0) {
            tablaProveedores.getColumnModel().getColumn(0).setResizable(false);
            tablaProveedores.getColumnModel().getColumn(1).setResizable(false);
            tablaProveedores.getColumnModel().getColumn(3).setResizable(false);
            tablaProveedores.getColumnModel().getColumn(4).setResizable(false);
            tablaProveedores.getColumnModel().getColumn(5).setResizable(false);
        }

        opcionBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "RFC", "Nombre", "Direccion", "Sitio Web" }));

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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoBusqueda)
                        .addGap(20, 20, 20)
                        .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buscar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPaneTabla)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        campoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefonoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoRFC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSitioWeb))
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
                        .addComponent(campoRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)
                        .addGap(0, 0, 0)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17)
                        .addGap(0, 0, 0)
                        .addComponent(campoSitioWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(962, Short.MAX_VALUE)
                .addComponent(agregar)
                .addGap(20, 20, 20)
                .addComponent(eliminar)
                .addGap(20, 20, 20)
                .addComponent(actualizar)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(eliminar)
                    .addComponent(actualizar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIDActionPerformed

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        Proveedor a = new Proveedor(campoRFC.getText(), campoNombre.getText(), campoDireccion.getText(), campoTelefono.getText(), campoSitioWeb.getText());
        pR.agregar(a);
        hacerTabla();
    }//GEN-LAST:event_agregarActionPerformed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        try {
            int fila = tablaProveedores.getSelectedRow();
            campoID.setText(tablaProveedores.getModel().getValueAt(fila, 0).toString());
            campoRFC.setText(tablaProveedores.getModel().getValueAt(fila, 1).toString());
            campoNombre.setText(tablaProveedores.getModel().getValueAt(fila, 2).toString());
            campoDireccion.setText(tablaProveedores.getModel().getValueAt(fila, 3).toString());
            campoTelefono.setText(tablaProveedores.getModel().getValueAt(fila, 4).toString());
            campoSitioWeb.setText(tablaProveedores.getModel().getValueAt(fila, 5).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Proveedor p = new Proveedor();
        p.setId(Integer.parseInt(campoID.getText()));
        pR.eliminar(p);
        hacerTabla();
    }//GEN-LAST:event_eliminarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        Proveedor p = new Proveedor(campoRFC.getText(),
                campoNombre.getText(), campoDireccion.getText(),
                campoTelefono.getText(), campoSitioWeb.getText());
        p.setId(Integer.parseInt(campoID.getText()));
        pR.actualizar(p);
        hacerTabla();
    }//GEN-LAST:event_actualizarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        switch (opcionBusqueda.getSelectedItem().toString()) {
            case "Todos":
                hacerTabla();
                break;
            case "ID":
                hacerTablaPorID();
                break;
            case "RFC":
                hacerTablaPorRFC();
                break;
            case "Nombre":
                hacerTablaPorNombre();
                break;
            case "Direccion":
                hacerTablaPorDireccion();
                break;
            case "Sitio Web":
                hacerTablaPorPagina();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al elegir "
                        + "la opción de busqueda, porfavor verifique que la ha "
                        + "seleccionado del comboBox.", "Error de selección",
                        ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        validarLetras(evt, 45, "Solo se aceptan caracteres en este campo", campoNombre.getText());
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefonoKeyTyped
        validarNumero(evt, 20, "Solo se aceptan numeros en este campo", campoTelefono.getText());
    }//GEN-LAST:event_campoTelefonoKeyTyped

    private void campoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyTyped
        switch (opcionBusqueda.getSelectedItem().toString()) {
            case "Todos":

                break;
            case "ID":
                validarNumero(evt, 11, "Solo se aceptan numeros en este campo", campoBusqueda.getText());
                break;
            case "RFC":
                
                break;
            case "Nombre":
                validarLetras(evt, 45, "Solo se aceptan caracteres en este campo", campoBusqueda.getText());
                break;
            case "Direccion":
               
                break;
            case "Sitio Web":
             
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al elegir "
                        + "la opción de busqueda, porfavor verifique que la ha "
                        + "seleccionado del comboBox.", "Error de selección",
                        ERROR_MESSAGE);
        }
    }//GEN-LAST:event_campoBusquedaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton agregar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRFC;
    private javax.swing.JTextField campoSitioWeb;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JComboBox<String> opcionBusqueda;
    private javax.swing.JTable tablaProveedores;
    // End of variables declaration//GEN-END:variables
}
