
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


public class Tblcurso extends javax.swing.JFrame {
    
    ConexionCurso con=new ConexionCurso();
    Connection cnn=con.Conexiondb();
    PreparedStatement ps=null;
    ResultSet rs=null;
    Validarletras validarletras =new  Validarletras();
    Validarnumeros validarnumeros=new Validarnumeros();
    
       

   
    public Tblcurso() {
        initComponents();
       getContentPane().setBackground(Color. ORANGE);
       cargatabla();
    }

   public void cargatabla(){
       DefaultTableModel tabla=new DefaultTableModel();
       
       tabla.addColumn("Código Curso");
       tabla.addColumn("Nombre de Curso");
       tabla.addColumn("Horas de Curso");
       tabla.addColumn("Valor de Curso");
       
       tablacurso.setModel(tabla);
       
       String datos[]=new String[4];
       
       try {
           ps=cnn.prepareStatement("SELECT * FROM tblcurso");
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
          ps=cnn.prepareStatement("INSERT INTO tblcurso(curs_cod, curs_nombre, curs_horas, curs_valor)VALUES (?,?,?,?)");
          ps.setString(1, codcurso.getText());
          ps.setString(2, nomcurso.getText());
          ps.setString(3, horascurso.getText());
          ps.setString(4, valorcurso.getText());
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Guardados");
          
      } catch (Exception e) {
          System.out.println("eee"+e);
      }
  }
  
  public void eliminar(String dat){
      try {
          ps=cnn.prepareStatement("DELETE FROM tblcurso WHERE curs_cod = '"+dat+"'");
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Datos Eliminados");
          cargatabla();
      } catch (Exception e) {
           System.out.print(e);
      }
  }
  
 public void modificar (String cod, String nom, String hor, String val){
     try {
         ps=cnn.prepareStatement("UPDATE tblcurso SET curs_nombre ='"+nom+"',curs_horas = '"+hor+"',curs_valor='"+val+"' WHERE curs_cod='"+cod+"'");
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
        tablacurso = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        codcurso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomcurso = new javax.swing.JTextField();
        horascurso = new javax.swing.JTextField();
        valorcurso = new javax.swing.JTextField();
        Registrar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel1.setText("TABLA CURSO");

        tablacurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablacurso.setForeground(new java.awt.Color(0, 102, 102));
        tablacurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablacurso);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Código de Curso: ");
        jLabel2.setOpaque(true);

        codcurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codcursoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setText("Nombre de Curso:");
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setText("Horas de Curso:");
        jLabel4.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setText("Valor de Curso:");
        jLabel5.setOpaque(true);

        nomcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomcursoActionPerformed(evt);
            }
        });
        nomcurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomcursoKeyTyped(evt);
            }
        });

        horascurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horascursoKeyTyped(evt);
            }
        });

        valorcurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorcursoKeyTyped(evt);
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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/figuresClassroom1.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Ir a Opciones de Tablas");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valorcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(horascurso, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nomcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(codcurso, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Registrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Eliminar)
                                .addGap(18, 18, 18)
                                .addComponent(Modificar)
                                .addGap(18, 18, 18)
                                .addComponent(Borrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(horascurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(valorcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Registrar)
                            .addComponent(Eliminar)
                            .addComponent(Modificar)
                            .addComponent(Borrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        registrar();
        cargatabla();
    }//GEN-LAST:event_RegistrarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String dat=codcurso.getText();
        eliminar(dat);
        cargatabla();
        
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        
        String c, n,h,v;
        c=codcurso.getText();
        n=nomcurso.getText();
        h=horascurso.getText();
        v=valorcurso.getText();
        modificar(c, n, h, v);
        cargatabla();
             
    }//GEN-LAST:event_ModificarActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
       codcurso.setText(null);
       nomcurso.setText(null);
       horascurso.setText(null);
       valorcurso.setText(null);
       
    }//GEN-LAST:event_BorrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Opciones opc=new Opciones();
    opc.setVisible(true);
        opc.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nomcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomcursoActionPerformed
                    
    }//GEN-LAST:event_nomcursoActionPerformed

    private void nomcursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomcursoKeyTyped
       String texto=nomcurso.getText();
       if (texto.length()>0){
            
            char primeraletra=texto.charAt(0);
            texto=Character.toUpperCase(primeraletra)+texto.substring(1,texto.length());
            nomcurso.setText(texto);
        }
    }//GEN-LAST:event_nomcursoKeyTyped

    private void codcursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codcursoKeyTyped
        validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_codcursoKeyTyped

    private void horascursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horascursoKeyTyped
         validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_horascursoKeyTyped

    private void valorcursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorcursoKeyTyped
        validarnumeros.solonumeros(evt);
    }//GEN-LAST:event_valorcursoKeyTyped

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
            java.util.logging.Logger.getLogger(Tblcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tblcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tblcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tblcurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tblcurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField codcurso;
    private javax.swing.JTextField horascurso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomcurso;
    private javax.swing.JTable tablacurso;
    private javax.swing.JTextField valorcurso;
    // End of variables declaration//GEN-END:variables
}
