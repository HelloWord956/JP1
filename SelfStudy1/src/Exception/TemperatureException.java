package Exception;

public abstract class TemperatureException extends Exception {
    private int temperature; // in Celsius
    public TemperatureException(int temperature) {
        this.temperature = temperature;
    }
    public int getTemperature() {
        return temperature;
    }
}
