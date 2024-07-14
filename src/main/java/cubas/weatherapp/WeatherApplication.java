package cubas.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherApplication extends Application {

    public static final String API_KEY = "a1fc87807e1d4f51a3064003240206";
    public static final String BASE_URL = "http://api.weatherapi.com/v1";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApplication.class.getResource("weather-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setTitle("Weather App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();


    }
}