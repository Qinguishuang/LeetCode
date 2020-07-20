package CS_Note.first.designmode.singleton;

/**
 * 枚举
 * 懒加载
 */
public class Test6 {
    public static void main(String[] args) {
        Singleton6 singleton1 = Singleton6.INSTANCE;
        Singleton6 singleton2 = Singleton6.INSTANCE;
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}

enum Singleton6 {
    INSTANCE;
    public  void isSame() {
        System.out.println("same");
    }
}



