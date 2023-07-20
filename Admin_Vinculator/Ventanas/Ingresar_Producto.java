/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class Ingresar_Producto extends javax.swing.JFrame {
        Conectar cc= new Conectar();
    Connection cn= cc.conexion();


    /**
     * Creates new form Ingresar_Producto
     */
    public Ingresar_Producto() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos("");
    }

    
    
    void mostrardatos(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Código");
    modelo.addColumn("Nombre");       
    tb_productos.setModel(modelo);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM producto";
    }
    else{
        sql="SELECT * FROM producto WHERE cod_prod='"+valor+"'";
    }
    
        String []datos = new String [2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            tb_productos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Ingresar_Producto.class.getName()).log(Level.SEVERE, null, ex);
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

        BTN_SALIR = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TXT_NUEVO_P = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_productos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(420, 350));
        setMinimumSize(new java.awt.Dimension(420, 350));
        setPreferredSize(new java.awt.Dimension(420, 350));
        getContentPane().setLayout(null);

        BTN_SALIR.setText("Atrás");
        BTN_SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SALIRActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_SALIR);
        BTN_SALIR.setBounds(305, 266, 85, 23);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 266, 80, 23);

        jLabel1.setText("Detalle de Producto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 110, 20);
        getContentPane().add(TXT_NUEVO_P);
        TXT_NUEVO_P.setBounds(155, 70, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Administrador de Productos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(113, 25, 170, 17);

        tb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_productos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 127, 380, 119);

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(99, 266, 90, 23);

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(205, 266, 90, 23);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Fondo-celeste-copia-1024x1024.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 430, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SALIRActionPerformed
        Inicio v3 = new Inicio();
        dispose();
        v3.setVisible(true);
    }//GEN-LAST:event_BTN_SALIRActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validar_producto(TXT_NUEVO_P.getText());   // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    String validar_producto(String valor){
        String vali = "";
        valor = valor.toUpperCase();
        try {
            String csql = "SELECT * FROM producto WHERE nom_prod='"+valor+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(csql);
            while(rs.next()){
                vali=rs.getString(1); 
            } 
        }
        catch(Exception e){
            System.out.println("Falló la carga del combobox \n"+e);              
        }
        if (vali.equals("")){
    try {
            if (TXT_NUEVO_P.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No puede dejar el campo en blanco.");
            }else{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO producto(nom_prod) VALUES (?)");
            pst.setString(1, TXT_NUEVO_P.getText().toUpperCase());
            pst.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Producto Agregado");
            mostrardatos("");
            TXT_NUEVO_P.setText("");
            }
    }catch (Exception e) {
        System.out.print(e.getMessage());
    }  
        }else {
         JOptionPane.showMessageDialog(null, "Producto duplicado");
        }
        return valor;
    }
    private void tb_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_productosMouseClicked
        TXT_NUEVO_P.setText(tb_productos.getValueAt(tb_productos.getSelectedRow(),1).toString());
    }//GEN-LAST:event_tb_productosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        if (TXT_NUEVO_P.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No puede dejar el campo en blanco.");
        }else{
            int fila = tb_productos.getSelectedRow();
            String coI="";
            coI=tb_productos.getValueAt(fila, 1).toString();
            String cod_p = obtenercod_producto(coI);
        PreparedStatement pst = cn.prepareStatement("UPDATE producto SET nom_prod= '"+TXT_NUEVO_P.getText().toUpperCase()+"' WHERE cod_prod= '"+cod_p+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Producto Actualizado");
        mostrardatos("");
        TXT_NUEVO_P.setText("");
                        }
    } catch (Exception e) {
        System.out.print(e.getMessage());
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int fila = tb_productos.getSelectedRow();
    String cod="";
    cod=tb_productos.getValueAt(fila, 0).toString();
    
    try {

        PreparedStatement pst = cn.prepareStatement("DELETE FROM producto WHERE  cod_prod='"+cod+"'");
        pst.executeUpdate();
        PreparedStatement dpst = cn.prepareStatement("DELETE FROM local_prod WHERE  cod_prod='"+cod+"'");
        dpst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Producto Eliminado");
        mostrardatos("");
    } catch (Exception e) {
    }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

        String obtenercod_producto(String valor){
        String dato;
        try {
            String psql = "SELECT cod_prod FROM producto WHERE nom_prod='"+valor+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(psql);
            while(rs.next()){
                dato=rs.getString(1);  
                valor = dato;
            } 
        }
        catch(Exception e){
            System.out.println("Falló la carga del combobox \n"+e);              
        }
        return valor;
    }
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
            java.util.logging.Logger.getLogger(Ingresar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_SALIR;
    private javax.swing.JTextField TXT_NUEVO_P;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_productos;
    // End of variables declaration//GEN-END:variables
}