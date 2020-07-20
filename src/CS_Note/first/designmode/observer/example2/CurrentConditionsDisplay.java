package CS_Note.first.designmode.observer.example2;

public class CurrentConditionsDisplay implements Observer {

    public CurrentConditionsDisplay() {

    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        System.out.println("天气数据展示" + temperature + humidity + pressure);
    }
}
