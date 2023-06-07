package com.javafx.intro.controllers;

import com.javafx.intro.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.*;

public class PersonsController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    private ObservableList<Person> observableList;

    @FXML
    private Button showAllButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person(UUID.randomUUID(), "Eduardo", "eduardo@gmail.com"));
        personsList.add(new Person(UUID.randomUUID(), "Mário", "mario@gmail.com"));
        personsList.add(new Person(UUID.randomUUID(), "Jéssica", "jessica@gmail.com"));

        observableList = FXCollections.observableArrayList(personsList);

        Callback<ListView<Person>, ListCell<Person>> factory = personListView -> new ListCell<Person>() {
            protected void updateItem(final Person element, boolean empty) {
                super.updateItem(element, empty);
                setText(empty ? "" : element.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
        comboBoxPerson.setItems(observableList);
    }

    @FXML
    protected void onComboBoxSelectAction() {
        var element = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println("Selected: " + element);
    }

    @FXML
    protected void onButtonShowAllAction() {
        for (Object element : comboBoxPerson.getItems()) {
            System.out.println(element);
        }

    }

}
