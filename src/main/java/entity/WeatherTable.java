package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "weather_table", schema = "weather")
public class WeatherTable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "weatherID")
    private int weatherId;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @Basic
    @Column(name = "temp_f")
    private BigDecimal tempF;
    @Basic
    @Column(name = "cloud_cover")
    private Integer cloudCover;
    @Basic
    @Column(name = "wind_mph")
    private BigDecimal windMph;
    @Basic
    @Column(name = "pressure_mb")
    private BigDecimal pressureMb;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public BigDecimal getTempF() {
        return tempF;
    }

    public void setTempF(BigDecimal tempF) {
        this.tempF = tempF;
    }

    public Integer getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Integer cloudCover) {
        this.cloudCover = cloudCover;
    }

    public BigDecimal getWindMph() {
        return windMph;
    }

    public void setWindMph(BigDecimal windMph) {
        this.windMph = windMph;
    }

    public BigDecimal getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(BigDecimal pressureMb) {
        this.pressureMb = pressureMb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherTable that = (WeatherTable) o;
        return weatherId == that.weatherId && Objects.equals(city, that.city) && Objects.equals(time, that.time) && Objects.equals(tempF, that.tempF) && Objects.equals(cloudCover, that.cloudCover) && Objects.equals(windMph, that.windMph) && Objects.equals(pressureMb, that.pressureMb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherId, city, time, tempF, cloudCover, windMph, pressureMb);
    }
}
