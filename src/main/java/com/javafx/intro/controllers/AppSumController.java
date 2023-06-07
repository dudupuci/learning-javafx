package com.javafx.intro.controllers;

import com.javafx.intro.utils.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class AppSumController {

    @FXML
    private TextField textFieldFirstNumber;
    @FXML
    private TextField textFieldSecondNumber;
    @FXML
    private Button calculateButton;
    @FXML
    private Label resultLabel;

    @FXML
    protected void onCalculateButtonAction() {
        Locale.setDefault(Locale.US);
        try {
            var sum = Double.valueOf(this.textFieldFirstNumber.getText())
                    + Double.valueOf(this.textFieldSecondNumber.getText());

            resultLabel.setText("O Resultado do cálculo é igual a " + String.format("%.2f", sum));
        } catch (NumberFormatException err) {
            Alerts.showAlert(
                    NumberFormatException.class.getName(),
                    null,
                    "number_format_exception" + err.getMessage(),
                    Alert.AlertType.ERROR
            );
        }
        afterCalculate();
    }

    private void afterCalculate() {
        this.textFieldFirstNumber.setText("");
        this.textFieldSecondNumber.setText("");
    }


}
