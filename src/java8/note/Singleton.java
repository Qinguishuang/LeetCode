package java8.note;

public class Singleton {
    private Singleton instance;

    private Singleton() {

    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}

class SynchronizedDemo {
    public synchronized void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}