/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import Model.Record;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import persistence.PlayerPersistence;

/**
 * FXML Controller class
 *
 * @author Leonardo Prestes
 */
public class RecordController implements Initializable {
    @FXML
    private Button cleanRecords, back;
    @FXML
    private Label record1, record2, record3, record4, record5;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listRecords();
    }    
    @FXML
    public void clean(ActionEvent e) throws IOException{
        if(e.getSource() == cleanRecords){
            PlayerPersistence j = new PlayerPersistence();
            j.cleanRecords();
        }else if(e.getSource() == back){
            ThePassword.changeScreen(5);
        }
        
    }
    
    @FXML
    public void listRecords(){
        PlayerPersistence j = new PlayerPersistence();
        ArrayList<Record> list = j.listRecords();
        
        switch (list.size()) {
            case 1:
                record1.setText("1. "+list.get(0).toString());
                break;
            case 2:
                record1.setText("1. "+list.get(0).toString());
                record2.setText("2. "+list.get(1).toString());
                break;
            case 3:
                record1.setText("1. "+list.get(0).toString());
                record2.setText("2. "+list.get(1).toString());
                record3.setText("3. "+list.get(2).toString());
                break;
            case 4:
                record1.setText("1. "+list.get(0).toString());
                record2.setText("2. "+list.get(1).toString());
                record3.setText("3. "+list.get(2).toString());
                record4.setText("4. "+list.get(3).toString());
                break;
            case 5:
                record1.setText("1. "+list.get(0).toString());
                record2.setText("2. "+list.get(1).toString());
                record3.setText("3. "+list.get(2).toString());
                record4.setText("4. "+list.get(3).toString());
                record5.setText("5. "+list.get(4).toString());
                break;
            default:
                break;
        }
        
    }
}
