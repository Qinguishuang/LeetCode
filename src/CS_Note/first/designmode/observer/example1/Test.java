package CS_Note.first.designmode.observer.example1;


/**
 * 定义了对象之间一对多的依赖, 一个对象状态改变是, 他的所有依赖都会收到通知并自动更新状态
 * 包含四个角色
 * 1. 抽象被观察者角色 (subject)
 * 2. 抽象观察者角色 (observer)
 * 3. 具体被观察者角色 (concrete subject)
 * 4. 具体观察者角色 (concrete subject)
 */
public class Test {

    public static void main(String[] args) {
        WeChatServer server = new WeChatServer();

        Observer qin = new User("qin");
        Observer gui = new User("gui");
        Observer shu = new User("user");

        server.registerObserver(qin);
        server.registerObserver(gui);
        server.registerObserver(shu);

        server.setInformation("java是最好用的语言");
        server.removeObserver(gui);
        server.setInformation("说错了");

    }


}
