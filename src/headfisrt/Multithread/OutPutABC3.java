package headfisrt.Multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class OutPutABC3 {
    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) throws InterruptedException {
        ParkUnPark pu = new ParkUnPark(5);
        t1 = new Thread(() -> {
            pu.print("A", t2);
        });
        t2 = new Thread(() -> {
            pu.print("B", t3);
        });
        t3 = new Thread(() -> {
            pu.print("C", t1);
        });
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);
        LockSupport.unpark(t1);
    }
}

class ParkUnPark {
    private int loopNumber;

    public ParkUnPark(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void print(String str, Thread current) {
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(current);
        }
    }
}
