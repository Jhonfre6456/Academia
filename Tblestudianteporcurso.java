
package Interfaz;

import Controlador.ConexionCurso;
import Controlador.Validarletras;
import Controlador.Validarnumeros;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Tblestudianteporcurso extends javax.swing.JFrame {
    
    ConexionCurso con=new ConexionCurso();
    Connection cnn=con.Conexiondb();
    PreparedStatement ps=null;
    ResultSet rs=null;
   
       

   
    public Tblestudianteporcurso() {
      initComponents();
       getContentPane().setBackground(Color. green);
       cargatabla();
       cargarcombocodcurso();
       cargarcombodocestudiante();
    }

   public void cargatabla(){
       DefaultTableModel tabla=new DefaultTableModel();
       
       tabla.addColumn("Código Curso");
       tabla.addColumn("Documento Estudiante");
       tabla.addColumn("Fecha de Inicio");
      
       
       tablaestudianteporcurso.setModel(tabla);
       
       String datos[]=new String[4];
       
       try {
           ps=cnn.prepareStatement("SELECT * FROM tblestudianteporcurso");
           rs=ps.executeQuery();
           
           while (rs.next()){
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
        
               tabla.addRow(datos);
                       
           }
       } catch (Exception e) {
           System.out.print(e);
       }
   }
    
  public void registrar(){
      
      try {
          ps=cnn.prepareStatement("INSERT INTO tblestudianteporcurso(Estuc_codcurso, Estuc_docestu, Estuc_fechaini)VALUES (?,?,?)");
          ps.setString(1, codcurso.getSelectedItem().toString());
          ps.setString(1, docestu.getSelectedItem().toString());
          ps.setString(3, Fechainicio.getText());
        
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Guardados");
          
      } catch (Exception e) {
          System.out.println("eee"+e);
      }
  }
  
  public void eliminar(String dat){
      try {
          ps=cnn.prepareStatement("DELETE FROM tblestudianteporcurso WHERE Estuc_codcurso = '"+dat+"'");
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Eliminados");
          cargatabla();
          cargarcombocodcurso();
          cargarcombodocestudiante();
          
      } catch (Exception e) {
           System.out.print(e);
      }
  }
  
 public void modificar (String cod, String doc, String fecha){
     try {
         ps=cnn.prepareStatement("UPDATE tblestudianteporcurso SET Estuc_docestu = '"+doc+"',Estuc_fechaini='"+fecha+"' WHERE Estuc_codcurso='"+cod+"'");
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Campo modificados");
     } catch (Exception e) {
         System.out.print(e);
     }
    
}
    
 
/*public void cargarcombocodcurso(){
    try {
        codcurso.removeAll();
        codcurso.addItem("Selecione Código de curso");
        ps=cnn.prepareStatement("SELECT Estuc_codcurso FROM tblestudianteporcurso");
        rs=ps.executeQuery();
        
        while (rs.next()){
            String aux = rs.getString("Estuc_codcurso");
            this.codcurso.addItem(aux);
            
        }
    } catch (Exception e) {
    }
}*/
 
 public void cargarcombocodcurso(){
    try {
        codcurso.removeAll();
        codcurso.addItem("Selecione Código de curso");
        ps=cnn.prepareStatement("SELECT curs_cod FROM tblcurso");
        rs=ps.executeQuery();
        
        while (rs.next()){
            String aux = rs.getString("curs_cod");
            this.codcurso.addItem(aux);
            
        }
    } catch (Exception e) {
    }
}


public void cargarcombodocestudiante(){
    try {
        docestu.removeAll();
        docestu.addItem("Seleccione Documento de Estudiante");
        ps=cnn.prepareStatement("SELECT est_doc FROM tblestudiante");
        rs=ps.executeQuery();
      
        
        while (rs.next()){
            String aux=rs.getString("est_doc");
            this.docestu.addItem(aux);
        }
    } catch (Exception e) {
        
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaestudianteporcurso = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Fechainicio = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        codcurso = new javax.swing.JComboBox<>();
        docestu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setText("TABLA ESTUDIANTE POR CURSO");

        tablaestudianteporcurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaestudianteporcurso.setForeground(new java.awt.Color(0, 102, 102));
        tablaestudianteporcurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaestudianteporcurso);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Código de Curso:");
        jLabel2.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Documento Estudiante:");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de Inicio:");
        jLabel4.setOpaque(true);

        Registrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        Eliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Modificar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Borrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/teacher_colaberation_pc_400_clr.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Ir a Opciones de Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        codcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codcursoActionPerformed(evt);
            }
        });

        docestu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docestuActionPerformed(evt);
            }
        });

        jLabel5.setText("AAAA/mm/dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(Registrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Eliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(Modificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(Borrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel5))
                                                    .addComponent(jLabel4))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(docestu, 0, 278, Short.MAX_VALUE)
                                            .addComponent(codcurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Fechainicio))))
                                .addGap(105, 105, 105)
                                .addComponent(jLabel6)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(docestu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Registrar)
                            .addComponent(Eliminar)
                            .addComponent(Modificar)
                            .addComponent(Borrar))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        registrar();
        cargatabla();
    }//GEN-LAST:event_RegistrarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String dat=codcurso.getSelectedItem().toString();
        eliminar(dat);
        cargatabla();
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        
        String c, d, f;
        c=codcurso.getSelectedItem().toString();
        d= docestu.getSelectedItem().toString();
        f=Fechainicio.getText();
        
        modificar(d, d, f);
        cargatabla();
             
    }//GEN-LAST:event_ModificarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
       codcurso.removeAllItems();
       cargarcombocodcurso();
       docestu.removeAllItems();
       cargarcombodocestudiante();
       Fechainicio.setText(null);
      
       
    }//GEN-LAST:event_BorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Opciones opc=new Opciones();
       opc.setVisible(true);
       opc.setLocationRelativeTo(null);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void docestuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docestuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docestuActionPerformed

    private void codcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codcursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codcursoActionPerformed

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
            java.util.logging.Logger.getLogger(Tblestudianteporcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tblestudianteporcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tblestudianteporcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tblestudianteporcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tblestudianteporcurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField Fechainicio;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Registrar;
    private javax.swing.JComboBox<String> codcurso;
    private javax.swing.JComboBox<String> docestu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaestudianteporcurso;
    // End of variables declaration//GEN-END:variables
}
