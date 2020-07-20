package java8.thread;

public class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("create " + threadName);
    }

    @Override
    public void run() {
        System.out.println("run " + threadName);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("thread " + threadName + " " + i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("thread " + threadName + " interrupted");
        }
        System.out.println("thread " + threadName + " exit");
    }

    public void start() {
        System.out.println("start " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
