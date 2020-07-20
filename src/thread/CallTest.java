package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int i = 0;
            for (i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                Thread t = new Thread(task, "返回值");
                t.start();
            }
        }
        System.out.println(task.get());
    }
}
