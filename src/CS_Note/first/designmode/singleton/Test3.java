package CS_Note.first.designmode.singleton;

/**
 * 懒汉式(线程不安全)
 */
public class Test3 {
    public static void main(String[] args) {
        Singleton3 singleton1 = Singleton3.getInstance();
        Singleton3 singleton2 = Singleton3.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    // 使用到时, 才创建
    public static Singleton3 getInstance() {
        if (instance == null) { // 此处线程不安全, 可能会多例, 不能让多个线程进入if
            instance = new Singleton3();
        }
        return instance;
    }
}
