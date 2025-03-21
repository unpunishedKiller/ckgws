package controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class NewTransactionController {
    @FXML
    private TextField shopIdField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField weightInField;

    @FXML
    private TextField weightOutField;

    @FXML
    private void addTransaction() {
        String shopId = shopIdField.getText();
        LocalDate date = dateField.getValue();
        String weightIn = weightInField.getText();
        String weightOut = weightOutField.getText();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ckgws", "root", "24102362")) {
            String sql = "INSERT INTO transactions (shopid, date, weight_in, weight_out) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(shopId));
                pstmt.setDate(2, java.sql.Date.valueOf(date));
                pstmt.setBigDecimal(3, new java.math.BigDecimal(weightIn));
                pstmt.setBigDecimal(4, new java.math.BigDecimal(weightOut));

                pstmt.executeUpdate();
                System.out.println("Transaction added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


