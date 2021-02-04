package headfisrt.A7_ProxyModel.simpleproxy;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
