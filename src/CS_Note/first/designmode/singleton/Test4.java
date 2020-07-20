package CS_Note.first.designmode.singleton;

/**
 * 懒汉式(线程安全)
 * 效率低
 */
public class Test4 {
    public static void main(String[] args) {
        Singleton4 singleton1 = Singleton4.getInstance();
        Singleton4 singleton2 = Singleton4.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    // 使用到时, 才创建
    // 进程同步
    public static synchronized Singleton4 getInstance() { // 不能让多个线程进入if
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
