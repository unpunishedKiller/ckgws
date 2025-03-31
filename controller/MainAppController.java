package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainAppController {
    @FXML
    private BorderPane contentPane;

    // Load the Add Shop view
    @FXML
    private void loadAddShop() {
        loadView("/view/ShopView.fxml");
    }

    // Load the Update Shop view
    @FXML
    private void loadUpdateShop() {
        loadView("/view/UpdateShopView.fxml");
    }

    // Load the Delete Shop view
    @FXML
    private void loadDeleteShop() {
        loadView("/view/DeleteShopView.fxml");
    }

    // Load the New Transaction view
    @FXML
    private void loadNewTransaction() {
        loadView("/view/NewTransactionView.fxml");
    }

    // Load the View Transactions view
    @FXML
    private void loadViewTransactions() {
        loadView("/view/TransactionsTableView.fxml");
    }

    // Load the Books view
    @FXML
    private void loadBooks() {
        loadView("/view/BooksView.fxml");
    }

    // General method to load views into the content area
    private void loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            contentPane.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
