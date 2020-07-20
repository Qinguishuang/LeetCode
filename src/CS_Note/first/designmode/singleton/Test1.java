package CS_Note.first.designmode.singleton;

/**
 * 某个类只能存在一个对象示例, 提供一个获取对象的方法(静态)
 * 1. 对于要重复创建销毁的对象, 提高性能
 * 2. 创建类消耗资源过多, 耗时过多
 * <p>
 * 饿汉式(静态变量)
 * 内存浪费, 可用
 * <p>
 * 构造方法私有化
 * 类的内部创建对象
 * 向外提供静态公共方法
 */
public class Test1 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


class Singleton {

    // 构造方法私有化
    private Singleton() {
    }

    // 创建对象示例
    private final static Singleton instance = new Singleton();

    // 提供静态公共方法
    public static Singleton getInstance() {
        return instance;
    }
}
