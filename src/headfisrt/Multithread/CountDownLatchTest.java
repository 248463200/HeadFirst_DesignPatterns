package headfisrt.Multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    static int loopNumber = 3;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(loopNumber);
        CountDownLatch latch = new CountDownLatch(loopNumber);
        for (int i = 0; i < loopNumber; i++) {
            final int  finalI = i;
            pool.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
                latch.countDown();
            });
        }

        latch.await();
        pool.shutdown();
    }
}


