package concurrent.PrintABC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private static int num = 1;

    private static Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        long loop = countDownLatch.getCount();

        new Thread(() -> {
            for (int i = 0; i < loop; i++) {
                try {
                    lock.lock();
                    if (num != 1) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    num = 2;
                    conditionB.signal();
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < loop; i++) {
                try {
                    lock.lock();
                    if (num != 2) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    num = 3;
                    conditionC.signal();
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < loop; i++) {
                try {
                    lock.lock();
                    if (num != 3) {
                        conditionC.await();
                    }
                    System.out.println(Thread.currentThread().getName());
                    num = 1;
                    conditionA.signal();
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }


}
