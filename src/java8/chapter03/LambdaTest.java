package java8.chapter03;

public class LambdaTest {
    Runnable r1 = () -> System.out.println("hello world 1");
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println("hello world 2");
        }
    };

    public static void main(String[] args) {
       LambdaTest l = new LambdaTest();
       process(l.r1);
       process(l.r2);
       process(() -> System.out.println("hello world 3"));
    }

    public static void process(Runnable r) {
        r.run();
    }
}
