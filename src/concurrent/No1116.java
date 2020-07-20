package concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class No1116 {
    public static void main(String[] args) {
        ZeroEvenOdd z = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                z.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                z.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                z.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // new Thread().start();
    }
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1); // 打印0
    private Semaphore even = new Semaphore(0); // 打印偶数
    private Semaphore odd = new Semaphore(0); // 打印奇数

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0)
                odd.release();
            else
                even.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
