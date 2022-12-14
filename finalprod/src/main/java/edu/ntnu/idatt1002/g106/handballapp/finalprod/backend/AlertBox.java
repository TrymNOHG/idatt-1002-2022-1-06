package edu.ntnu.idatt1002.g106.handballapp.finalprod.backend;

import edu.ntnu.idatt1002.g106.handballapp.finalprod.controller.HandballApplication;
import edu.ntnu.idatt1002.g106.handballapp.finalprod.fileHandling.HandBallAppFileHandling;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * this class is used as a message class
 * its purpose is to give the user different popup windows that alert the user about different events
 * @author Gruppe 6
 */
public class AlertBox {

    /**
     * method used when logOut button pressed
     * @return an alertbox with some information
     */
    public static int logOut() {
        AtomicInteger answer = new AtomicInteger();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("LogOut");
        window.setMinWidth(500);
        window.setMinHeight(250);
        Label label = new Label();
        label.setText("Do you want to log out");

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setAccessibleHelp("Press here to log out");
        yesButton.setAccessibleText("yes, logOut");
        noButton.setAccessibleHelp("Press here to go back to application");
        noButton.setAccessibleText("no, go back");


        yesButton.setOnAction(e -> {
            answer.set(1);

            try {
                HandBallAppFileHandling.serializeTournamentRegister(HandballApplication.adminList.get(0).getTournamentRegister(),new File(HandballApplication.file));
            } catch (IOException ex) {
                alertError("Could not save data to file");
            }
            window.close();
        });
        noButton.setOnAction(e -> {
            answer.set(-1);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return answer.get();
    }

    /**
     * The method provides a general error alert box which can be specified with the display message
     * @param message the display message to the alert box
     */
    public static void alertError(String message) {
        Alert dateAlert = new Alert(Alert.AlertType.ERROR);
        dateAlert.setTitle("Error");
        dateAlert.setContentText(message);
        dateAlert.showAndWait();
    }

    /**
     * This method provides the user with helpful information during submission or creation
     * @param message popup message
     */
    public static void confirmBox(String message){
        Alert dateAlert = new Alert(Alert.AlertType.CONFIRMATION);
        dateAlert.setTitle("Confirmation");
        dateAlert.setContentText(message);
        dateAlert.showAndWait();
    }

    //TODO: More methods to come
}

