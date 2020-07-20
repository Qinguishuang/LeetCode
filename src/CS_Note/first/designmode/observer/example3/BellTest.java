package CS_Note.first.designmode.observer.example3;

import java.util.ArrayList;
import java.util.List;

public class BellTest {
    public static void main(String[] args) {
        Bells b = new Bells();
        StudentBellEventListener student = new StudentBellEventListener();
        TeacherBellEventListener teacher = new TeacherBellEventListener();
        b.registerObserver(student);
        b.registerObserver(teacher);
        b.notifyObserver("上课了");
        b.notifyObserver("下课了");
    }

}

// 抽象被观察者
interface Bell {
    void registerObserver(BellEventListeners o);
    void removeObserver(BellEventListeners o);
    void notifyObserver(String message);
}

class Bells implements Bell {
    List<BellEventListeners> list = new ArrayList<>();

    @Override
    public void registerObserver(BellEventListeners o) {
        list.add(o);
    }

    @Override
    public void removeObserver(BellEventListeners o) {
        int index = list.indexOf(o);
        if (index >= 0)
            list.remove(o);
    }

    @Override
    public void notifyObserver(String message) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).hearBell(message);
        }
    }
}

// 抽象观察者
interface BellEventListeners {
    void hearBell(String message);
}

// 观察者
class StudentBellEventListener implements BellEventListeners {

    @Override
    public void hearBell(String message) {
        System.out.println("学生听到铃声 " + message);
    }
}

class TeacherBellEventListener implements BellEventListeners {

    @Override
    public void hearBell(String message) {
        System.out.println("老师听到铃声 " + message);
    }
}

