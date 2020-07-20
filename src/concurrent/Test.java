package concurrent;

import java8.thread.ThreadDemo;

class ThreadTest implements Runnable {
    int i = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    i ++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();

    }
}
