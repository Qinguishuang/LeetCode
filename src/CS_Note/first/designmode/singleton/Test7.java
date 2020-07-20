package CS_Note.first.designmode.singleton;

/**
 * 静态内部类
 * 懒加载
 */
public class Test7 {
    public static void main(String[] args) {
        Singleton7 singleton1 = Singleton7.getInstance();
        Singleton7 singleton2 = Singleton7.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }

}

class Singleton7 {
    private Singleton7() {
    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
