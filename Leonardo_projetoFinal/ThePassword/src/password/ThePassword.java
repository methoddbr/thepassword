/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo Prestes
 */
public class ThePassword extends Application {

    private static Stage stage;

    private static Scene passwordPane;
    private static Scene twoPlayers;
    private static Scene initial;
    private static Scene victory;
    private static Scene record;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        Parent fxmlini = FXMLLoader.load(getClass().getResource("Initial.fxml"));
        initial = new Scene(fxmlini);

        Parent fxmlsenhaPane = FXMLLoader.load(getClass().getResource("ThePassword.fxml"));
        passwordPane = new Scene(fxmlsenhaPane);

        Parent fxmldoisJogadores = FXMLLoader.load(getClass().getResource("TwoPlayers.fxml"));
        twoPlayers = new Scene(fxmldoisJogadores);

        Parent fxmlrecordes = FXMLLoader.load(getClass().getResource("Record.fxml"));
        record = new Scene(fxmlrecordes);

        Parent fxmlvitoria = this.loadTwitterScreen(getHostServices());
        victory = new Scene(fxmlvitoria);

        primaryStage.setTitle("The Password");
        primaryStage.setScene(initial);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }

    public Parent loadTwitterScreen(HostServices host) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Victory.fxml"));
        Parent victory = null;
        try {
            victory = (Parent) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ThePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        VictoryController controller = (VictoryController) loader.getController();
        controller.setServices(host);
        return victory;
    }

    public static void changeScreen(int op) throws IOException {
        switch (op) {
            case 1:
                stage.setScene(twoPlayers);
                break;
            case 2:
                stage.setScene(passwordPane);
                stage.centerOnScreen();
                break;
            case 3:
                stage.setScene(victory);
                break;
            case 4:
                stage.setScene(record);
                break;
            case 5:
                stage.setScene(initial);
                break;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
