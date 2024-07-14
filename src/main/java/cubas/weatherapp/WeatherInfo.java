package cubas.weatherapp;

public class WeatherInfo {

    private Current current;
    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    class Current {
        private float temp_f;
        private int cloud;
        private float wind_mph;
        private float pressure_mb;

        public float getTemp_f() {
            return temp_f;
        }

        public void setTemp_f(float temp_f) {
            this.temp_f = temp_f;
        }

        public int getCloud() {
            return cloud;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        public float getWind_mph() {
            return wind_mph;
        }

        public void setWind_mph(float wind_mph) {
            this.wind_mph = wind_mph;
        }

        public float getPressure_mb() {
            return pressure_mb;
        }

        public void setPressure_mb(float pressure_mb) {
            this.pressure_mb = pressure_mb;
        }
    }
}
