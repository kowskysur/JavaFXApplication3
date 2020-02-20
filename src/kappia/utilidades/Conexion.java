/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario pc
 */
public class Conexion {
    
    
    /**
     * Establece la conexion con la base de datos
     * @return 
     */  
    public Connection getConexionToDataBase(){
        String dbname = "kappia";
        String username = "root";
        String password = "12345678";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            
        }
        
        System.out.println("MySQL JDBC Driver Encontrado!");
        Connection connection = null;
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/"+dbname+"?serverTimezone=UTC", username, password);
            System.out.println("SQL Connection to database exitosa!");
    
        } catch (SQLException e) {
            System.out.println("Connection Failed! fallo en conexion");
            e.printStackTrace();
        }  
        
        return connection;
    }
    
}