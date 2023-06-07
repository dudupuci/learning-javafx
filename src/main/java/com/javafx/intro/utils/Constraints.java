package com.javafx.intro.utils;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Constraints {

    public static void setTextFieldInteger(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                textField.setText(oldValue);
            }
        });
    }

    public static void setTextFieldMaxLength(TextField textField, Integer maxLength) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > maxLength) {
                textField.setText(oldValue);
            }
        });
    }

    public static void setTextFieldDouble(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
                textField.setText(oldValue);
            }
        });
    }
}
