module cubas.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires  com.google.gson;
    requires  commons.math3;

    opens cubas.weatherapp to javafx.fxml,com.google.gson,commons.math3;
    exports cubas.weatherapp;
}