package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ShopController {
    @FXML
    private TextField shopNameField;

    @FXML
    private TextField shopLocationField;

    @FXML
    private TextField shopIdField; // For update/delete

    // Add a new shop
    @FXML
    private void addShop() {
        String shopName = shopNameField.getText();
        String shopLocation = shopLocationField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ckgws", "root", "24102362")) {
            String sql = "INSERT INTO shops (name, location) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, shopName);
                pstmt.setString(2, shopLocation);
                pstmt.executeUpdate();
                System.out.println("Shop added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update an existing shop
    @FXML
    private void updateShop() {
        String shopId = shopIdField.getText();
        String shopName = shopNameField.getText();
        String shopLocation = shopLocationField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ckgws", "root", "24102362")) {
            String sql = "UPDATE shops SET name = ?, location = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, shopName);
                pstmt.setString(2, shopLocation);
                pstmt.setInt(3, Integer.parseInt(shopId));
                pstmt.executeUpdate();
                System.out.println("Shop updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete a shop
    @FXML
    private void deleteShop() {
        String shopId = shopIdField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ckgws", "root", "24102362")) {
            String sql = "DELETE FROM shops WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(shopId));
                pstmt.executeUpdate();
                System.out.println("Shop deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        if (!ShopsMenuController.sceneHistory.isEmpty()) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(ShopsMenuController.sceneHistory.pop()); // Restore previous scene
            stage.show();
        }
    }





}


