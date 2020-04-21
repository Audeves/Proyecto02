/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ClienteRepository;
import ObjetosNegocio.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class MenuCliente extends javax.swing.JInternalFrame {

    ClienteRepository cR;

    /**
     * Creates new form Producto
     */
    public MenuCliente() {
        cR = new ClienteRepository();
        initComponents();
        hacerTabla();
    }

    public void eliminarDatos() {
        DefaultTableModel tb = (DefaultTableModel) tablaClientes.getModel();
        tb.setRowCount(0);
        
        //cargaTicket();
    }

    private void hacerTabla() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> clientes = cR.mostrarTodas();
        try {
            for (Cliente cliente : clientes) {
                dato[0] = Integer.toString(cliente.getId());
                dato[1] = cliente.getRfc();
                dato[2] = cliente.getNombre();
                dato[3] = cliente.getDireccion();
                dato[4] = cliente.getTelefono1();
                dato[5] = cliente.getTelefono2();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }

    }
    
    private void hacerTablaPorID() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaClientes.getModel();
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(campoBusqueda.getText()));
        cliente = cR.buscarPorId(cliente);
        try {
                dato[0] = Integer.toString(cliente.getId());
                dato[1] = cliente.getRfc();
                dato[2] = cliente.getNombre();
                dato[3] = cliente.getDireccion();
                dato[4] = cliente.getTelefono1();
                dato[5] = cliente.getTelefono2();
                tb.addRow(dato);
        } catch (Exception e) {
        }
    }
    
    private void hacerTablaPorRFC() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> clientes = cR.buscarPorRFC(campoBusqueda.getText());
        try {
            for (Cliente cliente : clientes) {
                dato[0] = Integer.toString(cliente.getId());
                dato[1] = cliente.getRfc();
                dato[2] = cliente.getNombre();
                dato[3] = cliente.getDireccion();
                dato[4] = cliente.getTelefono1();
                dato[5] = cliente.getTelefono2();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }
    private void hacerTablaPorNombre() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> clientes = cR.buscarPorNombre(campoBusqueda.getText());
        try {
            for (Cliente cliente : clientes) {
                dato[0] = Integer.toString(cliente.getId());
                dato[1] = cliente.getRfc();
                dato[2] = cliente.getNombre();
                dato[3] = cliente.getDireccion();
                dato[4] = cliente.getTelefono1();
                dato[5] = cliente.getTelefono2();
                tb.addRow(dato);
            }
        } catch (Exception e) {
        }
    }
    private void hacerTablaPorDireccion() {
        eliminarDatos();
        String[] dato = new String[6];
        DefaultTableModel tb = (DefaultTableModel) tablaClientes.getModel();
        List<Cliente> clientes = cR.buscarPorDireccion(campoBusqueda.getText());
        try {
            for (Cliente cliente : clientes) {
                dato[0] = Integer.toString(cliente.getId());
                dato[1] = cliente.getRfc();
                dato[2] = cliente.getNombre();
                dato[3] = cliente.getDireccion();
                dato[4] = cliente.getTelefono1();
                dato[5] = cliente.getTelefono2();
                tb.addRow(dato);
            }
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
   
    private void validarNumero(java.awt.event.KeyEvent evt, int longitud, String mensaje,String textoCompleto) {

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
        opcionBusqueda = new javax.swing.JComboBox<>();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        campoTelefono1 = new javax.swing.JTextField();
        campoTelefono2 = new javax.swing.JTextField();
        bEliminarClie = new javax.swing.JButton();
        bAgregarClie = new javax.swing.JButton();
        bActualizarClie = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ventana cliente");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(1300, 447));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1300, 447));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("ID Cliente");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("RFC*");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Nombre*");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Dirección*");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Telefono 1");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Telefono 2");

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

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscador de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

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

        opcionBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "RFC", "Nombre", "Direccion" }));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RFC", "Nombre", "Direccion", "Telefono 1", "Telefono 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPaneTabla.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setResizable(false);
            tablaClientes.getColumnModel().getColumn(1).setResizable(false);
            tablaClientes.getColumnModel().getColumn(2).setResizable(false);
            tablaClientes.getColumnModel().getColumn(3).setResizable(false);
            tablaClientes.getColumnModel().getColumn(4).setResizable(false);
            tablaClientes.getColumnModel().getColumn(5).setResizable(false);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoBusqueda)
                        .addGap(20, 20, 20)
                        .addComponent(opcionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buscar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
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

        campoTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefono1KeyTyped(evt);
            }
        });

        campoTelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoTelefono2KeyTyped(evt);
            }
        });

        bEliminarClie.setText("Eliminar");
        bEliminarClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarClieActionPerformed(evt);
            }
        });

        bAgregarClie.setText("Agregar");
        bAgregarClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarClieActionPerformed(evt);
            }
        });

        bActualizarClie.setText("Actualizar");
        bActualizarClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarClieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campoTelefono1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoRFC, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(campoTelefono2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAgregarClie)
                .addGap(20, 20, 20)
                .addComponent(bEliminarClie)
                .addGap(20, 20, 20)
                .addComponent(bActualizarClie)
                .addGap(48, 48, 48))
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
                        .addComponent(campoTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17)
                        .addGap(0, 0, 0)
                        .addComponent(campoTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAgregarClie)
                    .addComponent(bEliminarClie)
                    .addComponent(bActualizarClie))
                .addContainerGap())
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

    private void campoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBusquedaActionPerformed

    private void bAgregarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarClieActionPerformed
        // TODO add your handling code here:
        Cliente c = new Cliente(campoRFC.getText(), campoNombre.getText(), 
                campoDireccion.getText(), campoTelefono1.getText(), 
                campoTelefono2.getText());
        cR.agregar(c);
        hacerTabla();
    }//GEN-LAST:event_bAgregarClieActionPerformed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        try {
            int fila = tablaClientes.getSelectedRow();
            campoID.setText(tablaClientes.getModel().getValueAt(fila, 0).toString());
            campoRFC.setText(tablaClientes.getModel().getValueAt(fila, 1).toString());
            campoNombre.setText(tablaClientes.getModel().getValueAt(fila, 2).toString());
            campoDireccion.setText(tablaClientes.getModel().getValueAt(fila, 3).toString());
            campoTelefono1.setText(tablaClientes.getModel().getValueAt(fila, 4).toString());
            campoTelefono2.setText(tablaClientes.getModel().getValueAt(fila, 5).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void bEliminarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarClieActionPerformed
        Cliente c = new Cliente();
        c.setId(Integer.parseInt(campoID.getText()));
        cR.eliminar(c);
        hacerTabla();
    }//GEN-LAST:event_bEliminarClieActionPerformed

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
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void bActualizarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarClieActionPerformed
        Cliente c = new Cliente(campoRFC.getText(), 
                campoNombre.getText(), campoDireccion.getText(), 
                campoTelefono1.getText(), campoTelefono2.getText());
        c.setId(Integer.parseInt(campoID.getText()));
        cR.actualizar(c);
        hacerTabla();
    }//GEN-LAST:event_bActualizarClieActionPerformed

    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        validarLetras(evt, 45, "Solo se permiten caracteres en este campo",campoNombre.getText());
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoTelefono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefono1KeyTyped
       validarNumero(evt, 20,"Solo se aceptan numeros en este campo",campoTelefono1.getText());
    }//GEN-LAST:event_campoTelefono1KeyTyped

    private void campoTelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefono2KeyTyped
         validarNumero(evt, 20,"Solo se aceptan numeros en este campo",campoTelefono2.getText());
    }//GEN-LAST:event_campoTelefono2KeyTyped

    private void campoBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBusquedaKeyTyped
        switch (opcionBusqueda.getSelectedItem().toString()) {
            case "Todos":
               // hacerTabla();
                break;
            case "ID":
                 validarNumero(evt, 11,"Solo se aceptan numeros en este campo",campoBusqueda.getText());
                break;
            case "RFC":
              //  hacerTablaPorRFC();
                break;
            case "Nombre":
               validarLetras(evt, 45, "Solo se permiten caracteres en este campo",campoBusqueda.getText());
                break;
            case "Direccion":
               // hacerTablaPorDireccion();
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_campoBusquedaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizarClie;
    private javax.swing.JButton bAgregarClie;
    private javax.swing.JButton bEliminarClie;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campoBusqueda;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRFC;
    private javax.swing.JTextField campoTelefono1;
    private javax.swing.JTextField campoTelefono2;
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
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
