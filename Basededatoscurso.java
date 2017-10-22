
package Controlador;

import Interfaz.Acceso;


public class Basededatoscurso {

   
    public static void main(String[] args) {
     ConexionCurso con=new ConexionCurso();
     con.Conexiondb();
     
     Acceso acc=new Acceso();
     acc.setVisible(true);
    acc.setLocationRelativeTo(null);
     
    }
    
}
