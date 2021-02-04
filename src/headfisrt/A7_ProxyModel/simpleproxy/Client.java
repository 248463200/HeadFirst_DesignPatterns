package headfisrt.A7_ProxyModel.simpleproxy;

public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
