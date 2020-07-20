package CS_Note.first.designmode.observer.example2;

public class Test {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay();

        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(2.3, 3.4, 4.5);
        weatherData.setMeasurements(111, 222, 333);

    }

}
