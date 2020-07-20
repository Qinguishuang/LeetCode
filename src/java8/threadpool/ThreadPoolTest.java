package java8.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.shutdown();

    }
}


class TestThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep((long) (10L * Math.random()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}