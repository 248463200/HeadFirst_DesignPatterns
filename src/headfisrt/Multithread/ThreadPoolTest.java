package headfisrt.Multithread;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool pool =  new ThreadPool(2,5);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            pool.execute(new Thread(()->{
                System.out.println(finalI);
            }));
        }
    }

}

class ThreadPool {
    private BlockQueue<Runnable> taskQueue;
    private HashSet<Worker> workers = new HashSet<>();
    private int coresize;

    public ThreadPool(int coresize, int capacity) {
        this.coresize = coresize;
        this.taskQueue = new BlockQueue<>(capacity);
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            if (workers.size() < coresize) {
                Worker worker = new Worker(task);
                System.out.println("新增Worker"+worker);
                workers.add(worker);
                worker.start();
            } else {
                taskQueue.put(task);
            }
        }
    }

    class Worker extends Thread {
        private Runnable task;
        public Worker(Runnable task) {
            this.task = task;
        }
        @Override
        public void run() {
            while (task != null || (task = taskQueue.take()) != null) {
                try {
                    System.out.println("正在执行"+task);
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    task = null;
                    workers.remove(task);

                }
            }
        }
    }

}

class BlockQueue<T> {
    //任务队列
    private Deque<T> deque = new ArrayDeque<>();
    //锁
    ReentrantLock lock = new ReentrantLock();
    //生产者等待集合
    Condition fullwaitSet = lock.newCondition();
    //消费者等待集合
    Condition emptywaitSet = lock.newCondition();
    //容量
    private int capacity;

    public BlockQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(T element) {
        lock.lock();
        try {
            while (deque.size() == capacity) {
                try {
                    System.out.println("生产者等待");
                    fullwaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deque.addLast(element);
            System.out.println("put线程"+element);
            emptywaitSet.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (deque.isEmpty()) {
                try {
                    System.out.println("消费者等待");
                    emptywaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fullwaitSet.signal();
            T t = deque.removeFirst();
            System.out.println("take线程"+t);
            return t;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return deque.size();
        } finally {
            lock.unlock();
        }
    }
}
