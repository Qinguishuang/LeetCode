package CS_Note.first.designmode.observer.example2;

/**
 * 观察者
 */
public class StatisticsDisplay implements Observer {

    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("数据更新" + temperature + humidity + pressure);
    }
}
