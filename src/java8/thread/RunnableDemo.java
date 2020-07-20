package java8.thread;

class RunnableDemo implements Runnable {

    private Thread t;
    private String theadName;

    public RunnableDemo(String theadName) {
        this.theadName = theadName;
        System.out.println("create thread " + theadName);
    }

    @Override
    public void run() {
        System.out.println("running thread " + theadName);

        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("thread " + theadName + " " + i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread " + theadName + " exit");
    }

    public void start() {
        System.out.println("start thread " + theadName);
        if (t == null) {
            t = new Thread(this, theadName);
            t.start();
        }
    }

}
