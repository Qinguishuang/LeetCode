package java8.thread;


public class TestThread {
    public static void main(String[] args) {
        // RunnableDemo r1 = new RunnableDemo("thread_1");
        // r1.start();
        // RunnableDemo r2 = new RunnableDemo("thread_2");
        // r2.start();

        ThreadDemo t1 = new ThreadDemo("thread_1");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("thread_2");
        t2.start();

    }
}