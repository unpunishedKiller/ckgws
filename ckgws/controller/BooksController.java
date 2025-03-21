package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BooksController {
    @FXML
    private TableView<Transaction> transactionTable;
    @FXML
    private TableColumn<Transaction, Integer> shopIdColumn;
    @FXML
    private TableColumn<Transaction, String> dateColumn;
    @FXML
    private TableColumn<Transaction, Double> weightInColumn;
    @FXML
    private TableColumn<Transaction, Double> weightOutColumn;

    private ObservableList<Transaction> transactionList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind table columns to Transaction model properties
        shopIdColumn.setCellValueFactory(new PropertyValueFactory<>("shopId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        weightInColumn.setCellValueFactory(new PropertyValueFactory<>("weightIn"));
        weightOutColumn.setCellValueFactory(new PropertyValueFactory<>("weightOut"));
    }

    @FXML
    private void loadTransactions() {
        transactionList.clear(); // Clear existing data
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ckgws", "root", "24102362");
             Statement stmt = conn.createStatement()) {

            String query = "SELECT shopid, date, weight_in, weight_out FROM transactions";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                transactionList.add(new Transaction(
                        rs.getInt("shopid"),
                        rs.getDate("date").toString(),
                        rs.getDouble("weight_in"),
                        rs.getDouble("weight_out")
                ));
            }

            transactionTable.setItems(transactionList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

