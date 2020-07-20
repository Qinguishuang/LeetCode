package CS_Note.first.designmode.observer.example1;

/**
 * 观察者
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        System.out.println("收到推送 " + name);
    }

}
