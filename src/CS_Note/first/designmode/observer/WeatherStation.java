package CS_Note.first.designmode.observer;

import java.util.ArrayList;
import java.util.Observable;

/**
 * 主题, 负责通知观察者
 */
interface Subject {
    public void registerObserver(Observer o); // 注册观察者

    public void removeObserver(Observer o); // 移除观察者

    public void notifyObservers(); // 通知所有的观察者

}

interface Observer {
    public void update(float temp, float humidity, float pressure);
}

interface DisplayElement {
    public void display(); // 布告板上显示
}

/**
 * 主题
 */
class WeatherData implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers(); // 数据被修改时通知观察者
    }

    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", weatherData=" + weatherData +
                '}');
    }
}


public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay =
                new CurrentConditionDisplay(weatherData);

        weatherData.setWeatherData(11.1f, 22.2f, 33.3f);
        weatherData.setWeatherData(44.4f, 55.5f, 66.6f);
    }
}
