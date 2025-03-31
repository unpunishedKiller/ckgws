package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class WelcomeController {

    @FXML
    private void goToShops(ActionEvent event) throws IOException {
        switchScene(event, "/view/ShopsMenuView.fxml");
    }

    @FXML
    private void goToBooks(ActionEvent event) throws IOException {
        switchScene(event, "/view/BooksView.fxml");
    }

    @FXML
    private void goToTransactions(ActionEvent event) throws IOException {
        switchScene(event, "/view/TransactionsView.fxml");
    }


    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current stage from the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
