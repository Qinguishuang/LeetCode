package concurrent.PrintABC;

import java8.thread.ThreadDemo;

import java.util.concurrent.locks.LockSupport;

/**
 * 静态方法unpark()和park()可以分别实现阻塞当前线程和唤醒指定线程的效果
 */
public class LockSupportTest {
    private static Thread t1, t2, t3;
    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "A");

        t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(t3);
            }
        }, "B");

        t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
                LockSupport.unpark(t1);
            }
        }, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}
