
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


public class Tblestudiante extends javax.swing.JFrame {
    
    ConexionCurso con=new ConexionCurso();
    Connection cnn=con.Conexiondb();
    PreparedStatement ps=null;
    ResultSet rs=null;
    Validarletras validarletras =new  Validarletras();
    Validarnumeros validarnumeros=new Validarnumeros();
       

   
    public Tblestudiante() {
      initComponents();
       getContentPane().setBackground(Color. CYAN);
       cargatabla();
    }

   public void cargatabla(){
       DefaultTableModel tabla=new DefaultTableModel();
       
       tabla.addColumn("Doc. Estudiante");
       tabla.addColumn("Nombre Estudiante");
       tabla.addColumn("Apellido Estudiante");
       tabla.addColumn("Edad");
       
       tablaestudiante.setModel(tabla);
       
       String datos[]=new String[4];
       
       try {
           ps=cnn.prepareStatement("SELECT * FROM tblestudiante");
           rs=ps.executeQuery();
           
           while (rs.next()){
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               tabla.addRow(datos);
                       
           }
       } catch (Exception e) {
           System.out.print(e);
       }
   }
    
  public void registrar(){
      
      try {
          ps=cnn.prepareStatement("INSERT INTO tblestudiante(est_doc, est_nombre, est_apellido, est_edad)VALUES (?,?,?,?)");
          ps.setString(1, docestudiante.getText());
          ps.setString(2, nomestudiante.getText());
          ps.setString(3, apellidoestudiante.getText());
          ps.setString(4, edad.getText());
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Guardados");
          
      } catch (Exception e) {
          System.out.println("eee"+e);
      }
  }
  
  public void eliminar(String dat){
      try {
          ps=cnn.prepareStatement("DELETE FROM tblestudiante WHERE est_doc = '"+dat+"'");
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Eliminados");
          cargatabla();
      } catch (Exception e) {
           System.out.print(e);
      }
  }
  
 public void modificar (String doc, String nom, String apell, String edad){
     try {
         ps=cnn.prepareStatement("UPDATE tblestudiante SET est_nombre ='"+nom+"',est_apellido = '"+apell+"',est_edad='"+edad+"' WHERE est_doc='"+doc+"'");
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null, "Campo modificados");
     } catch (Exception e) {
         System.out.print(e);
     }
    
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaestudiante = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        docestudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomestudiante = new javax.swing.JTextField();
        apellidoestudiante = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setText("TABLA ESTUDIANTE");

        tablaestudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaestudiante.setForeground(new java.awt.Color(0, 102, 102));
        tablaestudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaestudiante);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Documento Estudiante:");
        jLabel2.setOpaque(true);

        docestudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                docestudianteKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Estudiante:");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Apellido Estudiante:");
        jLabel4.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Edad:");
        jLabel5.setOpaque(true);

        nomestudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomestudianteKeyTyped(evt);
            }
        });

        apellidoestudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoestudianteKeyTyped(evt);
            }
        });

        edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edadKeyTyped(evt);
            }
        });

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/estudiante.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Ir a Opciones de Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(775, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
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
                                .addComponent(jLabel4)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidoestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(docestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(docestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Registrar)
                            .addComponent(Eliminar)
                            .addComponent(Modificar)
                            .addComponent(Borrar))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
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
        String dat=docestudiante.getText();
        eliminar(dat);
        cargatabla();
        
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        
        String c, n,h,v;
        c=docestudiante.getText();
        n=nomestudiante.getText();
        h=apellidoestudiante.getText();
        v=edad.getText();
        modificar(c, n, h, v);
        cargatabla();
             
    }//GEN-LAST:event_ModificarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
       docestudiante.setText(null);
       nomestudiante.setText(null);
       apellidoestudiante.setText(null);
       edad.setText(null);
       
    }//GEN-LAST:event_BorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Opciones opc=new Opciones();
       opc.setVisible(true);
       opc.setLocationRelativeTo(null);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void docestudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_docestudianteKeyTyped
         validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_docestudianteKeyTyped

    private void edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edadKeyTyped
       validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_edadKeyTyped

    private void nomestudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomestudianteKeyTyped
        String texto=nomestudiante.getText();
       if (texto.length()>0){
            
            char primeraletra=texto.charAt(0);
            texto=Character.toUpperCase(primeraletra)+texto.substring(1,texto.length());
            nomestudiante.setText(texto);
        }
    }//GEN-LAST:event_nomestudianteKeyTyped

    private void apellidoestudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoestudianteKeyTyped
         String texto=apellidoestudiante.getText();
       if (texto.length()>0){
            
            char primeraletra=texto.charAt(0);
            texto=Character.toUpperCase(primeraletra)+texto.substring(1,texto.length());
            apellidoestudiante.setText(texto);
        }
    }//GEN-LAST:event_apellidoestudianteKeyTyped

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
            java.util.logging.Logger.getLogger(Tblestudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tblestudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tblestudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tblestudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tblestudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField apellidoestudiante;
    private javax.swing.JTextField docestudiante;
    private javax.swing.JTextField edad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomestudiante;
    private javax.swing.JTable tablaestudiante;
    // End of variables declaration//GEN-END:variables
}
