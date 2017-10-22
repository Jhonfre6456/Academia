
package Controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionCurso {
    Connection cnn=null;
    
     public Connection Conexiondb(){
        
        try {
        Class.forName("com.mysql.jdbc.Driver");
        cnn=DriverManager.getConnection("jdbc:mysql://localhost/laboratoriosql","root","1234");
        //base de datos , usuario de mysql,contraseña de mysql
            JOptionPane.showMessageDialog(null, "conexion exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.print(e);
        }
 
        return cnn;
    }
    
     public static void main (String args[]){
         ConexionCurso con=new ConexionCurso();
         con.Conexiondb();
     }
    
    
    
}
