package CS_Note.first.designmode.singleton;

/**
 * 双重检查
 * 懒汉式(线程安全)
 * 效率低
 */
public class Test5 {
    public static void main(String[] args) {
        Singleton5 singleton1 = Singleton5.getInstance();
        Singleton5 singleton2 = Singleton5.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


class Singleton5 {
    /**
     * 如果构造函数中操作比较多时，为了提升效率，JVM 会在构造函数里面的属性未全部完成实例化时，就返回对象。
     * 双重检测锁出现空指针问题的原因就是出现在这里，当某个线程获取锁进行实例化时，
     * 其他线程就直接获取实例使用，由于JVM指令重排序的原因，其他线程获取的对象也许不是一个完整的对象，
     * 所以在使用实例的时候就会出现空指针异常问题。
     */
    private static volatile Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) { // 进入第一个if后再检查一次
                if (instance == null)
                    instance = new Singleton5();
            }
        }
        return instance;
    }
}
