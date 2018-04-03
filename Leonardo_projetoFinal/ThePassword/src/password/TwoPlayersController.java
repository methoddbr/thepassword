/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.shape.Circle;


/**
 * FXML Controller class
 *
 * @author metho
 */
public class TwoPlayersController extends ThePasswordController implements Initializable {
    @FXML
    private Circle ball1, ball2, ball3, ball4;
    @FXML
    private Button sendPasswordButton;
    @FXML
    private Label labeltest;
    @FXML
    private AnchorPane twoPane;
    @FXML
    private TextField namePlayer1;
    public static ArrayList<Color> password = new ArrayList();
    

    /*    public TwoPlayersController() {
    senha.add(BLUE);
    senha.add(YELLOW);
    senha.add(RED);
    senha.add(GREEN);
    }*/
    
    
    
    @FXML
    public ArrayList<Color> sendPassword(ActionEvent e) throws IOException{
        if(e.getSource()==sendPasswordButton){
            if(ball1.getFill() == ball2.getFill() || ball1.getFill() == ball3.getFill() ||
                ball1.getFill() == ball4.getFill() || ball2.getFill() == ball3.getFill() ||
                ball2.getFill() == ball4.getFill() || ball3.getFill() == ball4.getFill() ||
                ball1.getFill()==WHITE || ball2.getFill()==WHITE || ball3.getFill()==WHITE || ball4.getFill()==WHITE){
                alert();
            }else{ 
                password.add((Color) ball1.getFill());
                password.add((Color) ball2.getFill());
                password.add((Color) ball3.getFill());
                password.add((Color) ball4.getFill());
                
              
                ThePassword.changeScreen(2);
                return password;   
            }
        }
        return null;
    }

    public void alert() {
	Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
        dialogo.setTitle("The Password");
        dialogo.setHeaderText("Invalid combination!");
        dialogo.setContentText("Can not contain repeated colors and white!");
        dialogo.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    public ArrayList<Color> getSenha() {
        return password;
    }
    
    @Override
    public String toString(){
        return password.get(0).getClass().getTypeName()+
                " "+password.get(1).getClass().getTypeName()+
                " "+password.get(2).getClass().getTypeName()+
                " "+password.get(3).getClass().getTypeName()+
                " "+password.get(4).getClass().getTypeName()+
                " "+password.get(5).getClass().getTypeName();
    }
    

}
