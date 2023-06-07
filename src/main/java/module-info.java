module com.javafx.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.javafx.intro to javafx.fxml;
    exports com.javafx.intro;
    exports com.javafx.intro.controllers;
    opens com.javafx.intro.controllers to javafx.fxml;
}