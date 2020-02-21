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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kappia.dao.PlanDAO;
import kappia.entidades.Plan;

/**
 * FXML Controller class
 *
 * @author usuario pc
 */
public class FXMLAgregarPlanesController implements Initializable {
    
    
    @FXML
    private Label labelNombePlan;

    @FXML
    private Label labelEstadoPlan;

    @FXML
    private TextField inputTextEstadoPlan;

    @FXML
    private Button btnGuardarPlan;

    @FXML
    private TextField inputTextNombrePlan;

    @FXML
    private Label labelDescripcionPlan;

    @FXML
    private TextField inputTextDescripcionPlan;

    @FXML
    void guardarNuevoPlan(ActionEvent event) {

        PlanDAO planDao = new PlanDAO();
        Plan plan = new Plan(inputTextNombrePlan.getText(), inputTextDescripcionPlan.getText(), Short.valueOf(inputTextEstadoPlan.getText()));
        planDao.savePlan(plan);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("KAPPIA");
        alert.setHeaderText("Información");
        String s ="Los datos del plan fueron almacenados";
        alert.setContentText(s);
        alert.show();
        
        /**List <Plan> plans = planDao.getPlans();
        for(Plan c: plans){
            System.out.println(c.getNombres());
        }*/
    }

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
