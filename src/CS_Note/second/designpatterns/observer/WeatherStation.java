// package CS_Note.second.designpatterns.observer;
//
// import java.util.Observable;
// import java.util.Observer;
//
// class WeatherData extends Observable {
//     // ArrayList<Observer> list;  // 父类保存观察者
//     private float temperature;
//     private float humidity;
//     private float pressure;
//
//     public WeatherData() {
//         // 不需要创建容器保存观察者
//     }
//
//     public void measurementsChanged() {
//         setChanged(); // 指示状态已改变
//         notifyObservers();
//     }
//
//     public void setWeatherData(float temperature, float humidity, float pressure) {
//         this.temperature = temperature;
//         this.humidity = humidity;
//         this.pressure = pressure;
//         measurementsChanged();
//     }
//
//     public float getTemperature() {
//         return temperature;
//     }
//
//     public float getHumidity() {
//         return humidity;
//     }
//
//     public float getPressure() {
//         return pressure;
//     }
// }
//
// interface DisplayElement {
//     public void display(); // 布告板上显示
// }
//
// class CurrentConditionDisplay implements Observer, DisplayElement {
//     Observable observable;
//     private float temperature;
//     private float humidity;
//
//     public CurrentConditionDisplay(Observable observable) {
//         this.observable = observable;
//         observable.addObserver(this);
//     }
//
//     @Override
//     public void display() {
//         System.out.println("CurrentConditionDisplay{" +
//                 "observable=" + observable +
//                 ", temperature=" + temperature +
//                 ", humidity=" + humidity +
//                 '}');
//     }
//
//     @Override
//     public void update(Observable o, Object arg) {
//
//     }
// }
//
// public class WeatherStation {
// }
