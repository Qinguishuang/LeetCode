package CS_Note.first.designmode.singleton;


/**
 * 某个类只能存在一个对象示例, 提供一个获取对象的方法(静态)
 * <p>
 * 饿汉式(静态代码)
 * 内存浪费, 可用
 * <p>
 * 构造方法私有化
 * 类的内部创建对象
 * 向外提供静态公共方法
 */
public class Test2 {

    public static void main(String[] args) {
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}

class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}