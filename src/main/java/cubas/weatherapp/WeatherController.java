package cubas.weatherapp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.google.gson.*;
import javafx.util.Duration;
import org.apache.commons.math3.util.Precision;

import static cubas.weatherapp.WeatherApplication.API_KEY;
import static cubas.weatherapp.WeatherApplication.BASE_URL;


public class WeatherController implements Initializable {

    private String city;

    private int minutesElapsed;

    private double tempF;

    private int cloudCover;

    private double windMph;

    private double pressureMb;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityField;

    @FXML
    private Label tempFLabel;

    @FXML
    private Label cloudCoverLabel;

    @FXML
    private Label windSpeedLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private LineChart tempChart;

    @FXML
    private LineChart cloudChart;

    @FXML
    private LineChart windChart;

    @FXML
    private LineChart pressureChart;


    private XYChart.Series<Integer, Number> tempSeries = new XYChart.Series<>();
    private XYChart.Series<Integer, Number> cloudSeries = new XYChart.Series<>();
    private XYChart.Series<Integer, Number> windSeries = new XYChart.Series<>();
    private XYChart.Series<Integer, Number> pressureSeries = new XYChart.Series<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void onSetButtonPressed(){
        city = cityField.getText();
        cityLabel.setText("City: "  + city);
        getData();
        Timeline timeline = new Timeline(new KeyFrame(Duration.minutes(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getData();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        timeline.play(); // Start the timeline


    }

    public void getData(){
        weatherConnection(city);
        addData(tempChart,tempSeries,minutesElapsed,tempF);
        addData(cloudChart,cloudSeries,minutesElapsed,cloudCover);
        addData(windChart,windSeries,minutesElapsed,windMph);
        addData(pressureChart,pressureSeries,minutesElapsed,pressureMb);
        minutesElapsed += 1;
    }

    public void addData(LineChart chart,XYChart.Series series,Integer minute,Number value) {

        series.getData().add( new XYChart.Data<>(minute,value));
        if (minute == 0) {
            chart.getData().add(series);
        }

    }

    public void weatherConnection(String targetCity){
        try {
            URL url1 = new URL(BASE_URL + "/current.json?key=" + API_KEY + "&q=" + targetCity);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String weatherResponse = response.toString();
                Gson gson = new Gson();
                WeatherInfo weatherInfo;
                weatherInfo = gson.fromJson(weatherResponse, WeatherInfo.class);
                tempF = weatherInfo.getCurrent().getTemp_f();
                cloudCover = weatherInfo.getCurrent().getCloud();
                windMph = weatherInfo.getCurrent().getWind_mph();
                pressureMb = weatherInfo.getCurrent().getPressure_mb();
                tempFLabel.setText(String.valueOf(Precision.round(tempF,1)));
                cloudCoverLabel.setText(String.valueOf(Precision.round(cloudCover,1)));
                windSpeedLabel.setText(String.valueOf(Precision.round(windMph,1)));
                pressureLabel.setText(String.valueOf(Precision.round(pressureMb,1)));



            } else {
                System.out.println("API Call Failed. Response Code: " + responseCode);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}