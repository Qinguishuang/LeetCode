package CS_Note.first.designmode.observer.example2;

/**
 * 抽象被观察者
 */
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}
