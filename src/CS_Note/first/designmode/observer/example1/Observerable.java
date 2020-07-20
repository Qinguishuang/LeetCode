package CS_Note.first.designmode.observer.example1;

/**
 * 抽象被观察者
 */
public interface Observerable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
