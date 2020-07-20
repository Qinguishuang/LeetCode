package java8.chapter03;

public class Test {
    public static void main(String[] args) {
        int i = 2;
        Runnable r = () -> System.out.println(i);
        r.run();
        // i = 3;
        System.out.println(i + 1);
    }

}
