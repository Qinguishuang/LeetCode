package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class No1114 {

}

/**
 * ReentrantLock，Condition实现
 */
class Foo {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    int state = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        if (state != 1)
            conditionA.await();
        state = 2;
        printFirst.run();
        conditionB.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        if (state != 2)
            conditionB.await();
        state = 3;
        printSecond.run();
        conditionC.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        if (state != 3)
            conditionC.await();
        state = 1;
        printThird.run();
        conditionA.signal();
        lock.unlock();
    }
}

/**
 * CountDownLatch实现
 */
class Foo2 {

    CountDownLatch latch1 = new CountDownLatch(1);
    CountDownLatch latch2 = new CountDownLatch(1);

    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch1.await();
        printSecond.run();
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch2.await();
        printThird.run();
    }
}

/**
 * Semaphore实现
 */
class Foo3 {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);


    public Foo3() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        s1.acquire();
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
    }
}

/**
 * volatile实现
 */
class Foo4 {

    volatile int i = 1;

    public Foo4() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        i = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i != 2) ;
        printSecond.run();
        i = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i != 3) ;
        printThird.run();
    }
}

/**
 * synchronized实现
 */
class Foo5 {
    private int flag = 1;
    private final Object object = new Object();

    public Foo5() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) {
                object.wait();
            }
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) {
                object.wait();
            }
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            object.wait();
            printThird.run();
            flag = 1;
            object.notifyAll();
        }
    }
}