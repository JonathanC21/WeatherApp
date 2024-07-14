module cubas.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires  com.google.gson;
    requires  commons.math3;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens cubas.weatherapp to javafx.fxml,com.google.gson,commons.math3;
    opens entity to org.hibernate.orm.core;
    exports cubas.weatherapp;
}