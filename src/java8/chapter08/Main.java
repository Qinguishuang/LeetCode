package java8.chapter08;

public class Main {
    public static void main(String[] args) {
        // 从匿名类到lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable r2 = () -> System.out.println("hello world");

        int a = 10;

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                int a = 2; // 匿名类可以屏蔽外部变量
                System.out.println(a);
            }
        };

        Runnable r4 = () -> {
            // int a = 2; lambda 不能屏蔽类变量
            System.out.println(a);
        };

        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("so something");
            }
        });

        // 两个匹配, 显示调用
        doSomething((Task) () -> {
            System.out.println("task do something");
        });

    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }
}


interface Task {
    public void execute();
}