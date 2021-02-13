package headfisrt.Multithread;

public class ProtectiveStop {
    public static void main(String[] args) {
        TestProtectiveStop protectiveStop = new TestProtectiveStop();

        new Thread(() -> {
            Object response = protectiveStop.getResponse(3500);
            System.out.println(response);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            protectiveStop.setResponse("result");
        }).start();

    }
}

class TestProtectiveStop {
    private Object response;

    public Object getResponse(long millis) {
        synchronized (this) {
            long base = System.currentTimeMillis();
            long now = 0;
            if (millis < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            while (response == null) {
                if (millis == 0) {
                    try {
                        wait(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    long delay = millis - now;
                    if (delay <= 0) {
                        System.out.println("timeout value is negative");
                        break;
                    }
                    try {
                        wait(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    now = System.currentTimeMillis() - base;
                }
            }
            return response;
        }
    }

    public void setResponse(Object response) {
        synchronized (this) {
            System.out.println("拿到结果");
            this.response = response;
            this.notifyAll();
        }
    }
}
