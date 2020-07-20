package CS_Note.first.designmode.observer.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class WeChatServer implements Observerable {

    private List<Observer> list;
    private String message;

    public WeChatServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < list.size(); i++) {
            Observer server = list.get(i);
            server.update(message);
        }
    }

    public void setInformation(String s) {
        this.message = s;
        System.out.println("微信号更新" + s);
        notifyObserver();
    }
}
