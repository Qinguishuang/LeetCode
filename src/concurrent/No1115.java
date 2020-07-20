package concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class No1115 {

}

class FooBar1 {
    private int n;
    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}

class FooBar2 {
    private int n;
    Lock lock = new ReentrantLock(true); // 公平锁
    volatile boolean permit = true;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (permit) { // 只能里面执行 i++, 当false时，unlock不能+1
                    printFoo.run();
                    i++;
                    permit = false;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if (!permit) {
                    printBar.run();
                    i++;
                    permit = true;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}


class FooBar3 {
    private int n;

    private Lock lock = new ReentrantLock(); // 非公平锁使用Condition
    private Condition foo = lock.newCondition();
    private Condition bar = lock.newCondition();
    private boolean fooRun = true;

    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                if (!fooRun) {
                    foo.await();
                    bar.signal();
                }
                printFoo.run();
                fooRun = false;
                bar.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                if (fooRun) {
                    bar.await();
                    foo.signal();
                }
                printBar.run();
                fooRun = true;
                foo.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}

class FooBar4 {
    private int n;
    private final Object lock = new java.lang.Object();
    private boolean fooRun = true;

    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!fooRun) {
                    lock.wait();
                }
                fooRun = false;
                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (fooRun) {
                    lock.wait();
                }
                fooRun = true;
                printBar.run();
                lock.notifyAll();
            }
        }
    }
}