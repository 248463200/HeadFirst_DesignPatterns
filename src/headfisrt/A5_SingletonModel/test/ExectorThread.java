package headfisrt.A5_SingletonModel.test;


import headfisrt.test.LazyDoubleCheckSingletons;

/**
 * Created by Tom.
 */
public class ExectorThread implements Runnable{
    @Override
    public void run() {
        LazyDoubleCheckSingletons singleton = LazyDoubleCheckSingletons.getInstance();
//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
