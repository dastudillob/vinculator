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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nacho
 */
public class Agregar_Producto extends javax.swing.JFrame {

    /**
     * Creates new form Agregar_Producto
     */
    Statement st = null;
    ResultSet rs = null;

    Conectar cc= new Conectar();
    Connection cn= cc.conexion();
    public Agregar_Producto() {
        initComponents();
        this.setLocationRelativeTo(null);
        Obtener_local("");
        Obtener_Producto("");
        mostrardatosp("");
        
    }

    public void Obtener_local(String valor){
        DefaultComboBoxModel combobx = new DefaultComboBoxModel();
        CB_NOMBRE_L.setModel(combobx);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM local";
    }

    
        String nombre;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombre=rs.getString(2);

                CB_NOMBRE_L.addItem(nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
    
     public void Obtener_Producto(String valor){
        DefaultComboBoxModel combobx = new DefaultComboBoxModel();
        CB_PRODUCTO.setModel(combobx);
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM producto";
    }

    
        String nombre;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombre=rs.getString(2);

                CB_PRODUCTO.addItem(nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }   
    void mostrardatosp(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Código Local");
    modelo.addColumn("Producto");    
  
    tb_producto.setModel(modelo);
    String sql="";
    String a;
    a = obtenercod_local(CB_NOMBRE_L.getSelectedItem().toString());
    valor = a;
    if(valor.equals(""))
    {
        sql="SELECT * FROM producto";
    }
    else{
        sql="SELECT * FROM local_prod WHERE cod_local='"+valor+"'";
    }
    
        String []datos = new String [2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=obtenernom_prod(rs.getString(2));

                modelo.addRow(datos);
            }
            tb_producto.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Agregar_Local.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
        String obtenercod_local(String valor){
        String dato;
        try {
            String csql = "SELECT cod_local FROM local WHERE nom_local='"+valor+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(csql);
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
        
    String obtenernom_prod(String valor){
        String dato;
        try {
            String csql = "SELECT nom_prod FROM producto WHERE cod_prod='"+valor+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(csql);
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BTN_SALIR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CB_NOMBRE_L = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_producto = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CB_PRODUCTO = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 400));
        setMinimumSize(new java.awt.Dimension(450, 400));
        setPreferredSize(new java.awt.Dimension(450, 400));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("AGREGAR PRODUCTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(124, 18, 177, 24);

        BTN_SALIR.setText("Atrás");
        BTN_SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SALIRActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_SALIR);
        BTN_SALIR.setBounds(292, 315, 85, 23);

        jLabel2.setText("Seleccione un Local");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(42, 60, 140, 32);

        CB_NOMBRE_L.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_NOMBRE_LItemStateChanged(evt);
            }
        });
        CB_NOMBRE_L.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CB_NOMBRE_LMouseClicked(evt);
            }
        });
        getContentPane().add(CB_NOMBRE_L);
        CB_NOMBRE_L.setBounds(219, 66, 198, 20);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(42, 155, 0, 0);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(34, 315, 71, 23);

        tb_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_producto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 173, 407, 119);

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(164, 315, 78, 23);

        jLabel4.setText("Seleccione un Producto");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(42, 110, 160, 14);

        getContentPane().add(CB_PRODUCTO);
        CB_PRODUCTO.setBounds(219, 110, 198, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Fondo-celeste-copia-1024x1024.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 470, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SALIRActionPerformed
        Inicio v3 = new Inicio();
        dispose();
        v3.setVisible(true);
    }//GEN-LAST:event_BTN_SALIRActionPerformed

    private void CB_NOMBRE_LMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CB_NOMBRE_LMouseClicked
           mostrardatosp("");
     // TODO add your handling code here:
    }//GEN-LAST:event_CB_NOMBRE_LMouseClicked

    private void CB_NOMBRE_LItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_NOMBRE_LItemStateChanged
        mostrardatosp("");
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_NOMBRE_LItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int fila = tb_producto.getSelectedRow();
    String cod="";
    cod=tb_producto.getValueAt(fila, 0).toString();
    String cod2="";
    cod2=obtenercod_producto(tb_producto.getValueAt(fila, 1).toString());
    
    try {

        PreparedStatement pst = cn.prepareStatement("DELETE FROM local_prod WHERE  cod_local='"+cod+"' and cod_prod = '" +cod2+ "'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Producto Eliminado");
        mostrardatosp("");
    } catch (Exception e) {
    }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String codigo_l = obtenercod_local(CB_NOMBRE_L.getSelectedItem().toString());  
        String codigo_p = obtenercod_producto(CB_PRODUCTO.getSelectedItem().toString());  
        validar_producto(codigo_l,codigo_p);
    }//GEN-LAST:event_jButton1ActionPerformed


    String validar_producto(String valor, String valor2){
        String vali = "";
        try {
            String csql = "SELECT * FROM local_prod WHERE cod_prod='"+valor2+"' and cod_local ='"+valor+"'";
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

        String sql = "Select cod_prod from producto where nom_prod = '"+ CB_PRODUCTO.getSelectedItem().toString() +"'";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String ex = rs.getString(1);
        PreparedStatement pstg = cn.prepareStatement("INSERT INTO LOCAL_PROD(cod_local,cod_prod) VALUES (?,?) ");
        String g;
        g = obtenercod_local(CB_NOMBRE_L.getSelectedItem().toString());
        pstg.setString(1,g);
        pstg.setString(2, ex);
        pstg.executeUpdate();
        JOptionPane.showMessageDialog(null, "Producto Agregado");
        mostrardatosp("");
 
    } catch (Exception e) {
        System.out.print(e.getMessage());
    }  
        }else {
         JOptionPane.showMessageDialog(null, "Producto duplicado");
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
            java.util.logging.Logger.getLogger(Agregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_SALIR;
    private javax.swing.JComboBox<String> CB_NOMBRE_L;
    private javax.swing.JComboBox<String> CB_PRODUCTO;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_producto;
    // End of variables declaration//GEN-END:variables
}
