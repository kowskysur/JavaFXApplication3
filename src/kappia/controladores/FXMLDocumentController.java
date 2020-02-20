/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.controladores;

import static antlr.build.ANTLR.root;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kappia.dao.ClienteDAO;
import kappia.entidades.Cliente;
import kappia.utilidades.Conexion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author usuario pc
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private Button button;

    @FXML
    private Button boton2;

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    
    @FXML
    void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
        /**Conexion conexion = new Conexion(); 
        Connection conexionToDB = conexion.getConexionToDataBase();
        String query = "SELECT * FROM cliente";
        try{
            Statement stament = conexionToDB.createStatement();
            ResultSet a = stament.executeQuery(query);
            
            System.out.println(a.first());
        }catch(Exception e){
            e.printStackTrace();
        }*/
        
        ClienteDAO clienteDao = new ClienteDAO();
        /**Cliente cliente = new Cliente(12008990, "Ramesh", "Fadatare", new Short("1"));
        clienteDao.saveCliente(cliente);*/
        List <Cliente> clientes = clienteDao.getClientes();
        for(Cliente c: clientes){
            System.out.println(c.getNombres());
        }

    }
    
    @FXML
    void show_pantallaClientes(ActionEvent event) {
        try{
            Parent root1 = FXMLLoader.load(getClass().getResource("/kappia/vistas/FXMLAgregarClientes.fxml"));

            Stage stage = new Stage();
            //FullScreen
            stage.setMaximized(true);
            stage.setTitle("Ingresar Nuevo Usuario");
            stage.setScene(new Scene(root1));  
            stage.show();
        }catch(Exception e) {
            e.printStackTrace();
        
        }

    }
    
    @FXML
    void show_pantallaConstultaClientes(ActionEvent event) {
        try{
            Parent root1 = FXMLLoader.load(getClass().getResource("/kappia/vistas/FXMLConsultarClientes.fxml"));

            Stage stage = new Stage();
            //FullScreen
            stage.setMaximized(true);
            stage.setTitle("Consultar Clientes");
            stage.setScene(new Scene(root1));  
            stage.show();
        }catch(Exception e) {
            e.printStackTrace();
        
        }
    }

}
