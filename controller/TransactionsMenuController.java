package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TransactionsMenuController {
    @FXML
    private void newTransaction() throws Exception {
        openWindow("/view/NewTransactionView.fxml", "New Transaction");
    }

    @FXML
    private void removeTransaction() throws Exception {
        openWindow("/view/RemoveTransactionView.fxml", "Remove Transaction");
    }


    private void openWindow(String fxmlPath, String title) throws Exception {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.show();
    }


}
