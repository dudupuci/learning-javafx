package com.javafx.intro.controllers;

import com.javafx.intro.utils.Alerts;
import com.javafx.intro.utils.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AppSumController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.setTextFieldDouble(this.textFieldFirstNumber);
        Constraints.setTextFieldDouble(this.textFieldSecondNumber);
    }
}
