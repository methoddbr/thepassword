/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import Model.Player;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import persistence.PlayerPersistence;

/**
 * FXML Controller class
 *
 * @author metho
 */
public class ThePasswordController implements Initializable {
    
    private static double start = 0;
    private static double end = 0;
    private static int attempt = 0;
    private static double time = 0;
    private int color = 0;
    private int colorContains = 0;
    private int colorPosition = 0;
    private boolean correctPassword = false;
    public ArrayList<Color> password = new ArrayList();
    
    private final Color[] colors = {Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED, Color.PINK, Color.ORANGE};
    
    @FXML
    private Label label1, label2, label3, label4, label5, label6, label7, label8, passwordField;
    
    @FXML
    private Button sendAttempt, sendButton1, sendButton2, sendButton3, sendButton4,
            sendButton5, sendButton6, sendButton7, sendButton8;
    
    @FXML 
    private Circle ball11, ball12, ball13, ball14, ball21, ball22, ball23, ball24, ball31, ball32,
            ball33, ball34, ball41, ball42, ball43, ball44, ball51, ball52, ball53, ball54, ball61, 
            ball62, ball63, ball64, ball71, ball72, ball73, ball74, ball81, ball82, ball83, ball84;
    
    @FXML
    private AnchorPane attempt1, attempt2, attempt3, attempt4, attempt5, attempt6, attempt7, attempt8, passwordPane;

    @FXML
    private TextField namePlayer2;
    
    @FXML
    public void attempt() throws IOException, SQLException{
        if(!correctPassword){
            switch(attempt){
                case 1:
                    label1.setText("First attempt");
                    //DoisJogadoresController senhaJogador1 = new TwoPlayersController();
                    //label1.setText(senhaJogador1.getSenha().toString());
                    habilitaPanel(attempt1);
                    sendButton1.setDisable(false);
                    attempt++;
                break;
                case 2:
                    toCompare(ball11, ball12, ball13, ball14);
                    label1.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    label2.setText("Second attempt");
                    //label2.setText(Double.toString(time(fim, inicio)));
                    habilitaPanel(attempt2);
                    sendButton2.setDisable(false);
                    sendButton1.setDisable(true);
                    attempt++;
                break;
                case 3:
                    toCompare(ball21, ball22, ball23, ball24);
                    label3.setText("Third attempt");
                    label2.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    habilitaPanel(attempt3);
                    sendButton3.setDisable(false);
                    sendButton2.setDisable(true);
                    attempt++;
                break;
                case 4:
                    toCompare(ball31, ball32, ball33, ball34);
                    label4.setText("Fourth attempt");
                    label3.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    habilitaPanel(attempt4);
                    sendButton4.setDisable(false);
                    sendButton3.setDisable(true);
                    attempt++;
                break;
                case 5:
                    toCompare(ball41, ball42, ball43, ball44);
                    label5.setText("Fifth attempt");
                    label4.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    habilitaPanel(attempt5);
                    sendButton5.setDisable(false);
                    sendButton4.setDisable(true);
                    attempt++;
                break;
                case 6:
                    toCompare(ball51, ball52, ball53, ball54);
                    label6.setText("Sixth attempt");
                    label5.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    habilitaPanel(attempt6);
                    sendButton6.setDisable(false);
                    sendButton5.setDisable(true);
                    attempt++;
                break;
                case 7:
                    toCompare(ball61, ball62, ball63, ball64);
                    label7.setText("Seventh attempt");
                    label6.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    habilitaPanel(attempt7);
                    sendButton7.setDisable(false);
                    sendButton6.setDisable(true);
                    attempt++;
                break;
                case 8:
                    toCompare(ball71, ball72, ball73, ball74);
                    label8.setText("Last try");
                    label7.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    habilitaPanel(attempt8);
                    sendButton8.setDisable(false);
                    sendButton7.setDisable(true);
                    attempt++;
                break;
                case 9:
                    toCompare(ball81, ball82, ball83, ball84);
                    label8.setText(colorContains+" corret color and "+colorPosition +" in the position.");
                    attempt++;
                break;
                case 10:
                    habilitaPanel(attempt1);
                    sendButton1.setDisable(false);
                    TwoPlayersController senhaFinal = new TwoPlayersController();
                    passwordField.setText("You lost!");
                    label1.setText("The correct password it was");
                    ball11.setFill(senhaFinal.getSenha().get(0));
                    ball12.setFill(senhaFinal.getSenha().get(1));
                    ball13.setFill(senhaFinal.getSenha().get(2));
                    ball14.setFill(senhaFinal.getSenha().get(3));
                    attempt++;
                break;
                case 11:
                    Platform.exit();
                break;
                default:
                    attempt1.setDisable(true);
                    attempt2.setDisable(true);
                    attempt3.setDisable(true);
                    attempt4.setDisable(true);
                    attempt5.setDisable(true);
                    attempt6.setDisable(true);
                    attempt7.setDisable(true);
                    attempt8.setDisable(true);
                break;
            }

        }else{
            
            ThePassword.changeScreen(3);
           //Platform.exit();
        }
    }
    
    
    @FXML
    public void habilitaPanel (AnchorPane p){
        attempt1.setDisable(true);
        attempt2.setDisable(true);
        attempt3.setDisable(true);
        attempt4.setDisable(true);
        attempt5.setDisable(true);
        attempt6.setDisable(true);
        attempt7.setDisable(true);
        attempt8.setDisable(true);
        sendButton1.setDisable(true);
        sendButton2.setDisable(true);
        sendButton3.setDisable(true);
        sendButton4.setDisable(true);
        sendButton5.setDisable(true);
        sendButton6.setDisable(true);
        sendButton7.setDisable(true);
        sendButton8.setDisable(true);
        p.setDisable(false);
        
    }

    @FXML
    public void clickBall(Event t) {
        if(color>=colors.length){
            color=0;
        }
        Circle b = (Circle) t.getSource();
        //b.setFill(corRand());
        b.setFill(colors[color]);
        color++;
    }
    
    public Color corRand(){
        int a = (int) (Math.random() * 6);
        Color color1 = colors[a];
        return color1;
    }

    @FXML
    public void sendAttempt(ActionEvent e) throws IOException, SQLException{
        attempt();
    }
    @FXML
    public void toCompare(Circle b1, Circle b2, Circle b3, Circle b4) throws SQLException{
        colorContains = 0;
        colorPosition  = 0;
        TwoPlayersController passwordPlayer1 = new TwoPlayersController();
        ArrayList<Color> toCompare = new ArrayList();
        HashSet<Color> contains = new HashSet();
        toCompare.add((Color) b1.getFill());
        toCompare.add((Color) b2.getFill());
        toCompare.add((Color) b3.getFill());
        toCompare.add((Color) b4.getFill());

        if(passwordPlayer1.getSenha().equals(toCompare)){
           colorContains = 4;
           colorPosition  = 4;
           passwordField.setText("You hit, press ok to continue.");
           correctPassword = true;
           end = System.currentTimeMillis();
           Player a = Player.getInstance();
           a.setName(namePlayer2.getText());
           a.setRecord(attempt-1);
           time = time();
           a.setTime(time);
           PlayerPersistence j2 = new PlayerPersistence();
           j2.registerRecord(a);
           
        }else{
            for (int i = 0; i < passwordPlayer1.getSenha().size(); i++) {
                if(passwordPlayer1.getSenha().get(i)==toCompare.get(i)){
                    contains.add(toCompare.get(i));
                    colorPosition  ++;
                }else if(passwordPlayer1.getSenha().contains(toCompare.get(i))){
                    contains.add(toCompare.get(i));
                }
            }
            colorContains = contains.size();
        }        

    }
    
    @FXML
    public void start(Event e) throws IOException, SQLException{
        if(e.getSource()==passwordField && !namePlayer2.getText().isEmpty() && attempt == 0){
            start = System.currentTimeMillis();
            attempt++;
            attempt();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            attempt();
        } catch (IOException ex) {
            Logger.getLogger(ThePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public static double time(){
        double millis = end - start;
        return millis/1000;
    }

    public static int getAttempt() {
        return attempt;
    }

    public static double getTime() {
        return time;
    }
    
    
    
}
