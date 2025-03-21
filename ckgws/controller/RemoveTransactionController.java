package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RemoveTransactionController {
    @FXML
    private TextField transactionIdField;

    @FXML
    private void removeTransaction() {
        String transactionId = transactionIdField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ckgws", "root", "24102362")) {
            String sql = "DELETE FROM transactions WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(transactionId));

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Transaction removed successfully!");
                } else {
                    System.out.println("Transaction not found.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
