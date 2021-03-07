package headfisrt.Multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSet {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
           AtomicInteger balance = new AtomicInteger(100);
            CyclicBarrier cyc = new CyclicBarrier(2,()->{
                System.out.println(balance.get());
            });
            new Thread(()->{
                withdraw(5,balance);
                try {
                    cyc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                withdraw(22,balance);
                try {
                    cyc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


        public static void withdraw(Integer amount, AtomicInteger balance){
        while (true){
            int prev = balance.get();
            int next = prev -amount;
            if(balance.compareAndSet(prev,next)){
                break;
            }
        }
    }
}
