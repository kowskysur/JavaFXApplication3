/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.controladores;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kappia.dao.ClienteDAO;
import kappia.entidades.Cliente;

/**
 * FXML Controller class
 *
 * @author usuario pc
 */
public class FXMLAgregarClientesController implements Initializable {

     
    @FXML
    private Button btnGuardar;

    @FXML
    private TextField inputTextNombreCliente;
    
    @FXML
    private TextField inputTextApellidosCliente;

    @FXML
    private TextField inputTextIdentificacionCliente;

    
    @FXML
    void guardarNuevoCliente(ActionEvent event) {
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = new Cliente(Integer.valueOf(inputTextIdentificacionCliente.getText()), inputTextNombreCliente.getText(), inputTextApellidosCliente.getText(), new Short("1"));
        clienteDao.saveCliente(cliente);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("KAPPIA");
        alert.setHeaderText("Información");
        String s ="Los datos del cliente fueron almacenados";
        alert.setContentText(s);
        alert.show();
        
        List <Cliente> clientes = clienteDao.getClientes();
        for(Cliente c: clientes){
            System.out.println(c.getNombres());
        }
    }
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
