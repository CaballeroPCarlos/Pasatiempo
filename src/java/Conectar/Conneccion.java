
package Conectar;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conneccion {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String myDB ="jdbc:mysql://localhost/ciclo1_pasatiempo";
            String usuario="root";
            String password="";
            Connection cnx = DriverManager.getConnection(myDB,usuario,password);
            return cnx;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Conneccion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}
