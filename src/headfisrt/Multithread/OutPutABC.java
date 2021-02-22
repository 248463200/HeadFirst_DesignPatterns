package headfisrt.Multithread;

public class OutPutABC {
    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify(5,1);
        new Thread(()->{
            wn.print("A",1,2);
        }).start();
        new Thread(()->{
            wn.print("B",2,3);
        }).start();
        new Thread(()->{
            wn.print("C",3,1);
        }).start();
    }
}

class WaitNotify{
    private int loopNumber;
    private int flag;
    public WaitNotify(int loopNumber,int flag){
        this.loopNumber = loopNumber;
        this.flag = flag;
    }
    public void print(String str , int thisFlag,int nextFlag)  {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while (this.flag != thisFlag){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                this.flag = nextFlag;
                notifyAll();
            }
        }
    }
}
