package headfisrt.Multithread;

public class ThreadTwosteps {
    public static void main(String[] args) throws InterruptedException {
        TestThreadTwosteps twosteps = new TestThreadTwosteps();
        twosteps.start();
        Thread.sleep(3500);
        twosteps.stop();
    }
}

class TestThreadTwosteps{
    private Thread monitor;
    public void start(){
        monitor = new Thread(()->{
          while (true){
              boolean flag = Thread.currentThread().isInterrupted();
              if (flag){
                  System.out.println("料理后事");
                  break;
              }
              try {
                  Thread.sleep(1000);
                  System.out.println("执行监控。。");
              } catch (InterruptedException e) {
                  e.printStackTrace();
                  monitor.interrupt();
              }
          }
        });
        monitor.start();
    }

    public void stop(){
        System.out.println("打断线程");
        monitor.interrupt();
    }
}
