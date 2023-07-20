
package Clases;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {
    Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/vinculator_bd_externa","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
}

