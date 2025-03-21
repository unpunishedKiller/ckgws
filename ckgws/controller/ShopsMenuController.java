package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Stack;

public class ShopsMenuController {

    static final Stack<Scene> sceneHistory = new Stack<>(); // Store previous scenes

    @FXML
    private void addShop(ActionEvent event) throws IOException {
        switchScene(event, "/view/ShopView.fxml");
    }

    @FXML
    private void updateShop(ActionEvent event) throws IOException {
        switchScene(event, "/view/UpdateShopView.fxml");
    }

    @FXML
    private void deleteShop(ActionEvent event) throws IOException {
        switchScene(event, "/view/DeleteShopView.fxml");
    }


    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Store the current scene before switching
        sceneHistory.push(stage.getScene());

        stage.setScene(new Scene(root));
        stage.show();
    }
}

