/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author Leonardo Prestes
 */
public class InitialController implements Initializable {
    @FXML
    private Button only, versus, record, inst;
    @FXML
    private Label logo;
    @FXML
    private AnchorPane centralPane;
    
    public void clickLogo(Event e){
        if(e.getSource()==logo){
            alert();
        }
    }
    
    public void clickButton(ActionEvent e) throws IOException{
        if (e.getSource()==versus){
            ThePassword.changeScreen(1);
        }else if(e.getSource()==record){
            ThePassword.changeScreen(4);
        }
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                    

    }    
    
    public void alert() {
	Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
        dialogo.setTitle("The Password");
        dialogo.setHeaderText("Developed by");
        dialogo.setContentText("Leonardo Prestes Machado in 2017.");
        dialogo.showAndWait();
    }
    

}
