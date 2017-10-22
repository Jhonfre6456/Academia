
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


public class Tblprofesor extends javax.swing.JFrame {
    
    ConexionCurso con=new ConexionCurso();
    Connection cnn=con.Conexiondb();
    PreparedStatement ps=null;
    ResultSet rs=null;
    Validarletras validarletras =new  Validarletras();
    Validarnumeros validarnumeros=new Validarnumeros();
       

   
    public Tblprofesor() {
      initComponents();
       getContentPane().setBackground(Color. DARK_GRAY);
       cargatabla();
    }

   public void cargatabla(){
       DefaultTableModel tabla=new DefaultTableModel();
       
       tabla.addColumn("Doc. Profeso");
       tabla.addColumn("Nombre Profesor");
       tabla.addColumn("Apellido Profesor");
       tabla.addColumn("Categoría");
       tabla.addColumn("Salario Profesor");
       
       tablaestudiante.setModel(tabla);
       
       String datos[]=new String[5];
       
       try {
           ps=cnn.prepareStatement("SELECT * FROM tblprofesor");
           rs=ps.executeQuery();
           
           while (rs.next()){
               datos[0]=rs.getString(1);
               datos[1]=rs.getString(2);
               datos[2]=rs.getString(3);
               datos[3]=rs.getString(4);
               datos[4]=rs.getString(5);
               
               tabla.addRow(datos);
                       
           }
       } catch (Exception e) {
           System.out.print(e);
       }
   }
    
  public void registrar(){
      
      try {
          ps=cnn.prepareStatement("INSERT INTO tblprofesor(prof_doc, prof_nom, prof_apel, prof_cate, prof_sal)VALUES (?,?,?,?,?)");
          ps.setString(1, docprofe.getText());
          ps.setString(2, nomprofe.getText());
          ps.setString(3, apellidoprofe.getText());
          ps.setString(4, catprofe.getText());
           ps.setString(5, salarioprofe.getText());
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Guardados");
          
      } catch (Exception e) {
          System.out.println("eee"+e);
      }
  }
  
  public void eliminar(String dat){
      try {
          ps=cnn.prepareStatement("DELETE FROM tblprofesor WHERE prof_doc = '"+dat+"'");
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Eliminados");
          cargatabla();
      } catch (Exception e) {
           System.out.print(e);
      }
  }
  
 public void modificar (String doc, String nom, String apell, String cat, String sal){
     try {
         ps=cnn.prepareStatement("UPDATE tblprofesor SET prof_nom ='"+nom+"',prof_apel = '"+apell+"',prof_cate='"+cat+"',prof_sal='"+sal+"' WHERE prof_doc='"+doc+"'");
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
        docprofe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomprofe = new javax.swing.JTextField();
        apellidoprofe = new javax.swing.JTextField();
        catprofe = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        salarioprofe = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TABLA PROFESOR");

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
        jLabel2.setText("Documento Profesor:");
        jLabel2.setOpaque(true);

        docprofe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                docprofeKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Profesor:");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Apellido Profesor:");
        jLabel4.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Categoría Profesor:");
        jLabel5.setOpaque(true);

        nomprofe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomprofeKeyTyped(evt);
            }
        });

        apellidoprofe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoprofeKeyTyped(evt);
            }
        });

        catprofe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                catprofeKeyTyped(evt);
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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/profesor3.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Ir a Opciones de Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setText("Salario Profesor:");
        jLabel7.setOpaque(true);

        salarioprofe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salarioprofeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salarioprofe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(catprofe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(apellidoprofe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nomprofe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(docprofe, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(189, 189, 189)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Registrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(Modificar)
                        .addGap(18, 18, 18)
                        .addComponent(Borrar)))
                .addContainerGap(19, Short.MAX_VALUE))
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
                            .addComponent(docprofe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomprofe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoprofe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(catprofe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(salarioprofe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Registrar)
                            .addComponent(Eliminar)
                            .addComponent(Modificar)
                            .addComponent(Borrar)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
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
        String dat=docprofe.getText();
        eliminar(dat);
        cargatabla();
        
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        
        String d, n,a,c,s;
        d=docprofe.getText();
        n=nomprofe.getText();
        a=apellidoprofe.getText();
        c=catprofe.getText();
        s=salarioprofe.getText();
        modificar(d,n,a,c,s);
        cargatabla();
             
    }//GEN-LAST:event_ModificarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
       docprofe.setText(null);
       nomprofe.setText(null);
       apellidoprofe.setText(null);
       catprofe.setText(null);
       salarioprofe.setText(null);
       
    }//GEN-LAST:event_BorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Opciones opc=new Opciones();
       opc.setVisible(true);
       opc.setLocationRelativeTo(null);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void docprofeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_docprofeKeyTyped
       validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_docprofeKeyTyped

    private void catprofeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_catprofeKeyTyped
        validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_catprofeKeyTyped

    private void salarioprofeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarioprofeKeyTyped
       validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_salarioprofeKeyTyped

    private void nomprofeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomprofeKeyTyped
         String texto=nomprofe.getText();
       if (texto.length()>0){
            
            char primeraletra=texto.charAt(0);
            texto=Character.toUpperCase(primeraletra)+texto.substring(1,texto.length());
            nomprofe.setText(texto);
        }
    }//GEN-LAST:event_nomprofeKeyTyped

    private void apellidoprofeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoprofeKeyTyped
         String texto=apellidoprofe.getText();
       if (texto.length()>0){
            
            char primeraletra=texto.charAt(0);
            texto=Character.toUpperCase(primeraletra)+texto.substring(1,texto.length());
            apellidoprofe.setText(texto);
        }
    }//GEN-LAST:event_apellidoprofeKeyTyped

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
            java.util.logging.Logger.getLogger(Tblprofesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tblprofesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tblprofesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tblprofesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tblprofesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField apellidoprofe;
    private javax.swing.JTextField catprofe;
    private javax.swing.JTextField docprofe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomprofe;
    private javax.swing.JTextField salarioprofe;
    private javax.swing.JTable tablaestudiante;
    // End of variables declaration//GEN-END:variables
}
