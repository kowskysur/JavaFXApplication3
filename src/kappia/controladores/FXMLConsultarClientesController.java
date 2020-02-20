/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import kappia.dao.ClienteDAO;
import kappia.entidades.Cliente;

/**
 * FXML Controller class
 *
 * @author usuario pc
 */
public class FXMLConsultarClientesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private ListView<Cliente> listaClientes;

    @FXML
    private Button btnconsultarClientes;
    
    @FXML
    void consultarClientes(ActionEvent event) {
        ClienteDAO clienteDao = new ClienteDAO();
        List <Cliente> listaClientesIn = clienteDao.getClientes();
        List <String> listaNombres = new ArrayList<>();
        //Devuelve la lista de nombres
        for(Cliente c: listaClientesIn){
           listaNombres.add(c.getNombres());
        }
        
        ObservableList listadesplegada = FXCollections.observableArrayList(listaNombres);
        
        listaClientes.setItems(listadesplegada);
    }


}
    
    

