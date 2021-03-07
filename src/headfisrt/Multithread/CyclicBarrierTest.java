package headfisrt.Multithread;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    static int loopNumber = 3;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(loopNumber);
        CyclicBarrier barrier = new CyclicBarrier(loopNumber,()->{
            System.out.println("结束");
            pool.shutdown();
        });
        for (int i = 0; i < loopNumber; i++) {
            final int  finalI = i;
            pool.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println(finalI);
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
