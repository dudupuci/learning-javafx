package com.javafx.intro.controllers;

import com.javafx.intro.utils.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ViewController {

    @FXML
    private Button viewButton;

    @FXML
    protected void onViewButtonAction() {
        System.out.println("ViewController.onViewButtonAction");
        Alerts.showAlert("Alert", "Header", "Button clicked", Alert.AlertType.INFORMATION);
    }

}
