/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        menuIcon = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        provedoresOption = new javax.swing.JMenuItem();
        productosOption = new javax.swing.JMenuItem();
        categoriasOption = new javax.swing.JMenuItem();
        clientesOption = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        registrarVentaOption = new javax.swing.JMenuItem();
        busquedaVentaOption = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTitulo.setText("PUNTO DE VENTAS");

        menuIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\menuIcon.png")); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\opcionesIcon.png")); // NOI18N
        jMenu1.setText("Opciones");

        provedoresOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\provedorIcon.png")); // NOI18N
        provedoresOption.setText("Provedores");
        provedoresOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provedoresOptionActionPerformed(evt);
            }
        });
        jMenu1.add(provedoresOption);

        productosOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\productoIcon.png")); // NOI18N
        productosOption.setText("Productos");
        productosOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosOptionActionPerformed(evt);
            }
        });
        jMenu1.add(productosOption);

        categoriasOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\categoriaIcon.png")); // NOI18N
        categoriasOption.setText("Categorias");
        categoriasOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasOptionActionPerformed(evt);
            }
        });
        jMenu1.add(categoriasOption);

        clientesOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\clienteIcon.png")); // NOI18N
        clientesOption.setText("Clientes");
        clientesOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesOptionActionPerformed(evt);
            }
        });
        jMenu1.add(clientesOption);

        jMenu3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\ventaMenuBarMenuIcon.png")); // NOI18N
        jMenu3.setText("Ventas");

        registrarVentaOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\ventaIcon.png")); // NOI18N
        registrarVentaOption.setText("Registrar Venta");
        registrarVentaOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarVentaOptionActionPerformed(evt);
            }
        });
        jMenu3.add(registrarVentaOption);

        busquedaVentaOption.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\consultarVentaIcon.png")); // NOI18N
        busquedaVentaOption.setText("Busqueda Venta");
        busquedaVentaOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaVentaOptionActionPerformed(evt);
            }
        });
        jMenu3.add(busquedaVentaOption);

        jMenu1.add(jMenu3);

        jMenuItem1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\salirIcon.png")); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Daniel\\Desktop\\Proyecto02_00000192937\\img\\aboutIcon.png")); // NOI18N
        jMenu2.setText("Acerca de");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(menuIcon)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(menuIcon)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void provedoresOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provedoresOptionActionPerformed
        FrmProvedores frmProvedores = new FrmProvedores();
        frmProvedores.setVisible(true);
        dispose();
    }//GEN-LAST:event_provedoresOptionActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        JOptionPane.showMessageDialog(this, "Alumno: Luis", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void productosOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosOptionActionPerformed
       FrmProducto frmProductos = new FrmProducto();
       frmProductos.setVisible(true);
       dispose();
    }//GEN-LAST:event_productosOptionActionPerformed

    private void categoriasOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasOptionActionPerformed
        FrmCategorias frmCategorias = new FrmCategorias();
        frmCategorias.setVisible(true);
        dispose();
    }//GEN-LAST:event_categoriasOptionActionPerformed

    private void clientesOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesOptionActionPerformed
        FrmClientes frmClientes = new FrmClientes();
        frmClientes.setVisible(true);
        dispose();
    }//GEN-LAST:event_clientesOptionActionPerformed

    private void registrarVentaOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarVentaOptionActionPerformed
        FrmRegistroVentas frmRegistroVenta = new FrmRegistroVentas();
        frmRegistroVenta.setVisible(true);
        dispose();
    }//GEN-LAST:event_registrarVentaOptionActionPerformed

    private void busquedaVentaOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaVentaOptionActionPerformed
        FrmBusquedaVentas frmBusquedaVenta = new FrmBusquedaVentas();
        frmBusquedaVenta.setVisible(true);
        dispose();
    }//GEN-LAST:event_busquedaVentaOptionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem busquedaVentaOption;
    private javax.swing.JMenuItem categoriasOption;
    private javax.swing.JMenuItem clientesOption;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel menuIcon;
    private javax.swing.JMenuItem productosOption;
    private javax.swing.JMenuItem provedoresOption;
    private javax.swing.JMenuItem registrarVentaOption;
    // End of variables declaration//GEN-END:variables
}
