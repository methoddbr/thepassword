/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * FXML Controller class
 *
 * @author Leonardo Prestes
 */
public class VictoryController implements Initializable {

    private HostServices services;
    @FXML
    private Label printAttempt, printTime;
    @FXML
    private AnchorPane victoryPane;
    @FXML
    private TextField fieldTwitter;

    private Twitter tt;
    private RequestToken rt;
    private String url;
    private String tweet;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConfigurationBuilder b = new ConfigurationBuilder();
        b.setDebugEnabled(true)
            .setOAuthConsumerKey("P7r9olDeswZ2dmhY66AdyrJhN")
            .setOAuthConsumerSecret("1idaG9riYaQYZPDqgBY729ZGWbffXHq7CNhgPAax61Zqpkt4pZ")
            .setOAuthAccessToken(null)
            .setOAuthAccessTokenSecret(null);
        Configuration conf = b.build();
        TwitterFactory tf = new TwitterFactory(conf);
        tt = tf.getInstance();
        try {
            rt = tt.getOAuthRequestToken();
        } catch (TwitterException ex) {
            Logger.getLogger(VictoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void printAttempt(Event e) {
        if (e.getSource() == victoryPane) {
            int tent = ThePasswordController.getAttempt() - 2;
            double tempo = ThePasswordController.getTime();
            String tempoString = Double.toString(tempo);
            String text = Integer.toString(tent);

            printAttempt.setText(text + " attempt, in ");
            printTime.setText(tempoString + " seconds.");
            printAttempt.setAlignment(Pos.CENTER);
            printTime.setAlignment(Pos.CENTER);

            tweet = "I guessed the password in the "+text +" attempt, in "+ tempoString +" seconds. "
                    + "Developed by Leonardo Prestes in 2017.";
        }
    }

    public HostServices getServices() {
        return services;
    }

    public void setServices(HostServices services) {
        this.services = services;
    }

    public void toShare(ActionEvent e) {
        String p = this.fieldTwitter.getText();
        try {
            tt.getOAuthAccessToken(this.rt, p);
            Thread.currentThread().sleep(2000);
            tt.updateStatus(tweet);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Done");
            alert.setHeaderText("Posted");
            alert.setContentText("Shared in Twitter successfully!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("OK");
                }
            });
            Platform.exit();
        } catch (TwitterException te) {
            te.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(VictoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void login(ActionEvent e) {
        services.showDocument(rt.getAuthenticationURL());
    }
}
