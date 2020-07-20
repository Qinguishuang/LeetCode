package concurrent.PrintABC;

public class SynchronizdTest {
    private static boolean startA = true;
    private static boolean startB = true;
    private static boolean startC = true;

    public static void main(String[] args) {

        final Object o = new Object();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10;) {
                    if (startA) {
                        System.out.println(Thread.currentThread().getName());
                        startA = false;
                        startB = true;
                        startC = false;
                        o.notifyAll();
                        i ++;
                    } else {
                        try {
                            o.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; ) {
                    if (startB) {
                        System.out.println(Thread.currentThread().getName());
                        startA = false;
                        startB = false;
                        startC = true;
                        o.notifyAll();
                        i ++;
                    } else {
                        try {
                            o.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "B").start();

        new Thread(() ->{
            synchronized (o) {
                for (int i = 0; i < 10;) {
                    if (startC) {
                        System.out.println(Thread.currentThread().getName());
                        startA = true;
                        startB = false;
                        startC = false;
                        o.notifyAll();
                        i ++;
                    } else {
                        try {
                            o.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "C").start();

    }

}
